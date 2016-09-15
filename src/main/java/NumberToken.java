
public class NumberToken implements Token {
	
	private static final int PRECEDENCE=-1;
	
	private String value;
	
	NumberToken(){//default constructor
		value="";
	}
	
	NumberToken(NumberToken token){//copy constructor
		value=token.value;
	}
	
	NumberToken(String token){//the constructor that takes a String as parameter
		value=token;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public int getType() {
		return NUMBER_TYPE;
	}

	@Override
	public int getPrecedence() {
		return PRECEDENCE;
	}
	
}
