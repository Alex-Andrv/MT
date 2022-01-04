package Functional2Imperative;

import Functional2Imperative.Util.MyStringBuilder;

import java.util.List;

public class Program {
    List<Function> li;

    public Program(List<Function> li) {
        this.li = li;
    }

    public String getImperativeProgram() {
        MyStringBuilder sb = new MyStringBuilder();
        for (Function fun : li) {
            sb = fun.getFun(sb).append('\n');
        }
        return sb.toString();
    }
}