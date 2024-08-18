package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3_차 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int T, N, P;
	static int [][] map;
					// 상 우 하 좌
	static int [] dr = {-1, 0, 1, 0};
	static int [] dc = {0, 1, 0, -1};
	
	static int nr, nc;
	static int sum, max;
	
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			max = -1;
			map = new int[N][N];
			
			// 마을 내 바이러스 개수를 받음
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 구역을 돌면서 제거할 수 있는 바이러스의 최댓값을 갱신
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sum = map[i][j];
					int d = 0;
					int k = 1;
					int n = 0;
					while(n < 4) {
						nr = i + dr[d]*k;
						nc = j + dc[d]*k;
						
						// 인덱스 범위 내면 sum에 더함
						if(in_range(nr, nc) && k<=P) {
							sum += map[nr][nc];
							k++;
						} else {
							d = (d+1)%4;
							k = 1;
							n++;
						}
						
					}
					max = Math.max(sum, max);
				}
			}
			
			sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(max);
			System.out.println(sb);
			
		}
	}
	
	static boolean in_range(int r, int c) {
		if(r < 0 || r >= N || c < 0 || c >= N) return false;
		return true;
	}
	
}
