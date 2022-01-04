lexer grammar LexerGrammar;

@header {
package grammar.gen;
}

GRAMMAR : 'grammar';

HEADER : '@header';

LOWER_CASE_INTEDEFICATION : [a-z][a-zA-Z0-9_]*;

UPPER_CASE_INTEDEFICATION : [A-Z][a-zA-Z0-9_]*;

RETURNS : 'returns';

COMMA : ',';

EQUALS : '=';

COLON : ':';

OR : '|';

NEWLINES : ('\n' | '\r' )+;

REGEX : '"' (~('"'))* '"';

SEMICOLON : ';';

/* We're going to ignore all white space characters */
SPACES : [ \t]+ -> skip;

OP : '[';

CP : ']';

FUNCTIONAL_ARROW : '->';

SKIP_ : 'skip';

OPENP : '{' -> pushMode(JAVA_CODE);

mode JAVA_CODE;

CODE_OPENP : '{' -> pushMode(JAVA_CODE);

CODE : (~[{}])+;


CLOSEP : '}' -> popMode;















