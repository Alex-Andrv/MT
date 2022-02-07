import generator.LexerGenerator;
import generator.ParserGenerator;
import generator.TokenEnumGenerator;
import grammar.gen.LexerGrammar;
import grammar.gen.ParserGrammar;
import grammar.model.Grammar;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Generator {

    private static final Path DEFAULT_OUT_DIR = Path.of("gen");

    /**
     * Prints the required format of the input data and terminates the program.
     */
    private static void printUsage(String error) {
        if (!error.isEmpty()) {
            System.err.println(error);
        }
        System.err.println("Usage: <input grammar> <output dir (optional)>. Sample: ex.g gen");
    }

    public static void main(String[] args) throws IOException {
        Objects.requireNonNull(args);
        if ((!List.of(1, 2).contains(args.length)) || Arrays.stream(args).anyMatch(Objects::isNull)) {
            printUsage("");
            return;
        }
        // grammar.g outDir
        Path inputGrammar = Path.of(args[0]);
        if (!Files.exists(inputGrammar)) {
            printUsage("input grammar don't exist");
            return;
        }
        Path outDir = DEFAULT_OUT_DIR;
        if (args.length == 2) {
            outDir = Path.of(args[1]);
        }
        System.out.println("Create outDir");
        Files.createDirectories(outDir);
        try {
            Grammar grammar = getGrammar(inputGrammar);
            generateLexerAndParser(grammar, outDir);
        } catch (IOException e) {
            printUsage(e.getMessage());
        }
    }

    private static void generateLexerAndParser(Grammar grammar, Path outDir) throws IOException {
        TokenEnumGenerator tokenEnumGenerator = new TokenEnumGenerator(grammar);
        LexerGenerator lexerGenerator = new LexerGenerator(grammar);
        ParserGenerator parserGenerator = new ParserGenerator(grammar);

        tokenEnumGenerator.genFile(outDir);
        lexerGenerator.genFile(outDir);
        parserGenerator.genFile(outDir);
    }

    private static Grammar getGrammar(Path inputGrammar) throws IOException {
        LexerGrammar lexerGrammar = new LexerGrammar(CharStreams.fromPath(inputGrammar));
        ParserGrammar parserGrammar = new ParserGrammar(new CommonTokenStream(lexerGrammar));
        return parserGrammar.translationGrammar().gr;
    }
}
