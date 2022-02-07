package grammar.model;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Grammar {

    public final static String EPS = "";

    public static final Set<String> RESERVED_TOKENS = Set.of("EOF");

    public String grammarName;

    public Optional<TranslatingSymbol> headers;

    public Map<String, ParserRule> parserRules;

    public List<LexerRule> lexerRules;

    public final Map<String, Set<String>> FIRST;

    public final Map<String, Set<String>> FOLLOW;

    public Grammar(String grammarName, Optional<TranslatingSymbol> headers,
                   List<ParserRule> parserRules, List<LexerRule> lexerRules) {
        this.grammarName = grammarName;
        this.headers = headers;
        checkParserRules(parserRules);
        this.parserRules = parserRules.stream().collect(Collectors.toMap(ParserRule::getRuleName, Function.identity()));
        checkLexerRule(lexerRules);
        this.lexerRules = lexerRules;//.stream().collect(Collectors.toMap(LexerRule::getRuleName, Function.identity()));
        this.FIRST = new HashMap<>();
        genFirst();
        this.FOLLOW = new HashMap<>();
        genFollow();
        checkLL1();
    }

    private void checkLL1() {
        for (Map.Entry<String, ParserRule> entry : parserRules.entrySet()) {
            String ruleName = entry.getKey();
            List<List<Symbol>> rules = entry.getValue().rules;
            for (int i = 0; i + 1 < rules.size(); i++) {
                for (int j = i + 1; j < rules.size(); j++) {
                    Set<String> common = new HashSet<>(getNext(rules.get(i), ruleName));
                    common.retainAll(getNext(rules.get(j), ruleName));
                    if (!common.isEmpty()) {
                        throw new IllegalStateException("This is not ll1 grammar");
                    }
                }
            }
        }
    }

    private void genFirst() {
        for (String ruleName : this.parserRules.keySet()) {
            FIRST.put(ruleName, new HashSet<>());
        }

        boolean repeat = true;
        while (repeat) {
            repeat = false;
            for (Map.Entry<String, ParserRule> entry : parserRules.entrySet()) {
                String ruleName = entry.getKey();
                ParserRule rules  = entry.getValue();
                for (List<Symbol> rule : rules.rules) {
                    Set<String> first = calcFirst(rule);
                    Set<String> oldFirst = FIRST.get(ruleName);
                    if (!oldFirst.containsAll(first)) {
                        oldFirst.addAll(first);
                        repeat = true;
                    }
                }
            }
        }
    }

    private Set<String> calcFirst(List<Symbol> rule) {
        if (rule.size() == 0) {
            return Set.of(EPS);
        }
        Symbol firstSymbol = rule.get(0);
        if (firstSymbol instanceof TerminalSymbol) {
            return Set.of(((TerminalSymbol) rule.get(0)).terminalName);
        } else if (firstSymbol instanceof  TranslatingSymbol) {
            return calcFirst(rule.subList(1, rule.size()));
        } else if (firstSymbol instanceof NonTerminalSymbol) {
            Set<String> res = FIRST.get(((NonTerminalSymbol) firstSymbol).nonTerminalName);
            if (res.contains(EPS)) {
                res.addAll(calcFirst(rule.subList(1, rule.size())));
            }
            return res;
        } else {
            throw new IllegalStateException("Unexpected case");
        }
    }


    private void genFollow() {
        for (String ruleName : this.parserRules.keySet()) {
            FOLLOW.put(ruleName, new HashSet<>());
        }

        boolean repeat = true;
        while (repeat) {
            repeat = false;
            for (Map.Entry<String, ParserRule> entry : parserRules.entrySet()) {
                String ruleName = entry.getKey();
                ParserRule rules  = entry.getValue();
                for (List<Symbol> rule : rules.rules) {
                    for (int i = 0; i < rule.size(); i++) {
                        Symbol symbol = rule.get(i);
                        if (symbol instanceof NonTerminalSymbol) {
                            Set<String> oldFirst = FOLLOW.get(((NonTerminalSymbol) symbol).nonTerminalName);
                            Set<String> newEls = new HashSet<>(getFirst(rule.subList(i + 1, rule.size())));
                            if (newEls.remove(EPS)) {
                                newEls.addAll(FOLLOW.get(ruleName));
                            }
                            if (!oldFirst.containsAll(newEls)) {
                                oldFirst.addAll(newEls);
                                repeat = true;
                            }
                        }
                    }
                }
            }
        }
    }


    public Set<String> getFirst(List<Symbol> rule) {
        if (rule.size() == 0) {
            return Set.of(Grammar.EPS);
        }
        Symbol firstSymbol = rule.get(0);
        if (firstSymbol instanceof TerminalSymbol) {
            return Set.of(((TerminalSymbol) rule.get(0)).terminalName);
        } else if (firstSymbol instanceof  TranslatingSymbol) {
            return getFirst(rule.subList(1, rule.size()));
        } else if (firstSymbol instanceof NonTerminalSymbol) {
            return FIRST.get(((NonTerminalSymbol) firstSymbol).nonTerminalName);
        } else {
            throw new IllegalStateException("Unexpected case");
        }
    }

    private void checkParserRules(List<ParserRule> parserRules) {
//        List<String> notUniqueKey = parserRules.stream().
//                collect(Collectors.groupingBy(ParserRule::getRuleName)).
//                entrySet().stream().
//                filter(s -> s.getValue().size() > 1).map(Map.Entry::getKey)
//                .collect(Collectors.toList());
//
//        if (!notUniqueKey.isEmpty()) {
//            throw new IllegalStateException("rule " + notUniqueKey.get(0) + " redefinition");
//        }
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


    public Set<String> getNext(List<Symbol> rule, String ruleName) {
        Set<String> nextElms = new HashSet<>(getFirst(rule));

        if (nextElms.remove(EPS)) {
            nextElms.addAll(FOLLOW.get(ruleName));
        }
        return nextElms;
    }
}
