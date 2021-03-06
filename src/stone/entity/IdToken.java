package stone.entity;

public class IdToken extends Token {

	private String value;
	
	public IdToken(int lineNum,String val) {
		super(lineNum);
		this.value = val;
	}

	public int getLineNumber() {
		return super.getLineNumber();
	}
	public boolean isNumber() {
		return super.isNumber();
	}
	public boolean isString() {
		return super.isString();
	}
	public int getNumber(){
		return super.getNumber();
	}

	public boolean isIdentifier() {
		return true;
	}
	public String getText() {
		return value;
	}

}
