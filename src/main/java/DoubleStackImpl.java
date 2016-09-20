
public class DoubleStackImpl implements DoubleStack{

	static final int INITIAL_MAX_NUMBER_OF_ELEMENTS=1;
	Double[] stackArray;
	int numberOfElements;
	
	DoubleStackImpl(){
		stackArray=new Double[INITIAL_MAX_NUMBER_OF_ELEMENTS];
		numberOfElements=0;
	}
	
	DoubleStackImpl(DoubleStackImpl source){
		stackArray=new Double[source.stackArray.length];
		numberOfElements=source.numberOfElements;
		copyElements(stackArray,source.stackArray,numberOfElements);
	}
	
	void copyElements(Double[] destination, Double[] source, int numberOfElements){
		for(int i=0;i<numberOfElements;i++){
			destination[i]=source[i].doubleValue();
		}
	}
	
	void increaseStackSize(){
		int newStackArraySize=stackArray.length*2;
		Double[] newStackArray=new Double[newStackArraySize];
		copyElements(newStackArray,stackArray,stackArray.length);//to be fixed
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
