
public class TokenListImpl implements TokenList {
	static final int MAX_ELEMENTS = 300;
	
	Token[] tokenRow;
	int numberOfElements;
	 
	TokenListImpl(){
		tokenRow = new Token[MAX_ELEMENTS];
		numberOfElements = 0;
	}
	
	TokenListImpl(TokenListImpl tokenList){//copy constructor
		tokenRow = new Token[tokenList.tokenRow.length];
		tokenRow = copyElements(tokenRow,tokenList.tokenRow,numberOfElements);
		numberOfElements = tokenList.numberOfElements;
	}
	 
	Token[] copyElements(Token[] destination, Token[] source, int numberOfElements){
		for(int i=0;i<numberOfElements;i++){
			destination[i]=source[i];
		}
		return destination;
	}
	 
	 
	public void add(Token token) {
		tokenRow[numberOfElements] = token;
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
		tokenRow[index] = token;
	}

	public Token get(int index) {
		return tokenRow[index];
	}

	
	public int size() {
		return numberOfElements;
	}
	
}
