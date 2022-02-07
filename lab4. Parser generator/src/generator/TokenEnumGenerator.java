package generator;

import grammar.model.Grammar;
import grammar.model.LexerRule;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class TokenEnumGenerator extends Generator {

    public TokenEnumGenerator(Grammar grammar) {
        super(grammar);
    }

    @Override
    public void genFile(Path outDir) throws IOException {
        String grammarName = grammar.grammarName;
        String enumName = getEnumName(grammarName);
        Path file = outDir.resolve(enumName + ".java");
        createFile(file, enumName);
        try (BufferedWriter bf = Files.newBufferedWriter(file)) {
            writeHeaders(bf);
            bf.write("public enum " + enumName + " { ");
            bf.newLine();
            writeTokens(bf);
            bf.write("}");
        }
    }

    private void writeTokens(BufferedWriter bf) throws IOException {

        bf.write(grammar.
                lexerRules.
                stream().
                map(LexerRule::getRuleName).
                collect(Collectors.joining(", ")));

        bf.write(", ");
        bf.write(String.join(", ", Grammar.RESERVED_TOKENS));
        bf.newLine();
    }

    public static String getEnumName(String ruleName) {
        return ruleName + "Enum";
    }
}
