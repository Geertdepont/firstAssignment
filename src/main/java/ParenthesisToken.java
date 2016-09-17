
public class ParenthesisToken implements Token{

	private static final int PRECEDENCE=-1;
	
	private String value;
	
	ParenthesisToken(){//default constructor
		value="";
	}
	
	ParenthesisToken(ParenthesisToken token){//copy constructor
		value=token.value;
	}
	
	ParenthesisToken(String token){//the constructor that takes a String as parameter
		value=token;
	}
	
	@Override
	public String getValue(){
		return value;
	}

	@Override
	public int getType(){
		return PARENTHESIS_TYPE;
	}

	@Override
	public int getPrecedence(){
		return PRECEDENCE;
	}
}
