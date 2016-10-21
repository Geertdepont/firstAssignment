public class DoubleStackImpl implements DoubleStack{

	private static final int INITIAL_MAX_NUMBER_OF_ELEMENTS=10;
	
	private Double[] stackArray;
	private int numberOfElements;
	
	DoubleStackImpl(){
		stackArray=new Double[INITIAL_MAX_NUMBER_OF_ELEMENTS];
		numberOfElements=0;
	}
	
	private void copyElements(Double[] destination, Double[] source, int numberOfElements){
		for(int i=0;i<numberOfElements;i++){
			destination[i]=source[i].doubleValue();
		}
	}
	
	private void increaseStackSize(){
		int newStackArraySize=stackArray.length*2;
		Double[] newStackArray=new Double[newStackArraySize];
		copyElements(newStackArray,stackArray,stackArray.length);
		stackArray=newStackArray;
	}
	
	@Override
	public void push(Double element){
		if(numberOfElements==stackArray.length){
			increaseStackSize();
		}
		stackArray[numberOfElements]=element;
		numberOfElements+=1;
	}

	@Override
	public Double pop(){
		numberOfElements-=1;
		return stackArray[numberOfElements];
	}

	@Override
	public Double top(){
		return new Double(stackArray[numberOfElements-1].doubleValue());
	}

	@Override
	public int size(){
		return numberOfElements;
	}
}
