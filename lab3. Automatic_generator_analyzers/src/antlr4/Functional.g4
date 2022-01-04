grammar Functional;

@header {
import Functional2Imperative.*;
import Functional2Imperative.Type.*;
import Functional2Imperative.Definition.*;
import Functional2Imperative.Definition.Expr.*;
import Functional2Imperative.Definition.Pattern.*;
import java.util.ArrayList;
}

program returns [Program p]: lines {$p = new Program($lines.li);};

lines returns [List<Function> li] :
                                    functionType functions[$functionType.fn, $functionType.types]
                                                    {$li = $functions.li;}
                                        |
                                    {$li = new ArrayList<>();};


functions[String fn, List<Type> types] returns [List<Function> li]: {List<FunctionDef> fds = new ArrayList<>();}
                                                (functionDef {fds.add($functionDef.fd);})+ lines
                                                        {
                                                            Function func = new Function($fn, $types, fds);
                                                            $lines.li.add(func);
                                                            $li = $lines.li;
                                                        };
// <-----------  Function Type
functionType returns [String fn, List<Type> types] :
              funName DOUBLE_COLONS type[new ArrayList<>()] NEWLINES
                    {
                       $fn = $funName.text;
                       $types = $type.outpr;
                    };

type[List<Type> inpr] returns[List<Type> outpr] :
              typeHead {$inpr.add($typeHead.t);} typeTail[$inpr] {$outpr = $typeTail.outpr;};


typeTail[List<Type> inpr]  returns[List<Type> outpr]  :
              FUNCTIONAL_ARROW type[$inpr] {$outpr = $type.outpr;}
                |
              {$outpr = $inpr;};

typeHead returns[Type t] :
              IDENTIFIER {$t = new PrimeType($IDENTIFIER.text);}
                |
              OPEN_PARENTHESIS type[new ArrayList<>()] CLOSE_PARENTHESIS
                     {
                        $t = new FunctionalType($type.outpr);
                     };
// --------------->

// <-----------  Function Def
functionDef returns [FunctionDef fd] :
        funName patterns definitions
           {
               $fd = new FunctionDef($funName.text, $patterns.pt, $definitions.defs);
           };

funName : IDENTIFIER;

patterns returns[Patterns pt] :
        {
            List<Pattern> patterns = new ArrayList<>();
        }
        (IDENTIFIER {patterns.add(new VarPattern($IDENTIFIER.text));}
            |
        INT {patterns.add(new IntPattern($INT.text));}
            |
        UNDERSCORES {patterns.add(new UnderscoresPattern($INT.text));})* {$pt = new Patterns(patterns);};

definitions returns[List<Definition> defs]: {$defs = new ArrayList<>();}
        (EQUALS expr {$defs.add(new Definition(null, $expr.e));} NEWLINES
            |
        (GUARD g=expr EQUALS e=expr {$defs.add(new Definition($g.e, $e.e));} NEWLINES)+);

expr returns[Expr e]:
        BIN_OPERATOR pl=prime pr=prime
                    {$e = new BinOperator($BIN_OPERATOR.text, $pl.e, $pr.e);}
            |
        UNARY_OPERATOR prime
                    {$e = new UnaryOperator($UNARY_OPERATOR.text, $prime.e);}
            |
        funName {List<Expr> exprs = new ArrayList<>();} (prime {exprs.add($prime.e);})*
                    {$e = new FunExpr($funName.text, exprs);}
            |
        prime
                    {$e = $prime.e;};


prime returns[Expr e]:
        IDENTIFIER                              {$e = new Prime($IDENTIFIER.text);}
            |
        INT                                     {$e = new Prime($INT.text);}
            |
        OPEN_PARENTHESIS expr CLOSE_PARENTHESIS {$e = $expr.e;  };
// --------------->

DOUBLE_COLONS : '::';

EQUALS : '=';

INT : [1-9][0-9]* | [0];

LIST : 'list';

UNDERSCORES : '_';

IDENTIFIER : [a-zA-Z]([a-zA-Z0-9_'])*;

FUNCTIONAL_ARROW : '->';

GUARD : '|';

OPEN_PARENTHESIS : '(';

CLOSE_PARENTHESIS : ')';

BIN_OPERATOR : ([%^&|*/\-+<>]|'=='|'!=');

UNARY_OPERATOR : [!];

NEWLINES : ('\n' | '\r' )+;

/* We're going to ignore all white space characters */
SPACES : [ \t]+ -> skip;