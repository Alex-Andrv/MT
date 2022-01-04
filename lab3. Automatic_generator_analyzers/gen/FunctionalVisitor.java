// Generated from D:/MT/lab3. Automatic_generator_analyzers/src/antlr4\Functional.g4 by ANTLR 4.9.2

import Functional2Imperative.*;
import Functional2Imperative.Type.*;
import Functional2Imperative.Definition.*;
import Functional2Imperative.Definition.Expr.*;
import Functional2Imperative.Definition.Pattern.*;
import java.util.ArrayList;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FunctionalParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FunctionalVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FunctionalParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(FunctionalParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalParser#lines}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLines(FunctionalParser.LinesContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalParser#functions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctions(FunctionalParser.FunctionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalParser#functionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionType(FunctionalParser.FunctionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(FunctionalParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalParser#typeTail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeTail(FunctionalParser.TypeTailContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalParser#typeHead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeHead(FunctionalParser.TypeHeadContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalParser#functionDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDef(FunctionalParser.FunctionDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalParser#funName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunName(FunctionalParser.FunNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalParser#patterns}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatterns(FunctionalParser.PatternsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalParser#definitions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinitions(FunctionalParser.DefinitionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(FunctionalParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalParser#prime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrime(FunctionalParser.PrimeContext ctx);
}