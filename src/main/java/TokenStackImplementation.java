
public class TokenStackImplementation implements TokenStack{
	
	static final int INITIAL_ARRAY_SIZE=100;
	Token[] stackArray;
	int numberOfElements;

	TokenStackImplementation(){
		stackArray=new Token[INITIAL_ARRAY_SIZE];
		numberOfElements=0;
	}
	
	TokenStackImplementation(TokenStackImplementation source){
		stackArray=new Token[source.stackArray.length];
		numberOfElements=source.numberOfElements;
		copyElements(stackArray,source.stackArray,numberOfElements);
	}
	
	void copyElements(Token[] destination, Token[] source, int numberOfElements){
		for(int i=0;i<numberOfElements;i++){
			destination[i]=source[i];
		}
	}
	
	void increaseStackSize(){
		int newStackArraySize=stackArray.length*2;
		Token[] newStackArray=new Token[newStackArraySize];
		copyElements(newStackArray,stackArray,stackArray.length);
		stackArray=newStackArray;
	}
	
	@Override
	public void push(Token token) {
		if(numberOfElements==stackArray.length){
			increaseStackSize();
		}
		stackArray[numberOfElements]=token;
		numberOfElements+=1;
	}

	@Override
	public Token pop() {
		numberOfElements-=1;
		return stackArray[numberOfElements];
	}

	@Override
	public Token top() {
//		return new TokenImplementation(stackArray[numberOfElements-1]);//returns a copy of the TOS instead of the TOS itself
		return null;
	}

	@Override
	public int size() {
		return numberOfElements;
	}
	
	//We probably need to add this to the interface, if we need it at all
	boolean isEmpty(){
		return numberOfElements==0;
	}

}
