import grammar.model.Grammar;
import grammar.model.LexerRule;

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
        String className = grammarName + "Lexer";
        Path file = outDir.resolve(className);
        createFile(file, className);
        try (BufferedWriter bf = Files.newBufferedWriter(file)) {
            writeHeaders(bf);
            bf.write("public class " + className + " extends AbstractLexer { ");
            bf.newLine();
            writeConstructor(bf, 1);
            bf.newLine();
            writeValueOf(bf, 1);
            bf.write("}");
        }
    }


    private void writeConstructor(BufferedWriter bf, int cntTab) throws IOException {
        writeTabs(bf, cntTab);
        bf.write("protected Lexer(InputStream input) throws ParseException {");
        bf.newLine();
        writeTabs(bf, cntTab + 1);
        bf.write("super(input);");
        bf.newLine();
        writeTabs(bf, cntTab);
        bf.write("}");
        bf.newLine();
    }

    private void writeValueOf(BufferedWriter bf, int cntTab) throws IOException {
        writeTabs(bf, cntTab);
        bf.write("@Override");
        bf.newLine();
        writeTabs(bf, cntTab);
        bf.write("protected Enum valueOf(String value) {");
        bf.newLine();
        writeTabs(bf, cntTab + 1);
        bf.write("return TokenEnum.valueOf(value);");
        bf.newLine();
        writeTabs(bf, cntTab);
        bf.write("}");
        bf.newLine();
    }

}














