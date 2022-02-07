package generator;

import grammar.model.Grammar;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LexerGenerator extends Generator {


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
            bf.write("public class " + className + " extends AbstractLexer { ");
            bf.newLine();
            writeConstructor(bf, className);
            bf.newLine();
            writeValueOf(bf);
            bf.write("}");
        }
    }


    private void writeConstructor(BufferedWriter bf, String className) throws IOException {
        writeln(bf, String.format("protected %s(InputStream input) throws ParseException {", className));
        writeln(bf, "super(input);");
        writeln(bf, "}");
    }

    private void writeValueOf(BufferedWriter bf) throws IOException {
        writeln(bf, "@Override");
        writeln(bf, "protected Enum valueOf(String value) {");
        writeln(bf,  "return TokenEnum.valueOf(value);");
        writeln(bf, "}");
    }

    public static String getLexerName(String grammarName) {
        return grammarName + "Lexer";
    }

}