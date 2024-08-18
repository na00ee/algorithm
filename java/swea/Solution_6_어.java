package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6_어 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	static StringTokenizer st;
	static int T, N, K, ans;
	static int [][] map;
	static boolean isS;
	
	
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ans = 0;
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c <= N-K; c++) {
					// isS = false;
					int cnt = 0;
					while (c < N) {
						if(map[r][c]==1) {
							cnt++;
							c++;
						} else {
							break;
						}
					}
					if (cnt == K) ans++;
				}
			}
			
			for (int c = 0; c < N; c++) {
				for (int r = 0; r <= N-K; r++) {
					// isS = false;
					int cnt = 0;
					while (r < N) {
						if(map[r][c]==1) {
							cnt++;
							r++;
						} else {
							break;
						}
					}
					if (cnt == K) ans++;
				}
			}
			sb.append("#").append(t).append(" ").append(ans);
			System.out.println(sb);
		}
	}

	static boolean in_range(int n) {
		if(n < 0 || n >= N) return false;
		return true;
	}
	
}
