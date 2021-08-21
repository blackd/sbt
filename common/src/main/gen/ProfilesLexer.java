// Generated from /home/plamen/my_develop/Inventory-Profiles-Next/common/src/main/antlr/org/anti_ad/mc/common/prifiles/ProfilesLexer.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ProfilesLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, PROFILE=2, ACTIVATE=3, HOT1=4, HOT2=5, HOT3=6, HOT4=7, HOT5=8, HOT6=9, 
		HOT7=10, HOT8=11, HOT9=12, CHESTPLATE=13, LEGS=14, FEET=15, HEAD=16, OFFHAND=17, 
		COMMA=18, LBRACK=19, RBRACK=20, LBRACE=21, RBRACE=22, DQUOTE=23, LID=24, 
		LVL=25, S=26, COLON=27, SEMICOLON=28, ENCHANTMENTS=29, POTION=30, ARROW=31, 
		Level=32, Id=33, NamespacedId=34, STRING=35;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WS", "PROFILE", "ACTIVATE", "HOT1", "HOT2", "HOT3", "HOT4", "HOT5", 
			"HOT6", "HOT7", "HOT8", "HOT9", "CHESTPLATE", "LEGS", "FEET", "HEAD", 
			"OFFHAND", "COMMA", "LBRACK", "RBRACK", "LBRACE", "RBRACE", "DQUOTE", 
			"LID", "LVL", "S", "COLON", "SEMICOLON", "ENCHANTMENTS", "POTION", "ARROW", 
			"ID", "NUMBER", "Level", "Id", "NamespacedId", "STRING", "ESC", "UNICODE", 
			"HEX", "SAFECODEPOINT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'profile'", "'activate'", "'HOT1'", "'HOT2'", "'HOT3'", 
			"'HOT4'", "'HOT5'", "'HOT6'", "'HOT7'", "'HOT8'", "'HOT9'", "'CHEST'", 
			"'LEGS'", "'FEET'", "'HEAD'", "'OFFHAND'", "','", "'['", "']'", "'{'", 
			"'}'", "'\"'", "'id'", "'lvl'", "'s'", "':'", "';'", "'\"Enchantments\" :'", 
			"'\"Potion\" :'", "'->'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "PROFILE", "ACTIVATE", "HOT1", "HOT2", "HOT3", "HOT4", "HOT5", 
			"HOT6", "HOT7", "HOT8", "HOT9", "CHESTPLATE", "LEGS", "FEET", "HEAD", 
			"OFFHAND", "COMMA", "LBRACK", "RBRACK", "LBRACE", "RBRACE", "DQUOTE", 
			"LID", "LVL", "S", "COLON", "SEMICOLON", "ENCHANTMENTS", "POTION", "ARROW", 
			"Level", "Id", "NamespacedId", "STRING"
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


	public ProfilesLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ProfilesLexer.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2%\u011f\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\6\2"+
		"W\n\2\r\2\16\2X\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3"+
		"\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3"+
		"\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3"+
		"!\6!\u00f1\n!\r!\16!\u00f2\3\"\6\"\u00f6\n\"\r\"\16\"\u00f7\3\"\5\"\u00fb"+
		"\n\"\3#\3#\3$\3$\3%\3%\3%\3%\3%\3%\3&\3&\3&\7&\u010a\n&\f&\16&\u010d\13"+
		"&\3&\3&\3\'\3\'\3\'\5\'\u0114\n\'\3(\3(\3(\3(\3(\3(\3)\3)\3*\3*\2\2+\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37="+
		" ?!A\2C\2E\"G#I$K%M\2O\2Q\2S\2\3\2\t\f\2\13\17\"\"\u0087\u0087\u00a2\u00a2"+
		"\u1682\u1682\u2002\u200c\u202a\u202b\u2031\u2031\u2061\u2061\u3002\u3002"+
		"\6\2\62;C\\aac|\3\2\62;\3\2c|\n\2$$\61\61^^ddhhppttvv\5\2\62;CHch\5\2"+
		"\2!$$^^\2\u011f\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3"+
		"\2\2\2\2K\3\2\2\2\3V\3\2\2\2\5\\\3\2\2\2\7d\3\2\2\2\tm\3\2\2\2\13r\3\2"+
		"\2\2\rw\3\2\2\2\17|\3\2\2\2\21\u0081\3\2\2\2\23\u0086\3\2\2\2\25\u008b"+
		"\3\2\2\2\27\u0090\3\2\2\2\31\u0095\3\2\2\2\33\u009a\3\2\2\2\35\u00a0\3"+
		"\2\2\2\37\u00a5\3\2\2\2!\u00aa\3\2\2\2#\u00af\3\2\2\2%\u00b7\3\2\2\2\'"+
		"\u00b9\3\2\2\2)\u00bb\3\2\2\2+\u00bd\3\2\2\2-\u00bf\3\2\2\2/\u00c1\3\2"+
		"\2\2\61\u00c3\3\2\2\2\63\u00c6\3\2\2\2\65\u00ca\3\2\2\2\67\u00cc\3\2\2"+
		"\29\u00ce\3\2\2\2;\u00d0\3\2\2\2=\u00e1\3\2\2\2?\u00ec\3\2\2\2A\u00f0"+
		"\3\2\2\2C\u00f5\3\2\2\2E\u00fc\3\2\2\2G\u00fe\3\2\2\2I\u0100\3\2\2\2K"+
		"\u0106\3\2\2\2M\u0110\3\2\2\2O\u0115\3\2\2\2Q\u011b\3\2\2\2S\u011d\3\2"+
		"\2\2UW\t\2\2\2VU\3\2\2\2WX\3\2\2\2XV\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Z[\b\2"+
		"\2\2[\4\3\2\2\2\\]\7r\2\2]^\7t\2\2^_\7q\2\2_`\7h\2\2`a\7k\2\2ab\7n\2\2"+
		"bc\7g\2\2c\6\3\2\2\2de\7c\2\2ef\7e\2\2fg\7v\2\2gh\7k\2\2hi\7x\2\2ij\7"+
		"c\2\2jk\7v\2\2kl\7g\2\2l\b\3\2\2\2mn\7J\2\2no\7Q\2\2op\7V\2\2pq\7\63\2"+
		"\2q\n\3\2\2\2rs\7J\2\2st\7Q\2\2tu\7V\2\2uv\7\64\2\2v\f\3\2\2\2wx\7J\2"+
		"\2xy\7Q\2\2yz\7V\2\2z{\7\65\2\2{\16\3\2\2\2|}\7J\2\2}~\7Q\2\2~\177\7V"+
		"\2\2\177\u0080\7\66\2\2\u0080\20\3\2\2\2\u0081\u0082\7J\2\2\u0082\u0083"+
		"\7Q\2\2\u0083\u0084\7V\2\2\u0084\u0085\7\67\2\2\u0085\22\3\2\2\2\u0086"+
		"\u0087\7J\2\2\u0087\u0088\7Q\2\2\u0088\u0089\7V\2\2\u0089\u008a\78\2\2"+
		"\u008a\24\3\2\2\2\u008b\u008c\7J\2\2\u008c\u008d\7Q\2\2\u008d\u008e\7"+
		"V\2\2\u008e\u008f\79\2\2\u008f\26\3\2\2\2\u0090\u0091\7J\2\2\u0091\u0092"+
		"\7Q\2\2\u0092\u0093\7V\2\2\u0093\u0094\7:\2\2\u0094\30\3\2\2\2\u0095\u0096"+
		"\7J\2\2\u0096\u0097\7Q\2\2\u0097\u0098\7V\2\2\u0098\u0099\7;\2\2\u0099"+
		"\32\3\2\2\2\u009a\u009b\7E\2\2\u009b\u009c\7J\2\2\u009c\u009d\7G\2\2\u009d"+
		"\u009e\7U\2\2\u009e\u009f\7V\2\2\u009f\34\3\2\2\2\u00a0\u00a1\7N\2\2\u00a1"+
		"\u00a2\7G\2\2\u00a2\u00a3\7I\2\2\u00a3\u00a4\7U\2\2\u00a4\36\3\2\2\2\u00a5"+
		"\u00a6\7H\2\2\u00a6\u00a7\7G\2\2\u00a7\u00a8\7G\2\2\u00a8\u00a9\7V\2\2"+
		"\u00a9 \3\2\2\2\u00aa\u00ab\7J\2\2\u00ab\u00ac\7G\2\2\u00ac\u00ad\7C\2"+
		"\2\u00ad\u00ae\7F\2\2\u00ae\"\3\2\2\2\u00af\u00b0\7Q\2\2\u00b0\u00b1\7"+
		"H\2\2\u00b1\u00b2\7H\2\2\u00b2\u00b3\7J\2\2\u00b3\u00b4\7C\2\2\u00b4\u00b5"+
		"\7P\2\2\u00b5\u00b6\7F\2\2\u00b6$\3\2\2\2\u00b7\u00b8\7.\2\2\u00b8&\3"+
		"\2\2\2\u00b9\u00ba\7]\2\2\u00ba(\3\2\2\2\u00bb\u00bc\7_\2\2\u00bc*\3\2"+
		"\2\2\u00bd\u00be\7}\2\2\u00be,\3\2\2\2\u00bf\u00c0\7\177\2\2\u00c0.\3"+
		"\2\2\2\u00c1\u00c2\7$\2\2\u00c2\60\3\2\2\2\u00c3\u00c4\7k\2\2\u00c4\u00c5"+
		"\7f\2\2\u00c5\62\3\2\2\2\u00c6\u00c7\7n\2\2\u00c7\u00c8\7x\2\2\u00c8\u00c9"+
		"\7n\2\2\u00c9\64\3\2\2\2\u00ca\u00cb\7u\2\2\u00cb\66\3\2\2\2\u00cc\u00cd"+
		"\7<\2\2\u00cd8\3\2\2\2\u00ce\u00cf\7=\2\2\u00cf:\3\2\2\2\u00d0\u00d1\7"+
		"$\2\2\u00d1\u00d2\7G\2\2\u00d2\u00d3\7p\2\2\u00d3\u00d4\7e\2\2\u00d4\u00d5"+
		"\7j\2\2\u00d5\u00d6\7c\2\2\u00d6\u00d7\7p\2\2\u00d7\u00d8\7v\2\2\u00d8"+
		"\u00d9\7o\2\2\u00d9\u00da\7g\2\2\u00da\u00db\7p\2\2\u00db\u00dc\7v\2\2"+
		"\u00dc\u00dd\7u\2\2\u00dd\u00de\7$\2\2\u00de\u00df\7\"\2\2\u00df\u00e0"+
		"\7<\2\2\u00e0<\3\2\2\2\u00e1\u00e2\7$\2\2\u00e2\u00e3\7R\2\2\u00e3\u00e4"+
		"\7q\2\2\u00e4\u00e5\7v\2\2\u00e5\u00e6\7k\2\2\u00e6\u00e7\7q\2\2\u00e7"+
		"\u00e8\7p\2\2\u00e8\u00e9\7$\2\2\u00e9\u00ea\7\"\2\2\u00ea\u00eb\7<\2"+
		"\2\u00eb>\3\2\2\2\u00ec\u00ed\7/\2\2\u00ed\u00ee\7@\2\2\u00ee@\3\2\2\2"+
		"\u00ef\u00f1\t\3\2\2\u00f0\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f0"+
		"\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3B\3\2\2\2\u00f4\u00f6\t\4\2\2\u00f5"+
		"\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2"+
		"\2\2\u00f8\u00fa\3\2\2\2\u00f9\u00fb\t\5\2\2\u00fa\u00f9\3\2\2\2\u00fa"+
		"\u00fb\3\2\2\2\u00fbD\3\2\2\2\u00fc\u00fd\5C\"\2\u00fdF\3\2\2\2\u00fe"+
		"\u00ff\5A!\2\u00ffH\3\2\2\2\u0100\u0101\5/\30\2\u0101\u0102\5A!\2\u0102"+
		"\u0103\7<\2\2\u0103\u0104\5A!\2\u0104\u0105\5/\30\2\u0105J\3\2\2\2\u0106"+
		"\u010b\7$\2\2\u0107\u010a\5M\'\2\u0108\u010a\5S*\2\u0109\u0107\3\2\2\2"+
		"\u0109\u0108\3\2\2\2\u010a\u010d\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c"+
		"\3\2\2\2\u010c\u010e\3\2\2\2\u010d\u010b\3\2\2\2\u010e\u010f\7$\2\2\u010f"+
		"L\3\2\2\2\u0110\u0113\7^\2\2\u0111\u0114\t\6\2\2\u0112\u0114\5O(\2\u0113"+
		"\u0111\3\2\2\2\u0113\u0112\3\2\2\2\u0114N\3\2\2\2\u0115\u0116\7w\2\2\u0116"+
		"\u0117\5Q)\2\u0117\u0118\5Q)\2\u0118\u0119\5Q)\2\u0119\u011a\5Q)\2\u011a"+
		"P\3\2\2\2\u011b\u011c\t\7\2\2\u011cR\3\2\2\2\u011d\u011e\n\b\2\2\u011e"+
		"T\3\2\2\2\n\2X\u00f2\u00f7\u00fa\u0109\u010b\u0113\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}