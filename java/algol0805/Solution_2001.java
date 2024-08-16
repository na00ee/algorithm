package algol0805;

import java.util.Scanner;

public class Solution_2001 {

	static int T;
	static int N;
	static int M;
	static int[][] map;
	static int max;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for (int t = 1; t < T+1; t++) {
			max = -1;
			
			N = sc.nextInt();
			M = sc.nextInt();
			
			map = new int[N+1][N+1];
			
			// 누적합 배열 계산
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					int num = sc.nextInt();
					map[i][j] = num + map[i-1][j] + map[i][j-1] - map[i-1][j-1];
				}
			}
			
			// 범위 내 누적합 중 최댓값 계산
			for (int i = M; i < N+1; i++) {
				for (int j = M; j < N+1; j++) {
					max = Math.max(max, map[i][j] - map[i][j-M] - map[i-M][j] + map[i-M][j-M]);
				}
				
			}
			
			System.out.println("#" + t + " " + max);
		}
		
	}

	
}
