
public class TokenStackImpl implements TokenStack{
	
	static final int INITIAL_ARRAY_SIZE=100;
	
	Token[] stackArray;
	int numberOfElements;

	TokenStackImpl(){
		stackArray=new Token[INITIAL_ARRAY_SIZE];
		numberOfElements=0;
	}
	
	TokenStackImpl(TokenStackImpl source){
		stackArray=new Token[source.stackArray.length];
		numberOfElements=source.numberOfElements;
		stackArray=copyElements(stackArray,source.stackArray,numberOfElements);
	}
	
	Token[] copyElements(Token[] destination, Token[] source, int numberOfElements){
		for(int i=0;i<numberOfElements;i++){
			destination[i]=source[i];
		}
		return destination;
	}
	
//	void copyElements(Token[] destination, Token[] source, int numberOfElements){
//		for(int i=0;i<numberOfElements;i++){
//			destination[i]=source[i];
//		}
//	}
	
	void increaseStackSize(){
		int newStackArraySize=stackArray.length*2;
		Token[] newStackArray=new Token[newStackArraySize];
		copyElements(newStackArray,stackArray,stackArray.length);//to be fixed
		stackArray=newStackArray;
	}
	
	@Override
	public void push(Token token){
		if(numberOfElements==stackArray.length){
			increaseStackSize();
		}
		stackArray[numberOfElements]=token;
		numberOfElements+=1;
	}

	@Override
	public Token pop(){
		numberOfElements-=1;
		return stackArray[numberOfElements];
	}

	@Override
	public Token top(){
		return stackArray[numberOfElements-1];
		//return new TokenImplementation(stackArray[numberOfElements-1]);//returns a copy of the TOS instead of the TOS itself
		//return null;
	}

	@Override
	public int size() {
		return numberOfElements;
	}
	
	public boolean isEmpty(){
		return numberOfElements==0;
	}
}
