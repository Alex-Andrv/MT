grammar ParserGrammar;

@header {
package grammar.gen;
}

translationGrammar [Grammar gr] locals [List<String> imports, OptionalString pkName]
@init {
        $pkName = new OptionalString();
        $imports = new ArrayList<>();
    } :
    grammarName
    (header {
                $pkName = $header.packageName_;
                $imports = $header.imports);
            })?
    parserRules lexerRules EOF {
                $gr = new Grammar($grammarName.grName, $pkName,
                                  $imports, $parserRules.stName,
                                  $parserRules.prs, $lexerRules.lrs,
                                  $lexerRules.skipp_lrs);
    };


grammarName returns[String grName]: 'grammar' intedefication {$grName = $intedefication.text};


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
header returns[List<OptionalString> imports, OptionalString packageName_]
@init {
    $imports = new List<String>;
    $packageName_ = new OptionalString();
} : '@header {' (NEWLINES)?
            (impl=import_ {$imports.add($impl.text)})*
            (package_ {$packageName_ = new OptionalString($package_.text)})?
            (impr=import_ {$imports.add($impr.text)})* '}' NEWLINES;

import_ : 'import' importName SEMICOLON NEWLINES;
package_ : 'package' packageName SEMICOLON NEWLINES;

importName : intedefication ('.' intedefication)* ('.*')?;

packageName : intedefication ('.' intedefication)*;
// ------>>>>>

// <<<------ Parser rules section.
/*
    start: E ` System.out.println($E.ans); `;
    E returns[Integer i] : NUMBER '+' e=E `$i = $NUMBER.text + $e.ans` | NUMBER `$i = $NUMBER.text`;

*/

parserRules returns[String stName, List<ParserRule> prs]
@init {
    $prs = new ArrayList<>;
} : parserRule_ {
                    $stName = $parserRule_.pr.nameRule;
                    $prs.add($parserRule_.pr);
                }
    (parserRule_ {$prs.add($parserRule_.pr)})*;

parserRule_ returns[ParserRule pr]:
              LOWER_CASE_INTEDEFICATION (inheritedAttributes)? (synthesizedAttribute)?
                                       COLON descriptionParseRule ('|' descriptionParseRule)* SEMICOLON;

descriptionParseRule : ((LOWER_CASE_INTEDEFICATION '=')? intedefication | semanticRules)+;

semanticRules : CODE;

inheritedAttributes : '[' attribute (',' attribute)+ ']';

synthesizedAttribute : 'returns' '[' attribute (',' attribute)+ ']';

attribute : type nameAttribute;

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

lexerRules returns[List<LexerRule> lrs, List<LexerRule> skipp_lrs]
@init {
    $lrs = new ArrayList<>;
    $skipp_lrs = new ArrayList<>;
} : (lexerRule[$lrs, $skipp_lrs])*;

lexerRule[List<LexerRule> lr, List<LexerRule> skip_lr] :
        UPPER_CASE_INTEDEFICATION COLON REGEX SEMICOLON NEWLINES
                                 {
                                    $lr = new LexerRule($UPPER_CASE_INTEDEFICATION.text,
                                              $REGEX.text);
                                 };
// ------->>>>>>>

intedefication : (LOWER_CASE_INTEDEFICATION | UPPER_CASE_INTEDEFICATION);

LOWER_CASE_INTEDEFICATION : [a-z][a-zA-Z0-9_]*;

UPPER_CASE_INTEDEFICATION : [A-Z][a-zA-Z0-9_]*;

COLON : ':';

NEWLINES : ('\n' | '\r' )+;

REGEX : '"' (~('"'))* '"';

SEMICOLON : ';';

/* We're going to ignore all white space characters */
SPACES : [ \t]+ -> skip;

CODE : '`' (~('`'))* '`';  // TODO.