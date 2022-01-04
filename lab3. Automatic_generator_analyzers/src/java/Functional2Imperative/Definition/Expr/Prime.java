package Functional2Imperative.Definition.Expr;

import Functional2Imperative.Definition.Expr.Expr;

public class Prime implements Expr{
    String name;

    public Prime(String name) {
        this.name = name;
    }

    @Override
    public String getExpr() {
        return name;
    }
}
