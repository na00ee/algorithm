package algol0805;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_1223 {

	static int N;
	static String s;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<String> stack = new Stack<>();
		
		for (int t = 1; t < 5; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				stack.push(st.nextToken());
				System.out.println(st.nextToken());
			}
		}
		
		for (int i = 0; i < stack.size(); i++) {
			System.out.println(stack.pop());
		}
//		System.out.println(stack.peek());
		
	}

}
