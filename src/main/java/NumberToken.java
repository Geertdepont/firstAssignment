
public class NumberToken implements Token {
	
	private static final int PRECEDENCE=-1;
	
	private double value;// depends if this should be a string
	
	NumberToken(){//default constructor
		value=0;
	}
	
	NumberToken(NumberToken token){//copy constructor
		value=token.value;
	}
	
	NumberToken(double token){//the constructor that takes a String as parameter
		value=token;
	}

	@Override
	public String getValue() {
		return Double.toString(value);
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
