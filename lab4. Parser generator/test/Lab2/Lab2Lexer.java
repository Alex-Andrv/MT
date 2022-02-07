
package Lab2;

import grammar.model.LexerRule;
import java.util.List;
import util.AbstractLexer;
import java.io.InputStream;
import java.text.ParseException;

public class Lab2Lexer extends AbstractLexer { 
	public Lab2Lexer(InputStream input) throws ParseException {
		super(input);
		lexerRules = List.of(new LexerRule("FUN", "fun", false),new LexerRule("OPEN_P", "\\(", false),new LexerRule("CLOSE_P", "\\)", false),new LexerRule("COLON", ":", false),new LexerRule("COMMA", ",", false),new LexerRule("IDENTIFIER", "[a-zA-Z_][a-zA-Z0-9_]*", false),new LexerRule("ARROW", "->", false),new LexerRule("SPACES", "[ \n\t]+", true));
	}

	@Override
	public Enum valueOf(String value) {
		return Lab2Enum.valueOf(value);
	}
}