import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.text.ParseException;
import java.util.List;

import Calculator.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    @Test
    public void testLexer() throws ParseException {
        CalculatorLexer lexer = null;
        List<CalculatorEnum> exp = null;

        lexer = getLexerGrammar(" 1 ");
        exp = List.of(CalculatorEnum.DIGIT, CalculatorEnum.EOF, CalculatorEnum.EOF, CalculatorEnum.EOF);
        checkLexer(lexer, exp);

        lexer = getLexerGrammar(" 1 + 2 ");
        exp = List.of(CalculatorEnum.DIGIT, CalculatorEnum.ADD,
                CalculatorEnum.DIGIT, CalculatorEnum.EOF, CalculatorEnum.EOF, CalculatorEnum.EOF);
        checkLexer(lexer, exp);


        lexer = getLexerGrammar(" + * / - +*/- 12 1 ");
        exp = List.of(CalculatorEnum.ADD, CalculatorEnum.MUL, CalculatorEnum.DIV, CalculatorEnum.SUB,
                CalculatorEnum.ADD, CalculatorEnum.MUL, CalculatorEnum.DIV, CalculatorEnum.SUB, CalculatorEnum.DIGIT,
                CalculatorEnum.DIGIT, CalculatorEnum.EOF, CalculatorEnum.EOF, CalculatorEnum.EOF);
        checkLexer(lexer, exp);


        lexer = getLexerGrammar("(()()) ");
        exp = List.of(CalculatorEnum.OPEN_P, CalculatorEnum.OPEN_P,
                CalculatorEnum.CLOSE_P, CalculatorEnum.OPEN_P, CalculatorEnum.CLOSE_P,
                CalculatorEnum.CLOSE_P, CalculatorEnum.EOF, CalculatorEnum.EOF, CalculatorEnum.EOF);
        checkLexer(lexer, exp);
    }

    @Test
    public void simpleTest() throws ParseException {
        assertEquals(getParserGrammar("1").calculator().res, 1);
        assertEquals(getParserGrammar("1 / 2").calculator().res, 0.5);
        assertEquals(getParserGrammar("1 + 2").calculator().res, 3);
        assertEquals(getParserGrammar("(1 + 2) * 10 / 2 + 1").calculator().res, 16);
        assertEquals(getParserGrammar("((1 + (2))) * ((10)) / ((2)) + (    1)").calculator().res, 16);
        assertEquals(getParserGrammar(
                "((" +
                        "1 + (2" +
                        "))) *" +
                        " ((10)) /" +
                        " ((2)) + (    1)"
        ).calculator().res, 16);
    }

    @Test
    public void negativeTest() throws ParseException {
        assertThrows(ParseException.class, () -> getParserGrammar("*").calculator());
        assertThrows(ParseException.class, () -> getParserGrammar("(())").calculator());
        assertThrows(ParseException.class, () -> getParserGrammar("(1").calculator());
        assertThrows(ParseException.class, () -> getParserGrammar("1 * 2 - ").calculator());
        assertThrows(ParseException.class, () -> getParserGrammar("1 * 2 - 5 5 ").calculator());
        assertThrows(ParseException.class, () -> getParserGrammar("1 * 2 - ((6 * 9)) / + ").calculator());
        assertThrows(ParseException.class, () -> getParserGrammar(" 1 + 2 * 6 / (15 - 3) kek").calculator());
    }


    public CalculatorParser getParserGrammar(String in) throws ParseException {
        return new CalculatorParser(new ByteArrayInputStream(in.getBytes()));
    }

    private void checkLexer(CalculatorLexer lexer, List<CalculatorEnum> exp) throws ParseException {
        for (CalculatorEnum e : exp) {
            lexer.nextToken();
            assertEquals(lexer.curToken().token, e);
        }
    }

    public CalculatorLexer getLexerGrammar(String in) throws ParseException {
        return new CalculatorLexer(new ByteArrayInputStream(in.getBytes()));
    }
}
