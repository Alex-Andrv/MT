package util;

import java.text.ParseException;

public interface Lexer {

    MyToken curToken();
    int curPos();
    void nextToken() throws ParseException;
    Enum valueOf(String value);
}
