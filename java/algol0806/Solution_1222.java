package algol0806;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_1222 {

	static int T = 10;
	static int N;
	static int sum;
	static char[] charns;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			sum = 0;
			charns = new char[N];
			Stack<Character> ops = new Stack<>();
			Stack<Integer>	 nums = new Stack<>();
			Stack<Integer>	 results = new Stack<>();
			for (int i = 0; i < N; i++) {
				if(charns[i]=='+') {
					ops.push(charns[i]);
				} else {
					nums.push(charns[i]-'0');
				}
			}
			
			while(!ops.isEmpty()) {
				int A = nums.pop();
				char op = ops.pop();
				if (op=='+') {
					results.push(A);
				}
				if(ops.size()==0 && nums.size()!=0) {
					results.push(nums.pop());	// 왜 A가 안 되는지?
				}
			}
			
			while(!results.isEmpty()) {
				sum+=results.pop();
			}
			System.out.println("#" + t + " " + sum);
			
		}
	}

}
