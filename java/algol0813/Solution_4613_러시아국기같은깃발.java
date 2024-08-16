import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4613_러시아국기같은깃발 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	static StringTokenizer st;
	static int min;
	static int cnt;
	static int T, N, M;
	static char[][] flag;
	
	public static void main(String[] args) throws Exception {
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			flag = new char[N][M];
			
			min = 2500;
			
			// 깃발 상태 받기
			for (int i = 0; i < N; i++) {
				flag[i] = br.readLine().toCharArray();
			}
			
			// 흰색의 개수를 점차 늘려가고, 파란색의 개수도 늘려가며 완탐
			for (int i = 0; i < N-2; i++) {
				for (int j = i+1; j < N-1; j++) {
					cnt = 0;
					
					// 흰색 기준 색을 얼마나 칠해야 하는지 계산
					for (int r = 0; r <= i; r++) {
						for (int c = 0; c < M; c++) {
							if(flag[r][c]!='W') cnt++;
						}
					}
					
					// 파란색 기준 색을 얼마나 칠해야 하는지 계산
					for (int r = i+1; r <= j; r++) {
						for (int c = 0; c < M; c++) {
							if(flag[r][c]!='B') cnt++;
						}
					}
					
					// 빨간색 기준 색을 얼마나 칠해야 하는지 계산
					for (int r = j+1; r < N; r++) {
						for (int c = 0; c < M; c++) {
							if(flag[r][c]!='R') cnt++;
						}
					}
					min = Math.min(min, cnt);
				}
			}
			sb.append(min);
			System.out.println(sb);
		}
	}
	
}
