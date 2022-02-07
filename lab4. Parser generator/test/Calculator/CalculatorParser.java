
package Calculator;

import java.io.InputStream;;
import java.text.ParseException;;
import util.Lexer;
import util.Tree;
import java.util.Set;
import util.MyToken;

public class CalculatorParser { 
	Lexer lex;

	public CalculatorParser(InputStream is) throws ParseException {
		lex = new CalculatorLexer(is);
		lex.nextToken();
	}

	public static class CalculatorContext extends Tree{
		public CalculatorContext(String node, Tree... children) {
			super(node, children);
		}
		public CalculatorContext(String node) {
			super(node);
		}
		public Double res;
	}

	public CalculatorContext calculator() throws ParseException {
		CalculatorContext _localctx = new CalculatorContext("calculator");
		if (Set.of(CalculatorEnum.OPEN_P,CalculatorEnum.DIGIT).contains(lex.curToken().token)) {
			ExprContext e = expr();
			_localctx.add(e);

			if (lex.curToken().token != CalculatorEnum.EOF) {
				throw new ParseException("Expected EOF, but found: " + lex.curToken().text, lex.curPos());
			}
			_localctx.add(new Tree(lex.curToken().text));
			MyToken e1 = lex.curToken();
			lex.nextToken();

			_localctx.res = e.res;

			return _localctx;
		}
		throw new ParseException("don't expected token: " + lex.curToken().text, lex.curPos());
	}

	public static class Term_Context extends Tree{
		public Term_Context(String node, Tree... children) {
			super(node, children);
		}
		public Term_Context(String node) {
			super(node);
		}
		public Double res;
	}

	public Term_Context term_(Double in) throws ParseException {
		Term_Context _localctx = new Term_Context("term_");
		if (Set.of(CalculatorEnum.MUL).contains(lex.curToken().token)) {
			if (lex.curToken().token != CalculatorEnum.MUL) {
				throw new ParseException("Expected MUL, but found: " + lex.curToken().text, lex.curPos());
			}
			_localctx.add(new Tree(lex.curToken().text));
			MyToken m = lex.curToken();
			lex.nextToken();

			TermContext t = term();
			_localctx.add(t);

			_localctx.res = in * t.res;

			return _localctx;
		}
		if (Set.of(CalculatorEnum.DIV).contains(lex.curToken().token)) {
			if (lex.curToken().token != CalculatorEnum.DIV) {
				throw new ParseException("Expected DIV, but found: " + lex.curToken().text, lex.curPos());
			}
			_localctx.add(new Tree(lex.curToken().text));
			MyToken d = lex.curToken();
			lex.nextToken();

			TermContext t = term();
			_localctx.add(t);

			_localctx.res = in / t.res;

			return _localctx;
		}
		if (Set.of(CalculatorEnum.ADD,CalculatorEnum.SUB,CalculatorEnum.CLOSE_P,CalculatorEnum.EOF).contains(lex.curToken().token)) {
			_localctx.res = in;

			return _localctx;
		}
		throw new ParseException("don't expected token: " + lex.curToken().text, lex.curPos());
	}

	public static class ExprContext extends Tree{
		public ExprContext(String node, Tree... children) {
			super(node, children);
		}
		public ExprContext(String node) {
			super(node);
		}
		public Double res;
	}

	public ExprContext expr() throws ParseException {
		ExprContext _localctx = new ExprContext("expr");
		if (Set.of(CalculatorEnum.OPEN_P,CalculatorEnum.DIGIT).contains(lex.curToken().token)) {
			TermContext t = term();
			_localctx.add(t);

			Expr_Context e = expr_(t.res);
			_localctx.add(e);

			_localctx.res = e.res;

			return _localctx;
		}
		throw new ParseException("don't expected token: " + lex.curToken().text, lex.curPos());
	}

	public static class TermContext extends Tree{
		public TermContext(String node, Tree... children) {
			super(node, children);
		}
		public TermContext(String node) {
			super(node);
		}
		public Double res;
	}

