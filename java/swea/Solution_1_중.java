package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1_중 {

	static int T, N;
	static int [][] map;
	static int r, c;
	static int r2, c2;
	static double max;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			N = Integer.parseInt(br.readLine().trim());
			
			map = new int[N+1][N+1];
			
			for (int i = 0; i < N+1; i++) {
				
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < N+1; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					if(map[i][j]==2) {
						r = i;
						c = j;
					}
					
				}
			}
			
			max = -1;
			
			for (int i = 0; i < N+1; i++) {
				for (int j = 0; j < N+1; j++) {
					if (map[i][j]==1) {
						double d = (i-r)*(i-r) + (j-c)*(j-c);
						max = Math.max(d, max);
					}
				}
			}
			
			// 2.0 처럼 딱 맞게 떨어지는 경우를 제외
			if(Math.sqrt(max)>(int)Math.sqrt(max)) max = (int)Math.sqrt(max)+1;
			else max = (int) Math.sqrt(max);
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append((int) max);
			System.out.println(sb);
		}
		
	}

}
