package grammar.model;

import java.util.List;

public class ParserRule {

    public String ruleName;

    public List<Attribute> inhAtrs;
    public List<Attribute> syntAtrs;

    public List<List<Symbol>> rules;

    public ParserRule(String ruleName, List<Attribute> inhAtrs,
                      List<Attribute> syntAtrs, List<List<Symbol>> rules) {
        this.ruleName = ruleName;
        this.inhAtrs = inhAtrs;
        this.syntAtrs = syntAtrs;
        this.rules = rules;
    }

    public String getRuleName() {
        return ruleName;
    }
}
