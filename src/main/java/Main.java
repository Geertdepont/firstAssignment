import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main implements CalculatorInterface {


    public TokenList readTokens(String input) {
        TokenList result = new TokenListImplementation(); 
        // read token from input put it in result;
        return result;
    }
    
    public boolean tokenIsOperator(String token){
    	
    	
    	return true;
    }
    
    public boolean tokenIsDouble(String token){	
    	TokenImplementation something = new TokenImplementation(5.5);
    	return something.getType()==Token.NUMBER_TYPE;
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
