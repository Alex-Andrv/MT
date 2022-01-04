// Generated from D:/MT/lab3. Automatic_generator_analyzers/src/antlr4\Functional.g4 by ANTLR 4.9.2

import Functional2Imperative.*;
import Functional2Imperative.Type.*;
import Functional2Imperative.Definition.*;
import Functional2Imperative.Definition.Expr.*;
import Functional2Imperative.Definition.Pattern.*;
import java.util.ArrayList;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FunctionalParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DOUBLE_COLONS=1, EQUALS=2, INT=3, LIST=4, UNDERSCORES=5, IDENTIFIER=6, 
		FUNCTIONAL_ARROW=7, GUARD=8, OPEN_PARENTHESIS=9, CLOSE_PARENTHESIS=10, 
		BIN_OPERATOR=11, UNARY_OPERATOR=12, NEWLINES=13, SPACES=14;
	public static final int
		RULE_program = 0, RULE_lines = 1, RULE_functions = 2, RULE_functionType = 3, 
		RULE_type = 4, RULE_typeTail = 5, RULE_typeHead = 6, RULE_functionDef = 7, 
		RULE_funName = 8, RULE_patterns = 9, RULE_definitions = 10, RULE_expr = 11, 
		RULE_prime = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "lines", "functions", "functionType", "type", "typeTail", 
			"typeHead", "functionDef", "funName", "patterns", "definitions", "expr", 
			"prime"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'::'", "'='", null, "'list'", "'_'", null, "'->'", "'|'", "'('", 
			"')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DOUBLE_COLONS", "EQUALS", "INT", "LIST", "UNDERSCORES", "IDENTIFIER", 
			"FUNCTIONAL_ARROW", "GUARD", "OPEN_PARENTHESIS", "CLOSE_PARENTHESIS", 
			"BIN_OPERATOR", "UNARY_OPERATOR", "NEWLINES", "SPACES"
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
	public String getGrammarFileName() { return "Functional.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FunctionalParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public Program p;
		public LinesContext lines;
		public LinesContext lines() {
			return getRuleContext(LinesContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionalListener ) ((FunctionalListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionalListener ) ((FunctionalListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionalVisitor ) return ((FunctionalVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			((ProgramContext)_localctx).lines = lines();
			((ProgramContext)_localctx).p =  new Program(((ProgramContext)_localctx).lines.li);
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

	public static class LinesContext extends ParserRuleContext {
		public List<Function> li;
		public FunctionTypeContext functionType;
		public FunctionsContext functions;
		public FunctionTypeContext functionType() {
			return getRuleContext(FunctionTypeContext.class,0);
		}
		public FunctionsContext functions() {
			return getRuleContext(FunctionsContext.class,0);
		}
		public LinesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lines; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionalListener ) ((FunctionalListener)listener).enterLines(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionalListener ) ((FunctionalListener)listener).exitLines(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionalVisitor ) return ((FunctionalVisitor<? extends T>)visitor).visitLines(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LinesContext lines() throws RecognitionException {
		LinesContext _localctx = new LinesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_lines);
		try {
			setState(34);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				((LinesContext)_localctx).functionType = functionType();
				setState(30);
				((LinesContext)_localctx).functions = functions(((LinesContext)_localctx).functionType.fn, ((LinesContext)_localctx).functionType.types);
				((LinesContext)_localctx).li =  ((LinesContext)_localctx).functions.li;
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				((LinesContext)_localctx).li =  new ArrayList<>();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class FunctionsContext extends ParserRuleContext {
		public String fn;
		public List<Type> types;
		public List<Function> li;
		public FunctionDefContext functionDef;
		public LinesContext lines;
		public LinesContext lines() {
			return getRuleContext(LinesContext.class,0);
		}
		public List<FunctionDefContext> functionDef() {
			return getRuleContexts(FunctionDefContext.class);
		}
		public FunctionDefContext functionDef(int i) {
			return getRuleContext(FunctionDefContext.class,i);
		}
		public FunctionsContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public FunctionsContext(ParserRuleContext parent, int invokingState, String fn, List<Type> types) {
			super(parent, invokingState);
			this.fn = fn;
			this.types = types;
		}
		@Override public int getRuleIndex() { return RULE_functions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionalListener ) ((FunctionalListener)listener).enterFunctions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionalListener ) ((FunctionalListener)listener).exitFunctions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionalVisitor ) return ((FunctionalVisitor<? extends T>)visitor).visitFunctions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionsContext functions(String fn,List<Type> types) throws RecognitionException {
		FunctionsContext _localctx = new FunctionsContext(_ctx, getState(), fn, types);
		enterRule(_localctx, 4, RULE_functions);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			List<FunctionDef> fds = new ArrayList<>();
			setState(40); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(37);
					((FunctionsContext)_localctx).functionDef = functionDef();
					fds.add(((FunctionsContext)_localctx).functionDef.fd);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(42); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(44);
			((FunctionsContext)_localctx).lines = lines();

			                                                            Function func = new Function(_localctx.fn, _localctx.types, fds);
			                                                            ((FunctionsContext)_localctx).lines.li.add(func);
			                                                            ((FunctionsContext)_localctx).li =  ((FunctionsContext)_localctx).lines.li;
			                                                        
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

	public static class FunctionTypeContext extends ParserRuleContext {
		public String fn;
		public List<Type> types;
		public FunNameContext funName;
		public TypeContext type;
		public FunNameContext funName() {
			return getRuleContext(FunNameContext.class,0);
		}
		public TerminalNode DOUBLE_COLONS() { return getToken(FunctionalParser.DOUBLE_COLONS, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode NEWLINES() { return getToken(FunctionalParser.NEWLINES, 0); }
		public FunctionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionalListener ) ((FunctionalListener)listener).enterFunctionType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionalListener ) ((FunctionalListener)listener).exitFunctionType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionalVisitor ) return ((FunctionalVisitor<? extends T>)visitor).visitFunctionType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionTypeContext functionType() throws RecognitionException {
		FunctionTypeContext _localctx = new FunctionTypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			((FunctionTypeContext)_localctx).funName = funName();
			setState(48);
			match(DOUBLE_COLONS);
			setState(49);
			((FunctionTypeContext)_localctx).type = type(new ArrayList<>());
			setState(50);
			match(NEWLINES);

			                       ((FunctionTypeContext)_localctx).fn =  (((FunctionTypeContext)_localctx).funName!=null?_input.getText(((FunctionTypeContext)_localctx).funName.start,((FunctionTypeContext)_localctx).funName.stop):null);
			                       ((FunctionTypeContext)_localctx).types =  ((FunctionTypeContext)_localctx).type.outpr;
			                    
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
		public List<Type> inpr;
		public List<Type> outpr;
		public TypeHeadContext typeHead;
		public TypeTailContext typeTail;
		public TypeHeadContext typeHead() {
			return getRuleContext(TypeHeadContext.class,0);
		}
		public TypeTailContext typeTail() {
			return getRuleContext(TypeTailContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public TypeContext(ParserRuleContext parent, int invokingState, List<Type> inpr) {
			super(parent, invokingState);
			this.inpr = inpr;
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionalListener ) ((FunctionalListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionalListener ) ((FunctionalListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionalVisitor ) return ((FunctionalVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type(List<Type> inpr) throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState(), inpr);
		enterRule(_localctx, 8, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			((TypeContext)_localctx).typeHead = typeHead();
			_localctx.inpr.add(((TypeContext)_localctx).typeHead.t);
			setState(55);
			((TypeContext)_localctx).typeTail = typeTail(_localctx.inpr);
			((TypeContext)_localctx).outpr =  ((TypeContext)_localctx).typeTail.outpr;
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

	public static class TypeTailContext extends ParserRuleContext {
		public List<Type> inpr;
		public List<Type> outpr;
		public TypeContext type;
		public TerminalNode FUNCTIONAL_ARROW() { return getToken(FunctionalParser.FUNCTIONAL_ARROW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeTailContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public TypeTailContext(ParserRuleContext parent, int invokingState, List<Type> inpr) {
			super(parent, invokingState);
			this.inpr = inpr;
		}
		@Override public int getRuleIndex() { return RULE_typeTail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionalListener ) ((FunctionalListener)listener).enterTypeTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionalListener ) ((FunctionalListener)listener).exitTypeTail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionalVisitor ) return ((FunctionalVisitor<? extends T>)visitor).visitTypeTail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeTailContext typeTail(List<Type> inpr) throws RecognitionException {
		TypeTailContext _localctx = new TypeTailContext(_ctx, getState(), inpr);
		enterRule(_localctx, 10, RULE_typeTail);
		try {
			setState(63);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNCTIONAL_ARROW:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				match(FUNCTIONAL_ARROW);
				setState(59);
				((TypeTailContext)_localctx).type = type(_localctx.inpr);
				((TypeTailContext)_localctx).outpr =  ((TypeTailContext)_localctx).type.outpr;
				}
				break;
			case CLOSE_PARENTHESIS:
			case NEWLINES:
				enterOuterAlt(_localctx, 2);
				{
				((TypeTailContext)_localctx).outpr =  _localctx.inpr;
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class TypeHeadContext extends ParserRuleContext {
		public Type t;
		public Token IDENTIFIER;
		public TypeContext type;
		public TerminalNode IDENTIFIER() { return getToken(FunctionalParser.IDENTIFIER, 0); }
		public TerminalNode OPEN_PARENTHESIS() { return getToken(FunctionalParser.OPEN_PARENTHESIS, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode CLOSE_PARENTHESIS() { return getToken(FunctionalParser.CLOSE_PARENTHESIS, 0); }
		public TypeHeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeHead; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionalListener ) ((FunctionalListener)listener).enterTypeHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionalListener ) ((FunctionalListener)listener).exitTypeHead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionalVisitor ) return ((FunctionalVisitor<? extends T>)visitor).visitTypeHead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeHeadContext typeHead() throws RecognitionException {
		TypeHeadContext _localctx = new TypeHeadContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_typeHead);
		try {
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				((TypeHeadContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				((TypeHeadContext)_localctx).t =  new PrimeType((((TypeHeadContext)_localctx).IDENTIFIER!=null?((TypeHeadContext)_localctx).IDENTIFIER.getText():null));
				}
				break;
			case OPEN_PARENTHESIS:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				match(OPEN_PARENTHESIS);
				setState(68);
				((TypeHeadContext)_localctx).type = type(new ArrayList<>());
				setState(69);
				match(CLOSE_PARENTHESIS);

				                        ((TypeHeadContext)_localctx).t =  new FunctionalType(((TypeHeadContext)_localctx).type.outpr);
				                     
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class FunctionDefContext extends ParserRuleContext {
		public FunctionDef fd;
		public FunNameContext funName;
		public PatternsContext patterns;
		public DefinitionsContext definitions;
		public FunNameContext funName() {
			return getRuleContext(FunNameContext.class,0);
		}
		public PatternsContext patterns() {
			return getRuleContext(PatternsContext.class,0);
		}
		public DefinitionsContext definitions() {
			return getRuleContext(DefinitionsContext.class,0);
		}
		public FunctionDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionalListener ) ((FunctionalListener)listener).enterFunctionDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionalListener ) ((FunctionalListener)listener).exitFunctionDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionalVisitor ) return ((FunctionalVisitor<? extends T>)visitor).visitFunctionDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefContext functionDef() throws RecognitionException {
		FunctionDefContext _localctx = new FunctionDefContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_functionDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			((FunctionDefContext)_localctx).funName = funName();
			setState(75);
			((FunctionDefContext)_localctx).patterns = patterns();
			setState(76);
			((FunctionDefContext)_localctx).definitions = definitions();

			               ((FunctionDefContext)_localctx).fd =  new FunctionDef((((FunctionDefContext)_localctx).funName!=null?_input.getText(((FunctionDefContext)_localctx).funName.start,((FunctionDefContext)_localctx).funName.stop):null), ((FunctionDefContext)_localctx).patterns.pt, ((FunctionDefContext)_localctx).definitions.defs);
			           
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

	public static class FunNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(FunctionalParser.IDENTIFIER, 0); }
		public FunNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionalListener ) ((FunctionalListener)listener).enterFunName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionalListener ) ((FunctionalListener)listener).exitFunName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionalVisitor ) return ((FunctionalVisitor<? extends T>)visitor).visitFunName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunNameContext funName() throws RecognitionException {
		FunNameContext _localctx = new FunNameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_funName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(IDENTIFIER);
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

	public static class PatternsContext extends ParserRuleContext {
		public Patterns pt;
		public Token IDENTIFIER;
		public Token INT;
		public List<TerminalNode> IDENTIFIER() { return getTokens(FunctionalParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(FunctionalParser.IDENTIFIER, i);
		}
		public List<TerminalNode> INT() { return getTokens(FunctionalParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(FunctionalParser.INT, i);
		}
		public List<TerminalNode> UNDERSCORES() { return getTokens(FunctionalParser.UNDERSCORES); }
		public TerminalNode UNDERSCORES(int i) {
			return getToken(FunctionalParser.UNDERSCORES, i);
		}
		public PatternsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patterns; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionalListener ) ((FunctionalListener)listener).enterPatterns(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionalListener ) ((FunctionalListener)listener).exitPatterns(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionalVisitor ) return ((FunctionalVisitor<? extends T>)visitor).visitPatterns(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatternsContext patterns() throws RecognitionException {
		PatternsContext _localctx = new PatternsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_patterns);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

			            List<Pattern> patterns = new ArrayList<>();
			        
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << UNDERSCORES) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(88);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IDENTIFIER:
					{
					setState(82);
					((PatternsContext)_localctx).IDENTIFIER = match(IDENTIFIER);
					patterns.add(new VarPattern((((PatternsContext)_localctx).IDENTIFIER!=null?((PatternsContext)_localctx).IDENTIFIER.getText():null)));
					}
					break;
				case INT:
					{
					setState(84);
					((PatternsContext)_localctx).INT = match(INT);
					patterns.add(new IntPattern((((PatternsContext)_localctx).INT!=null?((PatternsContext)_localctx).INT.getText():null)));
					}
					break;
				case UNDERSCORES:
					{
					setState(86);
					match(UNDERSCORES);
					patterns.add(new UnderscoresPattern((((PatternsContext)_localctx).INT!=null?((PatternsContext)_localctx).INT.getText():null)));
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			((PatternsContext)_localctx).pt =  new Patterns(patterns);
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

	public static class DefinitionsContext extends ParserRuleContext {
		public List<Definition> defs;
		public ExprContext expr;
		public ExprContext g;
		public ExprContext e;
		public List<TerminalNode> EQUALS() { return getTokens(FunctionalParser.EQUALS); }
		public TerminalNode EQUALS(int i) {
			return getToken(FunctionalParser.EQUALS, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> NEWLINES() { return getTokens(FunctionalParser.NEWLINES); }
		public TerminalNode NEWLINES(int i) {
			return getToken(FunctionalParser.NEWLINES, i);
		}
		public List<TerminalNode> GUARD() { return getTokens(FunctionalParser.GUARD); }
		public TerminalNode GUARD(int i) {
			return getToken(FunctionalParser.GUARD, i);
		}
		public DefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionalListener ) ((FunctionalListener)listener).enterDefinitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionalListener ) ((FunctionalListener)listener).exitDefinitions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionalVisitor ) return ((FunctionalVisitor<? extends T>)visitor).visitDefinitions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionsContext definitions() throws RecognitionException {
		DefinitionsContext _localctx = new DefinitionsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_definitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((DefinitionsContext)_localctx).defs =  new ArrayList<>();
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EQUALS:
				{
				setState(96);
				match(EQUALS);
				setState(97);
				((DefinitionsContext)_localctx).expr = expr();
				_localctx.defs.add(new Definition(null, ((DefinitionsContext)_localctx).expr.e));
				setState(99);
				match(NEWLINES);
				}
				break;
			case GUARD:
				{
				setState(108); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(101);
					match(GUARD);
					setState(102);
					((DefinitionsContext)_localctx).g = ((DefinitionsContext)_localctx).expr = expr();
					setState(103);
					match(EQUALS);
					setState(104);
					((DefinitionsContext)_localctx).e = ((DefinitionsContext)_localctx).expr = expr();
					_localctx.defs.add(new Definition(((DefinitionsContext)_localctx).g.e, ((DefinitionsContext)_localctx).e.e));
					setState(106);
					match(NEWLINES);
					}
					}
					setState(110); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==GUARD );
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ExprContext extends ParserRuleContext {
		public Expr e;
		public Token BIN_OPERATOR;
		public PrimeContext pl;
		public PrimeContext pr;
		public Token UNARY_OPERATOR;
		public PrimeContext prime;
		public FunNameContext funName;
		public TerminalNode BIN_OPERATOR() { return getToken(FunctionalParser.BIN_OPERATOR, 0); }
		public List<PrimeContext> prime() {
			return getRuleContexts(PrimeContext.class);
		}
		public PrimeContext prime(int i) {
			return getRuleContext(PrimeContext.class,i);
		}
		public TerminalNode UNARY_OPERATOR() { return getToken(FunctionalParser.UNARY_OPERATOR, 0); }
		public FunNameContext funName() {
			return getRuleContext(FunNameContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionalListener ) ((FunctionalListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionalListener ) ((FunctionalListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionalVisitor ) return ((FunctionalVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expr);
		int _la;
		try {
			setState(138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				((ExprContext)_localctx).BIN_OPERATOR = match(BIN_OPERATOR);
				setState(115);
				((ExprContext)_localctx).pl = prime();
				setState(116);
				((ExprContext)_localctx).pr = prime();
				((ExprContext)_localctx).e =  new BinOperator((((ExprContext)_localctx).BIN_OPERATOR!=null?((ExprContext)_localctx).BIN_OPERATOR.getText():null), ((ExprContext)_localctx).pl.e, ((ExprContext)_localctx).pr.e);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(119);
				((ExprContext)_localctx).UNARY_OPERATOR = match(UNARY_OPERATOR);
				setState(120);
				((ExprContext)_localctx).prime = prime();
				((ExprContext)_localctx).e =  new UnaryOperator((((ExprContext)_localctx).UNARY_OPERATOR!=null?((ExprContext)_localctx).UNARY_OPERATOR.getText():null), ((ExprContext)_localctx).prime.e);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(123);
				((ExprContext)_localctx).funName = funName();
				List<Expr> exprs = new ArrayList<>();
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << IDENTIFIER) | (1L << OPEN_PARENTHESIS))) != 0)) {
					{
					{
					setState(125);
					((ExprContext)_localctx).prime = prime();
					exprs.add(((ExprContext)_localctx).prime.e);
					}
					}
					setState(132);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				((ExprContext)_localctx).e =  new FunExpr((((ExprContext)_localctx).funName!=null?_input.getText(((ExprContext)_localctx).funName.start,((ExprContext)_localctx).funName.stop):null), exprs);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(135);
				((ExprContext)_localctx).prime = prime();
				((ExprContext)_localctx).e =  ((ExprContext)_localctx).prime.e;
				}
				break;
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

	public static class PrimeContext extends ParserRuleContext {
		public Expr e;
		public Token IDENTIFIER;
		public Token INT;
		public ExprContext expr;
		public TerminalNode IDENTIFIER() { return getToken(FunctionalParser.IDENTIFIER, 0); }
		public TerminalNode INT() { return getToken(FunctionalParser.INT, 0); }
		public TerminalNode OPEN_PARENTHESIS() { return getToken(FunctionalParser.OPEN_PARENTHESIS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_PARENTHESIS() { return getToken(FunctionalParser.CLOSE_PARENTHESIS, 0); }
		public PrimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prime; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionalListener ) ((FunctionalListener)listener).enterPrime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionalListener ) ((FunctionalListener)listener).exitPrime(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionalVisitor ) return ((FunctionalVisitor<? extends T>)visitor).visitPrime(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimeContext prime() throws RecognitionException {
		PrimeContext _localctx = new PrimeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_prime);
		try {
			setState(149);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				((PrimeContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				((PrimeContext)_localctx).e =  new Prime((((PrimeContext)_localctx).IDENTIFIER!=null?((PrimeContext)_localctx).IDENTIFIER.getText():null));
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(142);
				((PrimeContext)_localctx).INT = match(INT);
				((PrimeContext)_localctx).e =  new Prime((((PrimeContext)_localctx).INT!=null?((PrimeContext)_localctx).INT.getText():null));
				}
				break;
			case OPEN_PARENTHESIS:
				enterOuterAlt(_localctx, 3);
				{
				setState(144);
				match(OPEN_PARENTHESIS);
				setState(145);
				((PrimeContext)_localctx).expr = expr();
				setState(146);
				match(CLOSE_PARENTHESIS);
				((PrimeContext)_localctx).e =  ((PrimeContext)_localctx).expr.e;  
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\20\u009a\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3%\n"+
		"\3\3\4\3\4\3\4\3\4\6\4+\n\4\r\4\16\4,\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\5\7B\n\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\5\bK\n\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\7\13[\n\13\f\13\16\13^\13\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\6\fo\n\f\r\f\16\fp\5\fs\n\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u0083\n\r\f\r\16"+
		"\r\u0086\13\r\3\r\3\r\3\r\3\r\3\r\5\r\u008d\n\r\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\5\16\u0098\n\16\3\16\2\2\17\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\2\2\2\u009b\2\34\3\2\2\2\4$\3\2\2\2\6&\3\2\2\2\b\61\3"+
		"\2\2\2\n\67\3\2\2\2\fA\3\2\2\2\16J\3\2\2\2\20L\3\2\2\2\22Q\3\2\2\2\24"+
		"S\3\2\2\2\26a\3\2\2\2\30\u008c\3\2\2\2\32\u0097\3\2\2\2\34\35\5\4\3\2"+
		"\35\36\b\2\1\2\36\3\3\2\2\2\37 \5\b\5\2 !\5\6\4\2!\"\b\3\1\2\"%\3\2\2"+
		"\2#%\b\3\1\2$\37\3\2\2\2$#\3\2\2\2%\5\3\2\2\2&*\b\4\1\2\'(\5\20\t\2()"+
		"\b\4\1\2)+\3\2\2\2*\'\3\2\2\2+,\3\2\2\2,*\3\2\2\2,-\3\2\2\2-.\3\2\2\2"+
		"./\5\4\3\2/\60\b\4\1\2\60\7\3\2\2\2\61\62\5\22\n\2\62\63\7\3\2\2\63\64"+
		"\5\n\6\2\64\65\7\17\2\2\65\66\b\5\1\2\66\t\3\2\2\2\678\5\16\b\289\b\6"+
		"\1\29:\5\f\7\2:;\b\6\1\2;\13\3\2\2\2<=\7\t\2\2=>\5\n\6\2>?\b\7\1\2?B\3"+
		"\2\2\2@B\b\7\1\2A<\3\2\2\2A@\3\2\2\2B\r\3\2\2\2CD\7\b\2\2DK\b\b\1\2EF"+
		"\7\13\2\2FG\5\n\6\2GH\7\f\2\2HI\b\b\1\2IK\3\2\2\2JC\3\2\2\2JE\3\2\2\2"+
		"K\17\3\2\2\2LM\5\22\n\2MN\5\24\13\2NO\5\26\f\2OP\b\t\1\2P\21\3\2\2\2Q"+
		"R\7\b\2\2R\23\3\2\2\2S\\\b\13\1\2TU\7\b\2\2U[\b\13\1\2VW\7\5\2\2W[\b\13"+
		"\1\2XY\7\7\2\2Y[\b\13\1\2ZT\3\2\2\2ZV\3\2\2\2ZX\3\2\2\2[^\3\2\2\2\\Z\3"+
		"\2\2\2\\]\3\2\2\2]_\3\2\2\2^\\\3\2\2\2_`\b\13\1\2`\25\3\2\2\2ar\b\f\1"+
		"\2bc\7\4\2\2cd\5\30\r\2de\b\f\1\2ef\7\17\2\2fs\3\2\2\2gh\7\n\2\2hi\5\30"+
		"\r\2ij\7\4\2\2jk\5\30\r\2kl\b\f\1\2lm\7\17\2\2mo\3\2\2\2ng\3\2\2\2op\3"+
		"\2\2\2pn\3\2\2\2pq\3\2\2\2qs\3\2\2\2rb\3\2\2\2rn\3\2\2\2s\27\3\2\2\2t"+
		"u\7\r\2\2uv\5\32\16\2vw\5\32\16\2wx\b\r\1\2x\u008d\3\2\2\2yz\7\16\2\2"+
		"z{\5\32\16\2{|\b\r\1\2|\u008d\3\2\2\2}~\5\22\n\2~\u0084\b\r\1\2\177\u0080"+
		"\5\32\16\2\u0080\u0081\b\r\1\2\u0081\u0083\3\2\2\2\u0082\177\3\2\2\2\u0083"+
		"\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0087\3\2"+
		"\2\2\u0086\u0084\3\2\2\2\u0087\u0088\b\r\1\2\u0088\u008d\3\2\2\2\u0089"+
		"\u008a\5\32\16\2\u008a\u008b\b\r\1\2\u008b\u008d\3\2\2\2\u008ct\3\2\2"+
		"\2\u008cy\3\2\2\2\u008c}\3\2\2\2\u008c\u0089\3\2\2\2\u008d\31\3\2\2\2"+
		"\u008e\u008f\7\b\2\2\u008f\u0098\b\16\1\2\u0090\u0091\7\5\2\2\u0091\u0098"+
		"\b\16\1\2\u0092\u0093\7\13\2\2\u0093\u0094\5\30\r\2\u0094\u0095\7\f\2"+
		"\2\u0095\u0096\b\16\1\2\u0096\u0098\3\2\2\2\u0097\u008e\3\2\2\2\u0097"+
		"\u0090\3\2\2\2\u0097\u0092\3\2\2\2\u0098\33\3\2\2\2\r$,AJZ\\pr\u0084\u008c"+
		"\u0097";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}