package grammar.model;

public class TerminalSymbol implements Symbol {

    String var;

    String terminalName;

    public TerminalSymbol(String var, String terminalName) {
        this.var = var;
        this.terminalName = terminalName;
    }

    @Override
    public String genCode() {
        return null;
    }
}
