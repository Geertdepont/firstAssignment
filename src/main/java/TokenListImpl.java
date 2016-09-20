
public class TokenListImpl implements TokenList{
	
	static final int MAX_NUMBER_OF_ELEMENTS=300;
	
	Token[] tokenArray;
	int numberOfElements;
	 
	TokenListImpl(){
		tokenArray=new Token[MAX_NUMBER_OF_ELEMENTS];
		numberOfElements=0;
	}
	
	TokenListImpl(TokenListImpl tokenList){//copy constructor
		tokenArray=new Token[tokenList.tokenArray.length];
		tokenArray=copyElements(tokenArray,tokenList.tokenArray,numberOfElements);
		numberOfElements=tokenList.numberOfElements;
	}
	 
	Token[] copyElements(Token[] destination, Token[] source, int numberOfElements){
		for(int i=0;i<numberOfElements;i++){
			destination[i]=source[i];
		}
		return destination;
	}
	 
	 
	public void add(Token token){//change implementation to support arbitrarily long lists
		tokenArray[numberOfElements]=token;
		numberOfElements +=1;
	}

	//Assuming the index starts with 0

	public void remove(int index){
		for(int i=index;i<numberOfElements;i++){
			tokenArray[i]=tokenArray[i+1];
		}
		numberOfElements-=1;
	}

	public void set(int index, Token token){
		tokenArray[index]=token;
	}

	public Token get(int index){
		return tokenArray[index];
	}
	
	public int size(){
		return numberOfElements;
	}
}
