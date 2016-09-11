
public class DoubleStackImplementation implements DoubleStack{

	static final int INITIAL_ARRAY_SIZE=100;
	Double[] stackArray;
	int numberOfElements;
	
	DoubleStackImplementation(){
		stackArray=new Double[INITIAL_ARRAY_SIZE];
		numberOfElements=0;
	}
	
	DoubleStackImplementation(DoubleStackImplementation source){
		stackArray=new Double[source.stackArray.length];
		numberOfElements=source.numberOfElements;
		copyElements(stackArray,source.stackArray,numberOfElements);
	}
	
	void copyElements(Double[] destination, Double[] source, int numberOfElements){
		for(int i=0;i<numberOfElements;i++){
			destination[i]=source[i];
		}
	}
	
	void increaseStackSize(){
		int newStackArraySize=stackArray.length*2;
		Double[] newStackArray=new Double[newStackArraySize];
		copyElements(newStackArray,stackArray,stackArray.length);
		stackArray=newStackArray;
	}
	
	@Override
	public void push(Double element) {
		if(numberOfElements==stackArray.length){
			increaseStackSize();
		}
		stackArray[numberOfElements]=element;
		numberOfElements+=1;
	}

	@Override
	public Double pop() {
		numberOfElements-=1;
		return stackArray[numberOfElements];
	}

	@Override
	public Double top() {
		return stackArray[numberOfElements-1];
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
