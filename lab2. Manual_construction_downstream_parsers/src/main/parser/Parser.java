package parser;

import model.Tree;
import token.Token;
import token.LexicalAnalyzer;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.ParseException;

public class Parser {

//    S -> fun FUN_NAME ( PARAMS )  RETURN_VAL
//    PARAMS -> PARAM TAIL
//    PARAMS -> eps
//    PARAM -> VAR : TYPE
//    TAIL -> , PARAM TAIL
//    TAIL -> eps
//    RETURN_VAL -> : RETURN_TYPE
//    RETURN_VAL -> eps
//    FUN_NAME -> [a-zA_Z_][a-zA_Z0-9_]*
//    TYPE -> [a-zA_Z_][a-zA_Z0-9_]*
//    TYPE -> (TYPES) -> TYPE
//    VAR -> [a-zA_Z_][a-zA_Z0-9_]*
//    RETURN_TYPE -> [a-zA_Z_][a-zA_Z0-9_]*
//    RETURN_TYPE -> (TYPES) -> RETURN_TYPE
//    TYPES -> eps
//    TYPES -> TYPE TYPES_TAIL
//    TYPES_TAIL -> , TYPE TYPES_TAIL
//    TYPES_TAIL -> eps


    LexicalAnalyzer lex;

    public static final Tree EPS = new Tree ("\u03B5");

    private Tree S() throws ParseException {
        switch (lex.curToken()) {
            case FUN:
                // FUN
                lex.nextToken();
                // FULL_NAME
                Tree funName = FUN_NAME();
                // (
                if (lex.curToken() != Token.OPEN_PARENTHESIS) {
                    throw new ParseException("Expected '(', but found: " + lex.curChar(), lex.curPos());
                }
                lex.nextToken();
                // PARAMS
                Tree params = PARAMS();
                // )
                if (lex.curToken() != Token.CLOSE_PARENTHESIS) {
                    throw new ParseException("Expected ')', but found: " + lex.curChar(), lex.curPos());
                }
                lex.nextToken();
                // RETURN_TYPE
                Tree returnVal = RETURN_VAL();
                // $
                if (lex.curToken() != Token.END) {
                    throw new ParseException("Expected $, but found: " + lex.curChar(), lex.curPos());
                }
                lex.nextToken();

                return new Tree("S", new Tree("fun"), funName,
                        new Tree("("), params,
                        new Tree(")"), returnVal);

            default:
                throw new ParseException("Expected `fun`, but found: " + lex.curChar(),
                        lex.curPos());
        }
    }


    private Tree PARAMS() throws ParseException {
        switch (lex.curToken()) {
            case IDENTIFIER:
                // PARAM
                Tree param = PARAM();
                // TAIL
                Tree tail = TAIL();

                return new Tree("PARAMS", param, tail);

            case CLOSE_PARENTHESIS:
                return new Tree("PARAMS", EPS);

            default:
                throw new ParseException("Expected `[a-zA_Z_][a-zA_Z0-9_]*` or `)`, but found: " + lex.curChar(),
                        lex.curPos());
        }
    }


    private Tree PARAM() throws ParseException {
        switch (lex.curToken()) {
            case IDENTIFIER:
                // VAR
                Tree var = VAR();
                // `:`
                if (lex.curToken() != Token.COLON) {
                    throw new ParseException("Expected ':', but found: " + lex.curChar(), lex.curPos());
                }
                lex.nextToken();
                // TYPE
                Tree type = TYPE();

                return new Tree("PARAM", var, new Tree(":"), type);

            default:
                throw new ParseException("Expected `[a-zA_Z_][a-zA_Z0-9_]*`, but found: " + lex.curChar(),
                        lex.curPos());
        }
    }


    private Tree TAIL() throws ParseException {
        switch (lex.curToken()) {
            case COMMA:
                // `,`
                lex.nextToken();
                // PARAM
                Tree param = PARAM();
                // TAIL
                Tree tail = TAIL();

                return new Tree("TAIL", new Tree(","), param, tail);

            case CLOSE_PARENTHESIS:
                return new Tree("TAIL", EPS);

            default:
                throw new ParseException("Expected `,` or `)`, but found: " + lex.curChar(),
                        lex.curPos());
        }
    }


