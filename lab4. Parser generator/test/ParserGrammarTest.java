import grammar.gen.LexerGrammar;
import grammar.gen.ParserGrammar;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;


class ParserGrammarTest {

    @Test
    public void parseGrammarName()   {
        ParserGrammar parserGrammar = getParserGrammar(" grammar grammarName    ;   ");
        assertNull(parserGrammar.grammarName().exception);
        parserGrammar = getParserGrammar("\n grammar \n grammarName    \n ;   \n");
        assertNull(parserGrammar.grammarName().exception);
        parserGrammar = getParserGrammar("\n grammar \n GrammarName    \n ;   \n");
        assertNull(parserGrammar.grammarName().exception);
    }

    @Test
    public void parseLexerRule()   {
        ParserGrammar parserGrammar = getParserGrammar(" Goooo : 'a+'; ");
        assertNull(parserGrammar.lexerRule().exception);
        parserGrammar = getParserGrammar(" GG : 'a+' -> skip; ");
        assertNull(parserGrammar.lexerRule().exception);
        parserGrammar = getParserGrammar(" GG : '()' -> skip    ; ");
        assertNull(parserGrammar.lexerRule().exception);
    }

    @Test
    public void parseLexerRules()   {
        ParserGrammar parserGrammar = getParserGrammar(" GG : 'a+'; ");
        assertNull(parserGrammar.lexerRules().exception);
        parserGrammar = getParserGrammar("             ");
        assertNull(parserGrammar.lexerRules().exception);
        parserGrammar = getParserGrammar(" GG : '()' -> skip    ;" +
                " GGWP : 'a+';");
        assertNull(parserGrammar.lexerRules().exception);
    }


    @Test
    public void parseAttribute() {
        ParserGrammar parserGrammar = getParserGrammar(" String foo ");
        assertNull(parserGrammar.attribute().exception);
    }

    @Test
    public void parseAttributes()   {
        ParserGrammar parserGrammar = getParserGrammar(" [String op] ");
        assertNull(parserGrammar.attributes().exception);
        parserGrammar = getParserGrammar(" [String op, Integer i, Bool d] ");
        assertNull(parserGrammar.attributes().exception);
    }

    @Test
    public void parseSynthesizedAttributes()   {
        ParserGrammar parserGrammar = getParserGrammar(" returns [String op] ");
        assertNull(parserGrammar.synthesizedAttributes().exception);
        parserGrammar = getParserGrammar("returns [String op, Integer i, Bool d] ");
        assertNull(parserGrammar.synthesizedAttributes().exception);
    }

    @Test
    public void parseInheritedAttributes()   {
        ParserGrammar parserGrammar = getParserGrammar(" [String op] ");
        assertNull(parserGrammar.inheritedAttributes().exception);
        parserGrammar = getParserGrammar("[String op, Integer i, Bool d] ");
        assertNull(parserGrammar.inheritedAttributes().exception);
    }


    @Test
    public void parseSemanticRules()   {
        ParserGrammar parserGrammar = getParserGrammar(" { " +
                " int a = 1;" +
                "}");
        assertNull(parserGrammar.semanticRules().exception);

        parserGrammar = getParserGrammar(" { " +
                " int a = 1;" +
                " for (int j = 0; j < 10; j++) {" +
                "           a *= 10;" +
                " }" +
                "}");
        assertNull(parserGrammar.semanticRules().exception);

        parserGrammar = getParserGrammar(" { " +
                " int a = 1;" +
                " for (int j = 0; j < 10; j++) {" +
                "    {" +
                "           a *= 10;" +
                "    }   " +
                " }" +
                "}");
        assertNull(parserGrammar.semanticRules().exception);
    }

    @Test
    public void parseTerminal() {
        ParserGrammar parserGrammar = getParserGrammar(" Terminal");
        assertNull(parserGrammar.terminal().exception);
    }

    @Test
    public void parseNonTerminal() {
        ParserGrammar parserGrammar = getParserGrammar(" nonTerminal");
        assertNull(parserGrammar.nonTerminal().exception);

        parserGrammar = getParserGrammar(" nonTerminal[{ss.res, a}]");
        assertNull(parserGrammar.nonTerminal().exception);
    }

    @Test
    public void parseDescriptionParseRule() {
        ParserGrammar parserGrammar = getParserGrammar(" hh = nonTerminal");
        assertNull(parserGrammar.descriptionParseRule().exception);
        parserGrammar = getParserGrammar(" hh = Terminal");
        assertNull(parserGrammar.descriptionParseRule().exception);
        parserGrammar = getParserGrammar(" { " +
                " int a = 1;" +
                "}");
        assertNull(parserGrammar.semanticRules().exception);
        parserGrammar = getParserGrammar(" hh2 = Terminal  hh = nonTerminal");
        assertNull(parserGrammar.descriptionParseRule().exception);

        parserGrammar = getParserGrammar(" hh2 = Terminal  hh = nonTerminal[{i, j.m}]" + " { " +
                " int a = 1;" +
                "}");
        assertNull(parserGrammar.descriptionParseRule().exception);

    }

    @Test
    public void parseParserRule() {
        ParserGrammar parserGrammar = getParserGrammar(" hh : gg = eg;");
        assertNull(parserGrammar.parserRule_().exception);
        parserGrammar = getParserGrammar(" hh : gg = eg | hh2 = Terminal | " + " { " +
                " int a = 1;" +
                "};");
        assertNull(parserGrammar.parserRule_().exception);

        parserGrammar = getParserGrammar(" hh  returns [String g]: gg = eg[{ g}] | hh2 = Terminal | " + " { " +
                " int a = 1;" +
                "};");
        assertNull(parserGrammar.parserRule_().exception);

        parserGrammar = getParserGrammar(" hh [Integer cnt] returns [String g]: gg = eg | hh2 = Terminal | " + " { " +
                " int a = 1;" +
                "};");
        assertNull(parserGrammar.parserRule_().exception);
    }

    @Test
    public void parseHeader() {
        ParserGrammar parserGrammar = getParserGrammar(" @header {asjdklaksjd}");
        assertNull(parserGrammar.header().exception);
    }

    @Test
    public void parseParserRules() {
        ParserGrammar parserGrammar = getParserGrammar(
                " calculator : e = expr ee = EOF;\n" +
                "\n" +
                "expr : t = term e = expr_;\n" +
                "\n" +
                "expr_ : a = ADD e1 = expr | s = SUB e2 = expr_[{a}] | e = EPS;\n" +
                "\n" +
                "term : a = atom t = term_;\n" +
                "\n" +
                "term_ : m = MUL t = term[{a, b}] | e = DIV t = term | e = EPS;\n" +
                "\n" +
                "atom : o = OPEN_P e = expr c = CLOSE_P | d = DIGIT;");
        assertNull(parserGrammar.parserRules().exception);
    }



    public ParserGrammar getParserGrammar(String in) {
        LexerGrammar lexerGrammar = new LexerGrammar(CharStreams.fromString(in));
        return new ParserGrammar(new CommonTokenStream(lexerGrammar));
    }

}