import grammar.model.Grammar;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Deprecated
public class TokenGenerator extends Generator {

    public static final List<String> FIELDS = List.of("");

    public TokenGenerator(Grammar grammar) {
        super(grammar);
    }

    @Override
    public void genFile(Path outDir) throws IOException {
        String grammarName = grammar.grammarName;
        String tokenClassName = grammarName + "Token";
        Path file = outDir.resolve(tokenClassName);
        createFile(file, tokenClassName);
        try (BufferedWriter bf = Files.newBufferedWriter(file)) {
            writeHeaders(bf);
            bf.write("public class " + tokenClassName + " extends AbstractToken { ");
            bf.newLine();

            bf.write("final TokenEnum token;");
            bf.newLine();
            bf.write("public Token(String ruleName, String text, int startIndex, boolean skip) {");
            bf.newLine();
            bf.write("super(text, startIndex, skip);");
            bf.newLine();
            bf.write("this.token = TokenEnum.valueOf(ruleName);");
            bf.newLine();
            bf.write("}");



            bf.write("}");
        }
    }

}
