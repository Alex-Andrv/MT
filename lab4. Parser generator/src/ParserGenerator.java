import grammar.model.Grammar;
import grammar.model.ParserRule;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ParserGenerator extends Generator{

    public static final List<String> IMPORTS = List.of(
            "java.io.ByteArrayInputStream",
            "java.io.InputStream",
            "java.text.ParseException;");

    public ParserGenerator(Grammar grammar) {
        super(grammar);
    }

    @Override
    public void genFile(Path outDir) throws IOException {
        String grammarName = grammar.grammarName;
        String className = grammarName + "Parser";
        Path file = outDir.resolve(className);
        createFile(file, className);
        try (BufferedWriter bf = Files.newBufferedWriter(file)) {
            writeHeaders(bf);
            writeImports(bf);
            bf.write("public class " + className + " { ");
            bf.newLine();
            writeFields(bf, 1);
            bf.newLine();
            writeConstructors(bf, 1);
            bf.newLine();
            writeRule(bf, 1);
            bf.write("}");
        }
    }

    private void writeRule(BufferedWriter bf, int cntTab) throws IOException {
        for (ParserRule parserRule : grammar.parserRules) {
            bf.write(parserRule.genRuleContext(cntTab));
            bf.newLine();
            bf.write(parserRule.genRule(cntTab));
            bf.newLine();
        }
    }

    private void writeImports(BufferedWriter bf) throws IOException {
        for (String imp : IMPORTS) {
            bf.write("import " + imp + ';');
            bf.newLine();
        }
    }

    private void writeConstructors(BufferedWriter bf, int cntTab) throws IOException {
        writeTabs(bf, cntTab);
        bf.write("public void parse(InputStream is) throws ParseException {");
        bf.newLine();
        writeTabs(bf, cntTab + 1);
        bf.write("lex = new LexicalAnalyzer(is);");
        bf.newLine();
        writeTabs(bf, cntTab + 1);
        bf.write("lex.nextToken();");
        bf.newLine();
        writeTabs(bf, cntTab);
        bf.write("}");
        bf.newLine();

        writeTabs(bf, cntTab);
        bf.write("public Tree parse(String source) throws ParseException {");
        bf.newLine();
        writeTabs(bf, cntTab + 1);
        bf.write("return parse(new ByteArrayInputStream(source.getBytes()));");
        bf.newLine();
        writeTabs(bf, cntTab + 1);
        bf.write("}");
        bf.newLine();
    }

    private void writeFields(BufferedWriter bf, int cntTab) throws IOException {
        writeTabs(bf, cntTab);
        bf.write("Lexer lex;");
        bf.newLine();
    }


}
