package stone.entity;

public class StrToken extends Token {

	private String value;
	
	protected StrToken(int lineNum, String val) {
		super(lineNum);
		this.value = val;
	}

	public int getLineNumber() {
		return super.getLineNumber();
	}

	public boolean isIdentifier() {
		return super.isIdentifier();
	}

	public boolean isNumber() {
		return super.isNumber();
	}

	public int getNumber() throws Exception {
		return super.getNumber();
	}

	public boolean isString() {
		return true;
	}
	public String getText() {
		return value;
	}

}
