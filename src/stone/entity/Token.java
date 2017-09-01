package stone.entity;

import stone.exception.StoneException;

public abstract class Token {

	public static final Token EOF = new Token(-1){};
	public static final String EOL = "\\n";
	private int lineNumber = -1;
	
	protected Token(int lineNum){
		this.lineNumber = lineNum;
	}
	
	public  int getLineNumber(){
		return lineNumber;
	}
	public boolean isIdentifier(){
		return false;
	}
	public boolean isNumber(){
		return false;
	}
	public boolean isString(){
		return false;
	}
	public int getNumber() throws Exception{
		throw new StoneException("No Number Token");
	}
	public String getText(){
		return "";
	}
}
