

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_1218 {

	static int T = 10;
	static int N;
	static String s;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t < T+1; t++) {
			N = Integer.parseInt(br.readLine());
			s = br.readLine();
			System.out.println("#" + t + " " + infixToPostfix(s, N));
			
		}
	}

	static int infixToPostfix(String infix, int N) {
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			char c = infix.charAt(i);
			
			// stack이 비어있는 경우
			if(stack.isEmpty()) {
				// 왼쪽 괄호가 들어오면 push
				if (check1(c)) stack.push(c);
				// 오른쪽 괄호가 들어오면 return 0
				else return 0;
			// stack이 비어있지 않은 경우
			} else {
				// 왼쪽 괄호가 들어오면 push
				if (check1(c)) stack.push(c);
				else {
					// 오른쪽 괄호가 들어올 때 top에 위치한 요소와 괄호 짝이 맞지 않으면 return 0
					if(!check2(stack.pop(), c)) {
						return 0;
					}
				}
			}
		}
		return 1;
	}
	
	// 오른쪽 괄호인지 확인
	static boolean check1(char c) {
		if (c == ')' || c == ']' || c == '}' || c == '>') return false;
		return true;
	}
	
	// 오른쪽 괄호가 push하려 한다면, 괄호의 짝이 맞는지 확인
	static boolean check2(char pop, char push) {
		if ((pop=='(' && push==')') || (pop=='[' && push==']') || (pop=='{' && push=='}') || (pop=='<' && push=='>')) {
			return true;
		}
		return false;
	}
	
}
