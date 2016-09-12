import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main implements CalculatorInterface {
	static final String OPERATOR_TOKENS = "+-*/^";
	static final String PARENTHESIS_TOKENS = "()";

    public TokenList readTokens(String input) {
        TokenListImplementation result = new TokenListImplementation(); 
        
        Scanner in = new Scanner(input);
        
        while(in.hasNext()){
        	String token = in.next();
        	
        	if(tokenIsDouble(token)){
        		result.add(parseNumber(token));
        	} else if(tokenIsOperator(token)){
        		result.add(parseOperator(token));
        	}else if(tokenIsParenthesis(token)){
        		result.add(parseParenthesis(token));
        	}
        	
        	
        	
        }
        // read token from input put it in result;
        return result;
    }
    
    public Token parseOperator(String token){	
		return null;
	}

	public Token parseParenthesis(String token){	
		return null;
	}

	
	public Token parseNumber(String token){
		return null;
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
        return null;
    }

    public TokenList shuntingYard(TokenList tokens) {
        return null;
    }

    private void start() {
    	Scanner in = new Scanner(System.in);
    	while(in.hasNext()){
    		readTokens(in.nextLine());
    	}
        // Create a scanner on System.in
        
        // While there is input, read line and parse it.
    }

    public static void main(String[] argv) {
        new Main().start();
    }
}
