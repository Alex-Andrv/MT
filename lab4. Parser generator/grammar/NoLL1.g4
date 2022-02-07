grammar NoLL1;

@header {
package NoLL1;
}

calculator: e=expr;

expr: t=term a=ADD e=expr |  ;

term: a=atom m=MUL t=term |  ;


atom: o = OPEN_P e = expr c = CLOSE_P| d = DIGIT;

ADD : '\\+';

SUB : '-';

MUL : '\\*';

DIV : '/';

OPEN_P : '\\(';

CLOSE_P : '\\)';

DIGIT : '0|[1-9][0-9]*';

SPACES : '[ \n\t]+' -> skip;

