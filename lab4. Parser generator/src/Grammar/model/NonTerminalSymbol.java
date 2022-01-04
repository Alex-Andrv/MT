package grammar.model;

public class NonTerminalSymbol implements Symbol{

    String var;

    String nonTerminalName;

    public NonTerminalSymbol(String var, String nonTerminalName) {
        this.var = var;
        this.nonTerminalName = nonTerminalName;
    }

    @Override
    public String genCode() {
        return null;
    }
}
