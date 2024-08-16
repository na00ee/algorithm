package algol0805;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1224 {
    static int T = 10;
    static int N;
	public static void main(String[] args) throws Exception{
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t < T+1; t++){
         	N = Integer.parseInt(br.readLine());
            String expression = br.readLine();
            System.out.println("#" + t + " " + evaluate(expression));
        }
		
	}
	
	static int evaluate(String expression) {
		String postfix = infixToPostfix(expression);
		return evalPostfix(postfix);
	}
	
	// Map을 메서드 안에 넣으면 호출할 때마다 map이 선언되므로 static으로 따로 빼 준다
	static Map<Character, Integer> map = new HashMap<>();
	static {
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);
		// 여는 괄호는 굳이 우선순위를 주지 않아도 된다
	}
	
	static String infixToPostfix(String infix) {
		
		String postfix = "";
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			
			// 피연산자가 나오면 바로 출력
			if ('0' <= c && c <= '9') {
				postfix += c;
			} else if (c == '(') {
				// 여는 괄호는 스택에 push
				stack.push(c);
			} else if (c == ')') {
				// 닫는 괄호는 여는 괄호가 나올 때까지 pop
				char popItem = stack.pop();
				while (popItem != '(') {
					postfix += popItem;
					popItem = stack.pop();
				}
			} else {
				// 연산자
				// 스택의 마지막에
				// 우선순위가 낮은 연산자가 올 때까지 pop
				while (!stack.isEmpty() && 
						stack.peek()!='(' && 
						map.get(stack.peek()) >= map.get(c)) {
					
					char popItem = stack.pop();
					postfix += popItem;
					
				}
				
				stack.push(c);
			}
		}
		
		// 스택 비워주기
		while (!stack.isEmpty()) {
			postfix += stack.pop();
		}
		
		return postfix;
	}
	
	static int evalPostfix(String postfix) {
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);
			
			if('0' <= c && c <= '9') {
				stack.push(c - '0');
			} else {
				int num2 = stack.pop();
				int num1 = stack.pop();
				int result;
				
				if (c == '+') {
					result = num1 + num2;
				} else if (c == '-') {
					result = num1 - num2;
				} else if (c == '*') {
					result = num1 * num2;
				} else {
					result = num1 / num2;
				}
				stack.push(result);
			}
		}
		
		return stack.pop();
	}
	
}