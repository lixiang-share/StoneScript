package stone;

public class Lexer {

	private static final String patNum = "[0-9]+";
	/**
	 * ������ʽ�����Ҫƥ��"\"����������Ҫ"\\"
	 * Ȼ��java��String��Ҫ���������"\"Ҳ��Ҫ"\\"
	 * ����ͨ���ַ�����д������Ҫ���"\"������������Ҫ"\\\\"
	 */
	private static final String patStr = "(\\\\\"|\\\\\\\\|\\n|[^\"])*";
	private static final String patId = "[A-Z_a-z][A-Z_a-z0-9]*|==|<=|>=|&&|\\|\\||\\p{Punct}";
	private static final String patNote = "//.*";
	private static final String patRaw = "\\s*((%s)|(%s)|(%s)|(%s))?";
	public static String patLexer = String.format(patRaw,new Object[]{patNote, patNum,patStr,patId});
	
	
	
	
	
	
}
