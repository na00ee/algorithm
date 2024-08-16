package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2564_경비원2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int x, y;
	static int r, c;
	static int N;
	static int min;
	static int [][] map;
	
	public static void main(String[] args) throws Exception {
		
		st = new StringTokenizer(br.readLine());
		
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		N = Integer.parseInt(br.readLine());
		
		map = new int [N][2];
		
		// 1 북 2 남 3 서 4 동
		
		// 상점 위치 받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 경비원 위치 받기
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		// 1 북 2 남 3 서 4 동
		min = 0;
		for (int i = 0; i < N; i++) {
			
			if(map[i][0]==1) {
				
			}
			
		}
		System.out.println(min);
	}

}
