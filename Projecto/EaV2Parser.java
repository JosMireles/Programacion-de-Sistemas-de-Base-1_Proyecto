// Generated from EaV2.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class EaV2Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LEXCL=1, REXCL=2, LQN=3, RQN=4, PUNCT=5, CONJ=6, NUMBER=7, WORD=8, WS=9;
	public static final int
		RULE_text = 0, RULE_sentence = 1, RULE_question = 2, RULE_questionStrict = 3, 
		RULE_questionLoose = 4, RULE_exclamation = 5, RULE_exclamationStrict = 6, 
		RULE_exclamationLoose = 7, RULE_declarative = 8, RULE_clause = 9, RULE_phrase = 10, 
		RULE_term = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"text", "sentence", "question", "questionStrict", "questionLoose", "exclamation", 
			"exclamationStrict", "exclamationLoose", "declarative", "clause", "phrase", 
			"term"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'\\u00A1'", "'!'", "'\\u00BF'", "'?'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LEXCL", "REXCL", "LQN", "RQN", "PUNCT", "CONJ", "NUMBER", "WORD", 
			"WS"
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
	public String getGrammarFileName() { return "EaV2.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public EaV2Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TextContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(EaV2Parser.EOF, 0); }
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EaV2Listener ) ((EaV2Listener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EaV2Listener ) ((EaV2Listener)listener).exitText(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(24);
				sentence();
				}
				}
				setState(27); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 394L) != 0) );
			setState(29);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SentenceContext extends ParserRuleContext {
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public ExclamationContext exclamation() {
			return getRuleContext(ExclamationContext.class,0);
		}
		public DeclarativeContext declarative() {
			return getRuleContext(DeclarativeContext.class,0);
		}
		public SentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EaV2Listener ) ((EaV2Listener)listener).enterSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EaV2Listener ) ((EaV2Listener)listener).exitSentence(this);
		}
	}

	public final SentenceContext sentence() throws RecognitionException {
		SentenceContext _localctx = new SentenceContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sentence);
		try {
			setState(34);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				question();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(32);
				exclamation();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(33);
				declarative();
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

	@SuppressWarnings("CheckReturnValue")
	public static class QuestionContext extends ParserRuleContext {
		public QuestionStrictContext questionStrict() {
			return getRuleContext(QuestionStrictContext.class,0);
		}
		public QuestionLooseContext questionLoose() {
			return getRuleContext(QuestionLooseContext.class,0);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EaV2Listener ) ((EaV2Listener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EaV2Listener ) ((EaV2Listener)listener).exitQuestion(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_question);
		try {
			setState(38);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LQN:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				questionStrict();
				}
				break;
			case NUMBER:
			case WORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				questionLoose();
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

	@SuppressWarnings("CheckReturnValue")
	public static class QuestionStrictContext extends ParserRuleContext {
		public TerminalNode LQN() { return getToken(EaV2Parser.LQN, 0); }
		public ClauseContext clause() {
			return getRuleContext(ClauseContext.class,0);
		}
		public TerminalNode RQN() { return getToken(EaV2Parser.RQN, 0); }
		public QuestionStrictContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionStrict; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EaV2Listener ) ((EaV2Listener)listener).enterQuestionStrict(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EaV2Listener ) ((EaV2Listener)listener).exitQuestionStrict(this);
		}
	}

	public final QuestionStrictContext questionStrict() throws RecognitionException {
		QuestionStrictContext _localctx = new QuestionStrictContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_questionStrict);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(LQN);
			setState(41);
			clause();
			setState(42);
			match(RQN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class QuestionLooseContext extends ParserRuleContext {
		public ClauseContext clause() {
			return getRuleContext(ClauseContext.class,0);
		}
		public TerminalNode RQN() { return getToken(EaV2Parser.RQN, 0); }
		public QuestionLooseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionLoose; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EaV2Listener ) ((EaV2Listener)listener).enterQuestionLoose(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EaV2Listener ) ((EaV2Listener)listener).exitQuestionLoose(this);
		}
	}

	public final QuestionLooseContext questionLoose() throws RecognitionException {
		QuestionLooseContext _localctx = new QuestionLooseContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_questionLoose);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			clause();
			setState(45);
			match(RQN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExclamationContext extends ParserRuleContext {
		public ExclamationStrictContext exclamationStrict() {
			return getRuleContext(ExclamationStrictContext.class,0);
		}
		public ExclamationLooseContext exclamationLoose() {
			return getRuleContext(ExclamationLooseContext.class,0);
		}
		public ExclamationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exclamation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EaV2Listener ) ((EaV2Listener)listener).enterExclamation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EaV2Listener ) ((EaV2Listener)listener).exitExclamation(this);
		}
	}

	public final ExclamationContext exclamation() throws RecognitionException {
		ExclamationContext _localctx = new ExclamationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_exclamation);
		try {
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEXCL:
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				exclamationStrict();
				}
				break;
			case NUMBER:
			case WORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
				exclamationLoose();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExclamationStrictContext extends ParserRuleContext {
		public TerminalNode LEXCL() { return getToken(EaV2Parser.LEXCL, 0); }
		public ClauseContext clause() {
			return getRuleContext(ClauseContext.class,0);
		}
		public TerminalNode REXCL() { return getToken(EaV2Parser.REXCL, 0); }
		public ExclamationStrictContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exclamationStrict; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EaV2Listener ) ((EaV2Listener)listener).enterExclamationStrict(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EaV2Listener ) ((EaV2Listener)listener).exitExclamationStrict(this);
		}
	}

	public final ExclamationStrictContext exclamationStrict() throws RecognitionException {
		ExclamationStrictContext _localctx = new ExclamationStrictContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_exclamationStrict);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(LEXCL);
			setState(52);
			clause();
			setState(53);
			match(REXCL);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExclamationLooseContext extends ParserRuleContext {
		public ClauseContext clause() {
			return getRuleContext(ClauseContext.class,0);
		}
		public TerminalNode REXCL() { return getToken(EaV2Parser.REXCL, 0); }
		public ExclamationLooseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exclamationLoose; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EaV2Listener ) ((EaV2Listener)listener).enterExclamationLoose(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EaV2Listener ) ((EaV2Listener)listener).exitExclamationLoose(this);
		}
	}

	public final ExclamationLooseContext exclamationLoose() throws RecognitionException {
		ExclamationLooseContext _localctx = new ExclamationLooseContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_exclamationLoose);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			clause();
			setState(56);
			match(REXCL);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarativeContext extends ParserRuleContext {
		public ClauseContext clause() {
			return getRuleContext(ClauseContext.class,0);
		}
		public TerminalNode PUNCT() { return getToken(EaV2Parser.PUNCT, 0); }
		public DeclarativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarative; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EaV2Listener ) ((EaV2Listener)listener).enterDeclarative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EaV2Listener ) ((EaV2Listener)listener).exitDeclarative(this);
		}
	}

	public final DeclarativeContext declarative() throws RecognitionException {
		DeclarativeContext _localctx = new DeclarativeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_declarative);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			clause();
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNCT) {
				{
				setState(59);
				match(PUNCT);
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClauseContext extends ParserRuleContext {
		public List<PhraseContext> phrase() {
			return getRuleContexts(PhraseContext.class);
		}
		public PhraseContext phrase(int i) {
			return getRuleContext(PhraseContext.class,i);
		}
		public List<TerminalNode> CONJ() { return getTokens(EaV2Parser.CONJ); }
		public TerminalNode CONJ(int i) {
			return getToken(EaV2Parser.CONJ, i);
		}
		public ClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EaV2Listener ) ((EaV2Listener)listener).enterClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EaV2Listener ) ((EaV2Listener)listener).exitClause(this);
		}
	}

	public final ClauseContext clause() throws RecognitionException {
		ClauseContext _localctx = new ClauseContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			phrase();
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONJ) {
				{
				{
				setState(63);
				match(CONJ);
				setState(64);
				phrase();
				}
				}
				setState(69);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PhraseContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public PhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phrase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EaV2Listener ) ((EaV2Listener)listener).enterPhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EaV2Listener ) ((EaV2Listener)listener).exitPhrase(this);
		}
	}

	public final PhraseContext phrase() throws RecognitionException {
		PhraseContext _localctx = new PhraseContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_phrase);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(71); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(70);
					term();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(73); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(EaV2Parser.WORD, 0); }
		public TerminalNode NUMBER() { return getToken(EaV2Parser.NUMBER, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EaV2Listener ) ((EaV2Listener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EaV2Listener ) ((EaV2Listener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_la = _input.LA(1);
			if ( !(_la==NUMBER || _la==WORD) ) {
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
		"\u0004\u0001\tN\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0001"+
		"\u0000\u0004\u0000\u001a\b\u0000\u000b\u0000\f\u0000\u001b\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001#\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0003\u0002\'\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0003\u00052\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0003"+
		"\b=\b\b\u0001\t\u0001\t\u0001\t\u0005\tB\b\t\n\t\f\tE\t\t\u0001\n\u0004"+
		"\nH\b\n\u000b\n\f\nI\u0001\u000b\u0001\u000b\u0001\u000b\u0000\u0000\f"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0000\u0001"+
		"\u0001\u0000\u0007\bI\u0000\u0019\u0001\u0000\u0000\u0000\u0002\"\u0001"+
		"\u0000\u0000\u0000\u0004&\u0001\u0000\u0000\u0000\u0006(\u0001\u0000\u0000"+
		"\u0000\b,\u0001\u0000\u0000\u0000\n1\u0001\u0000\u0000\u0000\f3\u0001"+
		"\u0000\u0000\u0000\u000e7\u0001\u0000\u0000\u0000\u0010:\u0001\u0000\u0000"+
		"\u0000\u0012>\u0001\u0000\u0000\u0000\u0014G\u0001\u0000\u0000\u0000\u0016"+
		"K\u0001\u0000\u0000\u0000\u0018\u001a\u0003\u0002\u0001\u0000\u0019\u0018"+
		"\u0001\u0000\u0000\u0000\u001a\u001b\u0001\u0000\u0000\u0000\u001b\u0019"+
		"\u0001\u0000\u0000\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u001d"+
		"\u0001\u0000\u0000\u0000\u001d\u001e\u0005\u0000\u0000\u0001\u001e\u0001"+
		"\u0001\u0000\u0000\u0000\u001f#\u0003\u0004\u0002\u0000 #\u0003\n\u0005"+
		"\u0000!#\u0003\u0010\b\u0000\"\u001f\u0001\u0000\u0000\u0000\" \u0001"+
		"\u0000\u0000\u0000\"!\u0001\u0000\u0000\u0000#\u0003\u0001\u0000\u0000"+
		"\u0000$\'\u0003\u0006\u0003\u0000%\'\u0003\b\u0004\u0000&$\u0001\u0000"+
		"\u0000\u0000&%\u0001\u0000\u0000\u0000\'\u0005\u0001\u0000\u0000\u0000"+
		"()\u0005\u0003\u0000\u0000)*\u0003\u0012\t\u0000*+\u0005\u0004\u0000\u0000"+
		"+\u0007\u0001\u0000\u0000\u0000,-\u0003\u0012\t\u0000-.\u0005\u0004\u0000"+
		"\u0000.\t\u0001\u0000\u0000\u0000/2\u0003\f\u0006\u000002\u0003\u000e"+
		"\u0007\u00001/\u0001\u0000\u0000\u000010\u0001\u0000\u0000\u00002\u000b"+
		"\u0001\u0000\u0000\u000034\u0005\u0001\u0000\u000045\u0003\u0012\t\u0000"+
		"56\u0005\u0002\u0000\u00006\r\u0001\u0000\u0000\u000078\u0003\u0012\t"+
		"\u000089\u0005\u0002\u0000\u00009\u000f\u0001\u0000\u0000\u0000:<\u0003"+
		"\u0012\t\u0000;=\u0005\u0005\u0000\u0000<;\u0001\u0000\u0000\u0000<=\u0001"+
		"\u0000\u0000\u0000=\u0011\u0001\u0000\u0000\u0000>C\u0003\u0014\n\u0000"+
		"?@\u0005\u0006\u0000\u0000@B\u0003\u0014\n\u0000A?\u0001\u0000\u0000\u0000"+
		"BE\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000"+
		"\u0000D\u0013\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000FH\u0003"+
		"\u0016\u000b\u0000GF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000"+
		"IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000J\u0015\u0001\u0000"+
		"\u0000\u0000KL\u0007\u0000\u0000\u0000L\u0017\u0001\u0000\u0000\u0000"+
		"\u0007\u001b\"&1<CI";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}