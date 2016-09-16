import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main implements CalculatorInterface {
	static final String OPERATOR_TOKENS = "+-*/^";
	static final String ADDITION = "+";
	static final String SUBTRACTION = "-";
	static final String MULTIPLICATION = "*";
	static final String DIVISION = "/";
	static final String POWER = "^";
	static final String PARENTHESIS_TOKENS = "()";

    public TokenList readTokens(String input) {
        TokenListImpl result = new TokenListImpl(); 
        
        Scanner in = new Scanner(input);
        
        while(in.hasNext()){
        	String token = in.next();
        	
        	if(tokenIsDouble(token)){
        		result.add(parseNumber(token));
        	} else if(tokenIsOperator(token)){
        		result.add(parseOperator(token));
        	}else if(tokenIsParenthesis(token)){
        		result.add(parseParenthesis(token));
        	}else{
        		//Error
        		System.out.println("Input invalid, try again");
        	}
        	
        	
        }
        // read token from input put it in result;
        return result;
    }
    
    public Token parseOperator(String token){	
		return new OperatorToken(token);
	}

	public Token parseParenthesis(String token){	
		return new ParenthesisToken(token);
	}

	public Token parseNumber(String token){
		return new NumberToken(Double.parseDouble(token));
	}

	public boolean tokenIsOperator(String token){
    	Scanner in = new Scanner(token);
    	return OPERATOR_TOKENS.contains(in.next()); // not sure if this works
    }
    
    public boolean tokenIsDouble(String token){	
    	Scanner in = new Scanner(token);
    	return in.hasNextDouble();
    }
    
    public boolean tokenIsParenthesis(String token){
    	Scanner in = new Scanner(token);
    	return PARENTHESIS_TOKENS.contains(in.next()); // not sure if this works
    }
    
    
    public Double rpn(TokenList tokens) {
        DoubleStack stack = new DoubleStackImpl();
        
        for(int i=0; i<tokens.size();i++){
        	Token token = tokens.get(i);
        	
        	if(token.getType()==Token.NUMBER_TYPE){
        		stack.push(Double.parseDouble(token.getValue()));
        	}
        	else if(token.getType()== Token.OPERATOR_TYPE){
        		double first = stack.pop();
        		double second = stack.pop();
        		
        		if(token.getValue().equals(ADDITION)){
        			stack.push(first + second);
        		}
        		else if(token.getValue().equals(SUBTRACTION)){
        			stack.push(second - first);
        		}
        		else if(token.getValue().equals(MULTIPLICATION)){
          			stack.push(first * second);
           		}
        		else if(token.getValue().equals(DIVISION)){
          			stack.push(second / first);
           		}
        		else if(token.getValue().equals(POWER)){
          			stack.push(Math.pow(second, first));
           		}
        	}
        	
        }
    	if(stack.size()==1){
    		return stack.pop();
    	}
    	else{
    		System.out.println("An error occured");
    		return null;
    	}
    }

    public TokenList shuntingYard(TokenList tokens) {
        return null;
    }
    
    boolean equals(Token obj){
    	
    	return true;
    }
    
    private void start() {
    	Scanner in = new Scanner(System.in);
    	while(in.hasNext()){
    		TokenListImpl example = (TokenListImpl) readTokens(in.nextLine());
//    		for(int i= 0; i<example.size();i++){
//    			System.out.println(example.tokenRow[i].getType());
//    		}
    		System.out.println(rpn(example));
    		
    		
    	}
        // Create a scanner on System.in
        
        // While there is input, read line and parse it.
    }

    public static void main(String[] argv) {
        new Main().start();
    }
}
