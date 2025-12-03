// Generated from EaV2.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EaV2Parser}.
 */
public interface EaV2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EaV2Parser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(EaV2Parser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link EaV2Parser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(EaV2Parser.TextContext ctx);
	/**
	 * Enter a parse tree produced by {@link EaV2Parser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterSentence(EaV2Parser.SentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link EaV2Parser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitSentence(EaV2Parser.SentenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link EaV2Parser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(EaV2Parser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EaV2Parser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(EaV2Parser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EaV2Parser#questionStrict}.
	 * @param ctx the parse tree
	 */
	void enterQuestionStrict(EaV2Parser.QuestionStrictContext ctx);
	/**
	 * Exit a parse tree produced by {@link EaV2Parser#questionStrict}.
	 * @param ctx the parse tree
	 */
	void exitQuestionStrict(EaV2Parser.QuestionStrictContext ctx);
	/**
	 * Enter a parse tree produced by {@link EaV2Parser#questionLoose}.
	 * @param ctx the parse tree
	 */
	void enterQuestionLoose(EaV2Parser.QuestionLooseContext ctx);
	/**
	 * Exit a parse tree produced by {@link EaV2Parser#questionLoose}.
	 * @param ctx the parse tree
	 */
	void exitQuestionLoose(EaV2Parser.QuestionLooseContext ctx);
	/**
	 * Enter a parse tree produced by {@link EaV2Parser#exclamation}.
	 * @param ctx the parse tree
	 */
	void enterExclamation(EaV2Parser.ExclamationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EaV2Parser#exclamation}.
	 * @param ctx the parse tree
	 */
	void exitExclamation(EaV2Parser.ExclamationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EaV2Parser#exclamationStrict}.
	 * @param ctx the parse tree
	 */
	void enterExclamationStrict(EaV2Parser.ExclamationStrictContext ctx);
	/**
	 * Exit a parse tree produced by {@link EaV2Parser#exclamationStrict}.
	 * @param ctx the parse tree
	 */
	void exitExclamationStrict(EaV2Parser.ExclamationStrictContext ctx);
	/**
	 * Enter a parse tree produced by {@link EaV2Parser#exclamationLoose}.
	 * @param ctx the parse tree
	 */
	void enterExclamationLoose(EaV2Parser.ExclamationLooseContext ctx);
	/**
	 * Exit a parse tree produced by {@link EaV2Parser#exclamationLoose}.
	 * @param ctx the parse tree
	 */
	void exitExclamationLoose(EaV2Parser.ExclamationLooseContext ctx);
	/**
	 * Enter a parse tree produced by {@link EaV2Parser#declarative}.
	 * @param ctx the parse tree
	 */
	void enterDeclarative(EaV2Parser.DeclarativeContext ctx);
	/**
	 * Exit a parse tree produced by {@link EaV2Parser#declarative}.
	 * @param ctx the parse tree
	 */
	void exitDeclarative(EaV2Parser.DeclarativeContext ctx);
	/**
	 * Enter a parse tree produced by {@link EaV2Parser#clause}.
	 * @param ctx the parse tree
	 */
	void enterClause(EaV2Parser.ClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link EaV2Parser#clause}.
	 * @param ctx the parse tree
	 */
	void exitClause(EaV2Parser.ClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link EaV2Parser#phrase}.
	 * @param ctx the parse tree
	 */
	void enterPhrase(EaV2Parser.PhraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link EaV2Parser#phrase}.
	 * @param ctx the parse tree
	 */
	void exitPhrase(EaV2Parser.PhraseContext ctx);
	/**
	 * Enter a parse tree produced by {@link EaV2Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(EaV2Parser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link EaV2Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(EaV2Parser.TermContext ctx);
}