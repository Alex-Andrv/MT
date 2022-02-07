package generator;

import grammar.model.Grammar;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class Generator {

    protected int cntTab;

    protected final Grammar grammar;

    public Generator(Grammar grammar) {
        this.grammar = grammar;
        this.cntTab = 0;
    }

    public abstract void genFile(Path outDir) throws IOException;

    protected void writeHeaders(BufferedWriter bf) throws IOException {
        if (grammar.headers.isPresent()) {
            bf.write(grammar.headers.get().code);
            bf.newLine();
        }
    }

    protected void createFile(Path file, String className) throws IOException {
        System.out.println("Create " + className);
        Files.createFile(file);
    }

    protected void writeTabs(BufferedWriter bf) throws IOException {
        int _cntTab = cntTab;
        while (_cntTab-- > 0) {
            bf.write('\t');
        }
    }

    public void writeln(BufferedWriter bf, String str) throws IOException {
        writeTabs(bf);
        bf.write(str);
        bf.newLine();
    }
}
