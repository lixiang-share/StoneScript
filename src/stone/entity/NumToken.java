package stone.entity;

public class NumToken extends Token {
	private int value;
	
	public NumToken(int lineNum, int val) {
		super(lineNum);
		this.value = val;
	}

	public int getLineNumber() {
		return super.getLineNumber();
	}
	public boolean isIdentifier() {
		return super.isIdentifier();
	}
	public boolean isString() {
		return super.isString();
	}

	public boolean isNumber() {
		return true;
	}
	public int getNumber(){
		return this.value;
	}
	public String getText() {
		return Integer.toString(value);
	}

}
