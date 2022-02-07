
package Lab2;

import java.io.InputStream;;
import java.text.ParseException;;
import util.Lexer;
import util.Tree;
import java.util.Set;
import util.MyToken;

public class Lab2Parser { 
	Lexer lex;

	public Lab2Parser(InputStream is) throws ParseException {
		lex = new Lab2Lexer(is);
		lex.nextToken();
	}

	public static class Return_typeContext extends Tree{
		public Return_typeContext(String node, Tree... children) {
			super(node, children);
		}
		public Return_typeContext(String node) {
			super(node);
		}
	}

	public Return_typeContext return_type() throws ParseException {
		Return_typeContext _localctx = new Return_typeContext("return_type");
		if (Set.of(Lab2Enum.IDENTIFIER).contains(lex.curToken().token)) {
			if (lex.curToken().token != Lab2Enum.IDENTIFIER) {
				throw new ParseException("Expected IDENTIFIER, but found: " + lex.curToken().text, lex.curPos());
			}
			_localctx.add(new Tree(lex.curToken().text));
			MyToken i = lex.curToken();
			lex.nextToken();

			return _localctx;
		}
		if (Set.of(Lab2Enum.OPEN_P).contains(lex.curToken().token)) {
			if (lex.curToken().token != Lab2Enum.OPEN_P) {
				throw new ParseException("Expected OPEN_P, but found: " + lex.curToken().text, lex.curPos());
			}
			_localctx.add(new Tree(lex.curToken().text));
			MyToken o = lex.curToken();
			lex.nextToken();

			TypesContext t = types();
			_localctx.add(t);

			if (lex.curToken().token != Lab2Enum.CLOSE_P) {
				throw new ParseException("Expected CLOSE_P, but found: " + lex.curToken().text, lex.curPos());
			}
			_localctx.add(new Tree(lex.curToken().text));
			MyToken c = lex.curToken();
			lex.nextToken();

			if (lex.curToken().token != Lab2Enum.ARROW) {
				throw new ParseException("Expected ARROW, but found: " + lex.curToken().text, lex.curPos());
			}
			_localctx.add(new Tree(lex.curToken().text));
			MyToken a = lex.curToken();
			lex.nextToken();

			Return_typeContext r = return_type();
			_localctx.add(r);

			return _localctx;
		}
		throw new ParseException("don't expected token: " + lex.curToken().text, lex.curPos());
	}

	public static class Types_tailContext extends Tree{
		public Types_tailContext(String node, Tree... children) {
			super(node, children);
		}
		public Types_tailContext(String node) {
			super(node);
		}
	}

	public Types_tailContext types_tail() throws ParseException {
		Types_tailContext _localctx = new Types_tailContext("types_tail");
		if (Set.of(Lab2Enum.COMMA).contains(lex.curToken().token)) {
			if (lex.curToken().token != Lab2Enum.COMMA) {
				throw new ParseException("Expected COMMA, but found: " + lex.curToken().text, lex.curPos());
			}
			_localctx.add(new Tree(lex.curToken().text));
			MyToken c = lex.curToken();
			lex.nextToken();

			TypeContext t = type();
			_localctx.add(t);

			Types_tailContext t1 = types_tail();
			_localctx.add(t1);

			return _localctx;
		}
		if (Set.of(Lab2Enum.CLOSE_P).contains(lex.curToken().token)) {
			return _localctx;
		}
		throw new ParseException("don't expected token: " + lex.curToken().text, lex.curPos());
	}

	public static class TypesContext extends Tree{
		public TypesContext(String node, Tree... children) {
			super(node, children);
		}
		public TypesContext(String node) {
			super(node);
		}
	}

	public TypesContext types() throws ParseException {
		TypesContext _localctx = new TypesContext("types");
		if (Set.of(Lab2Enum.IDENTIFIER,Lab2Enum.OPEN_P).contains(lex.curToken().token)) {
			TypeContext t = type();
			_localctx.add(t);

			Types_tailContext t1 = types_tail();
			_localctx.add(t1);

			return _localctx;
		}
		if (Set.of(Lab2Enum.CLOSE_P).contains(lex.curToken().token)) {
			return _localctx;
		}
		throw new ParseException("don't expected token: " + lex.curToken().text, lex.curPos());
	}

	public static class SContext extends Tree{
		public SContext(String node, Tree... children) {
			super(node, children);
		}
		public SContext(String node) {
			super(node);
		}
	}

