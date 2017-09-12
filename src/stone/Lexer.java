package stone;

import java.io.LineNumberReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import stone.entity.IdToken;
import stone.entity.NumToken;
import stone.entity.StrToken;
import stone.entity.Token;
import stone.exception.ParseException;

public class Lexer {

	private static final String patNum = "[0-9]+";
	/**
	 * 正则表达式如果需要匹配"\"字面量，需要"\\"
	 * 然而java中String想要表达字面量"\"也需要"\\"
	 * 所以通过字符串在写正则想要表达"\"字面量，就需要"\\\\"
	 */
	private static final String patStr = "\"(\\\\\"|\\\\\\\\|\\\\n|[^\"])*\"";
	private static final String patId = "[A-Z_a-z][A-Z_a-z0-9]*|==|<=|>=|&&|\\|\\||\\p{Punct}";
	private static final String patNote = "//.*";
	private static final String patRaw = "\\s*((%s)|(%s)|(%s)|(%s))?";
	public static String patLexer = String.format(patRaw,new Object[]{patNote, patNum,patStr,patId});
	public static Pattern pattern = Pattern.compile(patLexer); 
	
	private LineNumberReader reader;
	private ArrayList<Token> queue = new ArrayList<Token>();
	private boolean hasMore;
	public Lexer(Reader r){
		reader = new LineNumberReader(r);
		hasMore = true;
	}
	
	public Token peek(int i) throws ParseException{
		if(fillQueue(i)){
			return queue.get(i);
		}else{
			return Token.EOF;
		}
	}
	
	public Token read() throws ParseException{
		if(fillQueue(0)){
			return queue.remove(0);
		}else{
			return Token.EOF;
		}
	}
	
	private boolean fillQueue(int i) throws ParseException{
		while(i>= queue.size()){
			if(hasMore){
				readLine();
			}else{
				return false;
			}
		}
		return true;
	}
	
	private void readLine() throws ParseException{
		String line;
		try {
			line = reader.readLine();
		} catch (Exception e) {
			throw new ParseException(e);
		}
		if(line == null){
			hasMore = false;
			return;
		}
		int lineNo = reader.getLineNumber();
		Matcher matcher = pattern.matcher(line);
		matcher.useTransparentBounds(true).useAnchoringBounds(false);
		int pos = 0;
		int endPos = line.length();
		while(pos < endPos){
			matcher.region(pos, endPos);
			if(matcher.lookingAt()){
				addToken(lineNo,matcher);
				pos = matcher.end();
			}else{
				throw new ParseException("error Token at line : "+lineNo);
			}
		}
		queue.add(new IdToken(lineNo,Token.EOL));
	}

	private void addToken(int lineNo, Matcher matcher) {
		String m = matcher.group(1);
		if(m != null && matcher.group(2) == null){
			Token token;
			if(matcher.group(3) != null){
				token = new NumToken(lineNo,Integer.parseInt(m)); 
			}else if(matcher.group(4) != null){
				token = new StrToken(lineNo,m); 
			}else{
				token = new IdToken(lineNo,m);
			}
			queue.add(token);
		}
	}
	
}

