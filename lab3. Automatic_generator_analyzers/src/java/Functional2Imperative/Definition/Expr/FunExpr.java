package Functional2Imperative.Definition.Expr;

import Functional2Imperative.Definition.Expr.Expr;

import java.util.List;
import java.util.stream.Collectors;

public class FunExpr implements Expr {
    String nameFun;
    List<Expr> params;

    public FunExpr(String nameFun, List<Expr> params) {
        this.nameFun = nameFun;
        this.params = params;
    }

    @Override
    public String getExpr() {
        return nameFun +
                '(' +
                params.stream().map(Expr::getExpr).collect(Collectors.joining(", ")) +
                ')';
    }
}
