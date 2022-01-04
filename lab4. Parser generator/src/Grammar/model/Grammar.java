package grammar.model;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Grammar {

    public static final Set<String> RESERVED_TOKENS = Set.of("EOF");

    public String grammarName;

    public Optional<TranslatingSymbol> headers;

    public List<ParserRule> parserRules;

    public List<LexerRule> lexerRules;

    public Grammar(String grammarName, Optional<TranslatingSymbol> headers,
                   List<ParserRule> parserRules, List<LexerRule> lexerRules) {
        this.grammarName = grammarName;
        this.headers = headers;
        checkParserRules(parserRules);
        this.parserRules = parserRules;
        checkLexerRule(lexerRules);
        this.lexerRules = lexerRules;
    }

    private void checkParserRules(List<ParserRule> parserRules) {
        // TODO
    }

    private void checkLexerRule(List<LexerRule> lexerRules) {

        List<String> notUniqueKey = lexerRules.stream().
                collect(Collectors.groupingBy(LexerRule::getRuleName)).
                entrySet().stream().
                filter(s -> s.getValue().size() > 1).map(Map.Entry::getKey)
                .collect(Collectors.toList());

        if (!notUniqueKey.isEmpty()) {
            throw new IllegalStateException("rule " + notUniqueKey.get(0) + " redefinition");
        }

        List<String> reservedTokens = lexerRules.stream().
                map(LexerRule::getRuleName).
                filter(RESERVED_TOKENS::contains).
                collect(Collectors.toList());

        if (!reservedTokens.isEmpty()) {
            throw new IllegalStateException("rule " + reservedTokens.get(0) + " is reserved");
        }

    }
}
