import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_1222_계산기1 {

	static int T = 10;
	static int N;
	static int sum;
	static char[] charns;
	static Stack<Character> ops = new Stack<>();
	static Stack<Integer> nums = new Stack<>();
	static Stack<Integer> result = new Stack<>();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t < T+1; t++) {
			N = Integer.parseInt(br.readLine());
			charns = br.readLine().toCharArray();
			
//			System.out.println(infixtoPostfix(charns, N));
			System.out.println("#" + t + " " + evaluate(infixtoPostfix(charns, N), N));
			
		}
		
	}

	// 후위표기식으로 변환
	static String infixtoPostfix(char [] s, int N) {
		String postfix = "";
		for (int i = 0; i < N; i++) {
			char c = s[i];
			
			if (c == '+') {
				// 더하기 기호를 stack에 넣음
				ops.push(c);
			} else {
				// 숫자를 stack에 넣음
				postfix+=c;
				if (!ops.isEmpty()) postfix+=ops.pop();
			}	
		}
		return postfix;
	}
	
	// 변환한 후위표기식으로 더함
	static int evaluate(String postfix, int N) {
		sum = 0;
		for (int i = 0; i < N; i++) {
			char c = postfix.charAt(i);
			if (c!='+') {
				result.push(c-'0');
			}
		}
		while(!result.isEmpty()) sum += result.pop();
		return sum;
	}
	
}
