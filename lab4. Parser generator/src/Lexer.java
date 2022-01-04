import generated.AbstractLexer;

import java.io.InputStream;
import java.text.ParseException;

public class Lexer extends AbstractLexer {


    protected Lexer(InputStream input) throws ParseException {
        super(input);
    }

    @Override
    protected Enum valueOf(String value) {
        return TokenEnum.valueOf(value);
    }

}












