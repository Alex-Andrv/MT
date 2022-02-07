parser grammar ParserGrammar;

options {
    tokenVocab = LexerGrammar;
}

@header {
package grammar.gen;
import grammar.model.*;
import util.*;
import java.util.Optional;
}
translationGrammar returns [Grammar gr] locals [Optional<TranslatingSymbol> headers]
@init {
    $headers = Optional.empty();
} :
    grammarName
    (header {
                $headers = $header.headers;
            })?
    parserRules lexerRules EOF {
                $gr = new Grammar($grammarName.grName, $headers,
                                  $parserRules.prs, $lexerRules.lrs);
    };


grammarName returns[String grName]: GRAMMAR identifier {
                                        $grName = $identifier.text;
                                    } SEMICOLON;


// <<<------ Header section.
/*
    Exemple:

    @header {
        import java.io.*;
        import org.antlr.v4.runtime.CommonTokenStream;
        package myPackage;
        import Grammar.antlr4.GrammarLexer;
    }

*/
header returns[Optional<TranslatingSymbol> headers] : HEADER semanticRules {
                                                $headers = Optional.of($semanticRules.s);
                                           };

// ------>>>>>

// <<<------ Parser rules section.
/*
    start: E { System.out.println($E.ans); };
    E returns[Integer i] : n=NUMBER p=PLUS e=E {i = NUMBER.text + e.ans} | n=NUMBER {i = NUMBER.text};

*/

parserRules returns[List<ParserRule> prs]
@init {
    $prs = new ArrayList<>();
} : (parserRule_ {$prs.add($parserRule_.pr);})+;

parserRule_  returns[ParserRule pr]
locals [List<Attribute> inhAtr, List<Attribute> syntAtr, List<List<Symbol>> rules]
@init {
        $inhAtr = new ArrayList<>();
        $syntAtr = new ArrayList<>();
        $rules = new ArrayList<>();
    } : LOWER_CASE_INTEDEFICATION
            (inheritedAttributes {$inhAtr = $inheritedAttributes.attrs;})?
            (synthesizedAttributes {$syntAtr = $synthesizedAttributes.attrs;})?
            COLON descriptionParseRule {$rules.add($descriptionParseRule.symbols);}
            (OR descriptionParseRule {$rules.add($descriptionParseRule.symbols);})* SEMICOLON
            {
                $pr = new ParserRule($LOWER_CASE_INTEDEFICATION.text, $inhAtr, $syntAtr, $rules);
            };

descriptionParseRule returns[List<Symbol> symbols] locals[String var]
@init {
    $symbols = new ArrayList<>();
} : (
         (
            LOWER_CASE_INTEDEFICATION EQUALS {$var = $LOWER_CASE_INTEDEFICATION.text;}
                (
                    nonTerminal {$symbols.add(new NonTerminalSymbol($var, $nonTerminal.s, $nonTerminal.sym));}
                        |
                    terminal {$symbols.add(new TerminalSymbol($var, $terminal.s));}
                )
         )
             |
         semanticRules {$symbols.add($semanticRules.s);}
    )*;

nonTerminal returns[String s, TranslatingSymbol sym]:
            LOWER_CASE_INTEDEFICATION ( OP semanticRules CP {$sym = $semanticRules.s;})?
                {
                    $s = $LOWER_CASE_INTEDEFICATION.text;
                };

terminal returns[String s]:
            UPPER_CASE_INTEDEFICATION
                {
                    $s = $UPPER_CASE_INTEDEFICATION.text;
                };


semanticRules returns[TranslatingSymbol s]: OPENP javaCode CLOSEP {
                                                $s = new TranslatingSymbol($javaCode.text);
                                            };

javaCode : (CODE | CODE_OPENP javaCode CLOSEP)+;

inheritedAttributes returns[List<Attribute> attrs] : attributes {$attrs = $attributes.attrs;};

synthesizedAttributes returns[List<Attribute> attrs] : RETURNS attributes {$attrs = $attributes.attrs;};

attributes returns[List<Attribute> attrs]
@init {
        $attrs = new ArrayList<>();
    } : OP attribute {$attrs.add($attribute.attr);}
                (COMMA attribute {$attrs.add($attribute.attr);})* CP;

attribute returns[Attribute attr]: type nameAttribute
        {
            $attr = new Attribute($type.text, $nameAttribute.text);
        };

type : UPPER_CASE_INTEDEFICATION;

nameAttribute : LOWER_CASE_INTEDEFICATION;

// ---------->>>>>>>


// <<<------ Lexer rules section.
/*
        LOWER_CASE_INTEDEFICATION : "[a-z][a-zA-Z0-9_]*";

        UPPER_CASE_INTEDEFICATION : "[A-Z][a-zA-Z0-9_]*";

        COLON : ":";

        SEMICOLON : ";";
*/

lexerRules returns[List<LexerRule> lrs]
@init {
    $lrs = new ArrayList<>();
} : (lexerRule {$lrs.add($lexerRule.lr);})*;

lexerRule returns[LexerRule lr] locals[boolean skip]
@init {
    $skip = false;
} : UPPER_CASE_INTEDEFICATION COLON REGEX
        (FUNCTIONAL_ARROW SKIP_ {$skip = true;})? SEMICOLON
        {
            $lr = new LexerRule($UPPER_CASE_INTEDEFICATION.text,
                      $REGEX.text, $skip);
        };
// ------->>>>>>>

identifier : (LOWER_CASE_INTEDEFICATION | UPPER_CASE_INTEDEFICATION);
