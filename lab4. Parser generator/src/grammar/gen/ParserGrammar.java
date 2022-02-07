// Generated from D:/MT/lab4. Parser generator/src/grammar/antlr4\ParserGrammar.g4 by ANTLR 4.9.2

package grammar.gen;
import grammar.model.*;
import util.*;
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
		GRAMMAR=1, HEADER=2, RETURNS=3, COMMA=4, EQUALS=5, COLON=6, OR=7, REGEX=8, 
		SEMICOLON=9, SPACES=10, OP=11, CP=12, FUNCTIONAL_ARROW=13, SKIP_=14, LOWER_CASE_INTEDEFICATION=15, 
		UPPER_CASE_INTEDEFICATION=16, OPENP=17, CODE_OPENP=18, CODE=19, CLOSEP=20;
	public static final int
		RULE_translationGrammar = 0, RULE_grammarName = 1, RULE_header = 2, RULE_parserRules = 3, 
		RULE_parserRule_ = 4, RULE_descriptionParseRule = 5, RULE_nonTerminal = 6, 
		RULE_terminal = 7, RULE_semanticRules = 8, RULE_javaCode = 9, RULE_inheritedAttributes = 10, 
		RULE_synthesizedAttributes = 11, RULE_attributes = 12, RULE_attribute = 13, 
		RULE_type = 14, RULE_nameAttribute = 15, RULE_lexerRules = 16, RULE_lexerRule = 17, 
		RULE_identifier = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"translationGrammar", "grammarName", "header", "parserRules", "parserRule_", 
			"descriptionParseRule", "nonTerminal", "terminal", "semanticRules", "javaCode", 
			"inheritedAttributes", "synthesizedAttributes", "attributes", "attribute", 
			"type", "nameAttribute", "lexerRules", "lexerRule", "identifier"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'grammar'", "'@header'", "'returns'", "','", "'='", "':'", "'|'", 
			null, "';'", null, "'['", "']'", "'->'", "'skip'", null, null, null, 
			null, null, "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "GRAMMAR", "HEADER", "RETURNS", "COMMA", "EQUALS", "COLON", "OR", 
			"REGEX", "SEMICOLON", "SPACES", "OP", "CP", "FUNCTIONAL_ARROW", "SKIP_", 
			"LOWER_CASE_INTEDEFICATION", "UPPER_CASE_INTEDEFICATION", "OPENP", "CODE_OPENP", 
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
		public TranslationGrammarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_translationGrammar; }
	}

	public final TranslationGrammarContext translationGrammar() throws RecognitionException {
		TranslationGrammarContext _localctx = new TranslationGrammarContext(_ctx, getState());
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
		public IdentifierContext identifier;
		public TerminalNode GRAMMAR() { return getToken(ParserGrammar.GRAMMAR, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(ParserGrammar.SEMICOLON, 0); }
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
			((GrammarNameContext)_localctx).identifier = identifier();

			                                        ((GrammarNameContext)_localctx).grName =  (((GrammarNameContext)_localctx).identifier!=null?_input.getText(((GrammarNameContext)_localctx).identifier.start,((GrammarNameContext)_localctx).identifier.stop):null);
			                                    
			setState(52);
			match(SEMICOLON);
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
			setState(54);
			match(HEADER);
			setState(55);
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
			setState(61); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(58);
				((ParserRulesContext)_localctx).parserRule_ = parserRule_();
				_localctx.prs.add(((ParserRulesContext)_localctx).parserRule_.pr);
				}
				}
				setState(63); 
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
			setState(65);
			((ParserRule_Context)_localctx).LOWER_CASE_INTEDEFICATION = match(LOWER_CASE_INTEDEFICATION);
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP) {
				{
				setState(66);
				((ParserRule_Context)_localctx).inheritedAttributes = inheritedAttributes();
				((ParserRule_Context)_localctx).inhAtr =  ((ParserRule_Context)_localctx).inheritedAttributes.attrs;
				}
			}

			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RETURNS) {
				{
				setState(71);
				((ParserRule_Context)_localctx).synthesizedAttributes = synthesizedAttributes();
				((ParserRule_Context)_localctx).syntAtr =  ((ParserRule_Context)_localctx).synthesizedAttributes.attrs;
				}
			}

			setState(76);
			match(COLON);
			setState(77);
			((ParserRule_Context)_localctx).descriptionParseRule = descriptionParseRule();
			_localctx.rules.add(((ParserRule_Context)_localctx).descriptionParseRule.symbols);
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(79);
				match(OR);
				setState(80);
				((ParserRule_Context)_localctx).descriptionParseRule = descriptionParseRule();
				_localctx.rules.add(((ParserRule_Context)_localctx).descriptionParseRule.symbols);
				}
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(88);
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
		public String var;
		public Token LOWER_CASE_INTEDEFICATION;
		public NonTerminalContext nonTerminal;
		public TerminalContext terminal;
		public SemanticRulesContext semanticRules;
		public List<SemanticRulesContext> semanticRules() {
			return getRuleContexts(SemanticRulesContext.class);
		}
		public SemanticRulesContext semanticRules(int i) {
			return getRuleContext(SemanticRulesContext.class,i);
		}
		public List<TerminalNode> LOWER_CASE_INTEDEFICATION() { return getTokens(ParserGrammar.LOWER_CASE_INTEDEFICATION); }
		public TerminalNode LOWER_CASE_INTEDEFICATION(int i) {
			return getToken(ParserGrammar.LOWER_CASE_INTEDEFICATION, i);
		}
		public List<TerminalNode> EQUALS() { return getTokens(ParserGrammar.EQUALS); }
		public TerminalNode EQUALS(int i) {
			return getToken(ParserGrammar.EQUALS, i);
		}
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
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LOWER_CASE_INTEDEFICATION || _la==OPENP) {
				{
				setState(105);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LOWER_CASE_INTEDEFICATION:
					{
					{
					setState(91);
					((DescriptionParseRuleContext)_localctx).LOWER_CASE_INTEDEFICATION = match(LOWER_CASE_INTEDEFICATION);
					setState(92);
					match(EQUALS);
					((DescriptionParseRuleContext)_localctx).var =  (((DescriptionParseRuleContext)_localctx).LOWER_CASE_INTEDEFICATION!=null?((DescriptionParseRuleContext)_localctx).LOWER_CASE_INTEDEFICATION.getText():null);
					setState(100);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LOWER_CASE_INTEDEFICATION:
						{
						setState(94);
						((DescriptionParseRuleContext)_localctx).nonTerminal = nonTerminal();
						_localctx.symbols.add(new NonTerminalSymbol(_localctx.var, ((DescriptionParseRuleContext)_localctx).nonTerminal.s, ((DescriptionParseRuleContext)_localctx).nonTerminal.sym));
						}
						break;
					case UPPER_CASE_INTEDEFICATION:
						{
						setState(97);
						((DescriptionParseRuleContext)_localctx).terminal = terminal();
						_localctx.symbols.add(new TerminalSymbol(_localctx.var, ((DescriptionParseRuleContext)_localctx).terminal.s));
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					break;
				case OPENP:
					{
					setState(102);
					((DescriptionParseRuleContext)_localctx).semanticRules = semanticRules();
					_localctx.symbols.add(((DescriptionParseRuleContext)_localctx).semanticRules.s);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(109);
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

	public static class NonTerminalContext extends ParserRuleContext {
		public String s;
		public TranslatingSymbol sym;
		public Token LOWER_CASE_INTEDEFICATION;
		public SemanticRulesContext semanticRules;
		public TerminalNode LOWER_CASE_INTEDEFICATION() { return getToken(ParserGrammar.LOWER_CASE_INTEDEFICATION, 0); }
		public TerminalNode OP() { return getToken(ParserGrammar.OP, 0); }
		public SemanticRulesContext semanticRules() {
			return getRuleContext(SemanticRulesContext.class,0);
		}
		public TerminalNode CP() { return getToken(ParserGrammar.CP, 0); }
		public NonTerminalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonTerminal; }
	}

	public final NonTerminalContext nonTerminal() throws RecognitionException {
		NonTerminalContext _localctx = new NonTerminalContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_nonTerminal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			((NonTerminalContext)_localctx).LOWER_CASE_INTEDEFICATION = match(LOWER_CASE_INTEDEFICATION);
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP) {
				{
				setState(111);
				match(OP);
				setState(112);
				((NonTerminalContext)_localctx).semanticRules = semanticRules();
				setState(113);
				match(CP);
				((NonTerminalContext)_localctx).sym =  ((NonTerminalContext)_localctx).semanticRules.s;
				}
			}


			                    ((NonTerminalContext)_localctx).s =  (((NonTerminalContext)_localctx).LOWER_CASE_INTEDEFICATION!=null?((NonTerminalContext)_localctx).LOWER_CASE_INTEDEFICATION.getText():null);
			                
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
		public String s;
		public Token UPPER_CASE_INTEDEFICATION;
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
			setState(120);
			((TerminalContext)_localctx).UPPER_CASE_INTEDEFICATION = match(UPPER_CASE_INTEDEFICATION);

			                    ((TerminalContext)_localctx).s =  (((TerminalContext)_localctx).UPPER_CASE_INTEDEFICATION!=null?((TerminalContext)_localctx).UPPER_CASE_INTEDEFICATION.getText():null);
			                
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
			setState(123);
			match(OPENP);
			setState(124);
			((SemanticRulesContext)_localctx).javaCode = javaCode();
			setState(125);
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
		public List<TerminalNode> CODE_OPENP() { return getTokens(ParserGrammar.CODE_OPENP); }
		public TerminalNode CODE_OPENP(int i) {
			return getToken(ParserGrammar.CODE_OPENP, i);
		}
		public List<JavaCodeContext> javaCode() {
			return getRuleContexts(JavaCodeContext.class);
		}
		public JavaCodeContext javaCode(int i) {
			return getRuleContext(JavaCodeContext.class,i);
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
			setState(133); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(133);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CODE:
					{
					setState(128);
					match(CODE);
					}
					break;
				case CODE_OPENP:
					{
					setState(129);
					match(CODE_OPENP);
					setState(130);
					javaCode();
					setState(131);
					match(CLOSEP);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(135); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CODE_OPENP || _la==CODE );
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
			setState(137);
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
			setState(140);
			match(RETURNS);
			setState(141);
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
			setState(144);
			match(OP);
			setState(145);
			((AttributesContext)_localctx).attribute = attribute();
			_localctx.attrs.add(((AttributesContext)_localctx).attribute.attr);
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(147);
				match(COMMA);
				setState(148);
				((AttributesContext)_localctx).attribute = attribute();
				_localctx.attrs.add(((AttributesContext)_localctx).attribute.attr);
				}
				}
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(156);
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
			setState(158);
			((AttributeContext)_localctx).type = type();
			setState(159);
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
			setState(162);
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
			setState(164);
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
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==UPPER_CASE_INTEDEFICATION) {
				{
				{
				setState(166);
				((LexerRulesContext)_localctx).lexerRule = lexerRule();
				_localctx.lrs.add(((LexerRulesContext)_localctx).lexerRule.lr);
				}
				}
				setState(173);
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
			setState(174);
			((LexerRuleContext)_localctx).UPPER_CASE_INTEDEFICATION = match(UPPER_CASE_INTEDEFICATION);
			setState(175);
			match(COLON);
			setState(176);
			((LexerRuleContext)_localctx).REGEX = match(REGEX);
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FUNCTIONAL_ARROW) {
				{
				setState(177);
				match(FUNCTIONAL_ARROW);
				setState(178);
				match(SKIP_);
				((LexerRuleContext)_localctx).skip =  true;
				}
			}

			setState(182);
			match(SEMICOLON);

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

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode LOWER_CASE_INTEDEFICATION() { return getToken(ParserGrammar.LOWER_CASE_INTEDEFICATION, 0); }
		public TerminalNode UPPER_CASE_INTEDEFICATION() { return getToken(ParserGrammar.UPPER_CASE_INTEDEFICATION, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26\u00be\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\5\2-\n\2\3\2\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\6\5@\n\5\r\5\16\5A\3\6\3"+
		"\6\3\6\3\6\5\6H\n\6\3\6\3\6\3\6\5\6M\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7"+
		"\6V\n\6\f\6\16\6Y\13\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\5\7g\n\7\3\7\3\7\3\7\7\7l\n\7\f\7\16\7o\13\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\5\bw\n\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\3\13\6\13\u0088\n\13\r\13\16\13\u0089\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u009a\n\16\f\16\16\16\u009d\13\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\7\22"+
		"\u00ac\n\22\f\22\16\22\u00af\13\22\3\23\3\23\3\23\3\23\3\23\3\23\5\23"+
		"\u00b7\n\23\3\23\3\23\3\23\3\24\3\24\3\24\2\2\25\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&\2\3\3\2\21\22\2\u00b8\2(\3\2\2\2\4\63\3\2\2\2"+
		"\68\3\2\2\2\b?\3\2\2\2\nC\3\2\2\2\fm\3\2\2\2\16p\3\2\2\2\20z\3\2\2\2\22"+
		"}\3\2\2\2\24\u0087\3\2\2\2\26\u008b\3\2\2\2\30\u008e\3\2\2\2\32\u0092"+
		"\3\2\2\2\34\u00a0\3\2\2\2\36\u00a4\3\2\2\2 \u00a6\3\2\2\2\"\u00ad\3\2"+
		"\2\2$\u00b0\3\2\2\2&\u00bb\3\2\2\2(,\5\4\3\2)*\5\6\4\2*+\b\2\1\2+-\3\2"+
		"\2\2,)\3\2\2\2,-\3\2\2\2-.\3\2\2\2./\5\b\5\2/\60\5\"\22\2\60\61\7\2\2"+
		"\3\61\62\b\2\1\2\62\3\3\2\2\2\63\64\7\3\2\2\64\65\5&\24\2\65\66\b\3\1"+
		"\2\66\67\7\13\2\2\67\5\3\2\2\289\7\4\2\29:\5\22\n\2:;\b\4\1\2;\7\3\2\2"+
		"\2<=\5\n\6\2=>\b\5\1\2>@\3\2\2\2?<\3\2\2\2@A\3\2\2\2A?\3\2\2\2AB\3\2\2"+
		"\2B\t\3\2\2\2CG\7\21\2\2DE\5\26\f\2EF\b\6\1\2FH\3\2\2\2GD\3\2\2\2GH\3"+
		"\2\2\2HL\3\2\2\2IJ\5\30\r\2JK\b\6\1\2KM\3\2\2\2LI\3\2\2\2LM\3\2\2\2MN"+
		"\3\2\2\2NO\7\b\2\2OP\5\f\7\2PW\b\6\1\2QR\7\t\2\2RS\5\f\7\2ST\b\6\1\2T"+
		"V\3\2\2\2UQ\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2XZ\3\2\2\2YW\3\2\2\2"+
		"Z[\7\13\2\2[\\\b\6\1\2\\\13\3\2\2\2]^\7\21\2\2^_\7\7\2\2_f\b\7\1\2`a\5"+
		"\16\b\2ab\b\7\1\2bg\3\2\2\2cd\5\20\t\2de\b\7\1\2eg\3\2\2\2f`\3\2\2\2f"+
		"c\3\2\2\2gl\3\2\2\2hi\5\22\n\2ij\b\7\1\2jl\3\2\2\2k]\3\2\2\2kh\3\2\2\2"+
		"lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2n\r\3\2\2\2om\3\2\2\2pv\7\21\2\2qr\7\r\2"+
		"\2rs\5\22\n\2st\7\16\2\2tu\b\b\1\2uw\3\2\2\2vq\3\2\2\2vw\3\2\2\2wx\3\2"+
		"\2\2xy\b\b\1\2y\17\3\2\2\2z{\7\22\2\2{|\b\t\1\2|\21\3\2\2\2}~\7\23\2\2"+
		"~\177\5\24\13\2\177\u0080\7\26\2\2\u0080\u0081\b\n\1\2\u0081\23\3\2\2"+
		"\2\u0082\u0088\7\25\2\2\u0083\u0084\7\24\2\2\u0084\u0085\5\24\13\2\u0085"+
		"\u0086\7\26\2\2\u0086\u0088\3\2\2\2\u0087\u0082\3\2\2\2\u0087\u0083\3"+
		"\2\2\2\u0088\u0089\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\25\3\2\2\2\u008b\u008c\5\32\16\2\u008c\u008d\b\f\1\2\u008d\27\3\2\2\2"+
		"\u008e\u008f\7\5\2\2\u008f\u0090\5\32\16\2\u0090\u0091\b\r\1\2\u0091\31"+
		"\3\2\2\2\u0092\u0093\7\r\2\2\u0093\u0094\5\34\17\2\u0094\u009b\b\16\1"+
		"\2\u0095\u0096\7\6\2\2\u0096\u0097\5\34\17\2\u0097\u0098\b\16\1\2\u0098"+
		"\u009a\3\2\2\2\u0099\u0095\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2"+
		"\2\2\u009b\u009c\3\2\2\2\u009c\u009e\3\2\2\2\u009d\u009b\3\2\2\2\u009e"+
		"\u009f\7\16\2\2\u009f\33\3\2\2\2\u00a0\u00a1\5\36\20\2\u00a1\u00a2\5 "+
		"\21\2\u00a2\u00a3\b\17\1\2\u00a3\35\3\2\2\2\u00a4\u00a5\7\22\2\2\u00a5"+
		"\37\3\2\2\2\u00a6\u00a7\7\21\2\2\u00a7!\3\2\2\2\u00a8\u00a9\5$\23\2\u00a9"+
		"\u00aa\b\22\1\2\u00aa\u00ac\3\2\2\2\u00ab\u00a8\3\2\2\2\u00ac\u00af\3"+
		"\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae#\3\2\2\2\u00af\u00ad"+
		"\3\2\2\2\u00b0\u00b1\7\22\2\2\u00b1\u00b2\7\b\2\2\u00b2\u00b6\7\n\2\2"+
		"\u00b3\u00b4\7\17\2\2\u00b4\u00b5\7\20\2\2\u00b5\u00b7\b\23\1\2\u00b6"+
		"\u00b3\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\7\13"+
		"\2\2\u00b9\u00ba\b\23\1\2\u00ba%\3\2\2\2\u00bb\u00bc\t\2\2\2\u00bc\'\3"+
		"\2\2\2\20,AGLWfkmv\u0087\u0089\u009b\u00ad\u00b6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}