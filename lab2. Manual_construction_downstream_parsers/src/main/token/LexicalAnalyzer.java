package token;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

public class LexicalAnalyzer {

    InputStream is;
    int curChar;
    int curPos;
    Token curToken;

    public LexicalAnalyzer(InputStream is) throws ParseException {
        this.is = is;
        curPos = 0;
        nextChar();
    }

    private boolean isBlank(int c) {
        return Character.isWhitespace(c);
    }

    private void nextChar() throws ParseException {
        curPos++;
        try {
            curChar = is.read();
        } catch (IOException e) {
            throw new ParseException(e.getMessage(), curPos);
        }
    }

    public void nextToken() throws ParseException {
        while (isBlank(curChar)) {
            nextChar();
        }
        switch (curChar) {
            case '(':
                nextChar();
                curToken = Token.OPEN_PARENTHESIS;
                break;
            case ')':
                nextChar();
                curToken = Token.CLOSE_PARENTHESIS;
                break;
            case ':':
                nextChar();
                curToken = Token.COLON;
                break;
            case ',':
                nextChar();
                curToken = Token.COMMA;
                break;
            case '-':
                nextChar();
                if (curChar != '>') {
                    throw new ParseException("Expected >, but found: " + curChar, curPos);
                }
                nextChar();
                curToken = Token.FUNCTIONAL_ARROW;
                break;
            case -1:
                curToken = Token.END;
                break;
            default:
                curToken = getLongToken();
        }
    }

    private Token getLongToken() throws ParseException {
        if (Character.isLetter(curChar) || (curChar == '_')) {
            StringBuilder token = new StringBuilder();
            token.append((char) curChar);
            nextChar();
            while (Character.isLetter(curChar) || (curChar == '_') || Character.isDigit(curChar)) {
                token.append((char) curChar);
                nextChar();
            }
            String stringToken =  token.toString();
            if (stringToken.equals("fun")) {
                return Token.FUN;
            } else {
                return Token.IDENTIFIER;
            }
        } else {
            throw new ParseException("Expected letter or '_', but found: " + curChar, curPos);
        }
    }

    public Token curToken() {
        return curToken;
    }

    public Token curChar() {
        return curToken;
    }

    public int curPos() {
        return curPos;
    }
}