	public TermContext term() throws ParseException {
		TermContext _localctx = new TermContext("term");
		if (Set.of(CalculatorEnum.OPEN_P,CalculatorEnum.DIGIT).contains(lex.curToken().token)) {
			AtomContext a = atom();
			_localctx.add(a);

			Term_Context t = term_(a.res);
			_localctx.add(t);

			_localctx.res = t.res;

			return _localctx;
		}
		throw new ParseException("don't expected token: " + lex.curToken().text, lex.curPos());
	}

	public static class AtomContext extends Tree{
		public AtomContext(String node, Tree... children) {
			super(node, children);
		}
		public AtomContext(String node) {
			super(node);
		}
		public Double res;
	}

	public AtomContext atom() throws ParseException {
		AtomContext _localctx = new AtomContext("atom");
		if (Set.of(CalculatorEnum.OPEN_P).contains(lex.curToken().token)) {
			if (lex.curToken().token != CalculatorEnum.OPEN_P) {
				throw new ParseException("Expected OPEN_P, but found: " + lex.curToken().text, lex.curPos());
			}
			_localctx.add(new Tree(lex.curToken().text));
			MyToken o = lex.curToken();
			lex.nextToken();

			ExprContext e = expr();
			_localctx.add(e);

			if (lex.curToken().token != CalculatorEnum.CLOSE_P) {
				throw new ParseException("Expected CLOSE_P, but found: " + lex.curToken().text, lex.curPos());
			}
			_localctx.add(new Tree(lex.curToken().text));
			MyToken c = lex.curToken();
			lex.nextToken();

			_localctx.res = e.res;

			return _localctx;
		}
		if (Set.of(CalculatorEnum.DIGIT).contains(lex.curToken().token)) {
			if (lex.curToken().token != CalculatorEnum.DIGIT) {
				throw new ParseException("Expected DIGIT, but found: " + lex.curToken().text, lex.curPos());
			}
			_localctx.add(new Tree(lex.curToken().text));
			MyToken d = lex.curToken();
			lex.nextToken();

			_localctx.res = Double.parseDouble(d.text);

			return _localctx;
		}
		throw new ParseException("don't expected token: " + lex.curToken().text, lex.curPos());
	}

	public static class Expr_Context extends Tree{
		public Expr_Context(String node, Tree... children) {
			super(node, children);
		}
		public Expr_Context(String node) {
			super(node);
		}
		public Double res;
	}

	public Expr_Context expr_(Double in) throws ParseException {
		Expr_Context _localctx = new Expr_Context("expr_");
		if (Set.of(CalculatorEnum.ADD).contains(lex.curToken().token)) {
			if (lex.curToken().token != CalculatorEnum.ADD) {
				throw new ParseException("Expected ADD, but found: " + lex.curToken().text, lex.curPos());
			}
			_localctx.add(new Tree(lex.curToken().text));
			MyToken a = lex.curToken();
			lex.nextToken();

			ExprContext e = expr();
			_localctx.add(e);

			_localctx.res = in + e.res;

			return _localctx;
		}
		if (Set.of(CalculatorEnum.SUB).contains(lex.curToken().token)) {
			if (lex.curToken().token != CalculatorEnum.SUB) {
				throw new ParseException("Expected SUB, but found: " + lex.curToken().text, lex.curPos());
			}
			_localctx.add(new Tree(lex.curToken().text));
			MyToken s = lex.curToken();
			lex.nextToken();

			ExprContext e = expr();
			_localctx.add(e);

			_localctx.res = in - e.res;

			return _localctx;
		}
		if (Set.of(CalculatorEnum.CLOSE_P,CalculatorEnum.EOF).contains(lex.curToken().token)) {
			_localctx.res = in;

			return _localctx;
		}
		throw new ParseException("don't expected token: " + lex.curToken().text, lex.curPos());
	}

}