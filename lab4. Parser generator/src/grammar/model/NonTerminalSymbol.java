package grammar.model;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

public class NonTerminalSymbol implements Symbol{

    public TranslatingSymbol translatingSymbol;

    public String var;

    public String nonTerminalName;

    public NonTerminalSymbol(String var, String nonTerminalName, TranslatingSymbol translatingSymbol) {
        this.var = var;
        this.nonTerminalName = nonTerminalName;
        this.translatingSymbol = translatingSymbol == null ? new TranslatingSymbol("") : translatingSymbol;
    }
}
