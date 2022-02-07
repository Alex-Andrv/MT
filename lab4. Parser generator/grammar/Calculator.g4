grammar Calculator;

@header {
package Calculator;
}

calculator returns[Double res]: e = expr e1 = EOF {$res = e.res;};

expr returns[Double res]: t = term e = expr_[{t.res}] {$res = e.res;};

expr_[Double in] returns[Double res]:
            a = ADD e = expr {$res = in + e.res;}
                |
            s = SUB e = expr {$res = in - e.res;}
                |
            {$res = in;};

term returns[Double res]: a = atom t = term_[{a.res}] {$res = t.res;};

term_[Double in] returns[Double res]:
            m = MUL t = term {$res = in * t.res;}
                |
            d = DIV t = term {$res = in / t.res;}
                |
            {$res = in;} ;

atom returns[Double res]: o = OPEN_P e = expr c = CLOSE_P {$res = e.res;} | d = DIGIT {$res = Double.parseDouble(d.text);};

ADD : '\\+';

SUB : '-';

MUL : '\\*';

DIV : '/';

OPEN_P : '\\(';

CLOSE_P : '\\)';

DIGIT : '0|[1-9][0-9]*';

SPACES : '[ \n\t]+' -> skip;