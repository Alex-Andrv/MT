package Functional2Imperative.Definition.Expr;

import Functional2Imperative.Definition.Expr.Expr;

public class BinOperator implements Expr {

    String op;
    Expr left;
    Expr right;

    public BinOperator(String op, Expr left, Expr right) {
        this.left = left;
        this.right = right;
        this.op = op;
    }


    @Override
    public String getExpr() {
        return '(' + left.getExpr() + ' ' + op + ' ' + right.getExpr() + ')';
    }
}
