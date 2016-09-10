
public class TokenImplementation implements Token {
	int type;
	double value;
	char character;
	
	TokenImplementation(double number){
		type = NUMBER_TYPE;
		value = number;
	}
	
	TokenImplementation(char character){
		this.character = character;
	}
	

	public String getValue() {
		return null;
	}

	public int getType() {
		return type;
	}

	public int getPrecedence() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
