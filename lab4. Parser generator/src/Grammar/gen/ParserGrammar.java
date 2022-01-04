// Generated from D:/MT/lab4. Parser generator/src/grammar/antlr4\ParserGrammar.g4 by ANTLR 4.9.2

package grammar.gen;
import grammar.*;
import grammar.model.*;
import generated.*;
import java.util.Optional;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ParserGrammar extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		GRAMMAR=1, HEADER=2, LOWER_CASE_INTEDEFICATION=3, UPPER_CASE_INTEDEFICATION=4, 
		RETURNS=5, COMMA=6, EQUALS=7, COLON=8, OR=9, NEWLINES=10, REGEX=11, SEMICOLON=12, 
		SPACES=13, OP=14, CP=15, FUNCTIONAL_ARROW=16, SKIP_=17, OPENP=18, CODE_OPENP=19, 
		CODE=20, CLOSEP=21;
	public static final int
		RULE_translationGrammar = 0, RULE_grammarName = 1, RULE_header = 2, RULE_parserRules = 3, 
		RULE_parserRule_ = 4, RULE_descriptionParseRule = 5, RULE_nonTerminal = 6, 
		RULE_terminal = 7, RULE_semanticRules = 8, RULE_javaCode = 9, RULE_inheritedAttributes = 10, 
		RULE_synthesizedAttributes = 11, RULE_attributes = 12, RULE_attribute = 13, 
		RULE_type = 14, RULE_nameAttribute = 15, RULE_lexerRules = 16, RULE_lexerRule = 17, 
		RULE_intedefication = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"translationGrammar", "grammarName", "header", "parserRules", "parserRule_", 
			"descriptionParseRule", "nonTerminal", "terminal", "semanticRules", "javaCode", 
			"inheritedAttributes", "synthesizedAttributes", "attributes", "attribute", 
			"type", "nameAttribute", "lexerRules", "lexerRule", "intedefication"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'grammar'", "'@header'", null, null, "'returns'", "','", "'='", 
			"':'", "'|'", null, null, "';'", null, "'['", "']'", "'->'", "'skip'", 
			null, null, null, "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "GRAMMAR", "HEADER", "LOWER_CASE_INTEDEFICATION", "UPPER_CASE_INTEDEFICATION", 
			"RETURNS", "COMMA", "EQUALS", "COLON", "OR", "NEWLINES", "REGEX", "SEMICOLON", 
			"SPACES", "OP", "CP", "FUNCTIONAL_ARROW", "SKIP_", "OPENP", "CODE_OPENP", 
			"CODE", "CLOSEP"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ParserGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ParserGrammar(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class TranslationGrammarContext extends ParserRuleContext {
		public Grammar gr;
		public Optional<TranslatingSymbol> headers;
		public GrammarNameContext grammarName;
		public HeaderContext header;
		public ParserRulesContext parserRules;
		public LexerRulesContext lexerRules;
		public GrammarNameContext grammarName() {
			return getRuleContext(GrammarNameContext.class,0);
		}
		public ParserRulesContext parserRules() {
			return getRuleContext(ParserRulesContext.class,0);
		}
		public LexerRulesContext lexerRules() {
			return getRuleContext(LexerRulesContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ParserGrammar.EOF, 0); }
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public TranslationGrammarContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public TranslationGrammarContext(ParserRuleContext parent, int invokingState, Grammar gr) {
			super(parent, invokingState);
			this.gr = gr;
		}
		@Override public int getRuleIndex() { return RULE_translationGrammar; }
	}

	public final TranslationGrammarContext translationGrammar(Grammar gr) throws RecognitionException {
		TranslationGrammarContext _localctx = new TranslationGrammarContext(_ctx, getState(), gr);
		enterRule(_localctx, 0, RULE_translationGrammar);

		    ((TranslationGrammarContext)_localctx).headers =  Optional.empty();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			((TranslationGrammarContext)_localctx).grammarName = grammarName();
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HEADER) {
				{
				setState(39);
				((TranslationGrammarContext)_localctx).header = header();

				                ((TranslationGrammarContext)_localctx).headers =  ((TranslationGrammarContext)_localctx).header.headers;
				            
				}
			}

			setState(44);
			((TranslationGrammarContext)_localctx).parserRules = parserRules();
			setState(45);
			((TranslationGrammarContext)_localctx).lexerRules = lexerRules();
			setState(46);
			match(EOF);

			                ((TranslationGrammarContext)_localctx).gr =  new Grammar(((TranslationGrammarContext)_localctx).grammarName.grName, _localctx.headers,
			                                  ((TranslationGrammarContext)_localctx).parserRules.prs, ((TranslationGrammarContext)_localctx).lexerRules.lrs);
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GrammarNameContext extends ParserRuleContext {
		public String grName;
		public IntedeficationContext intedefication;
		public TerminalNode GRAMMAR() { return getToken(ParserGrammar.GRAMMAR, 0); }
		public IntedeficationContext intedefication() {
			return getRuleContext(IntedeficationContext.class,0);
		}
		public GrammarNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grammarName; }
	}

	public final GrammarNameContext grammarName() throws RecognitionException {
		GrammarNameContext _localctx = new GrammarNameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_grammarName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(GRAMMAR);
			setState(50);
			((GrammarNameContext)_localctx).intedefication = intedefication();

			                                        ((GrammarNameContext)_localctx).grName =  (((GrammarNameContext)_localctx).intedefication!=null?_input.getText(((GrammarNameContext)_localctx).intedefication.start,((GrammarNameContext)_localctx).intedefication.stop):null);
			                                    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HeaderContext extends ParserRuleContext {
		public Optional<TranslatingSymbol> headers;
		public SemanticRulesContext semanticRules;
		public TerminalNode HEADER() { return getToken(ParserGrammar.HEADER, 0); }
		public SemanticRulesContext semanticRules() {
			return getRuleContext(SemanticRulesContext.class,0);
		}
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_header);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(HEADER);
			setState(54);
			((HeaderContext)_localctx).semanticRules = semanticRules();

			                                                ((HeaderContext)_localctx).headers =  Optional.of(((HeaderContext)_localctx).semanticRules.s);
			                                           
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParserRulesContext extends ParserRuleContext {
		public List<ParserRule> prs;
		public ParserRule_Context parserRule_;
		public List<ParserRule_Context> parserRule_() {
			return getRuleContexts(ParserRule_Context.class);
		}
		public ParserRule_Context parserRule_(int i) {
			return getRuleContext(ParserRule_Context.class,i);
		}
		public ParserRulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parserRules; }
	}

	public final ParserRulesContext parserRules() throws RecognitionException {
		ParserRulesContext _localctx = new ParserRulesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_parserRules);

		    ((ParserRulesContext)_localctx).prs =  new ArrayList<>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(57);
				((ParserRulesContext)_localctx).parserRule_ = parserRule_();
				_localctx.prs.add(((ParserRulesContext)_localctx).parserRule_.pr);
				}
				}
				setState(62); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LOWER_CASE_INTEDEFICATION );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParserRule_Context extends ParserRuleContext {
		public ParserRule pr;
		public List<Attribute> inhAtr;
		public List<Attribute> syntAtr;
		public List<List<Symbol>> rules;
		public Token LOWER_CASE_INTEDEFICATION;
		public InheritedAttributesContext inheritedAttributes;
		public SynthesizedAttributesContext synthesizedAttributes;
		public DescriptionParseRuleContext descriptionParseRule;
		public TerminalNode LOWER_CASE_INTEDEFICATION() { return getToken(ParserGrammar.LOWER_CASE_INTEDEFICATION, 0); }
		public TerminalNode COLON() { return getToken(ParserGrammar.COLON, 0); }
		public List<DescriptionParseRuleContext> descriptionParseRule() {
			return getRuleContexts(DescriptionParseRuleContext.class);
		}
		public DescriptionParseRuleContext descriptionParseRule(int i) {
			return getRuleContext(DescriptionParseRuleContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(ParserGrammar.SEMICOLON, 0); }
		public InheritedAttributesContext inheritedAttributes() {
			return getRuleContext(InheritedAttributesContext.class,0);
		}
		public SynthesizedAttributesContext synthesizedAttributes() {
			return getRuleContext(SynthesizedAttributesContext.class,0);
		}
		public List<TerminalNode> OR() { return getTokens(ParserGrammar.OR); }
		public TerminalNode OR(int i) {
			return getToken(ParserGrammar.OR, i);
		}
		public ParserRule_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parserRule_; }
	}

	public final ParserRule_Context parserRule_() throws RecognitionException {
		ParserRule_Context _localctx = new ParserRule_Context(_ctx, getState());
		enterRule(_localctx, 8, RULE_parserRule_);

		        ((ParserRule_Context)_localctx).inhAtr =  new ArrayList<>();
		        ((ParserRule_Context)_localctx).syntAtr =  new ArrayList<>();
		        ((ParserRule_Context)_localctx).rules =  new ArrayList<>();
		    
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			((ParserRule_Context)_localctx).LOWER_CASE_INTEDEFICATION = match(LOWER_CASE_INTEDEFICATION);
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP) {
				{
				setState(65);
				((ParserRule_Context)_localctx).inheritedAttributes = inheritedAttributes();
				((ParserRule_Context)_localctx).inhAtr =  ((ParserRule_Context)_localctx).inheritedAttributes.attrs;
				}
			}

			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RETURNS) {
				{
				setState(70);
				((ParserRule_Context)_localctx).synthesizedAttributes = synthesizedAttributes();
				((ParserRule_Context)_localctx).syntAtr =  ((ParserRule_Context)_localctx).synthesizedAttributes.attrs;
				}
			}

			setState(75);
			match(COLON);
			setState(76);
			((ParserRule_Context)_localctx).descriptionParseRule = descriptionParseRule();
			_localctx.rules.add(((ParserRule_Context)_localctx).descriptionParseRule.symbols);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(78);
				match(OR);
				setState(79);
				((ParserRule_Context)_localctx).descriptionParseRule = descriptionParseRule();
				_localctx.rules.add(((ParserRule_Context)_localctx).descriptionParseRule.symbols);
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87);
			match(SEMICOLON);

			                ((ParserRule_Context)_localctx).pr =  new ParserRule((((ParserRule_Context)_localctx).LOWER_CASE_INTEDEFICATION!=null?((ParserRule_Context)_localctx).LOWER_CASE_INTEDEFICATION.getText():null), _localctx.inhAtr, _localctx.syntAtr, _localctx.rules);
			            
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DescriptionParseRuleContext extends ParserRuleContext {
		public List<Symbol> symbols;
		public NonTerminalContext nonTerminal;
		public TerminalContext terminal;
		public SemanticRulesContext semanticRules;
		public List<NonTerminalContext> nonTerminal() {
			return getRuleContexts(NonTerminalContext.class);
		}
		public NonTerminalContext nonTerminal(int i) {
			return getRuleContext(NonTerminalContext.class,i);
		}
		public List<TerminalContext> terminal() {
			return getRuleContexts(TerminalContext.class);
		}
		public TerminalContext terminal(int i) {
			return getRuleContext(TerminalContext.class,i);
		}
		public List<SemanticRulesContext> semanticRules() {
			return getRuleContexts(SemanticRulesContext.class);
		}
		public SemanticRulesContext semanticRules(int i) {
			return getRuleContext(SemanticRulesContext.class,i);
		}
		public DescriptionParseRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_descriptionParseRule; }
	}

	public final DescriptionParseRuleContext descriptionParseRule() throws RecognitionException {
		DescriptionParseRuleContext _localctx = new DescriptionParseRuleContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_descriptionParseRule);

		    ((DescriptionParseRuleContext)_localctx).symbols =  new ArrayList<>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(99);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(90);
					((DescriptionParseRuleContext)_localctx).nonTerminal = nonTerminal();
					_localctx.symbols.add(((DescriptionParseRuleContext)_localctx).nonTerminal.s);
					}
					break;
				case 2:
					{
					setState(93);
					((DescriptionParseRuleContext)_localctx).terminal = terminal();
					_localctx.symbols.add(((DescriptionParseRuleContext)_localctx).terminal.s);
					}
					break;
				case 3:
					{
					setState(96);
					((DescriptionParseRuleContext)_localctx).semanticRules = semanticRules();
					_localctx.symbols.add(((DescriptionParseRuleContext)_localctx).semanticRules.s);
					}
					break;
				}
				}
				setState(101); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LOWER_CASE_INTEDEFICATION || _la==OPENP );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NonTerminalContext extends ParserRuleContext {
		public Symbol s;
		public String var;
		public Token LOWER_CASE_INTEDEFICATION;
		public Token sym;
		public List<TerminalNode> LOWER_CASE_INTEDEFICATION() { return getTokens(ParserGrammar.LOWER_CASE_INTEDEFICATION); }
		public TerminalNode LOWER_CASE_INTEDEFICATION(int i) {
			return getToken(ParserGrammar.LOWER_CASE_INTEDEFICATION, i);
		}
		public TerminalNode EQUALS() { return getToken(ParserGrammar.EQUALS, 0); }
		public NonTerminalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonTerminal; }
	}

	public final NonTerminalContext nonTerminal() throws RecognitionException {
		NonTerminalContext _localctx = new NonTerminalContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_nonTerminal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			((NonTerminalContext)_localctx).LOWER_CASE_INTEDEFICATION = match(LOWER_CASE_INTEDEFICATION);
			setState(104);
			match(EQUALS);
			((NonTerminalContext)_localctx).var =  (((NonTerminalContext)_localctx).LOWER_CASE_INTEDEFICATION!=null?((NonTerminalContext)_localctx).LOWER_CASE_INTEDEFICATION.getText():null);
			setState(106);
			((NonTerminalContext)_localctx).sym = match(LOWER_CASE_INTEDEFICATION);

			                    ((NonTerminalContext)_localctx).s =  new NonTerminalSymbol((((NonTerminalContext)_localctx).sym!=null?((NonTerminalContext)_localctx).sym.getText():null), _localctx.var);
			                
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TerminalContext extends ParserRuleContext {
		public Symbol s;
		public String var;
		public Token LOWER_CASE_INTEDEFICATION;
		public Token sym;
		public TerminalNode LOWER_CASE_INTEDEFICATION() { return getToken(ParserGrammar.LOWER_CASE_INTEDEFICATION, 0); }
		public TerminalNode EQUALS() { return getToken(ParserGrammar.EQUALS, 0); }
		public TerminalNode UPPER_CASE_INTEDEFICATION() { return getToken(ParserGrammar.UPPER_CASE_INTEDEFICATION, 0); }
		public TerminalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terminal; }
	}

	public final TerminalContext terminal() throws RecognitionException {
		TerminalContext _localctx = new TerminalContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_terminal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			((TerminalContext)_localctx).LOWER_CASE_INTEDEFICATION = match(LOWER_CASE_INTEDEFICATION);
			setState(110);
			match(EQUALS);
			((TerminalContext)_localctx).var =  (((TerminalContext)_localctx).LOWER_CASE_INTEDEFICATION!=null?((TerminalContext)_localctx).LOWER_CASE_INTEDEFICATION.getText():null);
			setState(112);
			((TerminalContext)_localctx).sym = match(UPPER_CASE_INTEDEFICATION);

			                    ((TerminalContext)_localctx).s =  new TerminalSymbol((((TerminalContext)_localctx).sym!=null?((TerminalContext)_localctx).sym.getText():null), _localctx.var);
			                
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SemanticRulesContext extends ParserRuleContext {
		public TranslatingSymbol s;
		public JavaCodeContext javaCode;
		public TerminalNode OPENP() { return getToken(ParserGrammar.OPENP, 0); }
		public JavaCodeContext javaCode() {
			return getRuleContext(JavaCodeContext.class,0);
		}
		public TerminalNode CLOSEP() { return getToken(ParserGrammar.CLOSEP, 0); }
		public SemanticRulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_semanticRules; }
	}

	public final SemanticRulesContext semanticRules() throws RecognitionException {
		SemanticRulesContext _localctx = new SemanticRulesContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_semanticRules);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(OPENP);
			setState(116);
			((SemanticRulesContext)_localctx).javaCode = javaCode();
			setState(117);
			match(CLOSEP);

			                                                ((SemanticRulesContext)_localctx).s =  new TranslatingSymbol((((SemanticRulesContext)_localctx).javaCode!=null?_input.getText(((SemanticRulesContext)_localctx).javaCode.start,((SemanticRulesContext)_localctx).javaCode.stop):null));
			                                            
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JavaCodeContext extends ParserRuleContext {
		public List<TerminalNode> CODE() { return getTokens(ParserGrammar.CODE); }
		public TerminalNode CODE(int i) {
			return getToken(ParserGrammar.CODE, i);
		}
		public List<TerminalNode> OPENP() { return getTokens(ParserGrammar.OPENP); }
		public TerminalNode OPENP(int i) {
			return getToken(ParserGrammar.OPENP, i);
		}
		public List<TerminalNode> CLOSEP() { return getTokens(ParserGrammar.CLOSEP); }
		public TerminalNode CLOSEP(int i) {
			return getToken(ParserGrammar.CLOSEP, i);
		}
		public JavaCodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_javaCode; }
	}

	public final JavaCodeContext javaCode() throws RecognitionException {
		JavaCodeContext _localctx = new JavaCodeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_javaCode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(124);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CODE:
					{
					setState(120);
					match(CODE);
					}
					break;
				case OPENP:
					{
					setState(121);
					match(OPENP);
					setState(122);
					match(CODE);
					setState(123);
					match(CLOSEP);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(126); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OPENP || _la==CODE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InheritedAttributesContext extends ParserRuleContext {
		public List<Attribute> attrs;
		public AttributesContext attributes;
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public InheritedAttributesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inheritedAttributes; }
	}

	public final InheritedAttributesContext inheritedAttributes() throws RecognitionException {
		InheritedAttributesContext _localctx = new InheritedAttributesContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_inheritedAttributes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			((InheritedAttributesContext)_localctx).attributes = attributes();
			((InheritedAttributesContext)_localctx).attrs =  ((InheritedAttributesContext)_localctx).attributes.attrs;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SynthesizedAttributesContext extends ParserRuleContext {
		public List<Attribute> attrs;
		public AttributesContext attributes;
		public TerminalNode RETURNS() { return getToken(ParserGrammar.RETURNS, 0); }
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public SynthesizedAttributesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_synthesizedAttributes; }
	}

	public final SynthesizedAttributesContext synthesizedAttributes() throws RecognitionException {
		SynthesizedAttributesContext _localctx = new SynthesizedAttributesContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_synthesizedAttributes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(RETURNS);
			setState(132);
			((SynthesizedAttributesContext)_localctx).attributes = attributes();
			((SynthesizedAttributesContext)_localctx).attrs =  ((SynthesizedAttributesContext)_localctx).attributes.attrs;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributesContext extends ParserRuleContext {
		public List<Attribute> attrs;
		public AttributeContext attribute;
		public TerminalNode OP() { return getToken(ParserGrammar.OP, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public TerminalNode CP() { return getToken(ParserGrammar.CP, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ParserGrammar.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ParserGrammar.COMMA, i);
		}
		public AttributesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributes; }
	}

	public final AttributesContext attributes() throws RecognitionException {
		AttributesContext _localctx = new AttributesContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_attributes);

		        ((AttributesContext)_localctx).attrs =  new ArrayList<>();
		    
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(OP);
			setState(136);
			((AttributesContext)_localctx).attribute = attribute();
			_localctx.attrs.add(((AttributesContext)_localctx).attribute.attr);
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(138);
				match(COMMA);
				setState(139);
				((AttributesContext)_localctx).attribute = attribute();
				_localctx.attrs.add(((AttributesContext)_localctx).attribute.attr);
				}
				}
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(147);
			match(CP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeContext extends ParserRuleContext {
		public Attribute attr;
		public TypeContext type;
		public NameAttributeContext nameAttribute;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public NameAttributeContext nameAttribute() {
			return getRuleContext(NameAttributeContext.class,0);
		}
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			((AttributeContext)_localctx).type = type();
			setState(150);
			((AttributeContext)_localctx).nameAttribute = nameAttribute();

			            ((AttributeContext)_localctx).attr =  new Attribute((((AttributeContext)_localctx).type!=null?_input.getText(((AttributeContext)_localctx).type.start,((AttributeContext)_localctx).type.stop):null), (((AttributeContext)_localctx).nameAttribute!=null?_input.getText(((AttributeContext)_localctx).nameAttribute.start,((AttributeContext)_localctx).nameAttribute.stop):null));
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode UPPER_CASE_INTEDEFICATION() { return getToken(ParserGrammar.UPPER_CASE_INTEDEFICATION, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(UPPER_CASE_INTEDEFICATION);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameAttributeContext extends ParserRuleContext {
		public TerminalNode LOWER_CASE_INTEDEFICATION() { return getToken(ParserGrammar.LOWER_CASE_INTEDEFICATION, 0); }
		public NameAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameAttribute; }
	}

	public final NameAttributeContext nameAttribute() throws RecognitionException {
		NameAttributeContext _localctx = new NameAttributeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_nameAttribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(LOWER_CASE_INTEDEFICATION);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LexerRulesContext extends ParserRuleContext {
		public List<LexerRule> lrs;
		public LexerRuleContext lexerRule;
		public List<LexerRuleContext> lexerRule() {
			return getRuleContexts(LexerRuleContext.class);
		}
		public LexerRuleContext lexerRule(int i) {
			return getRuleContext(LexerRuleContext.class,i);
		}
		public LexerRulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexerRules; }
	}

	public final LexerRulesContext lexerRules() throws RecognitionException {
		LexerRulesContext _localctx = new LexerRulesContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_lexerRules);

		    ((LexerRulesContext)_localctx).lrs =  new ArrayList<>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==UPPER_CASE_INTEDEFICATION) {
				{
				{
				setState(157);
				((LexerRulesContext)_localctx).lexerRule = lexerRule();
				_localctx.lrs.add(((LexerRulesContext)_localctx).lexerRule.lr);
				}
				}
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LexerRuleContext extends ParserRuleContext {
		public LexerRule lr;
		public boolean skip;
		public Token UPPER_CASE_INTEDEFICATION;
		public Token REGEX;
		public TerminalNode UPPER_CASE_INTEDEFICATION() { return getToken(ParserGrammar.UPPER_CASE_INTEDEFICATION, 0); }
		public TerminalNode COLON() { return getToken(ParserGrammar.COLON, 0); }
		public TerminalNode REGEX() { return getToken(ParserGrammar.REGEX, 0); }
		public TerminalNode SEMICOLON() { return getToken(ParserGrammar.SEMICOLON, 0); }
		public TerminalNode NEWLINES() { return getToken(ParserGrammar.NEWLINES, 0); }
		public TerminalNode FUNCTIONAL_ARROW() { return getToken(ParserGrammar.FUNCTIONAL_ARROW, 0); }
		public TerminalNode SKIP_() { return getToken(ParserGrammar.SKIP_, 0); }
		public LexerRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexerRule; }
	}

	public final LexerRuleContext lexerRule() throws RecognitionException {
		LexerRuleContext _localctx = new LexerRuleContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_lexerRule);

		    ((LexerRuleContext)_localctx).skip =  false;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			((LexerRuleContext)_localctx).UPPER_CASE_INTEDEFICATION = match(UPPER_CASE_INTEDEFICATION);
			setState(166);
			match(COLON);
			setState(167);
			((LexerRuleContext)_localctx).REGEX = match(REGEX);
			setState(168);
			match(SEMICOLON);
			setState(169);
			match(NEWLINES);
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FUNCTIONAL_ARROW) {
				{
				setState(170);
				match(FUNCTIONAL_ARROW);
				setState(171);
				match(SKIP_);
				((LexerRuleContext)_localctx).skip =  true;
				}
			}


			            ((LexerRuleContext)_localctx).lr =  new LexerRule((((LexerRuleContext)_localctx).UPPER_CASE_INTEDEFICATION!=null?((LexerRuleContext)_localctx).UPPER_CASE_INTEDEFICATION.getText():null),
			                      (((LexerRuleContext)_localctx).REGEX!=null?((LexerRuleContext)_localctx).REGEX.getText():null), _localctx.skip);
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntedeficationContext extends ParserRuleContext {
		public TerminalNode LOWER_CASE_INTEDEFICATION() { return getToken(ParserGrammar.LOWER_CASE_INTEDEFICATION, 0); }
		public TerminalNode UPPER_CASE_INTEDEFICATION() { return getToken(ParserGrammar.UPPER_CASE_INTEDEFICATION, 0); }
		public IntedeficationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intedefication; }
	}

	public final IntedeficationContext intedefication() throws RecognitionException {
		IntedeficationContext _localctx = new IntedeficationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_intedefication);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			_la = _input.LA(1);
			if ( !(_la==LOWER_CASE_INTEDEFICATION || _la==UPPER_CASE_INTEDEFICATION) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\27\u00b6\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\5\2-\n\2\3\2\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\6\5?\n\5\r\5\16\5@\3\6\3\6\3"+
		"\6\3\6\5\6G\n\6\3\6\3\6\3\6\5\6L\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6U"+
		"\n\6\f\6\16\6X\13\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\6"+
		"\7f\n\7\r\7\16\7g\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\6\13\177\n\13\r\13\16\13\u0080\3"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0091"+
		"\n\16\f\16\16\16\u0094\13\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3"+
		"\21\3\21\3\22\3\22\3\22\7\22\u00a3\n\22\f\22\16\22\u00a6\13\22\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00b0\n\23\3\23\3\23\3\24\3\24"+
		"\3\24\2\2\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\3\3\2\5\6\2"+
		"\u00af\2(\3\2\2\2\4\63\3\2\2\2\6\67\3\2\2\2\b>\3\2\2\2\nB\3\2\2\2\fe\3"+
		"\2\2\2\16i\3\2\2\2\20o\3\2\2\2\22u\3\2\2\2\24~\3\2\2\2\26\u0082\3\2\2"+
		"\2\30\u0085\3\2\2\2\32\u0089\3\2\2\2\34\u0097\3\2\2\2\36\u009b\3\2\2\2"+
		" \u009d\3\2\2\2\"\u00a4\3\2\2\2$\u00a7\3\2\2\2&\u00b3\3\2\2\2(,\5\4\3"+
		"\2)*\5\6\4\2*+\b\2\1\2+-\3\2\2\2,)\3\2\2\2,-\3\2\2\2-.\3\2\2\2./\5\b\5"+
		"\2/\60\5\"\22\2\60\61\7\2\2\3\61\62\b\2\1\2\62\3\3\2\2\2\63\64\7\3\2\2"+
		"\64\65\5&\24\2\65\66\b\3\1\2\66\5\3\2\2\2\678\7\4\2\289\5\22\n\29:\b\4"+
		"\1\2:\7\3\2\2\2;<\5\n\6\2<=\b\5\1\2=?\3\2\2\2>;\3\2\2\2?@\3\2\2\2@>\3"+
		"\2\2\2@A\3\2\2\2A\t\3\2\2\2BF\7\5\2\2CD\5\26\f\2DE\b\6\1\2EG\3\2\2\2F"+
		"C\3\2\2\2FG\3\2\2\2GK\3\2\2\2HI\5\30\r\2IJ\b\6\1\2JL\3\2\2\2KH\3\2\2\2"+
		"KL\3\2\2\2LM\3\2\2\2MN\7\n\2\2NO\5\f\7\2OV\b\6\1\2PQ\7\13\2\2QR\5\f\7"+
		"\2RS\b\6\1\2SU\3\2\2\2TP\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2WY\3\2\2"+
		"\2XV\3\2\2\2YZ\7\16\2\2Z[\b\6\1\2[\13\3\2\2\2\\]\5\16\b\2]^\b\7\1\2^f"+
		"\3\2\2\2_`\5\20\t\2`a\b\7\1\2af\3\2\2\2bc\5\22\n\2cd\b\7\1\2df\3\2\2\2"+
		"e\\\3\2\2\2e_\3\2\2\2eb\3\2\2\2fg\3\2\2\2ge\3\2\2\2gh\3\2\2\2h\r\3\2\2"+
		"\2ij\7\5\2\2jk\7\t\2\2kl\b\b\1\2lm\7\5\2\2mn\b\b\1\2n\17\3\2\2\2op\7\5"+
		"\2\2pq\7\t\2\2qr\b\t\1\2rs\7\6\2\2st\b\t\1\2t\21\3\2\2\2uv\7\24\2\2vw"+
		"\5\24\13\2wx\7\27\2\2xy\b\n\1\2y\23\3\2\2\2z\177\7\26\2\2{|\7\24\2\2|"+
		"}\7\26\2\2}\177\7\27\2\2~z\3\2\2\2~{\3\2\2\2\177\u0080\3\2\2\2\u0080~"+
		"\3\2\2\2\u0080\u0081\3\2\2\2\u0081\25\3\2\2\2\u0082\u0083\5\32\16\2\u0083"+
		"\u0084\b\f\1\2\u0084\27\3\2\2\2\u0085\u0086\7\7\2\2\u0086\u0087\5\32\16"+
		"\2\u0087\u0088\b\r\1\2\u0088\31\3\2\2\2\u0089\u008a\7\20\2\2\u008a\u008b"+
		"\5\34\17\2\u008b\u0092\b\16\1\2\u008c\u008d\7\b\2\2\u008d\u008e\5\34\17"+
		"\2\u008e\u008f\b\16\1\2\u008f\u0091\3\2\2\2\u0090\u008c\3\2\2\2\u0091"+
		"\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0095\3\2"+
		"\2\2\u0094\u0092\3\2\2\2\u0095\u0096\7\21\2\2\u0096\33\3\2\2\2\u0097\u0098"+
		"\5\36\20\2\u0098\u0099\5 \21\2\u0099\u009a\b\17\1\2\u009a\35\3\2\2\2\u009b"+
		"\u009c\7\6\2\2\u009c\37\3\2\2\2\u009d\u009e\7\5\2\2\u009e!\3\2\2\2\u009f"+
		"\u00a0\5$\23\2\u00a0\u00a1\b\22\1\2\u00a1\u00a3\3\2\2\2\u00a2\u009f\3"+
		"\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5"+
		"#\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00a8\7\6\2\2\u00a8\u00a9\7\n\2\2"+
		"\u00a9\u00aa\7\r\2\2\u00aa\u00ab\7\16\2\2\u00ab\u00af\7\f\2\2\u00ac\u00ad"+
		"\7\22\2\2\u00ad\u00ae\7\23\2\2\u00ae\u00b0\b\23\1\2\u00af\u00ac\3\2\2"+
		"\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\b\23\1\2\u00b2"+
		"%\3\2\2\2\u00b3\u00b4\t\2\2\2\u00b4\'\3\2\2\2\16,@FKVeg~\u0080\u0092\u00a4"+
		"\u00af";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}