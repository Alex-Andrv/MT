package Functional2Imperative.Util;

public class MyStringBuilder {
    private StringBuilder sb;

    public MyStringBuilder() {
        sb = new StringBuilder();
    }

    public MyStringBuilder append(char c) {
        sb.append(c);
        return this;
    }

    public MyStringBuilder append(String str) {
        sb.append(str);
        return this;
    }

    public MyStringBuilder append(char str, int cntRep) {
        while (cntRep-- > 0) {
            sb.append(str);
        }
        return this;
    }

    public MyStringBuilder append(MyStringBuilder msb) {
        this.sb.append(msb.sb);
        return this;
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
