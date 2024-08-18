package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5_C {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	static StringTokenizer st;
	static int T, N, K;
	static char[] sample, passCode;
	
	public static void main(String[] args) throws Exception {
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			
			sb = new StringBuilder();
			
			sb.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			sample = br.readLine().replace(" ", "").toCharArray();
			passCode = br.readLine().replace(" ", "").toCharArray();
			
			int d = N-1;
			
			for (int i = K-1; i >= 0; i--) {
				for (int j = d; j >= 0; j--) {
					if(sample[j] == passCode[i]) {
						K--;
						d = j-1;
						break;
					}
				}
			}
			if (K<=0) sb.append(1);
			else sb.append(0);
			System.out.println(sb);
		}
	}

}
