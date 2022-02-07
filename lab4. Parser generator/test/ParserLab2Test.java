import Lab2.Lab2Parser;
import org.junit.jupiter.api.Test;
import util.Tree;

import java.io.ByteArrayInputStream;
import java.text.ParseException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ParserLab2Test {

    private final static Tree EPS = new Tree("");

    Random random = new Random();

    private List<String> getTests(boolean withParams, boolean withReturnValue, boolean withFunType) {
        //* - zero or one space
        //? - one or many space

        List<String> funNames = List.of("simpleFun", "_simpleFun_11_", "_simpleFun_11_gfdgd", "__", "__123___");


        List<String> params = List.of("*");
        if (withParams) {
            params = getMapParameters();
        }

        List<String>  retValues = List.of("");
        if (withReturnValue) {
            retValues = List.of(":*Int", ":*_String", ":*_123", ":*__");
        }


        final String funTemplate = "*fun?%s*(*%s*)*%s*";

        List<String> tests = new ArrayList<>();
        for (String funName : funNames) {
            for (String param : params) {
                for (String retVal : retValues) {
                    String test = String.format(funTemplate, funName, param, retVal);
                    tests.add(test);
                }
            }
        }

        return tests;
    }

    private List<String> getMapParameters() {
        return List.of(
                "arg1:*Int",

                "final*:*Int*,*_bar_11*:*_my_1string1",

                "final*:*(*Int*)*->*Int*,*_bar_11*:*_my_1string1",

                "final*:*()*->*Int*,*_bar_11*:*_my_1string1",

                "final*:*(*Int*, String*)*->*Int*,*_bar_11*:*_my_1string1");
    }

    @Test
    public void functionWithoutParamsWithoutReturnTypeTest() throws ParseException {
        testTests(getTests(false, false, false));
    }

    @Test
    public void functionWithoutParamsWithReturnTypeTest() throws ParseException {
        testTests(getTests(false, true, false));
    }

    @Test
    public void functionWithParamsWithoutReturnTypeTest() throws ParseException {
        testTests(getTests(true, false, false));
    }

    @Test
    public void functionWithParamsWithReturnTypeTest() throws ParseException {

        testTests(getTests(true, true, false));

    }

    @Test
    public void functionWithExtraSymbolTest() throws ParseException {
        List<String> tests = getTests(true, true, false);

        for (String test : tests) {
            String breakTestString = breakTest(genTestString(test));
            System.out.println("test: " + breakTestString);
            assertThrows(ParseException.class,
                    () ->  new Lab2Parser(new ByteArrayInputStream(breakTestString.getBytes())).s());
        }
    }

    private void testTests(List<String> tests) throws ParseException {

        for (String test : tests) {
            String testString = genTestString(test);
            System.out.println("test: " + testString);
            getTreeWithoutExp(testString);
        }
    }

    private String genTestString(String key) {
        StringBuilder sb = new StringBuilder();
        for (char ch : key.toCharArray()) {
            int cntRep = 0;
            switch (ch) {
                case '?':
                    cntRep = 1;
                case '*':
                    cntRep += random.nextInt(3);
                    while (cntRep-- > 0)
                        sb.append(' ');
                    break;
                default:
                    sb.append(ch);
            }
        }
        return sb.toString();
    }

    private String breakTest(String testString) {
        List<Character> breakElems = List.of('>', '!', ')', '(', ':', '&', '$', '*');
        Character breakElem = breakElems.get(random.nextInt(breakElems.size()));
        int pos = random.nextInt(testString.length());
        return testString.substring(0, pos) + breakElem + testString.substring(pos);
    }

    private Tree getExpectedTree(Tree fun_name, Tree params, Tree returnType) {
        return new Tree("s", new Tree("fun"), fun_name,
                new Tree("("), params,
                new Tree(")"), returnType);
    }

    private Tree getTreeWithoutExp(String actual) throws ParseException {
        assertDoesNotThrow(() -> new Lab2Parser(new ByteArrayInputStream(actual.getBytes())).s());
        return  new Lab2Parser(new ByteArrayInputStream(actual.getBytes())).s();
    }
}