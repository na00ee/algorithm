package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_1874_스택수열2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, n, cnt = 1;
	static Stack<Integer> stack = new Stack<Integer>();
	static boolean isS;
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		isS = true;
		
		for (int i = 0; i < n; i++) {
			n = Integer.parseInt(br.readLine());
			
			while (cnt <= N) {
				stack.push(cnt++);
				sb.append("+\n");
			}
			
			// 만약 stack.peek()의 값이 n과 같지 않으면 
			if (stack.peek()!=n) {
				isS = false;
				break;
			}
			
			stack.pop();
			sb.append("-\n");
			
		}
		
		if(isS) System.out.println(sb);
		else System.out.println("NO");
		
	}

}
