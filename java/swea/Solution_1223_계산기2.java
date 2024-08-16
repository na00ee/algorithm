import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution_1223_계산기2 {

	static int N;
	static char[] charns;
	static String postfix;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t < 11; t++) {
			
			N = Integer.parseInt(br.readLine());
			charns = br.readLine().toCharArray();
			
			System.out.println(infixToPostfix(charns, N));
			System.out.println("#" + t + " " + evaluate(infixToPostfix(charns, N), N));
		}
		
	}
	
	// 후위연산식을 통해 연산 진행
	static int evaluate(String postfix, int N) {
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			char c = postfix.charAt(i);
			// 숫자면 stack에 push
			if(c >= '0' && c <= '9') {
				stack.push(c -'0');
			} else {
				// stack에 들어간 숫자 num을 꺼냄
				int num2 = stack.pop();
				int num1 = stack.pop();
				int result;
				
				// 연산자면 더하거나 곱한 뒤 해당 값을 stack에 넣음
				if (c=='*') result = num1 * num2;
				else result = num1 + num2;
				
				stack.push(result);
			}
		}
		
		return stack.pop();
	}
	
	// 연산자들의 우선순위를 저장할 Map 선언
	static Map<Character, Integer> map = new HashMap<>();
	
	static {
		map.put('+', 1);
		map.put('*', 2);
	}
	
	// 후위연산식으로 변경
	static String infixToPostfix(char[] s, int N) {
		// 후위연산식으로 return할 변수 postfix 초기화
		postfix = "";
		
		// 연산자를 push할 <char> stack 선언
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			// char 단위로 받을 변수 c 선언
			char c = s[i];
			
			// 숫자면 postfix에 바로 추가
			if (c >= '0' && c <='9') {
				postfix+=c;
				// 문자열이 끝났을 때 stack에 남아있는 연산자를 모두 추가해야 함
				if (i == N-1 && !stack.isEmpty()) {
					while(!stack.isEmpty()) {
						postfix+=stack.pop();
					}
				}
			
			}
			// 숫자가 아니면 우선순위 확인 후 stack에 넣거나 postfix에 추가
			else {
				// stack이 비어있지 않고
				// 현재 연산자가 top에 있는 연산자보다 우선순위가 낮은 경우
				// top에 있는 연산자를 postfix에 추가
				// stack에 남아있는 모든 연산자 중에서 c보다 우선순위가 같거나 높은 경우
				// 모두 postfix에 추가해야 함
				while (!stack.isEmpty() &&
					map.get(stack.peek()) >= map.get(c)) {
					postfix += stack.pop();
				}
				stack.push(c);
			}
		}
		
		return postfix;
		
	}

}
