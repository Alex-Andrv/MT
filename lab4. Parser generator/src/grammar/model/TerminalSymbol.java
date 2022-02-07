package grammar.model;

public class TerminalSymbol implements Symbol {

    public String var;

    public String terminalName;

    public TerminalSymbol(String var, String terminalName) {
        this.var = var;
        this.terminalName = terminalName;
    }
}
