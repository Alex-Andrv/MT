// Generated from D:/MT/lab3. Automatic_generator_analyzers/src/antlr4\Functional.g4 by ANTLR 4.9.2

import Functional2Imperative.*;
import Functional2Imperative.Type.*;
import Functional2Imperative.Definition.*;
import Functional2Imperative.Definition.Expr.*;
import Functional2Imperative.Definition.Pattern.*;
import java.util.ArrayList;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FunctionalParser}.
 */
public interface FunctionalListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FunctionalParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(FunctionalParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(FunctionalParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalParser#lines}.
	 * @param ctx the parse tree
	 */
	void enterLines(FunctionalParser.LinesContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalParser#lines}.
	 * @param ctx the parse tree
	 */
	void exitLines(FunctionalParser.LinesContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalParser#functions}.
	 * @param ctx the parse tree
	 */
	void enterFunctions(FunctionalParser.FunctionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalParser#functions}.
	 * @param ctx the parse tree
	 */
	void exitFunctions(FunctionalParser.FunctionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalParser#functionType}.
	 * @param ctx the parse tree
	 */
	void enterFunctionType(FunctionalParser.FunctionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalParser#functionType}.
	 * @param ctx the parse tree
	 */
	void exitFunctionType(FunctionalParser.FunctionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(FunctionalParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(FunctionalParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalParser#typeTail}.
	 * @param ctx the parse tree
	 */
	void enterTypeTail(FunctionalParser.TypeTailContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalParser#typeTail}.
	 * @param ctx the parse tree
	 */
	void exitTypeTail(FunctionalParser.TypeTailContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalParser#typeHead}.
	 * @param ctx the parse tree
	 */
	void enterTypeHead(FunctionalParser.TypeHeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalParser#typeHead}.
	 * @param ctx the parse tree
	 */
	void exitTypeHead(FunctionalParser.TypeHeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDef(FunctionalParser.FunctionDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDef(FunctionalParser.FunctionDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalParser#funName}.
	 * @param ctx the parse tree
	 */
	void enterFunName(FunctionalParser.FunNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalParser#funName}.
	 * @param ctx the parse tree
	 */
	void exitFunName(FunctionalParser.FunNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalParser#patterns}.
	 * @param ctx the parse tree
	 */
	void enterPatterns(FunctionalParser.PatternsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalParser#patterns}.
	 * @param ctx the parse tree
	 */
	void exitPatterns(FunctionalParser.PatternsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalParser#definitions}.
	 * @param ctx the parse tree
	 */
	void enterDefinitions(FunctionalParser.DefinitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalParser#definitions}.
	 * @param ctx the parse tree
	 */
	void exitDefinitions(FunctionalParser.DefinitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(FunctionalParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(FunctionalParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalParser#prime}.
	 * @param ctx the parse tree
	 */
	void enterPrime(FunctionalParser.PrimeContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalParser#prime}.
	 * @param ctx the parse tree
	 */
	void exitPrime(FunctionalParser.PrimeContext ctx);
}