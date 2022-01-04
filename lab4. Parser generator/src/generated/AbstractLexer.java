package generated;

import grammar.model.LexerRule;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;

public abstract class AbstractLexer {

    private final InputStream input;
    Queue<Character> buffer;
    int realPos;
    int curPos;
    int realChar;
    MyToken curToken;

    public List<LexerRule> lexerRules;


    protected AbstractLexer(InputStream input) throws ParseException {
        this.input = input;
        this.buffer = new ArrayDeque<>();
        realPos = 0;
        curPos = 0;
        nextToken();
    }

    protected abstract Enum valueOf(String value);


    private String getBufferString() {
        return buffer.stream().collect(Collector.of(
                StringBuilder::new,
                StringBuilder::append,
                StringBuilder::append,
                StringBuilder::toString));
    }

    public void nextNonSkipToken() throws ParseException {
        while (curToken.isSkip()) {
            curToken = nextToken();
        }
    }

    private MyToken nextToken() throws ParseException {
        List<LexerRule> candidates = new ArrayList<>(lexerRules);
        MyToken token = null;
        int newPos = curPos;
        while (realChar != -1 && candidates.size() > 0) {
            String curString = getBufferString();
            List<LexerRule> newCandidates = new ArrayList<>();
            for (LexerRule candidate : candidates) {
                Matcher matcher = Pattern.compile(candidate.regExp).matcher(curString);
                if (matcher.hitEnd()) {
                    newCandidates.add(candidate);
                }
                if (matcher.lookingAt()) {
                    String matchedString = curString.substring(0, matcher.end());
                    Enum type = valueOf(candidate.ruleName);
                    if (Objects.isNull(token)) {
                        token = new MyToken(type, matchedString, curPos, candidate.isSkip());
                        newPos = curPos + matcher.end();
                    } else if (token.getTokenLen() < matcher.end()){
                        token = new MyToken(type, matchedString, curPos, candidate.isSkip());
                        newPos = curPos + matcher.end();
                    }
                }
                candidates = newCandidates;
            }
            nextChar();
        }

        if (curPos == realPos && realChar == -1) {
            token = new MyToken(valueOf("EOF"), "", curPos, false);
        }

        if (Objects.isNull(token)) {
            throw new ParseException("Token recognition error at: '?'" + getBufferString(), curPos);
        }

        removeProcessedChars(newPos);

        return token;
    }


    private void removeProcessedChars(int newPost) {
        while (curPos++ != newPost) {
            buffer.remove();
        }
    }

    private void nextChar() throws ParseException {
        realPos++;
        try {
            realChar = input.read();
            if (realChar != -1) {
                buffer.add((char) realChar);
            }
        } catch (IOException e) {
            throw new ParseException(e.getMessage(), realPos);
        }
    }

    public MyToken curToken() {
        return curToken;
    }

    public int curPos() {
        return curPos;
    }
}