    private Tree RETURN_VAL() throws ParseException {
        switch (lex.curToken()) {
            case COLON:
                // COLON
                lex.nextToken();
                // RETURN_TYPE
                Tree returnType = RETURN_TYPE();

                return new Tree("RETURN_VAL", new Tree(":"), returnType);
            case END:
                return new Tree("RETURN_VAL", EPS);
            default:
                throw new ParseException("Expected `:` or $, but found: " + lex.curChar(),
                        lex.curPos());
        }
    }

    private Tree type(String name) throws ParseException {
        switch (lex.curToken()) {
            case IDENTIFIER:
                lex.nextToken();
                return new Tree(name);
            case OPEN_PARENTHESIS:
                lex.nextToken();
                // TYPES
                Tree types = TYPES(name);
                // )
                if (lex.curToken() != Token.CLOSE_PARENTHESIS) {
                    throw new ParseException("Expected ')', but found: " + lex.curChar(), lex.curPos());
                }
                lex.nextToken();
                // ->
                if (lex.curToken() != Token.FUNCTIONAL_ARROW) {
                    throw new ParseException("Expected '->', but found: " + lex.curChar(), lex.curPos());
                }
                lex.nextToken();
                // TYPES
                Tree type = type(name);

                return new Tree(
                        name,
                        new Tree("("),
                        types,
                        new Tree(")"),
                        new Tree("->", type));
            default:
                throw new ParseException("Expected `[a-zA_Z_][a-zA_Z0-9_]*`, but found: " + lex.curChar(),
                        lex.curPos());
        }
    }


    private Tree TYPES(String name) throws ParseException { //
        switch (lex.curToken()) {
            case IDENTIFIER:
            case OPEN_PARENTHESIS:
                // TYPE
                Tree type = TYPE();
                // TAIL
                Tree types_tail = TYPES_TAIL(name);

                return new Tree("TYPES", type, types_tail);

            case CLOSE_PARENTHESIS:
                return new Tree("TYPES", EPS);

            default:
                throw new ParseException("Expected `[a-zA_Z_][a-zA_Z0-9_]*` or `)`, but found: " + lex.curChar(),
                        lex.curPos());
        }
    }

    private Tree TYPES_TAIL(String name) throws ParseException {
        switch (lex.curToken()) {
            case COMMA:
                // `,`
                lex.nextToken();
                // TYPE
                Tree type = type(name);
                // TAIL
                Tree tail = TYPES_TAIL(name);

                return new Tree("TYPES_TAIL", new Tree(","), type, tail);

            case CLOSE_PARENTHESIS:
                return new Tree("TYPES_TAIL", EPS);

            default:
                throw new ParseException("Expected `,` or `)`, but found: " + lex.curChar(),
                        lex.curPos());
        }
    }

    private Tree TYPE() throws ParseException { //
        return type("TYPE");
    }

    // RETURN_TYPE != TYPE (logically), because different Follow sets.
    private Tree RETURN_TYPE() throws ParseException {
        return type("RETURN_TYPE");
    }

    private Tree VAR() throws ParseException {
       return identifier("VAR");
    }

    private Tree FUN_NAME() throws ParseException {
        return identifier("FUN_NAME");
    }

    private Tree identifier(String name) throws ParseException {
        switch (lex.curToken()) {
            case IDENTIFIER:
                lex.nextToken();
                return new Tree(name);
            default:
                throw new ParseException("Expected `[a-zA_Z_][a-zA_Z0-9_]*`, but found: " + lex.curChar(),
                        lex.curPos());
        }
    }

    public Tree parse(InputStream is) throws ParseException {
        lex = new LexicalAnalyzer(is);
        lex.nextToken();
        return S();
    }

    public Tree parse(String source) throws ParseException {
        return parse(new ByteArrayInputStream(source.getBytes()));
    }
}
