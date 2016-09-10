
public class TokenListImplementation implements TokenList {
	static final int MAX_ELEMENTS = 300;
	
	TokenImplementation[] tokenRow;
	int numberOfElements;
	 
	 TokenListImplementation(){
		 tokenRow = new TokenImplementation[MAX_ELEMENTS];
		 numberOfElements = 0;
	 }
	 
	public void add(Token token) {
		tokenRow[numberOfElements] = (TokenImplementation) token;
		numberOfElements +=1;
	}

	//Assuming the index starts with 0

	public void remove(int index) {
		for(int i=index; i<numberOfElements; i++){
			tokenRow[i]= tokenRow[i+1];
		}
		numberOfElements -=1;
	}

	public void set(int index, Token token) {
		tokenRow[index] = (TokenImplementation)token;
	}

	public Token get(int index) {
		return tokenRow[index];
	}

	
	public int size() {
		return numberOfElements;
	}

}
