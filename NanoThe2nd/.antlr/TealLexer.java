// Generated from c:\Users\fried\OneDrive\Dokumente\Code\Visual Studio Projects\Nano Operational Functional Script\NanoThe2nd\Teal.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TealLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "T__40", 
			"T__41", "T__42", "T__43", "T__44", "T__45", "T__46", "T__47", "T__48", 
			"T__49", "T__50", "T__51", "T__52", "T__53", "T__54", "T__55", "T__56", 
			"T__57", "T__58", "T__59", "T__60", "T__61", "T__62", "T__63", "NAME", 
			"NORMALSTRING", "CHARSTRING", "LONGSTRING", "NESTED_STR", "INT", "HEX", 
			"FLOAT", "HEX_FLOAT", "ExponentPart", "HexExponentPart", "EscapeSequence", 
			"DecimalEscape", "HexEscape", "UtfEscape", "Digit", "HexDigit", "COMMENT", 
			"LINE_COMMENT", "WS", "SHEBANG"
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


	public TealLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Teal.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2N\u02a9\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3 \3 \3!"+
		"\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3"+
		"$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3\'\3\'\3(\3(\3("+
		"\3(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3*\3+\3+\3+\3,\3,\3-\3-\3.\3.\3.\3/\3/"+
		"\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\63\3\64"+
		"\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3:\3;\3;\3"+
		"<\3<\3=\3=\3=\3>\3>\3>\3?\3?\3?\3?\3@\3@\3A\3A\3B\3B\7B\u01a9\nB\fB\16"+
		"B\u01ac\13B\3C\3C\3C\7C\u01b1\nC\fC\16C\u01b4\13C\3C\3C\3D\3D\3D\7D\u01bb"+
		"\nD\fD\16D\u01be\13D\3D\3D\3E\3E\3E\3E\3F\3F\3F\3F\3F\3F\7F\u01cc\nF\f"+
		"F\16F\u01cf\13F\3F\5F\u01d2\nF\3G\6G\u01d5\nG\rG\16G\u01d6\3H\3H\3H\6"+
		"H\u01dc\nH\rH\16H\u01dd\3I\6I\u01e1\nI\rI\16I\u01e2\3I\3I\7I\u01e7\nI"+
		"\fI\16I\u01ea\13I\3I\5I\u01ed\nI\3I\3I\6I\u01f1\nI\rI\16I\u01f2\3I\5I"+
		"\u01f6\nI\3I\6I\u01f9\nI\rI\16I\u01fa\3I\3I\5I\u01ff\nI\3J\3J\3J\6J\u0204"+
		"\nJ\rJ\16J\u0205\3J\3J\7J\u020a\nJ\fJ\16J\u020d\13J\3J\5J\u0210\nJ\3J"+
		"\3J\3J\3J\6J\u0216\nJ\rJ\16J\u0217\3J\5J\u021b\nJ\3J\3J\3J\6J\u0220\n"+
		"J\rJ\16J\u0221\3J\3J\5J\u0226\nJ\3K\3K\5K\u022a\nK\3K\6K\u022d\nK\rK\16"+
		"K\u022e\3L\3L\5L\u0233\nL\3L\6L\u0236\nL\rL\16L\u0237\3M\3M\3M\3M\5M\u023e"+
		"\nM\3M\3M\3M\3M\5M\u0244\nM\3N\3N\3N\3N\3N\3N\3N\3N\3N\3N\3N\5N\u0251"+
		"\nN\3O\3O\3O\3O\3O\3P\3P\3P\3P\3P\6P\u025d\nP\rP\16P\u025e\3P\3P\3Q\3"+
		"Q\3R\3R\3S\3S\3S\3S\3S\3S\3S\3S\3S\3T\3T\3T\3T\3T\3T\7T\u0276\nT\fT\16"+
		"T\u0279\13T\3T\3T\7T\u027d\nT\fT\16T\u0280\13T\3T\3T\7T\u0284\nT\fT\16"+
		"T\u0287\13T\3T\3T\7T\u028b\nT\fT\16T\u028e\13T\5T\u0290\nT\3T\3T\3T\5"+
		"T\u0295\nT\3T\3T\3U\6U\u029a\nU\rU\16U\u029b\3U\3U\3V\3V\3V\7V\u02a3\n"+
		"V\fV\16V\u02a6\13V\3V\3V\3\u01cd\2W\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083"+
		"C\u0085D\u0087E\u0089F\u008b\2\u008dG\u008fH\u0091I\u0093J\u0095\2\u0097"+
		"\2\u0099\2\u009b\2\u009d\2\u009f\2\u00a1\2\u00a3\2\u00a5K\u00a7L\u00a9"+
		"M\u00abN\3\2\23\5\2C\\aac|\6\2\62;C\\aac|\4\2$$^^\4\2))^^\4\2ZZzz\4\2"+
		"GGgg\4\2--//\4\2RRrr\f\2$$))^^cdhhppttvvxx||\3\2\62\64\3\2\62;\5\2\62"+
		";CHch\6\2\f\f\17\17??]]\4\2\f\f\17\17\5\2\f\f\17\17]]\4\3\f\f\17\17\5"+
		"\2\13\f\16\17\"\"\2\u02ce\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"+
		"\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2"+
		"\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2"+
		"\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]"+
		"\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2"+
		"\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2"+
		"\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2"+
		"\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2"+
		"\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u00a5"+
		"\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9\3\2\2\2\2\u00ab\3\2\2\2\3\u00ad\3\2\2"+
		"\2\5\u00af\3\2\2\2\7\u00b1\3\2\2\2\t\u00b7\3\2\2\2\13\u00bc\3\2\2\2\r"+
		"\u00bf\3\2\2\2\17\u00c3\3\2\2\2\21\u00c9\3\2\2\2\23\u00d0\3\2\2\2\25\u00d6"+
		"\3\2\2\2\27\u00d9\3\2\2\2\31\u00de\3\2\2\2\33\u00e5\3\2\2\2\35\u00ea\3"+
		"\2\2\2\37\u00ee\3\2\2\2!\u00f0\3\2\2\2#\u00f3\3\2\2\2%\u00fc\3\2\2\2\'"+
		"\u0102\3\2\2\2)\u0104\3\2\2\2+\u010b\3\2\2\2-\u010d\3\2\2\2/\u010f\3\2"+
		"\2\2\61\u0111\3\2\2\2\63\u0113\3\2\2\2\65\u0115\3\2\2\2\67\u011c\3\2\2"+
		"\29\u0124\3\2\2\2;\u0128\3\2\2\2=\u012f\3\2\2\2?\u0131\3\2\2\2A\u0133"+
		"\3\2\2\2C\u0137\3\2\2\2E\u013e\3\2\2\2G\u0143\3\2\2\2I\u0150\3\2\2\2K"+
		"\u0157\3\2\2\2M\u015a\3\2\2\2O\u015c\3\2\2\2Q\u0162\3\2\2\2S\u0167\3\2"+
		"\2\2U\u016a\3\2\2\2W\u016d\3\2\2\2Y\u016f\3\2\2\2[\u0171\3\2\2\2]\u0174"+
		"\3\2\2\2_\u0178\3\2\2\2a\u017b\3\2\2\2c\u017e\3\2\2\2e\u0181\3\2\2\2g"+
		"\u0184\3\2\2\2i\u0187\3\2\2\2k\u0189\3\2\2\2m\u018b\3\2\2\2o\u018d\3\2"+
		"\2\2q\u018f\3\2\2\2s\u0191\3\2\2\2u\u0194\3\2\2\2w\u0196\3\2\2\2y\u0198"+
		"\3\2\2\2{\u019b\3\2\2\2}\u019e\3\2\2\2\177\u01a2\3\2\2\2\u0081\u01a4\3"+
		"\2\2\2\u0083\u01a6\3\2\2\2\u0085\u01ad\3\2\2\2\u0087\u01b7\3\2\2\2\u0089"+
		"\u01c1\3\2\2\2\u008b\u01d1\3\2\2\2\u008d\u01d4\3\2\2\2\u008f\u01d8\3\2"+
		"\2\2\u0091\u01fe\3\2\2\2\u0093\u0225\3\2\2\2\u0095\u0227\3\2\2\2\u0097"+
		"\u0230\3\2\2\2\u0099\u0243\3\2\2\2\u009b\u0250\3\2\2\2\u009d\u0252\3\2"+
		"\2\2\u009f\u0257\3\2\2\2\u00a1\u0262\3\2\2\2\u00a3\u0264\3\2\2\2\u00a5"+
		"\u0266\3\2\2\2\u00a7\u026f\3\2\2\2\u00a9\u0299\3\2\2\2\u00ab\u029f\3\2"+
		"\2\2\u00ad\u00ae\7=\2\2\u00ae\4\3\2\2\2\u00af\u00b0\7?\2\2\u00b0\6\3\2"+
		"\2\2\u00b1\u00b2\7d\2\2\u00b2\u00b3\7t\2\2\u00b3\u00b4\7g\2\2\u00b4\u00b5"+
		"\7c\2\2\u00b5\u00b6\7m\2\2\u00b6\b\3\2\2\2\u00b7\u00b8\7i\2\2\u00b8\u00b9"+
		"\7q\2\2\u00b9\u00ba\7v\2\2\u00ba\u00bb\7q\2\2\u00bb\n\3\2\2\2\u00bc\u00bd"+
		"\7f\2\2\u00bd\u00be\7q\2\2\u00be\f\3\2\2\2\u00bf\u00c0\7g\2\2\u00c0\u00c1"+
		"\7p\2\2\u00c1\u00c2\7f\2\2\u00c2\16\3\2\2\2\u00c3\u00c4\7y\2\2\u00c4\u00c5"+
		"\7j\2\2\u00c5\u00c6\7k\2\2\u00c6\u00c7\7n\2\2\u00c7\u00c8\7g\2\2\u00c8"+
		"\20\3\2\2\2\u00c9\u00ca\7t\2\2\u00ca\u00cb\7g\2\2\u00cb\u00cc\7r\2\2\u00cc"+
		"\u00cd\7g\2\2\u00cd\u00ce\7c\2\2\u00ce\u00cf\7v\2\2\u00cf\22\3\2\2\2\u00d0"+
		"\u00d1\7w\2\2\u00d1\u00d2\7p\2\2\u00d2\u00d3\7v\2\2\u00d3\u00d4\7k\2\2"+
		"\u00d4\u00d5\7n\2\2\u00d5\24\3\2\2\2\u00d6\u00d7\7k\2\2\u00d7\u00d8\7"+
		"h\2\2\u00d8\26\3\2\2\2\u00d9\u00da\7v\2\2\u00da\u00db\7j\2\2\u00db\u00dc"+
		"\7g\2\2\u00dc\u00dd\7p\2\2\u00dd\30\3\2\2\2\u00de\u00df\7g\2\2\u00df\u00e0"+
		"\7n\2\2\u00e0\u00e1\7u\2\2\u00e1\u00e2\7g\2\2\u00e2\u00e3\7k\2\2\u00e3"+
		"\u00e4\7h\2\2\u00e4\32\3\2\2\2\u00e5\u00e6\7g\2\2\u00e6\u00e7\7n\2\2\u00e7"+
		"\u00e8\7u\2\2\u00e8\u00e9\7g\2\2\u00e9\34\3\2\2\2\u00ea\u00eb\7h\2\2\u00eb"+
		"\u00ec\7q\2\2\u00ec\u00ed\7t\2\2\u00ed\36\3\2\2\2\u00ee\u00ef\7.\2\2\u00ef"+
		" \3\2\2\2\u00f0\u00f1\7k\2\2\u00f1\u00f2\7p\2\2\u00f2\"\3\2\2\2\u00f3"+
		"\u00f4\7h\2\2\u00f4\u00f5\7w\2\2\u00f5\u00f6\7p\2\2\u00f6\u00f7\7e\2\2"+
		"\u00f7\u00f8\7v\2\2\u00f8\u00f9\7k\2\2\u00f9\u00fa\7q\2\2\u00fa\u00fb"+
		"\7p\2\2\u00fb$\3\2\2\2\u00fc\u00fd\7n\2\2\u00fd\u00fe\7q\2\2\u00fe\u00ff"+
		"\7e\2\2\u00ff\u0100\7c\2\2\u0100\u0101\7n\2\2\u0101&\3\2\2\2\u0102\u0103"+
		"\7<\2\2\u0103(\3\2\2\2\u0104\u0105\7i\2\2\u0105\u0106\7n\2\2\u0106\u0107"+
		"\7q\2\2\u0107\u0108\7d\2\2\u0108\u0109\7c\2\2\u0109\u010a\7n\2\2\u010a"+
		"*\3\2\2\2\u010b\u010c\7>\2\2\u010c,\3\2\2\2\u010d\u010e\7@\2\2\u010e."+
		"\3\2\2\2\u010f\u0110\7*\2\2\u0110\60\3\2\2\2\u0111\u0112\7+\2\2\u0112"+
		"\62\3\2\2\2\u0113\u0114\7~\2\2\u0114\64\3\2\2\2\u0115\u0116\7u\2\2\u0116"+
		"\u0117\7v\2\2\u0117\u0118\7t\2\2\u0118\u0119\7k\2\2\u0119\u011a\7p\2\2"+
		"\u011a\u011b\7i\2\2\u011b\66\3\2\2\2\u011c\u011d\7d\2\2\u011d\u011e\7"+
		"q\2\2\u011e\u011f\7q\2\2\u011f\u0120\7n\2\2\u0120\u0121\7g\2\2\u0121\u0122"+
		"\7c\2\2\u0122\u0123\7p\2\2\u01238\3\2\2\2\u0124\u0125\7p\2\2\u0125\u0126"+
		"\7k\2\2\u0126\u0127\7n\2\2\u0127:\3\2\2\2\u0128\u0129\7p\2\2\u0129\u012a"+
		"\7w\2\2\u012a\u012b\7o\2\2\u012b\u012c\7d\2\2\u012c\u012d\7g\2\2\u012d"+
		"\u012e\7t\2\2\u012e<\3\2\2\2\u012f\u0130\7}\2\2\u0130>\3\2\2\2\u0131\u0132"+
		"\7\177\2\2\u0132@\3\2\2\2\u0133\u0134\7\60\2\2\u0134\u0135\7\60\2\2\u0135"+
		"\u0136\7\60\2\2\u0136B\3\2\2\2\u0137\u0138\7t\2\2\u0138\u0139\7g\2\2\u0139"+
		"\u013a\7e\2\2\u013a\u013b\7q\2\2\u013b\u013c\7t\2\2\u013c\u013d\7f\2\2"+
		"\u013dD\3\2\2\2\u013e\u013f\7g\2\2\u013f\u0140\7p\2\2\u0140\u0141\7w\2"+
		"\2\u0141\u0142\7o\2\2\u0142F\3\2\2\2\u0143\u0144\7h\2\2\u0144\u0145\7"+
		"w\2\2\u0145\u0146\7p\2\2\u0146\u0147\7e\2\2\u0147\u0148\7v\2\2\u0148\u0149"+
		"\7k\2\2\u0149\u014a\7q\2\2\u014a\u014b\7p\2\2\u014b\u014c\7v\2\2\u014c"+
		"\u014d\7{\2\2\u014d\u014e\7r\2\2\u014e\u014f\7g\2\2\u014fH\3\2\2\2\u0150"+
		"\u0151\7t\2\2\u0151\u0152\7g\2\2\u0152\u0153\7v\2\2\u0153\u0154\7w\2\2"+
		"\u0154\u0155\7t\2\2\u0155\u0156\7p\2\2\u0156J\3\2\2\2\u0157\u0158\7<\2"+
		"\2\u0158\u0159\7<\2\2\u0159L\3\2\2\2\u015a\u015b\7\60\2\2\u015bN\3\2\2"+
		"\2\u015c\u015d\7h\2\2\u015d\u015e\7c\2\2\u015e\u015f\7n\2\2\u015f\u0160"+
		"\7u\2\2\u0160\u0161\7g\2\2\u0161P\3\2\2\2\u0162\u0163\7v\2\2\u0163\u0164"+
		"\7t\2\2\u0164\u0165\7w\2\2\u0165\u0166\7g\2\2\u0166R\3\2\2\2\u0167\u0168"+
		"\7c\2\2\u0168\u0169\7u\2\2\u0169T\3\2\2\2\u016a\u016b\7k\2\2\u016b\u016c"+
		"\7u\2\2\u016cV\3\2\2\2\u016d\u016e\7]\2\2\u016eX\3\2\2\2\u016f\u0170\7"+
		"_\2\2\u0170Z\3\2\2\2\u0171\u0172\7q\2\2\u0172\u0173\7t\2\2\u0173\\\3\2"+
		"\2\2\u0174\u0175\7c\2\2\u0175\u0176\7p\2\2\u0176\u0177\7f\2\2\u0177^\3"+
		"\2\2\2\u0178\u0179\7>\2\2\u0179\u017a\7?\2\2\u017a`\3\2\2\2\u017b\u017c"+
		"\7@\2\2\u017c\u017d\7?\2\2\u017db\3\2\2\2\u017e\u017f\7\u0080\2\2\u017f"+
		"\u0180\7?\2\2\u0180d\3\2\2\2\u0181\u0182\7?\2\2\u0182\u0183\7?\2\2\u0183"+
		"f\3\2\2\2\u0184\u0185\7\60\2\2\u0185\u0186\7\60\2\2\u0186h\3\2\2\2\u0187"+
		"\u0188\7-\2\2\u0188j\3\2\2\2\u0189\u018a\7/\2\2\u018al\3\2\2\2\u018b\u018c"+
		"\7,\2\2\u018cn\3\2\2\2\u018d\u018e\7\61\2\2\u018ep\3\2\2\2\u018f\u0190"+
		"\7\'\2\2\u0190r\3\2\2\2\u0191\u0192\7\61\2\2\u0192\u0193\7\61\2\2\u0193"+
		"t\3\2\2\2\u0194\u0195\7(\2\2\u0195v\3\2\2\2\u0196\u0197\7\u0080\2\2\u0197"+
		"x\3\2\2\2\u0198\u0199\7>\2\2\u0199\u019a\7>\2\2\u019az\3\2\2\2\u019b\u019c"+
		"\7@\2\2\u019c\u019d\7@\2\2\u019d|\3\2\2\2\u019e\u019f\7p\2\2\u019f\u01a0"+
		"\7q\2\2\u01a0\u01a1\7v\2\2\u01a1~\3\2\2\2\u01a2\u01a3\7%\2\2\u01a3\u0080"+
		"\3\2\2\2\u01a4\u01a5\7`\2\2\u01a5\u0082\3\2\2\2\u01a6\u01aa\t\2\2\2\u01a7"+
		"\u01a9\t\3\2\2\u01a8\u01a7\3\2\2\2\u01a9\u01ac\3\2\2\2\u01aa\u01a8\3\2"+
		"\2\2\u01aa\u01ab\3\2\2\2\u01ab\u0084\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ad"+
		"\u01b2\7$\2\2\u01ae\u01b1\5\u0099M\2\u01af\u01b1\n\4\2\2\u01b0\u01ae\3"+
		"\2\2\2\u01b0\u01af\3\2\2\2\u01b1\u01b4\3\2\2\2\u01b2\u01b0\3\2\2\2\u01b2"+
		"\u01b3\3\2\2\2\u01b3\u01b5\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b5\u01b6\7$"+
		"\2\2\u01b6\u0086\3\2\2\2\u01b7\u01bc\7)\2\2\u01b8\u01bb\5\u0099M\2\u01b9"+
		"\u01bb\n\5\2\2\u01ba\u01b8\3\2\2\2\u01ba\u01b9\3\2\2\2\u01bb\u01be\3\2"+
		"\2\2\u01bc\u01ba\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01bf\3\2\2\2\u01be"+
		"\u01bc\3\2\2\2\u01bf\u01c0\7)\2\2\u01c0\u0088\3\2\2\2\u01c1\u01c2\7]\2"+
		"\2\u01c2\u01c3\5\u008bF\2\u01c3\u01c4\7_\2\2\u01c4\u008a\3\2\2\2\u01c5"+
		"\u01c6\7?\2\2\u01c6\u01c7\5\u008bF\2\u01c7\u01c8\7?\2\2\u01c8\u01d2\3"+
		"\2\2\2\u01c9\u01cd\7]\2\2\u01ca\u01cc\13\2\2\2\u01cb\u01ca\3\2\2\2\u01cc"+
		"\u01cf\3\2\2\2\u01cd\u01ce\3\2\2\2\u01cd\u01cb\3\2\2\2\u01ce\u01d0\3\2"+
		"\2\2\u01cf\u01cd\3\2\2\2\u01d0\u01d2\7_\2\2\u01d1\u01c5\3\2\2\2\u01d1"+
		"\u01c9\3\2\2\2\u01d2\u008c\3\2\2\2\u01d3\u01d5\5\u00a1Q\2\u01d4\u01d3"+
		"\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7"+
		"\u008e\3\2\2\2\u01d8\u01d9\7\62\2\2\u01d9\u01db\t\6\2\2\u01da\u01dc\5"+
		"\u00a3R\2\u01db\u01da\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01db\3\2\2\2"+
		"\u01dd\u01de\3\2\2\2\u01de\u0090\3\2\2\2\u01df\u01e1\5\u00a1Q\2\u01e0"+
		"\u01df\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e0\3\2\2\2\u01e2\u01e3\3\2"+
		"\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e8\7\60\2\2\u01e5\u01e7\5\u00a1Q\2\u01e6"+
		"\u01e5\3\2\2\2\u01e7\u01ea\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e8\u01e9\3\2"+
		"\2\2\u01e9\u01ec\3\2\2\2\u01ea\u01e8\3\2\2\2\u01eb\u01ed\5\u0095K\2\u01ec"+
		"\u01eb\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed\u01ff\3\2\2\2\u01ee\u01f0\7\60"+
		"\2\2\u01ef\u01f1\5\u00a1Q\2\u01f0\u01ef\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2"+
		"\u01f0\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3\u01f5\3\2\2\2\u01f4\u01f6\5\u0095"+
		"K\2\u01f5\u01f4\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6\u01ff\3\2\2\2\u01f7"+
		"\u01f9\5\u00a1Q\2\u01f8\u01f7\3\2\2\2\u01f9\u01fa\3\2\2\2\u01fa\u01f8"+
		"\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc\u01fd\5\u0095K"+
		"\2\u01fd\u01ff\3\2\2\2\u01fe\u01e0\3\2\2\2\u01fe\u01ee\3\2\2\2\u01fe\u01f8"+
		"\3\2\2\2\u01ff\u0092\3\2\2\2\u0200\u0201\7\62\2\2\u0201\u0203\t\6\2\2"+
		"\u0202\u0204\5\u00a3R\2\u0203\u0202\3\2\2\2\u0204\u0205\3\2\2\2\u0205"+
		"\u0203\3\2\2\2\u0205\u0206\3\2\2\2\u0206\u0207\3\2\2\2\u0207\u020b\7\60"+
		"\2\2\u0208\u020a\5\u00a3R\2\u0209\u0208\3\2\2\2\u020a\u020d\3\2\2\2\u020b"+
		"\u0209\3\2\2\2\u020b\u020c\3\2\2\2\u020c\u020f\3\2\2\2\u020d\u020b\3\2"+
		"\2\2\u020e\u0210\5\u0097L\2\u020f\u020e\3\2\2\2\u020f\u0210\3\2\2\2\u0210"+
		"\u0226\3\2\2\2\u0211\u0212\7\62\2\2\u0212\u0213\t\6\2\2\u0213\u0215\7"+
		"\60\2\2\u0214\u0216\5\u00a3R\2\u0215\u0214\3\2\2\2\u0216\u0217\3\2\2\2"+
		"\u0217\u0215\3\2\2\2\u0217\u0218\3\2\2\2\u0218\u021a\3\2\2\2\u0219\u021b"+
		"\5\u0097L\2\u021a\u0219\3\2\2\2\u021a\u021b\3\2\2\2\u021b\u0226\3\2\2"+
		"\2\u021c\u021d\7\62\2\2\u021d\u021f\t\6\2\2\u021e\u0220\5\u00a3R\2\u021f"+
		"\u021e\3\2\2\2\u0220\u0221\3\2\2\2\u0221\u021f\3\2\2\2\u0221\u0222\3\2"+
		"\2\2\u0222\u0223\3\2\2\2\u0223\u0224\5\u0097L\2\u0224\u0226\3\2\2\2\u0225"+
		"\u0200\3\2\2\2\u0225\u0211\3\2\2\2\u0225\u021c\3\2\2\2\u0226\u0094\3\2"+
		"\2\2\u0227\u0229\t\7\2\2\u0228\u022a\t\b\2\2\u0229\u0228\3\2\2\2\u0229"+
		"\u022a\3\2\2\2\u022a\u022c\3\2\2\2\u022b\u022d\5\u00a1Q\2\u022c\u022b"+
		"\3\2\2\2\u022d\u022e\3\2\2\2\u022e\u022c\3\2\2\2\u022e\u022f\3\2\2\2\u022f"+
		"\u0096\3\2\2\2\u0230\u0232\t\t\2\2\u0231\u0233\t\b\2\2\u0232\u0231\3\2"+
		"\2\2\u0232\u0233\3\2\2\2\u0233\u0235\3\2\2\2\u0234\u0236\5\u00a1Q\2\u0235"+
		"\u0234\3\2\2\2\u0236\u0237\3\2\2\2\u0237\u0235\3\2\2\2\u0237\u0238\3\2"+
		"\2\2\u0238\u0098\3\2\2\2\u0239\u023a\7^\2\2\u023a\u0244\t\n\2\2\u023b"+
		"\u023d\7^\2\2\u023c\u023e\7\17\2\2\u023d\u023c\3\2\2\2\u023d\u023e\3\2"+
		"\2\2\u023e\u023f\3\2\2\2\u023f\u0244\7\f\2\2\u0240\u0244\5\u009bN\2\u0241"+
		"\u0244\5\u009dO\2\u0242\u0244\5\u009fP\2\u0243\u0239\3\2\2\2\u0243\u023b"+
		"\3\2\2\2\u0243\u0240\3\2\2\2\u0243\u0241\3\2\2\2\u0243\u0242\3\2\2\2\u0244"+
		"\u009a\3\2\2\2\u0245\u0246\7^\2\2\u0246\u0251\5\u00a1Q\2\u0247\u0248\7"+
		"^\2\2\u0248\u0249\5\u00a1Q\2\u0249\u024a\5\u00a1Q\2\u024a\u0251\3\2\2"+
		"\2\u024b\u024c\7^\2\2\u024c\u024d\t\13\2\2\u024d\u024e\5\u00a1Q\2\u024e"+
		"\u024f\5\u00a1Q\2\u024f\u0251\3\2\2\2\u0250\u0245\3\2\2\2\u0250\u0247"+
		"\3\2\2\2\u0250\u024b\3\2\2\2\u0251\u009c\3\2\2\2\u0252\u0253\7^\2\2\u0253"+
		"\u0254\7z\2\2\u0254\u0255\5\u00a3R\2\u0255\u0256\5\u00a3R\2\u0256\u009e"+
		"\3\2\2\2\u0257\u0258\7^\2\2\u0258\u0259\7w\2\2\u0259\u025a\7}\2\2\u025a"+
		"\u025c\3\2\2\2\u025b\u025d\5\u00a3R\2\u025c\u025b\3\2\2\2\u025d\u025e"+
		"\3\2\2\2\u025e\u025c\3\2\2\2\u025e\u025f\3\2\2\2\u025f\u0260\3\2\2\2\u0260"+
		"\u0261\7\177\2\2\u0261\u00a0\3\2\2\2\u0262\u0263\t\f\2\2\u0263\u00a2\3"+
		"\2\2\2\u0264\u0265\t\r\2\2\u0265\u00a4\3\2\2\2\u0266\u0267\7/\2\2\u0267"+
		"\u0268\7/\2\2\u0268\u0269\7]\2\2\u0269\u026a\3\2\2\2\u026a\u026b\5\u008b"+
		"F\2\u026b\u026c\7_\2\2\u026c\u026d\3\2\2\2\u026d\u026e\bS\2\2\u026e\u00a6"+
		"\3\2\2\2\u026f\u0270\7/\2\2\u0270\u0271\7/\2\2\u0271\u028f\3\2\2\2\u0272"+
		"\u0290\3\2\2\2\u0273\u0277\7]\2\2\u0274\u0276\7?\2\2\u0275\u0274\3\2\2"+
		"\2\u0276\u0279\3\2\2\2\u0277\u0275\3\2\2\2\u0277\u0278\3\2\2\2\u0278\u0290"+
		"\3\2\2\2\u0279\u0277\3\2\2\2\u027a\u027e\7]\2\2\u027b\u027d\7?\2\2\u027c"+
		"\u027b\3\2\2\2\u027d\u0280\3\2\2\2\u027e\u027c\3\2\2\2\u027e\u027f\3\2"+
		"\2\2\u027f\u0281\3\2\2\2\u0280\u027e\3\2\2\2\u0281\u0285\n\16\2\2\u0282"+
		"\u0284\n\17\2\2\u0283\u0282\3\2\2\2\u0284\u0287\3\2\2\2\u0285\u0283\3"+
		"\2\2\2\u0285\u0286\3\2\2\2\u0286\u0290\3\2\2\2\u0287\u0285\3\2\2\2\u0288"+
		"\u028c\n\20\2\2\u0289\u028b\n\17\2\2\u028a\u0289\3\2\2\2\u028b\u028e\3"+
		"\2\2\2\u028c\u028a\3\2\2\2\u028c\u028d\3\2\2\2\u028d\u0290\3\2\2\2\u028e"+
		"\u028c\3\2\2\2\u028f\u0272\3\2\2\2\u028f\u0273\3\2\2\2\u028f\u027a\3\2"+
		"\2\2\u028f\u0288\3\2\2\2\u0290\u0294\3\2\2\2\u0291\u0292\7\17\2\2\u0292"+
		"\u0295\7\f\2\2\u0293\u0295\t\21\2\2\u0294\u0291\3\2\2\2\u0294\u0293\3"+
		"\2\2\2\u0295\u0296\3\2\2\2\u0296\u0297\bT\2\2\u0297\u00a8\3\2\2\2\u0298"+
		"\u029a\t\22\2\2\u0299\u0298\3\2\2\2\u029a\u029b\3\2\2\2\u029b\u0299\3"+
		"\2\2\2\u029b\u029c\3\2\2\2\u029c\u029d\3\2\2\2\u029d\u029e\bU\3\2\u029e"+
		"\u00aa\3\2\2\2\u029f\u02a0\7%\2\2\u02a0\u02a4\7#\2\2\u02a1\u02a3\n\17"+
		"\2\2\u02a2\u02a1\3\2\2\2\u02a3\u02a6\3\2\2\2\u02a4\u02a2\3\2\2\2\u02a4"+
		"\u02a5\3\2\2\2\u02a5\u02a7\3\2\2\2\u02a6\u02a4\3\2\2\2\u02a7\u02a8\bV"+
		"\2\2\u02a8\u00ac\3\2\2\2*\2\u01aa\u01b0\u01b2\u01ba\u01bc\u01cd\u01d1"+
		"\u01d6\u01dd\u01e2\u01e8\u01ec\u01f2\u01f5\u01fa\u01fe\u0205\u020b\u020f"+
		"\u0217\u021a\u0221\u0225\u0229\u022e\u0232\u0237\u023d\u0243\u0250\u025e"+
		"\u0277\u027e\u0285\u028c\u028f\u0294\u029b\u02a4\4\2\3\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}