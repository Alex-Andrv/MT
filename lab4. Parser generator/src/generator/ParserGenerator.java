package generator;

import util.AbstractLexer;
import grammar.model.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class ParserGenerator extends Generator {

    public final Map<Symbol, Set<String>> FIRST = new HashMap<>();
    public final Map<Symbol, Set<String>> FOLLOW = new HashMap<>();

    public static final List<String> IMPORTS = List.of(
            "java.io.ByteArrayInputStream;",
            "java.io.InputStream;",
            "java.text.ParseException;",
            "generated.Lexer",
            "generated.Tree");

    public ParserGenerator(Grammar grammar) {
        super(grammar);
        genFirstAndFollow();
    }

    private void genFirstAndFollow() {
        genFirst();
 //       genFollow();
    }

    private void genFirst() {
//        for (String ruleName : grammar.parserRules.keySet()) {
//            FIRST.put(ruleName, new HashSet<>());
//        }
//
//        boolean repeat = true;
//        while (repeat) {
//            repeat = false;
//            for (Map.Entry<String, Set<String>> entry : FIRST.entrySet()) {
//                String ruleName = entry.getKey();
//                ParserRule rule = grammar.parserRules.get(ruleName);
//                if (rule == null) {
//                    throw new IllegalStateException(ruleName + "don't exist");
//                }
//                Set<String> set = entry.getValue();
//                for (List<Symbol> symbols : rule.getRules()) {
//                    for (Symbol symbol : symbols) {
//                        if (symbol instanceof TerminalSymbol) {
//                            set.add(((TerminalSymbol) symbol).getTerminalName());
//                            break;
//                        } else if (symbol instanceof NonTerminalSymbol) {
//                            Set<String> symbolName = FIRST.get(((NonTerminalSymbol) symbol).getNonTerminalName());
//                            if (symbolName.contains())
//                        }
//                    }
//                }
//            }
//        }
    }


    @Override
    public void genFile(Path outDir) throws IOException {
        String grammarName = grammar.grammarName;
        String className = grammarName + "Parser";
        Path file = outDir.resolve(className + ".java");
        createFile(file, className);
        try (BufferedWriter bf = Files.newBufferedWriter(file)) {
            writeHeaders(bf);
            writeImports(bf);
            writeln(bf, "public class " + className + " { ");
            writeFields(bf);
            writeConstructors(bf, grammarName);
            writeRules(bf);
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
                parserRule.syntAtrs.stream().map(s -> s.type + " " + s.value).collect(Collectors.joining()) +
                ")" + " throws ParseException " + "{");
        for (List<Symbol> rule : parserRule.rules) {
            if (rule.size() == 0) {
                // Пока хз
            }

            writeln(bf, "if (" + getIfConditional(rule.get(0)) + ") {");

            for (Symbol symbol : rule) {
                writeSymbol(bf, symbol);
            }

            writeln(bf, "return что-то;");
            writeln(bf, "}");
        }
        writeln(bf, "}");
    }

    private void writeSymbol(BufferedWriter bf, Symbol symbol) throws IOException {
        if (symbol instanceof TranslatingSymbol) {
            TranslatingSymbol tr = (TranslatingSymbol) symbol;
            for (String line : tr.code.split("\n")) {
                writeln(bf, line);
            }
        } else if (symbol instanceof TerminalSymbol) {
            writeln(bf, "if");
        }
    }

    private String getIfConditional(Symbol symbol) {
        Set<String> nextElms = FIRST.get(symbol);
        if (nextElms.remove(AbstractLexer.EPS)) {
            nextElms.addAll(FOLLOW.get(symbol));
        }
        return "Set.of(" + String.join(",", nextElms) + ").contains(lex.curToken())";
    }

    private String getFirst(List<Symbol> rule) {
        return "";
    }

    public void writeRuleContext(BufferedWriter bf, ParserRule parserRule) throws IOException {
        writeln(bf, "public static class " + getContextName(parserRule) + " extends Tree" + "{");
        for (Attribute inhAtr : parserRule.inhAtrs ) {
            writeln(bf, inhAtr.type + " " + inhAtr.value + ";");
        }
        writeln(bf, "}");
    }

    private void writeImports(BufferedWriter bf) throws IOException {
        for (String imp : IMPORTS) {
            writeln(bf, "import " + imp + ';');
        }
        bf.newLine();
    }

    private void writeConstructors(BufferedWriter bf, String grammarName) throws IOException {
        writeln(bf, "public void " + grammarName + " (InputStream is) throws ParseException {");
        writeln(bf, "lex = new " + LexerGenerator.getLexerName(grammarName) + "(is);");
        writeln(bf,  "lex.nextToken();");
        writeln(bf, "}");
        bf.newLine();
    }

    private void writeFields(BufferedWriter bf) throws IOException {
        writeln(bf, "Lexer lex;");
        bf.newLine();
    }

    private String getContextName(ParserRule parserRule) {
        String name =  parserRule.getRuleName();
        String upperCaseName = name.substring(0, 1).toUpperCase() + name.substring(1);
        return upperCaseName + "Context";
    }
}
