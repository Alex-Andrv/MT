
package Calculator;

import grammar.model.LexerRule;
import java.util.List;
import util.AbstractLexer;
import java.io.InputStream;
import java.text.ParseException;

public class CalculatorLexer extends AbstractLexer { 
	public CalculatorLexer(InputStream input) throws ParseException {
		super(input);
		lexerRules = List.of(new LexerRule("ADD", "\\+", false),new LexerRule("SUB", "-", false),new LexerRule("MUL", "\\*", false),new LexerRule("DIV", "/", false),new LexerRule("OPEN_P", "\\(", false),new LexerRule("CLOSE_P", "\\)", false),new LexerRule("DIGIT", "0|[1-9][0-9]*", false),new LexerRule("SPACES", "[ \n\t]+", true));
	}

	@Override
	public Enum valueOf(String value) {
		return CalculatorEnum.valueOf(value);
	}
}