import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main implements CalculatorInterface{
	
	static final String OPERATOR_TOKENS="+-*/^";
	static final String PARENTHESIS_TOKENS="()";
	static final String ADDITION="+";
	static final String SUBTRACTION="-";
	static final String MULTIPLICATION="*";
	static final String DIVISION="/";
	static final String POWER="^";
	static final String LEFT_PARENTHESIS="(";
	static final String RIGHT_PARENTHESIS=")";
	
	PrintStream out;
	InputStream in;
	
	Main(){
		out=System.out;
		in=System.in;
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
    	Scanner tokenScanner=new Scanner(token);
    	return OPERATOR_TOKENS.contains(tokenScanner.next());
    }
	
	public boolean tokenIsDouble(String token){	
    	Scanner tokenScanner=new Scanner(token);
    	return tokenScanner.hasNextDouble();
    }
	
	public boolean tokenIsParenthesis(String token){
    	Scanner tokenScanner=new Scanner(token);
    	return PARENTHESIS_TOKENS.contains(tokenScanner.next());
    }
	
	public TokenList readTokens(String expression){
		TokenListImpl result=new TokenListImpl();
		Scanner expressionScanner=new Scanner(expression);
		
		while(expressionScanner.hasNext()){
			String token=expressionScanner.next();
			
			if(tokenIsDouble(token)){
				result.add(parseNumber(token));
			}else if(tokenIsOperator(token)){
				result.add(parseOperator(token));
			}else if(tokenIsParenthesis(token)){
				result.add(parseParenthesis(token));
			}else{
				out.println("Input invalid, try again");//Error
			}
		}
		return result;
	}
	
	public TokenList shuntingYard(TokenList expression){
		TokenList rpnExpression=new TokenListImpl();
		TokenStack operatorStack=new TokenStackImpl();
		
		for(int i=0;i<expression.size();i++){
			Token token=expression.get(i);
			if(token.getType()==Token.NUMBER_TYPE){
				rpnExpression.add(token);
			}else if(token.getType()==Token.OPERATOR_TYPE){
				while(!(operatorStack.size()==0) && token.getPrecedence()<=operatorStack.top().getPrecedence()){
					rpnExpression.add(operatorStack.pop());
				}
				operatorStack.push(token);
			}
			if(token.getValue().equals(LEFT_PARENTHESIS)){
				operatorStack.push(token);
			}
			if(token.getValue().equals(RIGHT_PARENTHESIS)){
				while(!operatorStack.top().getValue().equals(LEFT_PARENTHESIS)){
					rpnExpression.add(operatorStack.pop());
				}
				operatorStack.pop();
			}
		}
		while(!(operatorStack.size()==0)){
			rpnExpression.add(operatorStack.pop());
		}
		return rpnExpression;
	}
	
	public Double rpn(TokenList rpnExpression){
		DoubleStack stack=new DoubleStackImpl();
		
		for(int i=0; i<rpnExpression.size();i++){
			Token token=rpnExpression.get(i);
			
			if(token.getType()==Token.NUMBER_TYPE){
				stack.push(Double.parseDouble(token.getValue()));
			}else if(token.getType()==Token.OPERATOR_TYPE){
				double first=stack.pop();
				double second=stack.pop();
				
				if(token.getValue().equals(ADDITION)){
					stack.push(first+second);
				}else if(token.getValue().equals(SUBTRACTION)){
					stack.push(second-first);
				}else if(token.getValue().equals(MULTIPLICATION)){
					stack.push(first*second);
				}else if(token.getValue().equals(DIVISION)){
					stack.push(second/first);
				}else if(token.getValue().equals(POWER)){
					stack.push(Math.pow(second, first));
				}
			}
		}
		if(stack.size()==1){
			return stack.pop();
		}else{
			out.println("An error occured");
			System.exit(1);
			return null;
		}
	}
	
	private void start(){
		Scanner inputScanner=new Scanner(in);
		
		while(inputScanner.hasNextLine()){
			out.println(rpn(shuntingYard(readTokens(inputScanner.nextLine()))));
		}
	}
	
	public static void main(String[] argv){
		new Main().start();
	}
}
