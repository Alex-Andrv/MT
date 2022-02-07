package generator;

import grammar.model.Grammar;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class LexerGenerator extends Generator {


    public static final List<String> IMPORTS = List.of(
            "grammar.model.LexerRule",
            "java.util.List",
            "util.AbstractLexer",
            "java.io.InputStream",
            "java.text.ParseException");



    public LexerGenerator(Grammar grammar) {
        super(grammar);
    }

    public void genFile(Path outDir) throws IOException {
        String grammarName = grammar.grammarName;
        String className = getLexerName(grammarName);
        Path file = outDir.resolve(className + ".java");
        createFile(file, className);
        try (BufferedWriter bf = Files.newBufferedWriter(file)) {
            writeHeaders(bf);
            writeImports(bf, IMPORTS);
            writeln(bf, "public class " + className + " extends AbstractLexer { ");
            cntTab++;
            writeConstructor(bf, className);
            cntTab--;
            bf.newLine();
            cntTab++;
            writeValueOf(bf);
            cntTab--;
            bf.write("}");
        }
    }


    private void writeConstructor(BufferedWriter bf, String className) throws IOException {
        writeln(bf, String.format("public %s(InputStream input) throws ParseException {", className));
        cntTab++;
        writeln(bf, "super(input);");
        writeln(bf, String.format("lexerRules = List.of(%s);", getLexerRules()));
        cntTab--;
        writeln(bf, "}");
    }

    private void writeValueOf(BufferedWriter bf) throws IOException {
        writeln(bf, "@Override");
        writeln(bf, "public Enum valueOf(String value) {");
        cntTab++;
        writeln(bf,  "return " + TokenEnumGenerator.getEnumName(grammar.grammarName) + ".valueOf(value);");
        cntTab--;
        writeln(bf, "}");
    }

    public static String getLexerName(String grammarName) {
        return grammarName + "Lexer";
    }

    private String getLexerRules() {
        return grammar.lexerRules.stream().map(s ->
                String.format("new LexerRule(\"%s\", \"%s\", %s)", s.ruleName, s.getRegExp(), s.isSkip()))
                .collect(Collectors.joining(","));
    }
}