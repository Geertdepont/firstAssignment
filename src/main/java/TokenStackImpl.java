public class TokenStackImpl implements TokenStack{
	
	private static final int INITIAL_MAX_NUMBER_OF_ELEMENTS=10;
	
	private Token[] stackArray;
	private int numberOfElements;

	TokenStackImpl(){
		stackArray=new Token[INITIAL_MAX_NUMBER_OF_ELEMENTS];
		numberOfElements=0;
	}
	
	private void copyElements(Token[] destination, Token[] source, int numberOfElements){
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
	
	private void increaseStackSize(){
		int newStackArraySize=stackArray.length*2;
		Token[] newStackArray=new Token[newStackArraySize];
		copyElements(newStackArray,stackArray,stackArray.length);
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
		if(stackArray[numberOfElements-1].getType()==Token.NUMBER_TYPE){
			return new NumberToken((NumberToken)stackArray[numberOfElements-1]);
		}else if(stackArray[numberOfElements-1].getType()==Token.OPERATOR_TYPE){
			return new OperatorToken((OperatorToken)stackArray[numberOfElements-1]);
		}else{//parenthesis token
			return new ParenthesisToken((ParenthesisToken)stackArray[numberOfElements-1]);
		}
	}

	@Override
	public int size() {
		return numberOfElements;
	}
	
}
