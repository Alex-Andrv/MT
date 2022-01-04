package Functional2Imperative.Definition;

import Functional2Imperative.Type.Type;
import Functional2Imperative.Util.MyStringBuilder;

import java.util.List;

public class FunctionDef {
    String funName;
    Patterns pattern;
    List<Definition> definitions;

    public FunctionDef(String funName, Patterns pattern, List<Definition> definitions) {
        this.funName = funName;
        this.pattern = pattern;
        this.definitions = definitions;
    }

    public MyStringBuilder getBody(MyStringBuilder sb, List<String> paramNames,
                                   List<Type> paramTypes, int cntTab) {
        pattern.getPattern(sb, paramNames, paramTypes, cntTab);
        for (Definition def :definitions) {
            def.getReturnVal(sb, cntTab + 1).append('\n');
        }
        return sb.append('\t', cntTab).
                append('}').
                append('\n');
    }

}
