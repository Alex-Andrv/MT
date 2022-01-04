package Functional2Imperative.Definition;

import Functional2Imperative.Definition.Expr.Expr;
import Functional2Imperative.Util.MyStringBuilder;

public class Definition {
    Expr guard;
    Expr expr;

    public Definition(Expr guard, Expr expr) {
        this.guard = guard;
        this.expr = expr;
    }

    public MyStringBuilder getReturnVal(MyStringBuilder sb, int cntTab) {
        return sb.append('\t',  cntTab).
                append("if").
                append(' ').
                append('(').
                append(guard == null ? "True" : guard.getExpr()).
                append(')').
                append(' ').
                append('{').
                append('\n').
                append('\t', cntTab + 1).
                append("return").
                append(' ').
                append(expr.getExpr()).
                append(';').
                append('\n').
                append('\t', cntTab).
                append('}');
    }
}
