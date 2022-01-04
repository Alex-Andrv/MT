package Functional2Imperative.Definition;

import Functional2Imperative.Definition.Pattern.IntPattern;
import Functional2Imperative.Definition.Pattern.Pattern;
import Functional2Imperative.Definition.Pattern.VarPattern;
import Functional2Imperative.Type.Type;
import Functional2Imperative.Util.MyStringBuilder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Patterns {
    final List<Pattern> patterns;

    public Patterns(List<Pattern> patterns) {
        this.patterns = patterns;
    }

    public MyStringBuilder getPattern(MyStringBuilder sb, List<String> paramNames, List<Type> paramTypes, int cntTab) {
        if (paramNames.size() != patterns.size()) {
            throw new IllegalStateException("cnt params should equals to cnt patterns");
        }
        sb.append('\t', cntTab).
                append("if").
                append(' ').
                append('(').
                append(getConditional(paramNames)).
                append(')').
                append(' ').
                append('{').
                append('\n');
        return getRenamingVar(sb, paramNames, paramTypes, cntTab + 1);
    }

    private MyStringBuilder getRenamingVar(MyStringBuilder sb,
                                           List<String> paramNames, List<Type> paramTypes, int cntTab) {
       for (int i = 0; i < paramNames.size(); i++) {
           if (patterns.get(i) instanceof VarPattern) {
               sb.append('\t', cntTab).
                       append("val ").
                       append(patterns.get(i).getPattern()).
                       append(':').
                       append(' ').
                       append(paramTypes.get(i).getType()).
                       append(' ').
                       append('=').
                       append(' ').
                       append(paramNames.get(i)).
                       append(';').
                       append('\n');
           }
       }
        return sb;
    }

    private String getConditional(List<String> paramNames) {
        String conditional = IntStream.
                range(0, paramNames.size()).
                filter(i -> patterns.get(i) instanceof IntPattern).
                mapToObj(i -> paramNames.get(i) + " == " + patterns.get(i).getPattern()).
                collect(Collectors.joining(" & "));

        return conditional.isEmpty() ? "true" : conditional;
    }
}










