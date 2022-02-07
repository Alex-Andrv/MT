package grammar.model;

public class LexerRule {
    public String ruleName;

    public String regExp;

    boolean skip;

    public LexerRule(String ruleName, String regExp, boolean skip) {
        this.ruleName = ruleName;
        this.regExp = regExp;
        this.skip = skip;
    }

    public boolean isSkip() {
        return skip;
    }


    public String getRuleName() {
        return ruleName;
    }


}
