package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_1874_스택수열 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, n, m = 0;
	static Stack<Integer> stack = new Stack<Integer>();
	static boolean isS;
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		isS = true;
		
		for (int i = 0; i < N; i++) {
			n = Integer.parseInt(br.readLine());
			
			// n보다 크면 이후 값들이 수열에 추가될 수 없으므로 NO
			if (!stack.empty() && stack.peek() > n) {
				isS = false;
				break;
			}
			
			// 0 혹은 마지막으로 push된 숫자를 기준으로 push 되게 함
			for (int j = m; j < n; j++) {
				stack.push(j+1);
				sb.append("+\n");
			}
			
			m = Math.max(m, n);
			
			stack.pop();
			sb.append("-\n");
			
		}
		
		if(isS) System.out.println(sb);
		else System.out.println("NO");
		
	}

}
