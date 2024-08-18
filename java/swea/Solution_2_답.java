package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2_답 {

	static int T, N, M;
	static int[] score;
	static int min, max;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			score = new int[M];
			
			max = -1;
			min = M*(M+1)/2;
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < M; i++) {
				score[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i < N+1; i++) {
				int a = 1;
				int sum = 0;
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					// 연속된 정답이면 sum에 점수를 더한 뒤 점수에 1을 더하고, 아니면 1로 바꿔준다
					if(score[j] == Integer.parseInt(st.nextToken())) {
						sum += a;
						a++;
					}
					else a = 1;
				}
				max = Math.max(max, sum);
				min = Math.min(min, sum);
			}
			System.out.println("#" + t + " " + (max - min));
		}
		
		
	}

}
