// Generated from D:/MT/lab3. Automatic_generator_analyzers/src/antlr4\Functional.g4 by ANTLR 4.9.2

import Functional2Imperative.*;
import Functional2Imperative.Type.*;
import Functional2Imperative.Definition.*;
import Functional2Imperative.Definition.Expr.*;
import Functional2Imperative.Definition.Pattern.*;
import java.util.ArrayList;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FunctionalLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DOUBLE_COLONS=1, EQUALS=2, INT=3, LIST=4, UNDERSCORES=5, IDENTIFIER=6, 
		FUNCTIONAL_ARROW=7, GUARD=8, OPEN_PARENTHESIS=9, CLOSE_PARENTHESIS=10, 
		BIN_OPERATOR=11, UNARY_OPERATOR=12, NEWLINES=13, SPACES=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"DOUBLE_COLONS", "EQUALS", "INT", "LIST", "UNDERSCORES", "IDENTIFIER", 
			"FUNCTIONAL_ARROW", "GUARD", "OPEN_PARENTHESIS", "CLOSE_PARENTHESIS", 
			"BIN_OPERATOR", "UNARY_OPERATOR", "NEWLINES", "SPACES"
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


	public FunctionalLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Functional.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20Z\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\3\3\3\3\4\3\4\7"+
		"\4\'\n\4\f\4\16\4*\13\4\3\4\5\4-\n\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\7\78\n\7\f\7\16\7;\13\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\f\5\fK\n\f\3\r\3\r\3\16\6\16P\n\16\r\16\16\16Q\3\17\6\17"+
		"U\n\17\r\17\16\17V\3\17\3\17\2\2\20\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\3\2\13\3\2\63;\3\2\62;\3\2\62\62\4"+
		"\2C\\c|\7\2))\62;C\\aac|\n\2\'(,-//\61\61>>@@``~~\3\2##\4\2\f\f\17\17"+
		"\4\2\13\13\"\"\2`\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\3\37\3\2\2\2\5"+
		"\"\3\2\2\2\7,\3\2\2\2\t.\3\2\2\2\13\63\3\2\2\2\r\65\3\2\2\2\17<\3\2\2"+
		"\2\21?\3\2\2\2\23A\3\2\2\2\25C\3\2\2\2\27J\3\2\2\2\31L\3\2\2\2\33O\3\2"+
		"\2\2\35T\3\2\2\2\37 \7<\2\2 !\7<\2\2!\4\3\2\2\2\"#\7?\2\2#\6\3\2\2\2$"+
		"(\t\2\2\2%\'\t\3\2\2&%\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)-\3\2\2"+
		"\2*(\3\2\2\2+-\t\4\2\2,$\3\2\2\2,+\3\2\2\2-\b\3\2\2\2./\7n\2\2/\60\7k"+
		"\2\2\60\61\7u\2\2\61\62\7v\2\2\62\n\3\2\2\2\63\64\7a\2\2\64\f\3\2\2\2"+
		"\659\t\5\2\2\668\t\6\2\2\67\66\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2"+
		":\16\3\2\2\2;9\3\2\2\2<=\7/\2\2=>\7@\2\2>\20\3\2\2\2?@\7~\2\2@\22\3\2"+
		"\2\2AB\7*\2\2B\24\3\2\2\2CD\7+\2\2D\26\3\2\2\2EK\t\7\2\2FG\7?\2\2GK\7"+
		"?\2\2HI\7#\2\2IK\7?\2\2JE\3\2\2\2JF\3\2\2\2JH\3\2\2\2K\30\3\2\2\2LM\t"+
		"\b\2\2M\32\3\2\2\2NP\t\t\2\2ON\3\2\2\2PQ\3\2\2\2QO\3\2\2\2QR\3\2\2\2R"+
		"\34\3\2\2\2SU\t\n\2\2TS\3\2\2\2UV\3\2\2\2VT\3\2\2\2VW\3\2\2\2WX\3\2\2"+
		"\2XY\b\17\2\2Y\36\3\2\2\2\t\2(,9JQV\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}