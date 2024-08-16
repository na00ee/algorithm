

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_10760_우주선2 {

	static int T, N, M;
	static int[][] map;
	static int sum, cnt;
	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int nr, nc, d;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			// 초기화
			map = new int[N][M];
			nr = 0;
			nc = 0;
			sum = 0;
			
			// map에 지형 정보 저장
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < M; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					cnt = 0;
					for(int i = 0; i < 8; i++) {
						nr = r + dr[i];
						nc = c + dc[i];
						
						if(in_range(N, M, nr, nc)) {
							if(map[r][c] > map[nr][nc]) {
								cnt++;
							}
						}
					}
					if(cnt >= 4) sum++;
				}
			}
			System.out.println("#" + t + " " + sum);
		}
		
	}
	
	// 인덱스 범위 체크
	static boolean in_range(int N, int M, int r, int c) {
		if(r >= 0 && r < N && c >= 0 && c < M) {
			return true;
		}
		return false;
	}

}
