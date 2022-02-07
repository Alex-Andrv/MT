package util;

import grammar.model.LexerRule;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;

public abstract class AbstractLexer implements Lexer {

    private final InputStream input;
    Queue<Character> buffer;
    int realPos;
    int curPos;
    int lastRead;
    MyToken curToken;

    public List<LexerRule> lexerRules;


    protected AbstractLexer(InputStream input) throws ParseException {
        this.input = input;
        this.buffer = new ArrayDeque<>();
        realPos = 0;
        curPos = 0;
    }

    public abstract Enum valueOf(String value);


    private String getBufferString() {
        return buffer.stream().collect(Collector.of(
                StringBuilder::new,
                StringBuilder::append,
                StringBuilder::append,
                StringBuilder::toString));
    }

    public void nextToken() throws ParseException {

        MyToken token;

        do {
            Set<LexerRule> candidates = new HashSet<>(lexerRules);
            token = null;
            int newPos = curPos;
            while (!isEnd() && candidates.size() > 0) {
                Set<LexerRule> newCandidates = new HashSet<>();
                for (LexerRule candidate : candidates) {
                    String curString = getBufferString();
                    Matcher matcher = Pattern.compile(candidate.regExp).matcher(curString);
                    matcher.matches();
                    if (matcher.hitEnd() && lastRead != -1) {
                        newCandidates.add(candidate);
                    }
                    if (matcher.lookingAt()) {
                        String matchedString = curString.substring(0, matcher.end());
                        Enum type = valueOf(candidate.ruleName);
                        if (Objects.isNull(token)) {
                            token = new MyToken(type, matchedString, curPos, candidate.isSkip());
                            newPos = curPos + matcher.end();
                        } else if (token.getTokenLen() < matcher.end()) {
                            token = new MyToken(type, matchedString, curPos, candidate.isSkip());
                            newPos = curPos + matcher.end();
                        }
                    }
                }
                candidates = newCandidates;
                nextChar();
            }

            if (isEnd()) {
                token = new MyToken(valueOf("EOF"), "", curPos, false);
            }

            if (Objects.isNull(token)) {
                throw new ParseException("Token recognition error at: " + getBufferString(), curPos);
            }

            removeProcessedChars(newPos);
        } while (token.isSkip());

        curToken = token;
    }


    private void removeProcessedChars(int newPost) {
        while (curPos != newPost) {
            buffer.remove();
            curPos++;
        }
    }

    private void nextChar() throws ParseException {
        try {
            lastRead = input.read();
            if (lastRead != -1) {
                realPos++;
                buffer.add((char) lastRead);
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

    private boolean isEnd() {
        return curPos == realPos && lastRead == -1;
    }
}