	public SContext s() throws ParseException {
		SContext _localctx = new SContext("s");
		if (Set.of(Lab2Enum.FUN).contains(lex.curToken().token)) {
			if (lex.curToken().token != Lab2Enum.FUN) {
				throw new ParseException("Expected FUN, but found: " + lex.curToken().text, lex.curPos());
			}
			_localctx.add(new Tree(lex.curToken().text));
			MyToken f = lex.curToken();
			lex.nextToken();

			Fun_nameContext f1 = fun_name();
			_localctx.add(f1);

			if (lex.curToken().token != Lab2Enum.OPEN_P) {
				throw new ParseException("Expected OPEN_P, but found: " + lex.curToken().text, lex.curPos());
			}
			_localctx.add(new Tree(lex.curToken().text));
			MyToken o = lex.curToken();
			lex.nextToken();

			ParamsContext p = params();
			_localctx.add(p);

			if (lex.curToken().token != Lab2Enum.CLOSE_P) {
				throw new ParseException("Expected CLOSE_P, but found: " + lex.curToken().text, lex.curPos());
			}
			_localctx.add(new Tree(lex.curToken().text));
			MyToken c = lex.curToken();
			lex.nextToken();

			Return_valContext r = return_val();
			_localctx.add(r);

			if (lex.curToken().token != Lab2Enum.EOF) {
				throw new ParseException("Expected EOF, but found: " + lex.curToken().text, lex.curPos());
			}
			_localctx.add(new Tree(lex.curToken().text));
			MyToken e = lex.curToken();
			lex.nextToken();

			return _localctx;
		}
		throw new ParseException("don't expected token: " + lex.curToken().text, lex.curPos());
	}

	public static class ParamContext extends Tree{
		public ParamContext(String node, Tree... children) {
			super(node, children);
		}
		public ParamContext(String node) {
			super(node);
		}
	}

	public ParamContext param() throws ParseException {
		ParamContext _localctx = new ParamContext("param");
		if (Set.of(Lab2Enum.IDENTIFIER).contains(lex.curToken().token)) {
			VarContext v = var();
			_localctx.add(v);

			if (lex.curToken().token != Lab2Enum.COLON) {
				throw new ParseException("Expected COLON, but found: " + lex.curToken().text, lex.curPos());
			}
			_localctx.add(new Tree(lex.curToken().text));
			MyToken c = lex.curToken();
			lex.nextToken();

			TypeContext t = type();
			_localctx.add(t);

			return _localctx;
		}
		throw new ParseException("don't expected token: " + lex.curToken().text, lex.curPos());
	}

	public static class TailContext extends Tree{
		public TailContext(String node, Tree... children) {
			super(node, children);
		}
		public TailContext(String node) {
			super(node);
		}
	}

	public TailContext tail() throws ParseException {
		TailContext _localctx = new TailContext("tail");
		if (Set.of(Lab2Enum.COMMA).contains(lex.curToken().token)) {
			if (lex.curToken().token != Lab2Enum.COMMA) {
				throw new ParseException("Expected COMMA, but found: " + lex.curToken().text, lex.curPos());
			}
			_localctx.add(new Tree(lex.curToken().text));
			MyToken c = lex.curToken();
			lex.nextToken();

			ParamContext p = param();
			_localctx.add(p);

			TailContext t = tail();
			_localctx.add(t);

			return _localctx;
		}
		if (Set.of(Lab2Enum.CLOSE_P).contains(lex.curToken().token)) {
			return _localctx;
		}
		throw new ParseException("don't expected token: " + lex.curToken().text, lex.curPos());
	}

	public static class VarContext extends Tree{
		public VarContext(String node, Tree... children) {
			super(node, children);
		}
		public VarContext(String node) {
			super(node);
		}
	}

	public VarContext var() throws ParseException {
		VarContext _localctx = new VarContext("var");
		if (Set.of(Lab2Enum.IDENTIFIER).contains(lex.curToken().token)) {
			if (lex.curToken().token != Lab2Enum.IDENTIFIER) {
				throw new ParseException("Expected IDENTIFIER, but found: " + lex.curToken().text, lex.curPos());
			}
			_localctx.add(new Tree(lex.curToken().text));
			MyToken i = lex.curToken();
			lex.nextToken();

			return _localctx;
		}
		throw new ParseException("don't expected token: " + lex.curToken().text, lex.curPos());
	}

	public static class Return_valContext extends Tree{
		public Return_valContext(String node, Tree... children) {
			super(node, children);
		}
		public Return_valContext(String node) {
			super(node);
		}
	}

