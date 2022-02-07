grammar Lab2;

@header {
package Lab2;
}

s : f=FUN f1=fun_name o=OPEN_P p=params c=CLOSE_P r=return_val e=EOF;

params: p=param t=tail | ;

param: v=var c=COLON t=type;

tail: c=COMMA p=param t=tail | ;

return_val: c=COLON r=return_type | ;

fun_name: i=IDENTIFIER;

type: i=IDENTIFIER | o=OPEN_P t=types c=CLOSE_P a=ARROW t1=type;

var: i=IDENTIFIER;

return_type: i=IDENTIFIER | o=OPEN_P t=types c=CLOSE_P a=ARROW r=return_type;

types: t=type t1=types_tail | ;

types_tail: c=COMMA t=type t1=types_tail | ;


FUN : 'fun';

OPEN_P : '\\(';

CLOSE_P : '\\)';

COLON : ':';

COMMA : ',';

IDENTIFIER: '[a-zA-Z_][a-zA-Z0-9_]*';

ARROW : '->';

SPACES : '[ \n\t]+' -> skip;



