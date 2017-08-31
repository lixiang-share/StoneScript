package stone;

public class Lexer {

	private static final String patNum = "[0-9]+";
	/**
	 * 正则表达式如果需要匹配"\"字面量，需要"\\"
	 * 然而java中String想要表达字面量"\"也需要"\\"
	 * 所以通过字符串在写正则想要表达"\"字面量，就需要"\\\\"
	 */
	private static final String patStr = "(\\\\\"|\\\\\\\\|\\n|[^\"])*";
	private static final String patId = "[A-Z_a-z][A-Z_a-z0-9]*|==|<=|>=|&&|\\|\\||\\p{Punct}";
	private static final String patNote = "//.*";
	private static final String patRaw = "\\s*((%s)|(%s)|(%s)|(%s))?";
	public static String patLexer = String.format(patRaw,new Object[]{patNote, patNum,patStr,patId});
	
	
	
	
	
	
}
