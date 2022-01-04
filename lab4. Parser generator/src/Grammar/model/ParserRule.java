package grammar.model;

import java.util.List;

public class ParserRule {
    public String nameRule;

    private final String ruleContextName;

    List<Attribute> inhAtr;
    List<Attribute> syntAtr;

    List<List<Symbol>> rules;

    public ParserRule(String nameRule, List<Attribute> inhAtr,
                      List<Attribute> syntAtr, List<List<Symbol>> rules) {
        this.nameRule = nameRule;
        this.inhAtr = inhAtr;
        this.syntAtr = syntAtr;
        this.rules = rules;
        this.ruleContextName = nameRule.substring(0, 1).toUpperCase() + nameRule.substring(1) + "Context";
    }


    public int genRuleContext(int cntTab) {
        
    }

    public int genRule(int cntTab) {

    }
}
