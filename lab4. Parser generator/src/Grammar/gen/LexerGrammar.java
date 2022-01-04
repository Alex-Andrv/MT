// Generated from D:/MT/lab4. Parser generator/src/grammar/antlr4\LexerGrammar.g4 by ANTLR 4.9.2

package grammar.gen;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LexerGrammar extends Lexer {
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
		JAVA_CODE=1;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "JAVA_CODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"GRAMMAR", "HEADER", "LOWER_CASE_INTEDEFICATION", "UPPER_CASE_INTEDEFICATION", 
			"RETURNS", "COMMA", "EQUALS", "COLON", "OR", "NEWLINES", "REGEX", "SEMICOLON", 
			"SPACES", "OP", "CP", "FUNCTIONAL_ARROW", "SKIP_", "OPENP", "CODE_OPENP", 
			"CODE", "CLOSEP"
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


	public LexerGrammar(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LexerGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u0090\b\1\b\1"+
		"\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t"+
		"\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4"+
		"\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\7\4A\n\4\f\4\16\4D"+
		"\13\4\3\5\3\5\7\5H\n\5\f\5\16\5K\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\6\13^\n\13\r\13\16\13_\3\f\3\f\7"+
		"\fd\n\f\f\f\16\fg\13\f\3\f\3\f\3\r\3\r\3\16\6\16n\n\16\r\16\16\16o\3\16"+
		"\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\6\25\u0089\n\25\r\25\16\25\u008a"+
		"\3\26\3\26\3\26\3\26\2\2\27\4\3\6\4\b\5\n\6\f\7\16\b\20\t\22\n\24\13\26"+
		"\f\30\r\32\16\34\17\36\20 \21\"\22$\23&\24(\25*\26,\27\4\2\3\t\3\2c|\6"+
		"\2\62;C\\aac|\3\2C\\\4\2\f\f\17\17\3\2$$\4\2\13\13\"\"\4\2}}\177\177\2"+
		"\u0094\2\4\3\2\2\2\2\6\3\2\2\2\2\b\3\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2\2\16"+
		"\3\2\2\2\2\20\3\2\2\2\2\22\3\2\2\2\2\24\3\2\2\2\2\26\3\2\2\2\2\30\3\2"+
		"\2\2\2\32\3\2\2\2\2\34\3\2\2\2\2\36\3\2\2\2\2 \3\2\2\2\2\"\3\2\2\2\2$"+
		"\3\2\2\2\2&\3\2\2\2\3(\3\2\2\2\3*\3\2\2\2\3,\3\2\2\2\4.\3\2\2\2\6\66\3"+
		"\2\2\2\b>\3\2\2\2\nE\3\2\2\2\fL\3\2\2\2\16T\3\2\2\2\20V\3\2\2\2\22X\3"+
		"\2\2\2\24Z\3\2\2\2\26]\3\2\2\2\30a\3\2\2\2\32j\3\2\2\2\34m\3\2\2\2\36"+
		"s\3\2\2\2 u\3\2\2\2\"w\3\2\2\2$z\3\2\2\2&\177\3\2\2\2(\u0083\3\2\2\2*"+
		"\u0088\3\2\2\2,\u008c\3\2\2\2./\7i\2\2/\60\7t\2\2\60\61\7c\2\2\61\62\7"+
		"o\2\2\62\63\7o\2\2\63\64\7c\2\2\64\65\7t\2\2\65\5\3\2\2\2\66\67\7B\2\2"+
		"\678\7j\2\289\7g\2\29:\7c\2\2:;\7f\2\2;<\7g\2\2<=\7t\2\2=\7\3\2\2\2>B"+
		"\t\2\2\2?A\t\3\2\2@?\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2C\t\3\2\2\2"+
		"DB\3\2\2\2EI\t\4\2\2FH\t\3\2\2GF\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2"+
		"J\13\3\2\2\2KI\3\2\2\2LM\7t\2\2MN\7g\2\2NO\7v\2\2OP\7w\2\2PQ\7t\2\2QR"+
		"\7p\2\2RS\7u\2\2S\r\3\2\2\2TU\7.\2\2U\17\3\2\2\2VW\7?\2\2W\21\3\2\2\2"+
		"XY\7<\2\2Y\23\3\2\2\2Z[\7~\2\2[\25\3\2\2\2\\^\t\5\2\2]\\\3\2\2\2^_\3\2"+
		"\2\2_]\3\2\2\2_`\3\2\2\2`\27\3\2\2\2ae\7$\2\2bd\n\6\2\2cb\3\2\2\2dg\3"+
		"\2\2\2ec\3\2\2\2ef\3\2\2\2fh\3\2\2\2ge\3\2\2\2hi\7$\2\2i\31\3\2\2\2jk"+
		"\7=\2\2k\33\3\2\2\2ln\t\7\2\2ml\3\2\2\2no\3\2\2\2om\3\2\2\2op\3\2\2\2"+
		"pq\3\2\2\2qr\b\16\2\2r\35\3\2\2\2st\7]\2\2t\37\3\2\2\2uv\7_\2\2v!\3\2"+
		"\2\2wx\7/\2\2xy\7@\2\2y#\3\2\2\2z{\7u\2\2{|\7m\2\2|}\7k\2\2}~\7r\2\2~"+
		"%\3\2\2\2\177\u0080\7}\2\2\u0080\u0081\3\2\2\2\u0081\u0082\b\23\3\2\u0082"+
		"\'\3\2\2\2\u0083\u0084\7}\2\2\u0084\u0085\3\2\2\2\u0085\u0086\b\24\3\2"+
		"\u0086)\3\2\2\2\u0087\u0089\n\b\2\2\u0088\u0087\3\2\2\2\u0089\u008a\3"+
		"\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b+\3\2\2\2\u008c\u008d"+
		"\7\177\2\2\u008d\u008e\3\2\2\2\u008e\u008f\b\26\4\2\u008f-\3\2\2\2\n\2"+
		"\3BI_eo\u008a\5\b\2\2\7\3\2\6\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}