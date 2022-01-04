parser grammar ParserGrammar;

options {
    tokenVocab = LexerGrammar;
}

@header {
package grammar.gen;
import grammar.*;
import grammar.model.*;
import generated.*;
import java.util.Optional;
}

translationGrammar [Grammar gr] locals [Optional<TranslatingSymbol> headers]
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


grammarName returns[String grName]: GRAMMAR intedefication {
                                        $grName = $intedefication.text;
                                    };


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
    start: E ` System.out.println($E.ans); `;
    E returns[Integer i] : NUMBER '+' e=E `$i = $NUMBER.text + $e.ans` | NUMBER `$i = $NUMBER.text`;

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

descriptionParseRule returns[List<Symbol> symbols]
@init {
    $symbols = new ArrayList<>();
} : (
         nonTerminal {$symbols.add($nonTerminal.s);}
             |
         terminal {$symbols.add($terminal.s);}
             |
         semanticRules {$symbols.add($semanticRules.s);}
    )+;

nonTerminal returns[Symbol s] locals[String var]:
            LOWER_CASE_INTEDEFICATION EQUALS {$var = $LOWER_CASE_INTEDEFICATION.text;}
            sym=LOWER_CASE_INTEDEFICATION
                {
                    $s = new NonTerminalSymbol($sym.text, $var);
                };

terminal returns[Symbol s] locals[String var]:
            LOWER_CASE_INTEDEFICATION EQUALS {$var = $LOWER_CASE_INTEDEFICATION.text;}
            sym=UPPER_CASE_INTEDEFICATION
                {
                    $s = new TerminalSymbol($sym.text, $var);
                };


semanticRules returns[TranslatingSymbol s]: OPENP javaCode CLOSEP {
                                                $s = new TranslatingSymbol($javaCode.text);
                                            };

javaCode : (CODE | OPENP CODE CLOSEP)+;

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

        NEWLINES : "('\n' | '\r' )+";

        SEMICOLON : ";";
*/

lexerRules returns[List<LexerRule> lrs]
@init {
    $lrs = new ArrayList<>();
} : (lexerRule {$lrs.add($lexerRule.lr);})*;

lexerRule returns[LexerRule lr] locals[boolean skip]
@init {
    $skip = false;
} : UPPER_CASE_INTEDEFICATION COLON REGEX SEMICOLON NEWLINES
        (FUNCTIONAL_ARROW SKIP_ {$skip = true;})?
        {
            $lr = new LexerRule($UPPER_CASE_INTEDEFICATION.text,
                      $REGEX.text, $skip);
        };
// ------->>>>>>>

intedefication : (LOWER_CASE_INTEDEFICATION | UPPER_CASE_INTEDEFICATION);