	public Return_valContext return_val() throws ParseException {
		Return_valContext _localctx = new Return_valContext("return_val");
		if (Set.of(Lab2Enum.COLON).contains(lex.curToken().token)) {
			if (lex.curToken().token != Lab2Enum.COLON) {
				throw new ParseException("Expected COLON, but found: " + lex.curToken().text, lex.curPos());
			}
			_localctx.add(new Tree(lex.curToken().text));
			MyToken c = lex.curToken();
			lex.nextToken();

			Return_typeContext r = return_type();
			_localctx.add(r);

			return _localctx;
		}
		if (Set.of(Lab2Enum.EOF).contains(lex.curToken().token)) {
			return _localctx;
		}
		throw new ParseException("don't expected token: " + lex.curToken().text, lex.curPos());
	}

	public static class ParamsContext extends Tree{
		public ParamsContext(String node, Tree... children) {
			super(node, children);
		}
		public ParamsContext(String node) {
			super(node);
		}
	}

	public ParamsContext params() throws ParseException {
		ParamsContext _localctx = new ParamsContext("params");
		if (Set.of(Lab2Enum.IDENTIFIER).contains(lex.curToken().token)) {
			ParamContext p = param();
			_localctx.add(p);

			TailContext t = tail();
			_localctx.add(t);

			return _localctx;
		}
		if (Set.of(Lab2Enum.CLOSE_P).contains(lex.curToken().token)) {
			return _localctx;
		}
		throw new ParseException("don't expected token: " + lex.curToken().text, lex.curPos());
	}

	public static class TypeContext extends Tree{
		public TypeContext(String node, Tree... children) {
			super(node, children);
		}
		public TypeContext(String node) {
			super(node);
		}
	}

	public TypeContext type() throws ParseException {
		TypeContext _localctx = new TypeContext("type");
		if (Set.of(Lab2Enum.IDENTIFIER).contains(lex.curToken().token)) {
			if (lex.curToken().token != Lab2Enum.IDENTIFIER) {
				throw new ParseException("Expected IDENTIFIER, but found: " + lex.curToken().text, lex.curPos());
			}
			_localctx.add(new Tree(lex.curToken().text));
			MyToken i = lex.curToken();
			lex.nextToken();

			return _localctx;
		}
		if (Set.of(Lab2Enum.OPEN_P).contains(lex.curToken().token)) {
			if (lex.curToken().token != Lab2Enum.OPEN_P) {
				throw new ParseException("Expected OPEN_P, but found: " + lex.curToken().text, lex.curPos());
			}
			_localctx.add(new Tree(lex.curToken().text));
			MyToken o = lex.curToken();
			lex.nextToken();

			TypesContext t = types();
			_localctx.add(t);

			if (lex.curToken().token != Lab2Enum.CLOSE_P) {
				throw new ParseException("Expected CLOSE_P, but found: " + lex.curToken().text, lex.curPos());
			}
			_localctx.add(new Tree(lex.curToken().text));
			MyToken c = lex.curToken();
			lex.nextToken();

			if (lex.curToken().token != Lab2Enum.ARROW) {
				throw new ParseException("Expected ARROW, but found: " + lex.curToken().text, lex.curPos());
			}
			_localctx.add(new Tree(lex.curToken().text));
			MyToken a = lex.curToken();
			lex.nextToken();

			TypeContext t1 = type();
			_localctx.add(t1);

			return _localctx;
		}
		throw new ParseException("don't expected token: " + lex.curToken().text, lex.curPos());
	}

	public static class Fun_nameContext extends Tree{
		public Fun_nameContext(String node, Tree... children) {
			super(node, children);
		}
		public Fun_nameContext(String node) {
			super(node);
		}
	}

	public Fun_nameContext fun_name() throws ParseException {
		Fun_nameContext _localctx = new Fun_nameContext("fun_name");
		if (Set.of(Lab2Enum.IDENTIFIER).contains(lex.curToken().token)) {
			if (lex.curToken().token != Lab2Enum.IDENTIFIER) {
				throw new ParseException("Expected IDENTIFIER, but found: " + lex.curToken().text, lex.curPos());
			}
			_localctx.add(new Tree(lex.curToken().text));
			MyToken i = lex.curToken();
			lex.nextToken();

			return _localctx;
		}
		throw new ParseException("don't expected token: " + lex.curToken().text, lex.curPos());
	}

}