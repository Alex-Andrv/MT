package Functional2Imperative.Definition.Expr;

import Functional2Imperative.Definition.Expr.Expr;

public class UnaryOperator implements Expr {

    String op;
    Expr expr;

    public UnaryOperator(String op, Expr expr) {
        this.expr = expr;
        this.op = op;
    }

    @Override
    public String getExpr() {
        return op + '(' + expr.getExpr() + ')';
    }
}
