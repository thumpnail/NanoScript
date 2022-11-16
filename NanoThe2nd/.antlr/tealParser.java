// Generated from c:\Users\fried\OneDrive\Dokumente\Code\Visual Studio Projects\Nano Operational Functional Script\NanoThe2nd\Teal.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TealParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, T__60=61, T__61=62, T__62=63, T__63=64, NAME=65, NORMALSTRING=66, 
		CHARSTRING=67, LONGSTRING=68, INT=69, HEX=70, FLOAT=71, HEX_FLOAT=72, 
		COMMENT=73, LINE_COMMENT=74, WS=75, SHEBANG=76;
	public static final int
		RULE_chunk = 0, RULE_block = 1, RULE_stat = 2, RULE_attnamelist = 3, RULE_attrib = 4, 
		RULE_typ = 5, RULE_basetype = 6, RULE_typelist = 7, RULE_retlist = 8, 
		RULE_typeargs = 9, RULE_newtype = 10, RULE_functiontype = 11, RULE_partypelist = 12, 
		RULE_partype = 13, RULE_parnamelist = 14, RULE_parname = 15, RULE_retstat = 16, 
		RULE_label = 17, RULE_funcname = 18, RULE_varlist = 19, RULE_namelist = 20, 
		RULE_explist = 21, RULE_exp = 22, RULE_prefixexp = 23, RULE_functioncall = 24, 
		RULE_varOrExp = 25, RULE_variable = 26, RULE_varSuffix = 27, RULE_nameAndArgs = 28, 
		RULE_args = 29, RULE_functiondef = 30, RULE_funcbody = 31, RULE_parlist = 32, 
		RULE_tableconstructor = 33, RULE_fieldlist = 34, RULE_field = 35, RULE_fieldsep = 36, 
		RULE_operatorOr = 37, RULE_operatorAnd = 38, RULE_operatorComparison = 39, 
		RULE_operatorStrcat = 40, RULE_operatorAddSub = 41, RULE_operatorMulDivMod = 42, 
		RULE_operatorBitwise = 43, RULE_operatorUnary = 44, RULE_operatorPower = 45, 
		RULE_number = 46, RULE_str = 47;
	private static String[] makeRuleNames() {
		return new String[] {
			"chunk", "block", "stat", "attnamelist", "attrib", "typ", "basetype", 
			"typelist", "retlist", "typeargs", "newtype", "functiontype", "partypelist", 
			"partype", "parnamelist", "parname", "retstat", "label", "funcname", 
			"varlist", "namelist", "explist", "exp", "prefixexp", "functioncall", 
			"varOrExp", "variable", "varSuffix", "nameAndArgs", "args", "functiondef", 
			"funcbody", "parlist", "tableconstructor", "fieldlist", "field", "fieldsep", 
			"operatorOr", "operatorAnd", "operatorComparison", "operatorStrcat", 
			"operatorAddSub", "operatorMulDivMod", "operatorBitwise", "operatorUnary", 
			"operatorPower", "number", "str"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'='", "'break'", "'goto'", "'do'", "'end'", "'while'", 
			"'repeat'", "'until'", "'if'", "'then'", "'elseif'", "'else'", "'for'", 
			"','", "'in'", "'function'", "'local'", "':'", "'global'", "'<'", "'>'", 
			"'('", "')'", "'|'", "'string'", "'boolean'", "'nil'", "'number'", "'{'", 
			"'}'", "'...'", "'record'", "'enum'", "'functiontype'", "'return'", "'::'", 
			"'.'", "'false'", "'true'", "'as'", "'is'", "'['", "']'", "'or'", "'and'", 
			"'<='", "'>='", "'~='", "'=='", "'..'", "'+'", "'-'", "'*'", "'/'", "'%'", 
			"'//'", "'&'", "'~'", "'<<'", "'>>'", "'not'", "'#'", "'^'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "NAME", "NORMALSTRING", "CHARSTRING", "LONGSTRING", 
			"INT", "HEX", "FLOAT", "HEX_FLOAT", "COMMENT", "LINE_COMMENT", "WS", 
			"SHEBANG"
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
	public String getGrammarFileName() { return "Teal.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TealParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ChunkContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode EOF() { return getToken(TealParser.EOF, 0); }
		public ChunkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chunk; }
	}

	public final ChunkContext chunk() throws RecognitionException {
		ChunkContext _localctx = new ChunkContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_chunk);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			block();
			setState(97);
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

	public static class BlockContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public RetstatContext retstat() {
			return getRuleContext(RetstatContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__13) | (1L << T__16) | (1L << T__17) | (1L << T__19) | (1L << T__22) | (1L << T__36))) != 0) || _la==NAME) {
				{
				{
				setState(99);
				stat();
				}
				}
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__35) {
				{
				setState(105);
				retstat();
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

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RepeatStatContext extends StatContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public RepeatStatContext(StatContext ctx) { copyFrom(ctx); }
	}
	public static class BreakStatContext extends StatContext {
		public BreakStatContext(StatContext ctx) { copyFrom(ctx); }
	}
	public static class FuncStatContext extends StatContext {
		public FuncnameContext funcname() {
			return getRuleContext(FuncnameContext.class,0);
		}
		public FuncbodyContext funcbody() {
			return getRuleContext(FuncbodyContext.class,0);
		}
		public FuncStatContext(StatContext ctx) { copyFrom(ctx); }
	}
	public static class SemiStatContext extends StatContext {
		public SemiStatContext(StatContext ctx) { copyFrom(ctx); }
	}
	public static class ForInStatContext extends StatContext {
		public NamelistContext namelist() {
			return getRuleContext(NamelistContext.class,0);
		}
		public ExplistContext explist() {
			return getRuleContext(ExplistContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ForInStatContext(StatContext ctx) { copyFrom(ctx); }
	}
	public static class GlobalAttrStatContext extends StatContext {
		public AttnamelistContext attnamelist() {
			return getRuleContext(AttnamelistContext.class,0);
		}
		public TypelistContext typelist() {
			return getRuleContext(TypelistContext.class,0);
		}
		public GlobalAttrStatContext(StatContext ctx) { copyFrom(ctx); }
	}
	public static class IfStatContext extends StatContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public IfStatContext(StatContext ctx) { copyFrom(ctx); }
	}
	public static class LocalFuncStatContext extends StatContext {
		public TerminalNode NAME() { return getToken(TealParser.NAME, 0); }
		public FuncbodyContext funcbody() {
			return getRuleContext(FuncbodyContext.class,0);
		}
		public LocalFuncStatContext(StatContext ctx) { copyFrom(ctx); }
	}
	public static class WhileStatContext extends StatContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStatContext(StatContext ctx) { copyFrom(ctx); }
	}
	public static class GotoStatContext extends StatContext {
		public TerminalNode NAME() { return getToken(TealParser.NAME, 0); }
		public GotoStatContext(StatContext ctx) { copyFrom(ctx); }
	}
	public static class LocalAttrAssignStatContext extends StatContext {
		public AttnamelistContext attnamelist() {
			return getRuleContext(AttnamelistContext.class,0);
		}
		public TypelistContext typelist() {
			return getRuleContext(TypelistContext.class,0);
		}
		public ExplistContext explist() {
			return getRuleContext(ExplistContext.class,0);
		}
		public LocalAttrAssignStatContext(StatContext ctx) { copyFrom(ctx); }
	}
	public static class LocalNewTypeStatContext extends StatContext {
		public TerminalNode NAME() { return getToken(TealParser.NAME, 0); }
		public NewtypeContext newtype() {
			return getRuleContext(NewtypeContext.class,0);
		}
		public LocalNewTypeStatContext(StatContext ctx) { copyFrom(ctx); }
	}
	public static class GlobalAttrAssignStatContext extends StatContext {
		public AttnamelistContext attnamelist() {
			return getRuleContext(AttnamelistContext.class,0);
		}
		public ExplistContext explist() {
			return getRuleContext(ExplistContext.class,0);
		}
		public TypelistContext typelist() {
			return getRuleContext(TypelistContext.class,0);
		}
		public GlobalAttrAssignStatContext(StatContext ctx) { copyFrom(ctx); }
	}
	public static class LabelStatContext extends StatContext {
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public LabelStatContext(StatContext ctx) { copyFrom(ctx); }
	}
	public static class ForStatContext extends StatContext {
		public TerminalNode NAME() { return getToken(TealParser.NAME, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ForStatContext(StatContext ctx) { copyFrom(ctx); }
	}
	public static class GlobalFuncStatContext extends StatContext {
		public TerminalNode NAME() { return getToken(TealParser.NAME, 0); }
		public FuncbodyContext funcbody() {
			return getRuleContext(FuncbodyContext.class,0);
		}
		public GlobalFuncStatContext(StatContext ctx) { copyFrom(ctx); }
	}
	public static class AssignStatContext extends StatContext {
		public VarlistContext varlist() {
			return getRuleContext(VarlistContext.class,0);
		}
		public ExplistContext explist() {
			return getRuleContext(ExplistContext.class,0);
		}
		public AssignStatContext(StatContext ctx) { copyFrom(ctx); }
	}
	public static class DoStatContext extends StatContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public DoStatContext(StatContext ctx) { copyFrom(ctx); }
	}
	public static class GlobalAssignStatContext extends StatContext {
		public TerminalNode NAME() { return getToken(TealParser.NAME, 0); }
		public NewtypeContext newtype() {
			return getRuleContext(NewtypeContext.class,0);
		}
		public GlobalAssignStatContext(StatContext ctx) { copyFrom(ctx); }
	}
	public static class FuncCallStatContext extends StatContext {
		public FunctioncallContext functioncall() {
			return getRuleContext(FunctioncallContext.class,0);
		}
		public FuncCallStatContext(StatContext ctx) { copyFrom(ctx); }
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stat);
		int _la;
		try {
			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new SemiStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				match(T__0);
				}
				break;
			case 2:
				_localctx = new AssignStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				varlist();
				setState(110);
				match(T__1);
				setState(111);
				explist();
				}
				break;
			case 3:
				_localctx = new FuncCallStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				functioncall();
				}
				break;
			case 4:
				_localctx = new LabelStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(114);
				label();
				}
				break;
			case 5:
				_localctx = new BreakStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(115);
				match(T__2);
				}
				break;
			case 6:
				_localctx = new GotoStatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(116);
				match(T__3);
				setState(117);
				match(NAME);
				}
				break;
			case 7:
				_localctx = new DoStatContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(118);
				match(T__4);
				setState(119);
				block();
				setState(120);
				match(T__5);
				}
				break;
			case 8:
				_localctx = new WhileStatContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(122);
				match(T__6);
				setState(123);
				exp(0);
				setState(124);
				match(T__4);
				setState(125);
				block();
				setState(126);
				match(T__5);
				}
				break;
			case 9:
				_localctx = new RepeatStatContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(128);
				match(T__7);
				setState(129);
				block();
				setState(130);
				match(T__8);
				setState(131);
				exp(0);
				}
				break;
			case 10:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(133);
				match(T__9);
				setState(134);
				exp(0);
				setState(135);
				match(T__10);
				setState(136);
				block();
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(137);
					match(T__11);
					setState(138);
					exp(0);
					setState(139);
					match(T__10);
					setState(140);
					block();
					}
					}
					setState(146);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__12) {
					{
					setState(147);
					match(T__12);
					setState(148);
					block();
					}
				}

				setState(151);
				match(T__5);
				}
				break;
			case 11:
				_localctx = new ForStatContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(153);
				match(T__13);
				setState(154);
				match(NAME);
				setState(155);
				match(T__1);
				setState(156);
				exp(0);
				setState(157);
				match(T__14);
				setState(158);
				exp(0);
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(159);
					match(T__14);
					setState(160);
					exp(0);
					}
				}

				setState(163);
				match(T__4);
				setState(164);
				block();
				setState(165);
				match(T__5);
				}
				break;
			case 12:
				_localctx = new ForInStatContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(167);
				match(T__13);
				setState(168);
				namelist();
				setState(169);
				match(T__15);
				setState(170);
				explist();
				setState(171);
				match(T__4);
				setState(172);
				block();
				setState(173);
				match(T__5);
				}
				break;
			case 13:
				_localctx = new FuncStatContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(175);
				match(T__16);
				setState(176);
				funcname();
				setState(177);
				funcbody();
				}
				break;
			case 14:
				_localctx = new LocalFuncStatContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(179);
				match(T__17);
				setState(180);
				match(T__16);
				setState(181);
				match(NAME);
				setState(182);
				funcbody();
				}
				break;
			case 15:
				_localctx = new LocalAttrAssignStatContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(183);
				match(T__17);
				setState(184);
				attnamelist();
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__18) {
					{
					setState(185);
					match(T__18);
					setState(186);
					typelist();
					}
				}

				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(189);
					match(T__1);
					setState(190);
					explist();
					}
				}

				}
				break;
			case 16:
				_localctx = new LocalNewTypeStatContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(193);
				match(T__17);
				setState(194);
				match(NAME);
				setState(195);
				match(T__1);
				setState(196);
				newtype();
				}
				break;
			case 17:
				_localctx = new GlobalFuncStatContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(197);
				match(T__19);
				setState(198);
				match(T__16);
				setState(199);
				match(NAME);
				setState(200);
				funcbody();
				}
				break;
			case 18:
				_localctx = new GlobalAttrStatContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(201);
				match(T__19);
				setState(202);
				attnamelist();
				setState(203);
				match(T__18);
				setState(204);
				typelist();
				}
				break;
			case 19:
				_localctx = new GlobalAttrAssignStatContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(206);
				match(T__19);
				setState(207);
				attnamelist();
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__18) {
					{
					setState(208);
					match(T__18);
					setState(209);
					typelist();
					}
				}

				setState(212);
				match(T__1);
				setState(213);
				explist();
				}
				break;
			case 20:
				_localctx = new GlobalAssignStatContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(215);
				match(T__19);
				setState(216);
				match(NAME);
				setState(217);
				match(T__1);
				setState(218);
				newtype();
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

	public static class AttnamelistContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(TealParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(TealParser.NAME, i);
		}
		public List<AttribContext> attrib() {
			return getRuleContexts(AttribContext.class);
		}
		public AttribContext attrib(int i) {
			return getRuleContext(AttribContext.class,i);
		}
		public AttnamelistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attnamelist; }
	}

	public final AttnamelistContext attnamelist() throws RecognitionException {
		AttnamelistContext _localctx = new AttnamelistContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_attnamelist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(NAME);
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(222);
				attrib();
				}
			}

			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(225);
				match(T__14);
				setState(226);
				match(NAME);
				setState(228);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__20) {
					{
					setState(227);
					attrib();
					}
				}

				}
				}
				setState(234);
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

	public static class AttribContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(TealParser.NAME, 0); }
		public AttribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrib; }
	}

	public final AttribContext attrib() throws RecognitionException {
		AttribContext _localctx = new AttribContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_attrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(T__20);
			setState(236);
			match(NAME);
			setState(237);
			match(T__21);
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

	public static class TypContext extends ParserRuleContext {
		public TypContext typ() {
			return getRuleContext(TypContext.class,0);
		}
		public List<BasetypeContext> basetype() {
			return getRuleContexts(BasetypeContext.class);
		}
		public BasetypeContext basetype(int i) {
			return getRuleContext(BasetypeContext.class,i);
		}
		public TypContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typ; }
	}

	public final TypContext typ() throws RecognitionException {
		TypContext _localctx = new TypContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_typ);
		try {
			int _alt;
			setState(251);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				setState(239);
				match(T__22);
				setState(240);
				typ();
				setState(241);
				match(T__23);
				}
				break;
			case T__16:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(243);
				basetype();
				setState(248);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(244);
						match(T__24);
						setState(245);
						basetype();
						}
						} 
					}
					setState(250);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				}
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

	public static class BasetypeContext extends ParserRuleContext {
		public List<TypContext> typ() {
			return getRuleContexts(TypContext.class);
		}
		public TypContext typ(int i) {
			return getRuleContext(TypContext.class,i);
		}
		public FunctiontypeContext functiontype() {
			return getRuleContext(FunctiontypeContext.class,0);
		}
		public TerminalNode NAME() { return getToken(TealParser.NAME, 0); }
		public TypeargsContext typeargs() {
			return getRuleContext(TypeargsContext.class,0);
		}
		public BasetypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basetype; }
	}

	public final BasetypeContext basetype() throws RecognitionException {
		BasetypeContext _localctx = new BasetypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_basetype);
		try {
			setState(273);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(253);
				match(T__25);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(254);
				match(T__26);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(255);
				match(T__27);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(256);
				match(T__28);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(257);
				match(T__29);
				setState(258);
				typ();
				setState(259);
				match(T__30);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(261);
				match(T__29);
				setState(262);
				typ();
				setState(263);
				match(T__18);
				setState(264);
				typ();
				setState(265);
				match(T__30);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(267);
				match(T__16);
				setState(268);
				functiontype();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(269);
				match(NAME);
				setState(271);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(270);
					typeargs();
					}
					break;
				}
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

	public static class TypelistContext extends ParserRuleContext {
		public List<TypContext> typ() {
			return getRuleContexts(TypContext.class);
		}
		public TypContext typ(int i) {
			return getRuleContext(TypContext.class,i);
		}
		public TypelistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typelist; }
	}

	public final TypelistContext typelist() throws RecognitionException {
		TypelistContext _localctx = new TypelistContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_typelist);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			typ();
			setState(278);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(276);
				match(T__14);
				setState(277);
				typ();
				}
				break;
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

	public static class RetlistContext extends ParserRuleContext {
		public TypelistContext typelist() {
			return getRuleContext(TypelistContext.class,0);
		}
		public RetlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_retlist; }
	}

	public final RetlistContext retlist() throws RecognitionException {
		RetlistContext _localctx = new RetlistContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_retlist);
		int _la;
		try {
			setState(292);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(280);
				match(T__22);
				setState(282);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (T__16 - 17)) | (1L << (T__22 - 17)) | (1L << (T__25 - 17)) | (1L << (T__26 - 17)) | (1L << (T__27 - 17)) | (1L << (T__28 - 17)) | (1L << (T__29 - 17)) | (1L << (NAME - 17)))) != 0)) {
					{
					setState(281);
					typelist();
					}
				}

				setState(285);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__31) {
					{
					setState(284);
					match(T__31);
					}
				}

				setState(287);
				match(T__23);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(288);
				typelist();
				setState(290);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(289);
					match(T__31);
					}
					break;
				}
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

	public static class TypeargsContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(TealParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(TealParser.NAME, i);
		}
		public TypeargsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeargs; }
	}

	public final TypeargsContext typeargs() throws RecognitionException {
		TypeargsContext _localctx = new TypeargsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_typeargs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			match(T__20);
			setState(295);
			match(NAME);
			setState(300);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(296);
				match(T__14);
				setState(297);
				match(NAME);
				}
				}
				setState(302);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(303);
			match(T__21);
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

	public static class NewtypeContext extends ParserRuleContext {
		public NewtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newtype; }
	 
		public NewtypeContext() { }
		public void copyFrom(NewtypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RecordNewTypeContext extends NewtypeContext {
		public TypeargsContext typeargs() {
			return getRuleContext(TypeargsContext.class,0);
		}
		public List<TypContext> typ() {
			return getRuleContexts(TypContext.class);
		}
		public TypContext typ(int i) {
			return getRuleContext(TypContext.class,i);
		}
		public List<TerminalNode> NAME() { return getTokens(TealParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(TealParser.NAME, i);
		}
		public List<NewtypeContext> newtype() {
			return getRuleContexts(NewtypeContext.class);
		}
		public NewtypeContext newtype(int i) {
			return getRuleContext(NewtypeContext.class,i);
		}
		public RecordNewTypeContext(NewtypeContext ctx) { copyFrom(ctx); }
	}
	public static class EnumNewTypeContext extends NewtypeContext {
		public List<StrContext> str() {
			return getRuleContexts(StrContext.class);
		}
		public StrContext str(int i) {
			return getRuleContext(StrContext.class,i);
		}
		public EnumNewTypeContext(NewtypeContext ctx) { copyFrom(ctx); }
	}
	public static class FuncNewTypeContext extends NewtypeContext {
		public FunctiontypeContext functiontype() {
			return getRuleContext(FunctiontypeContext.class,0);
		}
		public FuncNewTypeContext(NewtypeContext ctx) { copyFrom(ctx); }
	}

	public final NewtypeContext newtype() throws RecognitionException {
		NewtypeContext _localctx = new NewtypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_newtype);
		int _la;
		try {
			int _alt;
			setState(342);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__32:
				_localctx = new RecordNewTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(305);
				match(T__32);
				setState(307);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__20) {
					{
					setState(306);
					typeargs();
					}
				}

				setState(313);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__29) {
					{
					setState(309);
					match(T__29);
					setState(310);
					typ();
					setState(311);
					match(T__30);
					}
				}

				setState(320);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(315);
						match(NAME);
						setState(316);
						match(T__1);
						setState(317);
						newtype();
						}
						} 
					}
					setState(322);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				}
				setState(328);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NAME) {
					{
					{
					setState(323);
					match(NAME);
					setState(324);
					match(T__18);
					setState(325);
					typ();
					}
					}
					setState(330);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(331);
				match(T__5);
				}
				break;
			case T__33:
				_localctx = new EnumNewTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(332);
				match(T__33);
				setState(336);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (NORMALSTRING - 66)) | (1L << (CHARSTRING - 66)) | (1L << (LONGSTRING - 66)))) != 0)) {
					{
					{
					setState(333);
					str();
					}
					}
					setState(338);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(339);
				match(T__5);
				}
				break;
			case T__34:
				_localctx = new FuncNewTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(340);
				match(T__34);
				setState(341);
				functiontype();
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

	public static class FunctiontypeContext extends ParserRuleContext {
		public PartypelistContext partypelist() {
			return getRuleContext(PartypelistContext.class,0);
		}
		public TypeargsContext typeargs() {
			return getRuleContext(TypeargsContext.class,0);
		}
		public RetlistContext retlist() {
			return getRuleContext(RetlistContext.class,0);
		}
		public FunctiontypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functiontype; }
	}

	public final FunctiontypeContext functiontype() throws RecognitionException {
		FunctiontypeContext _localctx = new FunctiontypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_functiontype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(344);
				typeargs();
				}
			}

			setState(347);
			match(T__22);
			setState(348);
			partypelist();
			setState(349);
			match(T__23);
			setState(352);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(350);
				match(T__18);
				setState(351);
				retlist();
				}
				break;
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

	public static class PartypelistContext extends ParserRuleContext {
		public List<PartypeContext> partype() {
			return getRuleContexts(PartypeContext.class);
		}
		public PartypeContext partype(int i) {
			return getRuleContext(PartypeContext.class,i);
		}
		public PartypelistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partypelist; }
	}

	public final PartypelistContext partypelist() throws RecognitionException {
		PartypelistContext _localctx = new PartypelistContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_partypelist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			partype();
			setState(359);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(355);
				match(T__14);
				setState(356);
				partype();
				}
				}
				setState(361);
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

	public static class PartypeContext extends ParserRuleContext {
		public TypContext typ() {
			return getRuleContext(TypContext.class,0);
		}
		public TerminalNode NAME() { return getToken(TealParser.NAME, 0); }
		public PartypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partype; }
	}

	public final PartypeContext partype() throws RecognitionException {
		PartypeContext _localctx = new PartypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_partype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(362);
				match(NAME);
				setState(363);
				match(T__18);
				}
				break;
			}
			setState(366);
			typ();
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

	public static class ParnamelistContext extends ParserRuleContext {
		public List<ParnameContext> parname() {
			return getRuleContexts(ParnameContext.class);
		}
		public ParnameContext parname(int i) {
			return getRuleContext(ParnameContext.class,i);
		}
		public ParnamelistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parnamelist; }
	}

	public final ParnamelistContext parnamelist() throws RecognitionException {
		ParnamelistContext _localctx = new ParnamelistContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_parnamelist);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
			parname();
			setState(373);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(369);
					match(T__14);
					setState(370);
					parname();
					}
					} 
				}
				setState(375);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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

	public static class ParnameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(TealParser.NAME, 0); }
		public TypContext typ() {
			return getRuleContext(TypContext.class,0);
		}
		public ParnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parname; }
	}

	public final ParnameContext parname() throws RecognitionException {
		ParnameContext _localctx = new ParnameContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_parname);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			match(NAME);
			setState(379);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__18) {
				{
				setState(377);
				match(T__18);
				setState(378);
				typ();
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

	public static class RetstatContext extends ParserRuleContext {
		public RetstatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_retstat; }
	 
		public RetstatContext() { }
		public void copyFrom(RetstatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ReturnStatContext extends RetstatContext {
		public ExplistContext explist() {
			return getRuleContext(ExplistContext.class,0);
		}
		public ReturnStatContext(RetstatContext ctx) { copyFrom(ctx); }
	}

	public final RetstatContext retstat() throws RecognitionException {
		RetstatContext _localctx = new RetstatContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_retstat);
		int _la;
		try {
			_localctx = new ReturnStatContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			match(T__35);
			setState(383);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (T__16 - 17)) | (1L << (T__22 - 17)) | (1L << (T__27 - 17)) | (1L << (T__29 - 17)) | (1L << (T__31 - 17)) | (1L << (T__38 - 17)) | (1L << (T__39 - 17)) | (1L << (T__52 - 17)) | (1L << (T__58 - 17)) | (1L << (T__61 - 17)) | (1L << (T__62 - 17)) | (1L << (NAME - 17)) | (1L << (NORMALSTRING - 17)) | (1L << (CHARSTRING - 17)) | (1L << (LONGSTRING - 17)) | (1L << (INT - 17)) | (1L << (HEX - 17)) | (1L << (FLOAT - 17)) | (1L << (HEX_FLOAT - 17)))) != 0)) {
				{
				setState(382);
				explist();
				}
			}

			setState(386);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(385);
				match(T__0);
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

	public static class LabelContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(TealParser.NAME, 0); }
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388);
			match(T__36);
			setState(389);
			match(NAME);
			setState(390);
			match(T__36);
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

	public static class FuncnameContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(TealParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(TealParser.NAME, i);
		}
		public FuncnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcname; }
	}

	public final FuncnameContext funcname() throws RecognitionException {
		FuncnameContext _localctx = new FuncnameContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_funcname);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			match(NAME);
			setState(397);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__37) {
				{
				{
				setState(393);
				match(T__37);
				setState(394);
				match(NAME);
				}
				}
				setState(399);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(402);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__18) {
				{
				setState(400);
				match(T__18);
				setState(401);
				match(NAME);
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

	public static class VarlistContext extends ParserRuleContext {
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public VarlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varlist; }
	}

	public final VarlistContext varlist() throws RecognitionException {
		VarlistContext _localctx = new VarlistContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_varlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			variable();
			setState(409);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(405);
				match(T__14);
				setState(406);
				variable();
				}
				}
				setState(411);
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

	public static class NamelistContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(TealParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(TealParser.NAME, i);
		}
		public NamelistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namelist; }
	}

	public final NamelistContext namelist() throws RecognitionException {
		NamelistContext _localctx = new NamelistContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_namelist);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(412);
			match(NAME);
			setState(417);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(413);
					match(T__14);
					setState(414);
					match(NAME);
					}
					} 
				}
				setState(419);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
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

	public static class ExplistContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public ExplistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explist; }
	}

	public final ExplistContext explist() throws RecognitionException {
		ExplistContext _localctx = new ExplistContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_explist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(420);
			exp(0);
			setState(425);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(421);
				match(T__14);
				setState(422);
				exp(0);
				}
				}
				setState(427);
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

	public static class ExpContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public StrContext str() {
			return getRuleContext(StrContext.class,0);
		}
		public FunctiondefContext functiondef() {
			return getRuleContext(FunctiondefContext.class,0);
		}
		public PrefixexpContext prefixexp() {
			return getRuleContext(PrefixexpContext.class,0);
		}
		public TableconstructorContext tableconstructor() {
			return getRuleContext(TableconstructorContext.class,0);
		}
		public OperatorUnaryContext operatorUnary() {
			return getRuleContext(OperatorUnaryContext.class,0);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode NAME() { return getToken(TealParser.NAME, 0); }
		public TypContext typ() {
			return getRuleContext(TypContext.class,0);
		}
		public OperatorPowerContext operatorPower() {
			return getRuleContext(OperatorPowerContext.class,0);
		}
		public OperatorMulDivModContext operatorMulDivMod() {
			return getRuleContext(OperatorMulDivModContext.class,0);
		}
		public OperatorAddSubContext operatorAddSub() {
			return getRuleContext(OperatorAddSubContext.class,0);
		}
		public OperatorStrcatContext operatorStrcat() {
			return getRuleContext(OperatorStrcatContext.class,0);
		}
		public OperatorComparisonContext operatorComparison() {
			return getRuleContext(OperatorComparisonContext.class,0);
		}
		public OperatorAndContext operatorAnd() {
			return getRuleContext(OperatorAndContext.class,0);
		}
		public OperatorOrContext operatorOr() {
			return getRuleContext(OperatorOrContext.class,0);
		}
		public OperatorBitwiseContext operatorBitwise() {
			return getRuleContext(OperatorBitwiseContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_exp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				setState(429);
				match(T__27);
				}
				break;
			case 2:
				{
				setState(430);
				match(T__38);
				}
				break;
			case 3:
				{
				setState(431);
				match(T__39);
				}
				break;
			case 4:
				{
				setState(432);
				number();
				}
				break;
			case 5:
				{
				setState(433);
				str();
				}
				break;
			case 6:
				{
				setState(434);
				match(T__31);
				}
				break;
			case 7:
				{
				setState(435);
				functiondef();
				}
				break;
			case 8:
				{
				setState(436);
				prefixexp();
				}
				break;
			case 9:
				{
				setState(437);
				tableconstructor();
				}
				break;
			case 10:
				{
				setState(438);
				operatorUnary();
				setState(439);
				exp(9);
				}
				break;
			case 11:
				{
				setState(441);
				match(NAME);
				setState(442);
				match(T__41);
				setState(443);
				typ();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(483);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(481);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
					case 1:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(446);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(447);
						operatorPower();
						setState(448);
						exp(10);
						}
						break;
					case 2:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(450);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(451);
						operatorMulDivMod();
						setState(452);
						exp(9);
						}
						break;
					case 3:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(454);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(455);
						operatorAddSub();
						setState(456);
						exp(8);
						}
						break;
					case 4:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(458);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(459);
						operatorStrcat();
						setState(460);
						exp(6);
						}
						break;
					case 5:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(462);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(463);
						operatorComparison();
						setState(464);
						exp(6);
						}
						break;
					case 6:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(466);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(467);
						operatorAnd();
						setState(468);
						exp(4);
						}
						break;
					case 7:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(470);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(471);
						operatorOr();
						setState(472);
						exp(3);
						}
						break;
					case 8:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(474);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(475);
						operatorBitwise();
						setState(476);
						exp(2);
						}
						break;
					case 9:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(478);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(479);
						match(T__40);
						setState(480);
						typ();
						}
						break;
					}
					} 
				}
				setState(485);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrefixexpContext extends ParserRuleContext {
		public VarOrExpContext varOrExp() {
			return getRuleContext(VarOrExpContext.class,0);
		}
		public List<NameAndArgsContext> nameAndArgs() {
			return getRuleContexts(NameAndArgsContext.class);
		}
		public NameAndArgsContext nameAndArgs(int i) {
			return getRuleContext(NameAndArgsContext.class,i);
		}
		public PrefixexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixexp; }
	}

	public final PrefixexpContext prefixexp() throws RecognitionException {
		PrefixexpContext _localctx = new PrefixexpContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_prefixexp);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(486);
			varOrExp();
			setState(490);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(487);
					nameAndArgs();
					}
					} 
				}
				setState(492);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
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

	public static class FunctioncallContext extends ParserRuleContext {
		public VarOrExpContext varOrExp() {
			return getRuleContext(VarOrExpContext.class,0);
		}
		public List<NameAndArgsContext> nameAndArgs() {
			return getRuleContexts(NameAndArgsContext.class);
		}
		public NameAndArgsContext nameAndArgs(int i) {
			return getRuleContext(NameAndArgsContext.class,i);
		}
		public FunctioncallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functioncall; }
	}

	public final FunctioncallContext functioncall() throws RecognitionException {
		FunctioncallContext _localctx = new FunctioncallContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_functioncall);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(493);
			varOrExp();
			setState(495); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(494);
					nameAndArgs();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(497); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
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

	public static class VarOrExpContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public VarOrExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varOrExp; }
	}

	public final VarOrExpContext varOrExp() throws RecognitionException {
		VarOrExpContext _localctx = new VarOrExpContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_varOrExp);
		try {
			setState(504);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(499);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(500);
				match(T__22);
				setState(501);
				exp(0);
				setState(502);
				match(T__23);
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

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(TealParser.NAME, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<VarSuffixContext> varSuffix() {
			return getRuleContexts(VarSuffixContext.class);
		}
		public VarSuffixContext varSuffix(int i) {
			return getRuleContext(VarSuffixContext.class,i);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_variable);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(512);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				{
				setState(506);
				match(NAME);
				}
				break;
			case T__22:
				{
				setState(507);
				match(T__22);
				setState(508);
				exp(0);
				setState(509);
				match(T__23);
				setState(510);
				varSuffix();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(517);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(514);
					varSuffix();
					}
					} 
				}
				setState(519);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
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

	public static class VarSuffixContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode NAME() { return getToken(TealParser.NAME, 0); }
		public List<NameAndArgsContext> nameAndArgs() {
			return getRuleContexts(NameAndArgsContext.class);
		}
		public NameAndArgsContext nameAndArgs(int i) {
			return getRuleContext(NameAndArgsContext.class,i);
		}
		public VarSuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varSuffix; }
	}

	public final VarSuffixContext varSuffix() throws RecognitionException {
		VarSuffixContext _localctx = new VarSuffixContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_varSuffix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(523);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 19)) & ~0x3f) == 0 && ((1L << (_la - 19)) & ((1L << (T__18 - 19)) | (1L << (T__22 - 19)) | (1L << (T__29 - 19)) | (1L << (NORMALSTRING - 19)) | (1L << (CHARSTRING - 19)) | (1L << (LONGSTRING - 19)))) != 0)) {
				{
				{
				setState(520);
				nameAndArgs();
				}
				}
				setState(525);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(532);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__42:
				{
				setState(526);
				match(T__42);
				setState(527);
				exp(0);
				setState(528);
				match(T__43);
				}
				break;
			case T__37:
				{
				setState(530);
				match(T__37);
				setState(531);
				match(NAME);
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

	public static class NameAndArgsContext extends ParserRuleContext {
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode NAME() { return getToken(TealParser.NAME, 0); }
		public NameAndArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameAndArgs; }
	}

	public final NameAndArgsContext nameAndArgs() throws RecognitionException {
		NameAndArgsContext _localctx = new NameAndArgsContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_nameAndArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(536);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__18) {
				{
				setState(534);
				match(T__18);
				setState(535);
				match(NAME);
				}
			}

			setState(538);
			args();
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

	public static class ArgsContext extends ParserRuleContext {
		public ExplistContext explist() {
			return getRuleContext(ExplistContext.class,0);
		}
		public TableconstructorContext tableconstructor() {
			return getRuleContext(TableconstructorContext.class,0);
		}
		public StrContext str() {
			return getRuleContext(StrContext.class,0);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_args);
		int _la;
		try {
			setState(547);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				setState(540);
				match(T__22);
				setState(542);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (T__16 - 17)) | (1L << (T__22 - 17)) | (1L << (T__27 - 17)) | (1L << (T__29 - 17)) | (1L << (T__31 - 17)) | (1L << (T__38 - 17)) | (1L << (T__39 - 17)) | (1L << (T__52 - 17)) | (1L << (T__58 - 17)) | (1L << (T__61 - 17)) | (1L << (T__62 - 17)) | (1L << (NAME - 17)) | (1L << (NORMALSTRING - 17)) | (1L << (CHARSTRING - 17)) | (1L << (LONGSTRING - 17)) | (1L << (INT - 17)) | (1L << (HEX - 17)) | (1L << (FLOAT - 17)) | (1L << (HEX_FLOAT - 17)))) != 0)) {
					{
					setState(541);
					explist();
					}
				}

				setState(544);
				match(T__23);
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 2);
				{
				setState(545);
				tableconstructor();
				}
				break;
			case NORMALSTRING:
			case CHARSTRING:
			case LONGSTRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(546);
				str();
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

	public static class FunctiondefContext extends ParserRuleContext {
		public FuncbodyContext funcbody() {
			return getRuleContext(FuncbodyContext.class,0);
		}
		public FunctiondefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functiondef; }
	}

	public final FunctiondefContext functiondef() throws RecognitionException {
		FunctiondefContext _localctx = new FunctiondefContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_functiondef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(549);
			match(T__16);
			setState(550);
			funcbody();
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

	public static class FuncbodyContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TypeargsContext typeargs() {
			return getRuleContext(TypeargsContext.class,0);
		}
		public ParlistContext parlist() {
			return getRuleContext(ParlistContext.class,0);
		}
		public RetlistContext retlist() {
			return getRuleContext(RetlistContext.class,0);
		}
		public FuncbodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcbody; }
	}

	public final FuncbodyContext funcbody() throws RecognitionException {
		FuncbodyContext _localctx = new FuncbodyContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_funcbody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(553);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(552);
				typeargs();
				}
			}

			setState(555);
			match(T__22);
			setState(557);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__31 || _la==NAME) {
				{
				setState(556);
				parlist();
				}
			}

			setState(559);
			match(T__23);
			setState(562);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__18) {
				{
				setState(560);
				match(T__18);
				setState(561);
				retlist();
				}
			}

			setState(564);
			block();
			setState(565);
			match(T__5);
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

	public static class ParlistContext extends ParserRuleContext {
		public NamelistContext namelist() {
			return getRuleContext(NamelistContext.class,0);
		}
		public ParnamelistContext parnamelist() {
			return getRuleContext(ParnamelistContext.class,0);
		}
		public TypContext typ() {
			return getRuleContext(TypContext.class,0);
		}
		public ParlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parlist; }
	}

	public final ParlistContext parlist() throws RecognitionException {
		ParlistContext _localctx = new ParlistContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_parlist);
		int _la;
		try {
			setState(587);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(567);
				namelist();
				setState(570);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(568);
					match(T__14);
					setState(569);
					match(T__31);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(572);
				match(T__31);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(573);
				parnamelist();
				setState(580);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(574);
					match(T__14);
					setState(575);
					match(T__31);
					setState(578);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__18) {
						{
						setState(576);
						match(T__18);
						setState(577);
						typ();
						}
					}

					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(582);
				match(T__31);
				setState(585);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__18) {
					{
					setState(583);
					match(T__18);
					setState(584);
					typ();
					}
				}

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

	public static class TableconstructorContext extends ParserRuleContext {
		public FieldlistContext fieldlist() {
			return getRuleContext(FieldlistContext.class,0);
		}
		public TableconstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableconstructor; }
	}

	public final TableconstructorContext tableconstructor() throws RecognitionException {
		TableconstructorContext _localctx = new TableconstructorContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_tableconstructor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(589);
			match(T__29);
			setState(591);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (T__16 - 17)) | (1L << (T__22 - 17)) | (1L << (T__27 - 17)) | (1L << (T__29 - 17)) | (1L << (T__31 - 17)) | (1L << (T__38 - 17)) | (1L << (T__39 - 17)) | (1L << (T__42 - 17)) | (1L << (T__52 - 17)) | (1L << (T__58 - 17)) | (1L << (T__61 - 17)) | (1L << (T__62 - 17)) | (1L << (NAME - 17)) | (1L << (NORMALSTRING - 17)) | (1L << (CHARSTRING - 17)) | (1L << (LONGSTRING - 17)) | (1L << (INT - 17)) | (1L << (HEX - 17)) | (1L << (FLOAT - 17)) | (1L << (HEX_FLOAT - 17)))) != 0)) {
				{
				setState(590);
				fieldlist();
				}
			}

			setState(593);
			match(T__30);
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

	public static class FieldlistContext extends ParserRuleContext {
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public List<FieldsepContext> fieldsep() {
			return getRuleContexts(FieldsepContext.class);
		}
		public FieldsepContext fieldsep(int i) {
			return getRuleContext(FieldsepContext.class,i);
		}
		public FieldlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldlist; }
	}

	public final FieldlistContext fieldlist() throws RecognitionException {
		FieldlistContext _localctx = new FieldlistContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_fieldlist);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(595);
			field();
			setState(601);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(596);
					fieldsep();
					setState(597);
					field();
					}
					} 
				}
				setState(603);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
			}
			setState(605);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0 || _la==T__14) {
				{
				setState(604);
				fieldsep();
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

	public static class FieldContext extends ParserRuleContext {
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
	 
		public FieldContext() { }
		public void copyFrom(FieldContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssignFieldContext extends FieldContext {
		public TerminalNode NAME() { return getToken(TealParser.NAME, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TypContext typ() {
			return getRuleContext(TypContext.class,0);
		}
		public AssignFieldContext(FieldContext ctx) { copyFrom(ctx); }
	}
	public static class AssignNewTypeFieldContext extends FieldContext {
		public TerminalNode NAME() { return getToken(TealParser.NAME, 0); }
		public NewtypeContext newtype() {
			return getRuleContext(NewtypeContext.class,0);
		}
		public AssignNewTypeFieldContext(FieldContext ctx) { copyFrom(ctx); }
	}
	public static class ExprFieldContext extends FieldContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ExprFieldContext(FieldContext ctx) { copyFrom(ctx); }
	}
	public static class BracketAssginFieldContext extends FieldContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public BracketAssginFieldContext(FieldContext ctx) { copyFrom(ctx); }
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_field);
		int _la;
		try {
			setState(624);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				_localctx = new BracketAssginFieldContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(607);
				match(T__42);
				setState(608);
				exp(0);
				setState(609);
				match(T__43);
				setState(610);
				match(T__1);
				setState(611);
				exp(0);
				}
				break;
			case 2:
				_localctx = new AssignFieldContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(613);
				match(NAME);
				setState(616);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__18) {
					{
					setState(614);
					match(T__18);
					setState(615);
					typ();
					}
				}

				setState(618);
				match(T__1);
				setState(619);
				exp(0);
				}
				break;
			case 3:
				_localctx = new AssignNewTypeFieldContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(620);
				match(NAME);
				setState(621);
				match(T__1);
				setState(622);
				newtype();
				}
				break;
			case 4:
				_localctx = new ExprFieldContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(623);
				exp(0);
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

	public static class FieldsepContext extends ParserRuleContext {
		public FieldsepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldsep; }
	}

	public final FieldsepContext fieldsep() throws RecognitionException {
		FieldsepContext _localctx = new FieldsepContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_fieldsep);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(626);
			_la = _input.LA(1);
			if ( !(_la==T__0 || _la==T__14) ) {
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

	public static class OperatorOrContext extends ParserRuleContext {
		public OperatorOrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorOr; }
	}

	public final OperatorOrContext operatorOr() throws RecognitionException {
		OperatorOrContext _localctx = new OperatorOrContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_operatorOr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(628);
			match(T__44);
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

	public static class OperatorAndContext extends ParserRuleContext {
		public OperatorAndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorAnd; }
	}

	public final OperatorAndContext operatorAnd() throws RecognitionException {
		OperatorAndContext _localctx = new OperatorAndContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_operatorAnd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(630);
			match(T__45);
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

	public static class OperatorComparisonContext extends ParserRuleContext {
		public OperatorComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorComparison; }
	}

	public final OperatorComparisonContext operatorComparison() throws RecognitionException {
		OperatorComparisonContext _localctx = new OperatorComparisonContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_operatorComparison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(632);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49))) != 0)) ) {
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

	public static class OperatorStrcatContext extends ParserRuleContext {
		public OperatorStrcatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorStrcat; }
	}

	public final OperatorStrcatContext operatorStrcat() throws RecognitionException {
		OperatorStrcatContext _localctx = new OperatorStrcatContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_operatorStrcat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(634);
			match(T__50);
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

	public static class OperatorAddSubContext extends ParserRuleContext {
		public OperatorAddSubContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorAddSub; }
	}

	public final OperatorAddSubContext operatorAddSub() throws RecognitionException {
		OperatorAddSubContext _localctx = new OperatorAddSubContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_operatorAddSub);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(636);
			_la = _input.LA(1);
			if ( !(_la==T__51 || _la==T__52) ) {
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

	public static class OperatorMulDivModContext extends ParserRuleContext {
		public OperatorMulDivModContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorMulDivMod; }
	}

	public final OperatorMulDivModContext operatorMulDivMod() throws RecognitionException {
		OperatorMulDivModContext _localctx = new OperatorMulDivModContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_operatorMulDivMod);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(638);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56))) != 0)) ) {
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

	public static class OperatorBitwiseContext extends ParserRuleContext {
		public OperatorBitwiseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorBitwise; }
	}

	public final OperatorBitwiseContext operatorBitwise() throws RecognitionException {
		OperatorBitwiseContext _localctx = new OperatorBitwiseContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_operatorBitwise);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(640);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0)) ) {
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

	public static class OperatorUnaryContext extends ParserRuleContext {
		public OperatorUnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorUnary; }
	}

	public final OperatorUnaryContext operatorUnary() throws RecognitionException {
		OperatorUnaryContext _localctx = new OperatorUnaryContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_operatorUnary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(642);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__52) | (1L << T__58) | (1L << T__61) | (1L << T__62))) != 0)) ) {
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

	public static class OperatorPowerContext extends ParserRuleContext {
		public OperatorPowerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorPower; }
	}

	public final OperatorPowerContext operatorPower() throws RecognitionException {
		OperatorPowerContext _localctx = new OperatorPowerContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_operatorPower);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(644);
			match(T__63);
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

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(TealParser.INT, 0); }
		public TerminalNode HEX() { return getToken(TealParser.HEX, 0); }
		public TerminalNode FLOAT() { return getToken(TealParser.FLOAT, 0); }
		public TerminalNode HEX_FLOAT() { return getToken(TealParser.HEX_FLOAT, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(646);
			_la = _input.LA(1);
			if ( !(((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (INT - 69)) | (1L << (HEX - 69)) | (1L << (FLOAT - 69)) | (1L << (HEX_FLOAT - 69)))) != 0)) ) {
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

	public static class StrContext extends ParserRuleContext {
		public TerminalNode NORMALSTRING() { return getToken(TealParser.NORMALSTRING, 0); }
		public TerminalNode CHARSTRING() { return getToken(TealParser.CHARSTRING, 0); }
		public TerminalNode LONGSTRING() { return getToken(TealParser.LONGSTRING, 0); }
		public StrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_str; }
	}

	public final StrContext str() throws RecognitionException {
		StrContext _localctx = new StrContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_str);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(648);
			_la = _input.LA(1);
			if ( !(((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (NORMALSTRING - 66)) | (1L << (CHARSTRING - 66)) | (1L << (LONGSTRING - 66)))) != 0)) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 22:
			return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		case 7:
			return precpred(_ctx, 1);
		case 8:
			return precpred(_ctx, 11);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3N\u028d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\3\2\3\2\3\3\7\3g\n\3\f"+
		"\3\16\3j\13\3\3\3\5\3m\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\7\4\u0091\n\4\f\4\16\4\u0094\13\4\3\4\3\4\5\4\u0098"+
		"\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u00a4\n\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\5\4\u00be\n\4\3\4\3\4\5\4\u00c2\n\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u00d5\n\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\5\4\u00de\n\4\3\5\3\5\5\5\u00e2\n\5\3\5\3\5\3\5\5"+
		"\5\u00e7\n\5\7\5\u00e9\n\5\f\5\16\5\u00ec\13\5\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\7\7\u00f9\n\7\f\7\16\7\u00fc\13\7\5\7\u00fe\n\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\5\b\u0112\n\b\5\b\u0114\n\b\3\t\3\t\3\t\5\t\u0119\n\t\3\n\3\n\5\n\u011d"+
		"\n\n\3\n\5\n\u0120\n\n\3\n\3\n\3\n\5\n\u0125\n\n\5\n\u0127\n\n\3\13\3"+
		"\13\3\13\3\13\7\13\u012d\n\13\f\13\16\13\u0130\13\13\3\13\3\13\3\f\3\f"+
		"\5\f\u0136\n\f\3\f\3\f\3\f\3\f\5\f\u013c\n\f\3\f\3\f\3\f\7\f\u0141\n\f"+
		"\f\f\16\f\u0144\13\f\3\f\3\f\3\f\7\f\u0149\n\f\f\f\16\f\u014c\13\f\3\f"+
		"\3\f\3\f\7\f\u0151\n\f\f\f\16\f\u0154\13\f\3\f\3\f\3\f\5\f\u0159\n\f\3"+
		"\r\5\r\u015c\n\r\3\r\3\r\3\r\3\r\3\r\5\r\u0163\n\r\3\16\3\16\3\16\7\16"+
		"\u0168\n\16\f\16\16\16\u016b\13\16\3\17\3\17\5\17\u016f\n\17\3\17\3\17"+
		"\3\20\3\20\3\20\7\20\u0176\n\20\f\20\16\20\u0179\13\20\3\21\3\21\3\21"+
		"\5\21\u017e\n\21\3\22\3\22\5\22\u0182\n\22\3\22\5\22\u0185\n\22\3\23\3"+
		"\23\3\23\3\23\3\24\3\24\3\24\7\24\u018e\n\24\f\24\16\24\u0191\13\24\3"+
		"\24\3\24\5\24\u0195\n\24\3\25\3\25\3\25\7\25\u019a\n\25\f\25\16\25\u019d"+
		"\13\25\3\26\3\26\3\26\7\26\u01a2\n\26\f\26\16\26\u01a5\13\26\3\27\3\27"+
		"\3\27\7\27\u01aa\n\27\f\27\16\27\u01ad\13\27\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u01bf\n\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u01e4\n\30\f\30\16\30\u01e7\13"+
		"\30\3\31\3\31\7\31\u01eb\n\31\f\31\16\31\u01ee\13\31\3\32\3\32\6\32\u01f2"+
		"\n\32\r\32\16\32\u01f3\3\33\3\33\3\33\3\33\3\33\5\33\u01fb\n\33\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\5\34\u0203\n\34\3\34\7\34\u0206\n\34\f\34\16\34"+
		"\u0209\13\34\3\35\7\35\u020c\n\35\f\35\16\35\u020f\13\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\5\35\u0217\n\35\3\36\3\36\5\36\u021b\n\36\3\36\3\36\3"+
		"\37\3\37\5\37\u0221\n\37\3\37\3\37\3\37\5\37\u0226\n\37\3 \3 \3 \3!\5"+
		"!\u022c\n!\3!\3!\5!\u0230\n!\3!\3!\3!\5!\u0235\n!\3!\3!\3!\3\"\3\"\3\""+
		"\5\"\u023d\n\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0245\n\"\5\"\u0247\n\"\3\""+
		"\3\"\3\"\5\"\u024c\n\"\5\"\u024e\n\"\3#\3#\5#\u0252\n#\3#\3#\3$\3$\3$"+
		"\3$\7$\u025a\n$\f$\16$\u025d\13$\3$\5$\u0260\n$\3%\3%\3%\3%\3%\3%\3%\3"+
		"%\3%\5%\u026b\n%\3%\3%\3%\3%\3%\3%\5%\u0273\n%\3&\3&\3\'\3\'\3(\3(\3)"+
		"\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\61\2\3."+
		"\62\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@B"+
		"DFHJLNPRTVXZ\\^`\2\n\4\2\3\3\21\21\4\2\27\30\61\64\3\2\66\67\3\28;\4\2"+
		"\33\33<?\5\2\67\67==@A\3\2GJ\3\2DF\2\u02cd\2b\3\2\2\2\4h\3\2\2\2\6\u00dd"+
		"\3\2\2\2\b\u00df\3\2\2\2\n\u00ed\3\2\2\2\f\u00fd\3\2\2\2\16\u0113\3\2"+
		"\2\2\20\u0115\3\2\2\2\22\u0126\3\2\2\2\24\u0128\3\2\2\2\26\u0158\3\2\2"+
		"\2\30\u015b\3\2\2\2\32\u0164\3\2\2\2\34\u016e\3\2\2\2\36\u0172\3\2\2\2"+
		" \u017a\3\2\2\2\"\u017f\3\2\2\2$\u0186\3\2\2\2&\u018a\3\2\2\2(\u0196\3"+
		"\2\2\2*\u019e\3\2\2\2,\u01a6\3\2\2\2.\u01be\3\2\2\2\60\u01e8\3\2\2\2\62"+
		"\u01ef\3\2\2\2\64\u01fa\3\2\2\2\66\u0202\3\2\2\28\u020d\3\2\2\2:\u021a"+
		"\3\2\2\2<\u0225\3\2\2\2>\u0227\3\2\2\2@\u022b\3\2\2\2B\u024d\3\2\2\2D"+
		"\u024f\3\2\2\2F\u0255\3\2\2\2H\u0272\3\2\2\2J\u0274\3\2\2\2L\u0276\3\2"+
		"\2\2N\u0278\3\2\2\2P\u027a\3\2\2\2R\u027c\3\2\2\2T\u027e\3\2\2\2V\u0280"+
		"\3\2\2\2X\u0282\3\2\2\2Z\u0284\3\2\2\2\\\u0286\3\2\2\2^\u0288\3\2\2\2"+
		"`\u028a\3\2\2\2bc\5\4\3\2cd\7\2\2\3d\3\3\2\2\2eg\5\6\4\2fe\3\2\2\2gj\3"+
		"\2\2\2hf\3\2\2\2hi\3\2\2\2il\3\2\2\2jh\3\2\2\2km\5\"\22\2lk\3\2\2\2lm"+
		"\3\2\2\2m\5\3\2\2\2n\u00de\7\3\2\2op\5(\25\2pq\7\4\2\2qr\5,\27\2r\u00de"+
		"\3\2\2\2s\u00de\5\62\32\2t\u00de\5$\23\2u\u00de\7\5\2\2vw\7\6\2\2w\u00de"+
		"\7C\2\2xy\7\7\2\2yz\5\4\3\2z{\7\b\2\2{\u00de\3\2\2\2|}\7\t\2\2}~\5.\30"+
		"\2~\177\7\7\2\2\177\u0080\5\4\3\2\u0080\u0081\7\b\2\2\u0081\u00de\3\2"+
		"\2\2\u0082\u0083\7\n\2\2\u0083\u0084\5\4\3\2\u0084\u0085\7\13\2\2\u0085"+
		"\u0086\5.\30\2\u0086\u00de\3\2\2\2\u0087\u0088\7\f\2\2\u0088\u0089\5."+
		"\30\2\u0089\u008a\7\r\2\2\u008a\u0092\5\4\3\2\u008b\u008c\7\16\2\2\u008c"+
		"\u008d\5.\30\2\u008d\u008e\7\r\2\2\u008e\u008f\5\4\3\2\u008f\u0091\3\2"+
		"\2\2\u0090\u008b\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092"+
		"\u0093\3\2\2\2\u0093\u0097\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0096\7\17"+
		"\2\2\u0096\u0098\5\4\3\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0099\u009a\7\b\2\2\u009a\u00de\3\2\2\2\u009b\u009c\7\20"+
		"\2\2\u009c\u009d\7C\2\2\u009d\u009e\7\4\2\2\u009e\u009f\5.\30\2\u009f"+
		"\u00a0\7\21\2\2\u00a0\u00a3\5.\30\2\u00a1\u00a2\7\21\2\2\u00a2\u00a4\5"+
		".\30\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5"+
		"\u00a6\7\7\2\2\u00a6\u00a7\5\4\3\2\u00a7\u00a8\7\b\2\2\u00a8\u00de\3\2"+
		"\2\2\u00a9\u00aa\7\20\2\2\u00aa\u00ab\5*\26\2\u00ab\u00ac\7\22\2\2\u00ac"+
		"\u00ad\5,\27\2\u00ad\u00ae\7\7\2\2\u00ae\u00af\5\4\3\2\u00af\u00b0\7\b"+
		"\2\2\u00b0\u00de\3\2\2\2\u00b1\u00b2\7\23\2\2\u00b2\u00b3\5&\24\2\u00b3"+
		"\u00b4\5@!\2\u00b4\u00de\3\2\2\2\u00b5\u00b6\7\24\2\2\u00b6\u00b7\7\23"+
		"\2\2\u00b7\u00b8\7C\2\2\u00b8\u00de\5@!\2\u00b9\u00ba\7\24\2\2\u00ba\u00bd"+
		"\5\b\5\2\u00bb\u00bc\7\25\2\2\u00bc\u00be\5\20\t\2\u00bd\u00bb\3\2\2\2"+
		"\u00bd\u00be\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00c0\7\4\2\2\u00c0\u00c2"+
		"\5,\27\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00de\3\2\2\2\u00c3"+
		"\u00c4\7\24\2\2\u00c4\u00c5\7C\2\2\u00c5\u00c6\7\4\2\2\u00c6\u00de\5\26"+
		"\f\2\u00c7\u00c8\7\26\2\2\u00c8\u00c9\7\23\2\2\u00c9\u00ca\7C\2\2\u00ca"+
		"\u00de\5@!\2\u00cb\u00cc\7\26\2\2\u00cc\u00cd\5\b\5\2\u00cd\u00ce\7\25"+
		"\2\2\u00ce\u00cf\5\20\t\2\u00cf\u00de\3\2\2\2\u00d0\u00d1\7\26\2\2\u00d1"+
		"\u00d4\5\b\5\2\u00d2\u00d3\7\25\2\2\u00d3\u00d5\5\20\t\2\u00d4\u00d2\3"+
		"\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d7\7\4\2\2\u00d7"+
		"\u00d8\5,\27\2\u00d8\u00de\3\2\2\2\u00d9\u00da\7\26\2\2\u00da\u00db\7"+
		"C\2\2\u00db\u00dc\7\4\2\2\u00dc\u00de\5\26\f\2\u00ddn\3\2\2\2\u00ddo\3"+
		"\2\2\2\u00dds\3\2\2\2\u00ddt\3\2\2\2\u00ddu\3\2\2\2\u00ddv\3\2\2\2\u00dd"+
		"x\3\2\2\2\u00dd|\3\2\2\2\u00dd\u0082\3\2\2\2\u00dd\u0087\3\2\2\2\u00dd"+
		"\u009b\3\2\2\2\u00dd\u00a9\3\2\2\2\u00dd\u00b1\3\2\2\2\u00dd\u00b5\3\2"+
		"\2\2\u00dd\u00b9\3\2\2\2\u00dd\u00c3\3\2\2\2\u00dd\u00c7\3\2\2\2\u00dd"+
		"\u00cb\3\2\2\2\u00dd\u00d0\3\2\2\2\u00dd\u00d9\3\2\2\2\u00de\7\3\2\2\2"+
		"\u00df\u00e1\7C\2\2\u00e0\u00e2\5\n\6\2\u00e1\u00e0\3\2\2\2\u00e1\u00e2"+
		"\3\2\2\2\u00e2\u00ea\3\2\2\2\u00e3\u00e4\7\21\2\2\u00e4\u00e6\7C\2\2\u00e5"+
		"\u00e7\5\n\6\2\u00e6\u00e5\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e9\3\2"+
		"\2\2\u00e8\u00e3\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea"+
		"\u00eb\3\2\2\2\u00eb\t\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed\u00ee\7\27\2"+
		"\2\u00ee\u00ef\7C\2\2\u00ef\u00f0\7\30\2\2\u00f0\13\3\2\2\2\u00f1\u00f2"+
		"\7\31\2\2\u00f2\u00f3\5\f\7\2\u00f3\u00f4\7\32\2\2\u00f4\u00fe\3\2\2\2"+
		"\u00f5\u00fa\5\16\b\2\u00f6\u00f7\7\33\2\2\u00f7\u00f9\5\16\b\2\u00f8"+
		"\u00f6\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2"+
		"\2\2\u00fb\u00fe\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd\u00f1\3\2\2\2\u00fd"+
		"\u00f5\3\2\2\2\u00fe\r\3\2\2\2\u00ff\u0114\7\34\2\2\u0100\u0114\7\35\2"+
		"\2\u0101\u0114\7\36\2\2\u0102\u0114\7\37\2\2\u0103\u0104\7 \2\2\u0104"+
		"\u0105\5\f\7\2\u0105\u0106\7!\2\2\u0106\u0114\3\2\2\2\u0107\u0108\7 \2"+
		"\2\u0108\u0109\5\f\7\2\u0109\u010a\7\25\2\2\u010a\u010b\5\f\7\2\u010b"+
		"\u010c\7!\2\2\u010c\u0114\3\2\2\2\u010d\u010e\7\23\2\2\u010e\u0114\5\30"+
		"\r\2\u010f\u0111\7C\2\2\u0110\u0112\5\24\13\2\u0111\u0110\3\2\2\2\u0111"+
		"\u0112\3\2\2\2\u0112\u0114\3\2\2\2\u0113\u00ff\3\2\2\2\u0113\u0100\3\2"+
		"\2\2\u0113\u0101\3\2\2\2\u0113\u0102\3\2\2\2\u0113\u0103\3\2\2\2\u0113"+
		"\u0107\3\2\2\2\u0113\u010d\3\2\2\2\u0113\u010f\3\2\2\2\u0114\17\3\2\2"+
		"\2\u0115\u0118\5\f\7\2\u0116\u0117\7\21\2\2\u0117\u0119\5\f\7\2\u0118"+
		"\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\21\3\2\2\2\u011a\u011c\7\31\2"+
		"\2\u011b\u011d\5\20\t\2\u011c\u011b\3\2\2\2\u011c\u011d\3\2\2\2\u011d"+
		"\u011f\3\2\2\2\u011e\u0120\7\"\2\2\u011f\u011e\3\2\2\2\u011f\u0120\3\2"+
		"\2\2\u0120\u0121\3\2\2\2\u0121\u0127\7\32\2\2\u0122\u0124\5\20\t\2\u0123"+
		"\u0125\7\"\2\2\u0124\u0123\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0127\3\2"+
		"\2\2\u0126\u011a\3\2\2\2\u0126\u0122\3\2\2\2\u0127\23\3\2\2\2\u0128\u0129"+
		"\7\27\2\2\u0129\u012e\7C\2\2\u012a\u012b\7\21\2\2\u012b\u012d\7C\2\2\u012c"+
		"\u012a\3\2\2\2\u012d\u0130\3\2\2\2\u012e\u012c\3\2\2\2\u012e\u012f\3\2"+
		"\2\2\u012f\u0131\3\2\2\2\u0130\u012e\3\2\2\2\u0131\u0132\7\30\2\2\u0132"+
		"\25\3\2\2\2\u0133\u0135\7#\2\2\u0134\u0136\5\24\13\2\u0135\u0134\3\2\2"+
		"\2\u0135\u0136\3\2\2\2\u0136\u013b\3\2\2\2\u0137\u0138\7 \2\2\u0138\u0139"+
		"\5\f\7\2\u0139\u013a\7!\2\2\u013a\u013c\3\2\2\2\u013b\u0137\3\2\2\2\u013b"+
		"\u013c\3\2\2\2\u013c\u0142\3\2\2\2\u013d\u013e\7C\2\2\u013e\u013f\7\4"+
		"\2\2\u013f\u0141\5\26\f\2\u0140\u013d\3\2\2\2\u0141\u0144\3\2\2\2\u0142"+
		"\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u014a\3\2\2\2\u0144\u0142\3\2"+
		"\2\2\u0145\u0146\7C\2\2\u0146\u0147\7\25\2\2\u0147\u0149\5\f\7\2\u0148"+
		"\u0145\3\2\2\2\u0149\u014c\3\2\2\2\u014a\u0148\3\2\2\2\u014a\u014b\3\2"+
		"\2\2\u014b\u014d\3\2\2\2\u014c\u014a\3\2\2\2\u014d\u0159\7\b\2\2\u014e"+
		"\u0152\7$\2\2\u014f\u0151\5`\61\2\u0150\u014f\3\2\2\2\u0151\u0154\3\2"+
		"\2\2\u0152\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0155\3\2\2\2\u0154"+
		"\u0152\3\2\2\2\u0155\u0159\7\b\2\2\u0156\u0157\7%\2\2\u0157\u0159\5\30"+
		"\r\2\u0158\u0133\3\2\2\2\u0158\u014e\3\2\2\2\u0158\u0156\3\2\2\2\u0159"+
		"\27\3\2\2\2\u015a\u015c\5\24\13\2\u015b\u015a\3\2\2\2\u015b\u015c\3\2"+
		"\2\2\u015c\u015d\3\2\2\2\u015d\u015e\7\31\2\2\u015e\u015f\5\32\16\2\u015f"+
		"\u0162\7\32\2\2\u0160\u0161\7\25\2\2\u0161\u0163\5\22\n\2\u0162\u0160"+
		"\3\2\2\2\u0162\u0163\3\2\2\2\u0163\31\3\2\2\2\u0164\u0169\5\34\17\2\u0165"+
		"\u0166\7\21\2\2\u0166\u0168\5\34\17\2\u0167\u0165\3\2\2\2\u0168\u016b"+
		"\3\2\2\2\u0169\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a\33\3\2\2\2\u016b"+
		"\u0169\3\2\2\2\u016c\u016d\7C\2\2\u016d\u016f\7\25\2\2\u016e\u016c\3\2"+
		"\2\2\u016e\u016f\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0171\5\f\7\2\u0171"+
		"\35\3\2\2\2\u0172\u0177\5 \21\2\u0173\u0174\7\21\2\2\u0174\u0176\5 \21"+
		"\2\u0175\u0173\3\2\2\2\u0176\u0179\3\2\2\2\u0177\u0175\3\2\2\2\u0177\u0178"+
		"\3\2\2\2\u0178\37\3\2\2\2\u0179\u0177\3\2\2\2\u017a\u017d\7C\2\2\u017b"+
		"\u017c\7\25\2\2\u017c\u017e\5\f\7\2\u017d\u017b\3\2\2\2\u017d\u017e\3"+
		"\2\2\2\u017e!\3\2\2\2\u017f\u0181\7&\2\2\u0180\u0182\5,\27\2\u0181\u0180"+
		"\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0184\3\2\2\2\u0183\u0185\7\3\2\2\u0184"+
		"\u0183\3\2\2\2\u0184\u0185\3\2\2\2\u0185#\3\2\2\2\u0186\u0187\7\'\2\2"+
		"\u0187\u0188\7C\2\2\u0188\u0189\7\'\2\2\u0189%\3\2\2\2\u018a\u018f\7C"+
		"\2\2\u018b\u018c\7(\2\2\u018c\u018e\7C\2\2\u018d\u018b\3\2\2\2\u018e\u0191"+
		"\3\2\2\2\u018f\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0194\3\2\2\2\u0191"+
		"\u018f\3\2\2\2\u0192\u0193\7\25\2\2\u0193\u0195\7C\2\2\u0194\u0192\3\2"+
		"\2\2\u0194\u0195\3\2\2\2\u0195\'\3\2\2\2\u0196\u019b\5\66\34\2\u0197\u0198"+
		"\7\21\2\2\u0198\u019a\5\66\34\2\u0199\u0197\3\2\2\2\u019a\u019d\3\2\2"+
		"\2\u019b\u0199\3\2\2\2\u019b\u019c\3\2\2\2\u019c)\3\2\2\2\u019d\u019b"+
		"\3\2\2\2\u019e\u01a3\7C\2\2\u019f\u01a0\7\21\2\2\u01a0\u01a2\7C\2\2\u01a1"+
		"\u019f\3\2\2\2\u01a2\u01a5\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a3\u01a4\3\2"+
		"\2\2\u01a4+\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a6\u01ab\5.\30\2\u01a7\u01a8"+
		"\7\21\2\2\u01a8\u01aa\5.\30\2\u01a9\u01a7\3\2\2\2\u01aa\u01ad\3\2\2\2"+
		"\u01ab\u01a9\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac-\3\2\2\2\u01ad\u01ab\3"+
		"\2\2\2\u01ae\u01af\b\30\1\2\u01af\u01bf\7\36\2\2\u01b0\u01bf\7)\2\2\u01b1"+
		"\u01bf\7*\2\2\u01b2\u01bf\5^\60\2\u01b3\u01bf\5`\61\2\u01b4\u01bf\7\""+
		"\2\2\u01b5\u01bf\5> \2\u01b6\u01bf\5\60\31\2\u01b7\u01bf\5D#\2\u01b8\u01b9"+
		"\5Z.\2\u01b9\u01ba\5.\30\13\u01ba\u01bf\3\2\2\2\u01bb\u01bc\7C\2\2\u01bc"+
		"\u01bd\7,\2\2\u01bd\u01bf\5\f\7\2\u01be\u01ae\3\2\2\2\u01be\u01b0\3\2"+
		"\2\2\u01be\u01b1\3\2\2\2\u01be\u01b2\3\2\2\2\u01be\u01b3\3\2\2\2\u01be"+
		"\u01b4\3\2\2\2\u01be\u01b5\3\2\2\2\u01be\u01b6\3\2\2\2\u01be\u01b7\3\2"+
		"\2\2\u01be\u01b8\3\2\2\2\u01be\u01bb\3\2\2\2\u01bf\u01e5\3\2\2\2\u01c0"+
		"\u01c1\f\f\2\2\u01c1\u01c2\5\\/\2\u01c2\u01c3\5.\30\f\u01c3\u01e4\3\2"+
		"\2\2\u01c4\u01c5\f\n\2\2\u01c5\u01c6\5V,\2\u01c6\u01c7\5.\30\13\u01c7"+
		"\u01e4\3\2\2\2\u01c8\u01c9\f\t\2\2\u01c9\u01ca\5T+\2\u01ca\u01cb\5.\30"+
		"\n\u01cb\u01e4\3\2\2\2\u01cc\u01cd\f\b\2\2\u01cd\u01ce\5R*\2\u01ce\u01cf"+
		"\5.\30\b\u01cf\u01e4\3\2\2\2\u01d0\u01d1\f\7\2\2\u01d1\u01d2\5P)\2\u01d2"+
		"\u01d3\5.\30\b\u01d3\u01e4\3\2\2\2\u01d4\u01d5\f\5\2\2\u01d5\u01d6\5N"+
		"(\2\u01d6\u01d7\5.\30\6\u01d7\u01e4\3\2\2\2\u01d8\u01d9\f\4\2\2\u01d9"+
		"\u01da\5L\'\2\u01da\u01db\5.\30\5\u01db\u01e4\3\2\2\2\u01dc\u01dd\f\3"+
		"\2\2\u01dd\u01de\5X-\2\u01de\u01df\5.\30\4\u01df\u01e4\3\2\2\2\u01e0\u01e1"+
		"\f\r\2\2\u01e1\u01e2\7+\2\2\u01e2\u01e4\5\f\7\2\u01e3\u01c0\3\2\2\2\u01e3"+
		"\u01c4\3\2\2\2\u01e3\u01c8\3\2\2\2\u01e3\u01cc\3\2\2\2\u01e3\u01d0\3\2"+
		"\2\2\u01e3\u01d4\3\2\2\2\u01e3\u01d8\3\2\2\2\u01e3\u01dc\3\2\2\2\u01e3"+
		"\u01e0\3\2\2\2\u01e4\u01e7\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e5\u01e6\3\2"+
		"\2\2\u01e6/\3\2\2\2\u01e7\u01e5\3\2\2\2\u01e8\u01ec\5\64\33\2\u01e9\u01eb"+
		"\5:\36\2\u01ea\u01e9\3\2\2\2\u01eb\u01ee\3\2\2\2\u01ec\u01ea\3\2\2\2\u01ec"+
		"\u01ed\3\2\2\2\u01ed\61\3\2\2\2\u01ee\u01ec\3\2\2\2\u01ef\u01f1\5\64\33"+
		"\2\u01f0\u01f2\5:\36\2\u01f1\u01f0\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3\u01f1"+
		"\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4\63\3\2\2\2\u01f5\u01fb\5\66\34\2\u01f6"+
		"\u01f7\7\31\2\2\u01f7\u01f8\5.\30\2\u01f8\u01f9\7\32\2\2\u01f9\u01fb\3"+
		"\2\2\2\u01fa\u01f5\3\2\2\2\u01fa\u01f6\3\2\2\2\u01fb\65\3\2\2\2\u01fc"+
		"\u0203\7C\2\2\u01fd\u01fe\7\31\2\2\u01fe\u01ff\5.\30\2\u01ff\u0200\7\32"+
		"\2\2\u0200\u0201\58\35\2\u0201\u0203\3\2\2\2\u0202\u01fc\3\2\2\2\u0202"+
		"\u01fd\3\2\2\2\u0203\u0207\3\2\2\2\u0204\u0206\58\35\2\u0205\u0204\3\2"+
		"\2\2\u0206\u0209\3\2\2\2\u0207\u0205\3\2\2\2\u0207\u0208\3\2\2\2\u0208"+
		"\67\3\2\2\2\u0209\u0207\3\2\2\2\u020a\u020c\5:\36\2\u020b\u020a\3\2\2"+
		"\2\u020c\u020f\3\2\2\2\u020d\u020b\3\2\2\2\u020d\u020e\3\2\2\2\u020e\u0216"+
		"\3\2\2\2\u020f\u020d\3\2\2\2\u0210\u0211\7-\2\2\u0211\u0212\5.\30\2\u0212"+
		"\u0213\7.\2\2\u0213\u0217\3\2\2\2\u0214\u0215\7(\2\2\u0215\u0217\7C\2"+
		"\2\u0216\u0210\3\2\2\2\u0216\u0214\3\2\2\2\u02179\3\2\2\2\u0218\u0219"+
		"\7\25\2\2\u0219\u021b\7C\2\2\u021a\u0218\3\2\2\2\u021a\u021b\3\2\2\2\u021b"+
		"\u021c\3\2\2\2\u021c\u021d\5<\37\2\u021d;\3\2\2\2\u021e\u0220\7\31\2\2"+
		"\u021f\u0221\5,\27\2\u0220\u021f\3\2\2\2\u0220\u0221\3\2\2\2\u0221\u0222"+
		"\3\2\2\2\u0222\u0226\7\32\2\2\u0223\u0226\5D#\2\u0224\u0226\5`\61\2\u0225"+
		"\u021e\3\2\2\2\u0225\u0223\3\2\2\2\u0225\u0224\3\2\2\2\u0226=\3\2\2\2"+
		"\u0227\u0228\7\23\2\2\u0228\u0229\5@!\2\u0229?\3\2\2\2\u022a\u022c\5\24"+
		"\13\2\u022b\u022a\3\2\2\2\u022b\u022c\3\2\2\2\u022c\u022d\3\2\2\2\u022d"+
		"\u022f\7\31\2\2\u022e\u0230\5B\"\2\u022f\u022e\3\2\2\2\u022f\u0230\3\2"+
		"\2\2\u0230\u0231\3\2\2\2\u0231\u0234\7\32\2\2\u0232\u0233\7\25\2\2\u0233"+
		"\u0235\5\22\n\2\u0234\u0232\3\2\2\2\u0234\u0235\3\2\2\2\u0235\u0236\3"+
		"\2\2\2\u0236\u0237\5\4\3\2\u0237\u0238\7\b\2\2\u0238A\3\2\2\2\u0239\u023c"+
		"\5*\26\2\u023a\u023b\7\21\2\2\u023b\u023d\7\"\2\2\u023c\u023a\3\2\2\2"+
		"\u023c\u023d\3\2\2\2\u023d\u024e\3\2\2\2\u023e\u024e\7\"\2\2\u023f\u0246"+
		"\5\36\20\2\u0240\u0241\7\21\2\2\u0241\u0244\7\"\2\2\u0242\u0243\7\25\2"+
		"\2\u0243\u0245\5\f\7\2\u0244\u0242\3\2\2\2\u0244\u0245\3\2\2\2\u0245\u0247"+
		"\3\2\2\2\u0246\u0240\3\2\2\2\u0246\u0247\3\2\2\2\u0247\u024e\3\2\2\2\u0248"+
		"\u024b\7\"\2\2\u0249\u024a\7\25\2\2\u024a\u024c\5\f\7\2\u024b\u0249\3"+
		"\2\2\2\u024b\u024c\3\2\2\2\u024c\u024e\3\2\2\2\u024d\u0239\3\2\2\2\u024d"+
		"\u023e\3\2\2\2\u024d\u023f\3\2\2\2\u024d\u0248\3\2\2\2\u024eC\3\2\2\2"+
		"\u024f\u0251\7 \2\2\u0250\u0252\5F$\2\u0251\u0250\3\2\2\2\u0251\u0252"+
		"\3\2\2\2\u0252\u0253\3\2\2\2\u0253\u0254\7!\2\2\u0254E\3\2\2\2\u0255\u025b"+
		"\5H%\2\u0256\u0257\5J&\2\u0257\u0258\5H%\2\u0258\u025a\3\2\2\2\u0259\u0256"+
		"\3\2\2\2\u025a\u025d\3\2\2\2\u025b\u0259\3\2\2\2\u025b\u025c\3\2\2\2\u025c"+
		"\u025f\3\2\2\2\u025d\u025b\3\2\2\2\u025e\u0260\5J&\2\u025f\u025e\3\2\2"+
		"\2\u025f\u0260\3\2\2\2\u0260G\3\2\2\2\u0261\u0262\7-\2\2\u0262\u0263\5"+
		".\30\2\u0263\u0264\7.\2\2\u0264\u0265\7\4\2\2\u0265\u0266\5.\30\2\u0266"+
		"\u0273\3\2\2\2\u0267\u026a\7C\2\2\u0268\u0269\7\25\2\2\u0269\u026b\5\f"+
		"\7\2\u026a\u0268\3\2\2\2\u026a\u026b\3\2\2\2\u026b\u026c\3\2\2\2\u026c"+
		"\u026d\7\4\2\2\u026d\u0273\5.\30\2\u026e\u026f\7C\2\2\u026f\u0270\7\4"+
		"\2\2\u0270\u0273\5\26\f\2\u0271\u0273\5.\30\2\u0272\u0261\3\2\2\2\u0272"+
		"\u0267\3\2\2\2\u0272\u026e\3\2\2\2\u0272\u0271\3\2\2\2\u0273I\3\2\2\2"+
		"\u0274\u0275\t\2\2\2\u0275K\3\2\2\2\u0276\u0277\7/\2\2\u0277M\3\2\2\2"+
		"\u0278\u0279\7\60\2\2\u0279O\3\2\2\2\u027a\u027b\t\3\2\2\u027bQ\3\2\2"+
		"\2\u027c\u027d\7\65\2\2\u027dS\3\2\2\2\u027e\u027f\t\4\2\2\u027fU\3\2"+
		"\2\2\u0280\u0281\t\5\2\2\u0281W\3\2\2\2\u0282\u0283\t\6\2\2\u0283Y\3\2"+
		"\2\2\u0284\u0285\t\7\2\2\u0285[\3\2\2\2\u0286\u0287\7B\2\2\u0287]\3\2"+
		"\2\2\u0288\u0289\t\b\2\2\u0289_\3\2\2\2\u028a\u028b\t\t\2\2\u028ba\3\2"+
		"\2\2Ehl\u0092\u0097\u00a3\u00bd\u00c1\u00d4\u00dd\u00e1\u00e6\u00ea\u00fa"+
		"\u00fd\u0111\u0113\u0118\u011c\u011f\u0124\u0126\u012e\u0135\u013b\u0142"+
		"\u014a\u0152\u0158\u015b\u0162\u0169\u016e\u0177\u017d\u0181\u0184\u018f"+
		"\u0194\u019b\u01a3\u01ab\u01be\u01e3\u01e5\u01ec\u01f3\u01fa\u0202\u0207"+
		"\u020d\u0216\u021a\u0220\u0225\u022b\u022f\u0234\u023c\u0244\u0246\u024b"+
		"\u024d\u0251\u025b\u025f\u026a\u0272";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}