
public class OperatorToken implements Token {

	private static final String OPERATORS_WITH_HIGHEST_PRECEDENCE="^";
	private static final String OPERATORS_WITH_SECOND_HIGHEST_PRECEDENCE="*/";
	private static final String OPERATORS_WITH_THIRD_HIGHEST_PRECEDENCE="+-";
	private static final int HIGHEST_PRECEDENCE=3;
	private static final int SECOND_HIGHEST_PRECEDENCE=2;
	private static final int THIRD_HIGHEST_PRECEDENCE=1;
	
	private String value;
	
	OperatorToken(){//default constructor
		value="";
	}
	
	OperatorToken(OperatorToken token){//copy constructor
		value=token.value;
	}
	
	OperatorToken(String token){//the constructor that takes a String as parameter
		value=token;
	}
	
	@Override
	public String getValue() {
		return value;
	}

	@Override
	public int getType() {
		return OPERATOR_TYPE;
	}

	@Override
	public int getPrecedence() {
		if(OPERATORS_WITH_HIGHEST_PRECEDENCE.contains(value)){
			return HIGHEST_PRECEDENCE;
		}else if(OPERATORS_WITH_SECOND_HIGHEST_PRECEDENCE.contains(value)){
			return SECOND_HIGHEST_PRECEDENCE;
		}else if(OPERATORS_WITH_THIRD_HIGHEST_PRECEDENCE.contains(value)){
			return THIRD_HIGHEST_PRECEDENCE;
		}else{//error which should not happen since only the operators (+, -, *, /, '^') can be OperatorToken-s
			System.exit(1);
			return 0;
		}
	}

}
