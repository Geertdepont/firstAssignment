
public class TokenListImpl implements TokenList{
	
	static final int INITIAL_MAX_NUMBER_OF_ELEMENTS=1;
	
	Token[] tokenArray;
	int numberOfElements;
	 
	TokenListImpl(){
		tokenArray=new Token[INITIAL_MAX_NUMBER_OF_ELEMENTS];
		numberOfElements=0;
	}
	
	TokenListImpl(TokenListImpl tokenList){//copy constructor
		tokenArray=new Token[tokenList.tokenArray.length];
		numberOfElements=tokenList.numberOfElements;
		copyElements(tokenArray,tokenList.tokenArray,numberOfElements);
	}
	 
	void copyElements(Token[] destination, Token[] source, int numberOfElements){
		for(int i=0;i<numberOfElements;i++){
			if(source[i].getType()==Token.NUMBER_TYPE){
				destination[i]=new NumberToken((NumberToken)source[i]);
			}else if(source[i].getType()==Token.OPERATOR_TYPE){
				destination[i]=new OperatorToken((OperatorToken)source[i]);
			}else{//parenthesis token
				destination[i]=new ParenthesisToken((ParenthesisToken)source[i]);
			}
		}
	}
	
	void increaseListSize(){
		int newTokenArraySize=tokenArray.length*2;
		Token[] newTokenArray=new Token[newTokenArraySize];
		copyElements(newTokenArray,tokenArray,tokenArray.length);//to be fixed
		tokenArray=newTokenArray;
	}
	 
	public void add(Token token){//change implementation to support arbitrarily long lists
		if(numberOfElements==tokenArray.length){
			increaseListSize();
		}
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
