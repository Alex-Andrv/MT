package generator;

import grammar.model.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class ParserGenerator extends Generator {

    public static final List<String> IMPORTS = List.of(
            "java.io.InputStream;",
            "java.text.ParseException;",
            "util.Lexer",
            "util.Tree",
            "java.util.Set",
            "util.MyToken");

    public ParserGenerator(Grammar grammar) {
        super(grammar);
    }

    public String getContextVar() {
        return "_localctx";
    }

    public String getLexerVar() {
        return "lex";
    }


    @Override
    public void genFile(Path outDir) throws IOException {
        String grammarName = grammar.grammarName;
        String className = getParserName(grammarName);
        Path file = outDir.resolve(className + ".java");
        createFile(file, className);
        try (BufferedWriter bf = Files.newBufferedWriter(file)) {
            writeHeaders(bf);
            writeImports(bf, IMPORTS);
            writeln(bf, "public class " + className + " { ");
            cntTab++;
            writeFields(bf);
            writeConstructors(bf, grammarName);
            writeRules(bf);
            cntTab--;
            bf.write("}");
        }
    }

    private void writeRules(BufferedWriter bf) throws IOException {
        for (ParserRule parserRule : grammar.parserRules.values()) {
            writeRuleContext(bf, parserRule);
            bf.newLine();
            writeParserRule(bf, parserRule);
            bf.newLine();
        }
    }

    private void writeParserRule(BufferedWriter bf, ParserRule parserRule) throws IOException {
        writeln(bf, "public " + getContextName(parserRule) + " " + parserRule.getRuleName()
                + "(" +
                parserRule.inhAtrs.stream().map(s -> s.type + " " + s.value).collect(Collectors.joining()) +
                ")" + " throws ParseException " + "{");
        cntTab++;

        writeln(bf, getContextName(parserRule) + " " + getContextVar() +
                " = new " + getContextName(parserRule) + "(\"" + parserRule.getRuleName() + "\");");

        for (List<Symbol> rule : parserRule.rules) {

            Set<String> nextElms = grammar.getNext(rule, parserRule.getRuleName());

            String ifCondition = String.format("Set.of(%s).contains(%s.curToken().token)",
                    nextElms.stream().map(this::getEnum).collect(Collectors.joining(",")), getLexerVar());

            writeln(bf, "if (" + ifCondition + ") {");
            cntTab++;

            for (Symbol symbol : rule) {
                writeSymbol(bf, symbol);
            }

            writeln(bf, "return " + getContextVar() + ";");
            cntTab--;
            writeln(bf, "}");
        }

        writeln(bf, String.format("throw new ParseException(\"don't expected token: \" + %s.curToken().text, %s.curPos());", getLexerVar(), getLexerVar()));

        cntTab--;

        writeln(bf, "}");
    }

    private String  getEnum(String s) {
        return TokenEnumGenerator.getEnumName(grammar.grammarName) + "." + s;
    }

    private void writeSymbol(BufferedWriter bf, Symbol symbol) throws IOException {
        if (symbol instanceof TranslatingSymbol tr) {
            tr.normalize(getContextVar());
            for (String line : tr.code.split("\n")) {
                writeln(bf, line);
            }
            bf.newLine();
        } else if (symbol instanceof TerminalSymbol ts) {
            writeln(bf, String.format("if (%s.curToken().token != %s) {", getLexerVar(), getEnum(ts.terminalName)));
            cntTab++;
            writeln(bf, String.format("throw new ParseException(\"Expected %s, but found: \"" +
                            " + %s.curToken().text, lex.curPos());", ts.terminalName, getLexerVar()));
            cntTab--;
            writeln(bf, "}");
            writeln(bf, String.format("%s.add(new Tree(%s.curToken().text));", getContextVar(), getLexerVar()));
            writeln(bf, String.format("MyToken %s = %s.curToken();", ts.var,getLexerVar()));
            writeln(bf, getLexerVar() + ".nextToken();");
            bf.newLine();
        } else if (symbol instanceof  NonTerminalSymbol nt) {
            writeln(bf, String.format("%s %s = %s(%s);",
                    getContextName(grammar.parserRules.get(nt.nonTerminalName)), nt.var, nt.nonTerminalName,
                    nt.translatingSymbol.code));
            writeln(bf, getContextVar() + ".add(" + nt.var + ");");
            bf.newLine();

        }
    }

    public void writeRuleContext(BufferedWriter bf, ParserRule parserRule) throws IOException {
        writeln(bf, "public static class " + getContextName(parserRule) + " extends Tree" + "{");
        cntTab++;

        writeln(bf, "public " + getContextName(parserRule) + "(String node, Tree... children) {");
        cntTab++;
        writeln(bf, "super(node, children);");
        cntTab--;
        writeln(bf, "}");

        writeln(bf, "public " + getContextName(parserRule) + "(String node) {");
        cntTab++;
        writeln(bf, "super(node);");
        cntTab--;
        writeln(bf, "}");

        for (Attribute syntAtr : parserRule.syntAtrs ) {
            writeln(bf, "public " + syntAtr.type + " " + syntAtr.value + ";");
        }
        cntTab--;
        writeln(bf, "}");
    }

    private void writeConstructors(BufferedWriter bf, String grammarName) throws IOException {
        writeln(bf, "public " +getParserName(grammarName) + "(InputStream is) throws ParseException {");
        cntTab++;
        writeln(bf, String.format("%s = new %s(is);", getLexerVar(),  LexerGenerator.getLexerName(grammarName)));
        writeln(bf,  String.format("%s.nextToken();", getLexerVar()));
        cntTab--;
        writeln(bf, "}");
        bf.newLine();
    }

    private void writeFields(BufferedWriter bf) throws IOException {
        writeln(bf, String.format("Lexer %s;", getLexerVar()));
        bf.newLine();
    }

    private String getContextName(ParserRule parserRule) {
        String name =  parserRule.getRuleName();
        String upperCaseName = name.substring(0, 1).toUpperCase() + name.substring(1);
        return upperCaseName + "Context";
    }

    public static String getParserName(String grammarName) {
        return grammarName + "Parser";
    }
}
