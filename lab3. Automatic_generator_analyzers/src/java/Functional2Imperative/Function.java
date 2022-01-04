package Functional2Imperative;

import Functional2Imperative.Definition.FunctionDef;
import Functional2Imperative.Type.Type;
import Functional2Imperative.Util.MyStringBuilder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Function {

    private static final String FUN = "fun";

    public String funName;

    public Type returnType;

    public final List<Type> paramTypes;

    public final List<String> paramNames;

    List<FunctionDef> functionDef;

    final int cntParam;



    public Function(String funName, List<Type> types, List<FunctionDef> functionDef) {
        this.funName = funName;
        this.returnType = types.remove(types.size() - 1);
        this.cntParam = types.size();
        this.paramTypes = types;
        this.functionDef = functionDef;
        this.paramNames = IntStream.
                            range(0, types.size()).
                            mapToObj(i -> "_x" + i).
                            collect(Collectors.toList());
        /*
                TODO
                check FunNames and cntParams
         */
    }

    public MyStringBuilder getFun(MyStringBuilder sb) {
        getFunctionSignature(sb, 0).
                append(' ').
                append('{').
                append('\n');
        for (FunctionDef functionDef : functionDef) {
            functionDef.getBody(sb, paramNames, paramTypes, 1).append('\n');
        }
        return sb.append('}');
    }

    public MyStringBuilder getFunctionSignature(MyStringBuilder sb, int cntTab) {
        return sb.append('\t', cntTab).
                append(FUN).
                append(' ').
                append(funName).
                append('(').
                append(getParams()).
                append(')').
                append(':').
                append(' ').
                append(returnType.getType());
    }


    private String getParams() {
        return IntStream.
                range(0, cntParam).
                mapToObj(i -> paramNames.get(i) + ": " + paramTypes.get(i).getType()).
                collect(Collectors.joining(", "));
    }
}
