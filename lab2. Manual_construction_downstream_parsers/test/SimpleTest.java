import model.Tree;
import org.junit.jupiter.api.Test;
import parser.Parser;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Deprecated
public class SimpleTest {
    Parser parser = new Parser();

    @Test
    public void functionWithoutReturnTypeTest() throws ParseException {

        testToken("fun simpleFun()",
                newFun(new Tree("PARAMS", Parser.EPS),
                        new Tree("RETURN_VAL", Parser.EPS)));

        testToken("fun _simpleFun_11_()",
                newFun(new Tree("PARAMS", Parser.EPS),
                        new Tree("RETURN_VAL", Parser.EPS)));

        testToken("fun _simpleFun_11_gfdgd(arg1: Int)",
                newFun(new Tree("PARAMS",
                                new Tree("PARAM",
                                        new Tree("VAR"), new Tree(":"), new Tree("TYPE")),
                                new Tree("TAIL", Parser.EPS)),
                        new Tree("RETURN_VAL", Parser.EPS)));

        testToken("fun _simpleFun_11_gfdgd(final: Int, _bar_11: _my_1string1)",
                newFun(new Tree("PARAMS",
                                new Tree("PARAM",
                                        new Tree("VAR"), new Tree(":"), new Tree("TYPE")),
                                new Tree("TAIL", new Tree(","), new Tree("PARAM",
                                        new Tree("VAR"), new Tree(":"), new Tree("TYPE")),
                                        new Tree("TAIL", Parser.EPS))),
                        new Tree("RETURN_VAL", Parser.EPS)));

    }

    @Test
    public void functionWithReturnTypeTest() throws ParseException {

        testToken("fun simpleFun(): Int",
                newFun(new Tree("PARAMS", Parser.EPS),
                        new Tree("RETURN_VAL", new Tree(":"), new Tree("RETURN_TYPE"))));

        testToken("fun _simpleFun_11_(): _String",
                newFun(new Tree("PARAMS", Parser.EPS),
                        new Tree("RETURN_VAL", new Tree(":"), new Tree("RETURN_TYPE"))));

        testToken("fun _simpleFun_11_gfdgd(arg1: Int): _123",
                newFun(new Tree("PARAMS",
                                new Tree("PARAM",
                                        new Tree("VAR"), new Tree(":"), new Tree("TYPE")),
                                new Tree("TAIL", Parser.EPS)),
                        new Tree("RETURN_VAL", new Tree(":"), new Tree("RETURN_TYPE"))));

        testToken("fun _simpleFun_11_gfdgd(final: Int, _bar_11: _my_1string1): __",
                newFun(new Tree("PARAMS",
                                new Tree("PARAM",
                                        new Tree("VAR"), new Tree(":"), new Tree("TYPE")),
                                new Tree("TAIL", new Tree(","), new Tree("PARAM",
                                        new Tree("VAR"), new Tree(":"), new Tree("TYPE")),
                                        new Tree("TAIL", Parser.EPS))),
                        new Tree("RETURN_VAL", new Tree(":"), new Tree("RETURN_TYPE"))));
    }

    @Test
    public void functionWithExtraOrSkippSpacesTest() throws ParseException {

        testToken("fun simpleFun(): Int",
                newFun(new Tree("PARAMS", Parser.EPS),
                        new Tree("RETURN_VAL", new Tree(":"), new Tree("RETURN_TYPE"))));

        testToken("fun _simpleFun_11_(): _String",
                newFun(new Tree("PARAMS", Parser.EPS),
                        new Tree("RETURN_VAL", new Tree(":"), new Tree("RETURN_TYPE"))));

        testToken("fun _simpleFun_11_gfdgd(arg1: Int): _123",
                newFun(new Tree("PARAMS",
                                new Tree("PARAM",
                                        new Tree("VAR"), new Tree(":"), new Tree("TYPE")),
                                new Tree("TAIL", Parser.EPS)),
                        new Tree("RETURN_VAL", new Tree(":"), new Tree("RETURN_TYPE"))));

        testToken("fun _simpleFun_11_gfdgd(final: Int, _bar_11: _my_1string1): __",
                newFun(new Tree("PARAMS",
                                new Tree("PARAM",
                                        new Tree("VAR"), new Tree(":"), new Tree("TYPE")),
                                new Tree("TAIL", new Tree(","), new Tree("PARAM",
                                        new Tree("VAR"), new Tree(":"), new Tree("TYPE")),
                                        new Tree("TAIL", Parser.EPS))),
                        new Tree("RETURN_VAL", new Tree(":"), new Tree("RETURN_TYPE"))));
    }

    private Tree newFun(Tree params, Tree returnType) {
        return new Tree("S", new Tree("fun"), new Tree("FUN_NAME"),
                new Tree("("), params,
                new Tree(")"), returnType);
    }

    private void testToken(String actual, Tree expected) throws ParseException {
        assertEquals(getTreeWithoutExp(actual), expected);
    }

    private InputStream getInputStream(String source) {
        return new ByteArrayInputStream(source.getBytes());
    }

    private Tree getTreeWithoutExp(String actual) throws ParseException {
        assertDoesNotThrow(() -> parser.parse(getInputStream(actual)));
        return parser.parse(getInputStream(actual));
    }
}

