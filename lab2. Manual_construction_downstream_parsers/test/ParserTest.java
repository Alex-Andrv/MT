import model.Tree;
import org.junit.jupiter.api.Test;
import parser.Parser;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


class ParserTest {

    Parser parser = new Parser();

    Random random = new Random();

    private Map<String, Tree> getTests(boolean withParams, boolean withReturnValue, boolean withFunType) {
        //* - zero or one space
        //? - one or many space

        List<String> funNames = List.of("simpleFun", "_simpleFun_11_", "_simpleFun_11_gfdgd", "__", "__123___");

        Map<String, Tree> paramsMap = Map.of("*", new Tree("PARAMS", Parser.EPS));
        if (withParams) {
            paramsMap = getMapParameters();
        }

        Map<String, Tree> retValMap = Map.of("", new Tree("RETURN_VAL", Parser.EPS));
        if (withReturnValue) {
            List<String> retValues = List.of(":*Int", ":*_String", ":*_123", ":*__");
            retValMap = new HashMap<>();
            for (String retValue : retValues) {
                retValMap.put(retValue,
                        new Tree("RETURN_VAL", new Tree(":"), new Tree("RETURN_TYPE")));
            }
        }


        final String funTemplate = "*fun?%s*(*%s*)*%s*";

        Map<String, Tree> tests = new HashMap<>();
        for (String funName : funNames) {
            for (Map.Entry<String, Tree> param : paramsMap.entrySet()) {
                for (Map.Entry<String, Tree> retVal : retValMap.entrySet()) {
                    String test = String.format(funTemplate, funName, param.getKey(), retVal.getKey());
                    tests.put(test, getExpectedTree(param.getValue(), retVal.getValue()));
                }
            }
        }


        return tests;
    }

    private Map<String, Tree> getMapParameters() {
        return Map.of(


                "arg1:*Int",
                new Tree("PARAMS",
                        new Tree("PARAM",
                                new Tree("VAR"), new Tree(":"), new Tree("TYPE")),
                        new Tree("TAIL", Parser.EPS)),


                "final*:*Int*,*_bar_11*:*_my_1string1",
                new Tree("PARAMS",
                        new Tree("PARAM",
                                new Tree("VAR"), new Tree(":"), new Tree("TYPE")),
                        new Tree("TAIL", new Tree(","), new Tree("PARAM",
                                new Tree("VAR"), new Tree(":"), new Tree("TYPE")),
                                new Tree("TAIL", Parser.EPS))),


                "final*:*(*Int*)*->*Int*,*_bar_11*:*_my_1string1",
                new Tree("PARAMS",
                        new Tree("PARAM",
                                new Tree("VAR"), new Tree(":"),
                                new Tree("TYPE",
                                        new Tree("("),
                                        new Tree("TYPES", new Tree("TYPE"),
                                                new Tree("TYPES_TAIL", Parser.EPS)),
                                        new Tree(")"),
                                        new Tree("->", new Tree("TYPE")))),
                        new Tree("TAIL", new Tree(","),
                                new Tree("PARAM",
                                        new Tree("VAR"), new Tree(":"), new Tree("TYPE")),
                                new Tree("TAIL", Parser.EPS))),

                "final*:*()*->*Int*,*_bar_11*:*_my_1string1",
                new Tree("PARAMS",
                        new Tree("PARAM",
                                new Tree("VAR"), new Tree(":"),
                                new Tree("TYPE",
                                        new Tree("("),
                                        new Tree("TYPES", Parser.EPS),
                                        new Tree(")"),
                                        new Tree("->", new Tree("TYPE")))),
                        new Tree("TAIL", new Tree(","),
                                new Tree("PARAM",
                                        new Tree("VAR"), new Tree(":"), new Tree("TYPE")),
                                new Tree("TAIL", Parser.EPS))),

                "final*:*(*Int*, String*)*->*Int*,*_bar_11*:*_my_1string1",
                new Tree("PARAMS",
                        new Tree("PARAM",
                                new Tree("VAR"), new Tree(":"),
                                new Tree("TYPE",
                                        new Tree("("),
                                        new Tree("TYPES", new Tree("TYPE"),
                                                new Tree("TYPES_TAIL", new Tree(","),
                                                        new Tree("TYPE"),
                                                        new Tree("TYPES_TAIL", Parser.EPS))),
                                        new Tree(")"),
                                        new Tree("->", new Tree("TYPE")))),
                        new Tree("TAIL", new Tree(","),
                                new Tree("PARAM",
                                        new Tree("VAR"), new Tree(":"), new Tree("TYPE")),
                                new Tree("TAIL", Parser.EPS))));
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
        Map<String, Tree> tests = getTests(true, true, false);

        for (Map.Entry<String, Tree> test : tests.entrySet()) {
            String breakTestString = breakTest(genTestString(test.getKey()));
            System.out.println("test: " + breakTestString);
            assertThrows(ParseException.class, () -> parser.parse(breakTestString));
        }
    }

    private void testTests(Map<String, Tree> tests) throws ParseException {

        for (Map.Entry<String, Tree> test : tests.entrySet()) {
            String testString = genTestString(test.getKey());
            System.out.println("test: " + testString);
            Tree expectedTree = test.getValue();
            assertEquals(getTreeWithoutExp(testString), expectedTree);
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
        List<Character> breakElems = List.of('>', '!', ')', '(', ':', ',', '$', '*');
        Character breakElem = breakElems.get(random.nextInt(breakElems.size()));
        int pos = random.nextInt(testString.length());
        return testString.substring(0, pos) + breakElem + testString.substring(pos);
    }

    private Tree getExpectedTree(Tree params, Tree returnType) {
        return new Tree("S", new Tree("fun"), new Tree("FUN_NAME"),
                new Tree("("), params,
                new Tree(")"), returnType);
    }

    private Tree getTreeWithoutExp(String actual) throws ParseException {
        assertDoesNotThrow(() -> parser.parse(actual));
        return parser.parse(actual);
    }
}