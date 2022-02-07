package grammar.model;

import util.Tree;

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

    public String getRegExp() {
        return regExp.substring(1, regExp.length() - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LexerRule))
            return false;
        LexerRule other = (LexerRule)o;
        return ruleName.equals(other.ruleName) && regExp.equals(other.regExp) && (skip == other.skip);
    }

    @Override
    public final int hashCode() {
        return ruleName.hashCode() + regExp.hashCode() + Boolean.hashCode(skip);
    }
}
