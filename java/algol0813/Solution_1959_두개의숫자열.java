import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1959_두개의숫자열 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int T, N, M, n, m;
	static int[] arr, arr2;
	static int cnt, sum;
	
	public static void main(String[] args) throws Exception {
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N];
			arr2 = new int[M];
			sum = 0;
			sb = new StringBuilder();
			
//			if(N > M) {
//				arr = new int[N];
//				arr2 = new int[M];
//				n = N; m = M;
//				st = new StringTokenizer(br.readLine());
//				for (int i = 0; i < N; i++) {
//					arr[i] = Integer.parseInt(st.nextToken());
//				}
//				
//				st = new StringTokenizer(br.readLine());
//				for (int i = 0; i < M; i++) {
//					arr2[i] = Integer.parseInt(st.nextToken());
//				}
//			} else {
//				arr = new int[M];
//				arr2 = new int[N];
//				n = M; m = N;
//				st = new StringTokenizer(br.readLine());
//				for (int i = 0; i < N; i++) {
//					arr2[i] = Integer.parseInt(st.nextToken());
//				}
//				
//				st = new StringTokenizer(br.readLine());
//				for (int i = 0; i < M; i++) {
//					arr[i] = Integer.parseInt(st.nextToken());
//				}
//			}
			
			// 각각의 배열을 받아서 슬라이딩 원도우 형식으로 풀어보기
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				arr2[i] = Integer.parseInt(st.nextToken());
			}
			
			// N과 M 중 더 큰 값을 구하고 슬라이딩 윈도우로 최대값 구하기
			if(N > M) {
				for (int i = 0; i < N-M+1; i++) {
					cnt = 0;
					for (int j = 0; j < M; j++) {
						cnt += arr[i+j] * arr2[j];
					}
					sum = Math.max(sum, cnt);
				}
			} else {
				for (int i = 0; i < M-N+1; i++) {
					cnt = 0;
					for (int j = 0; j < N; j++) {
						cnt += arr[j] * arr2[i+j];
					}
					sum = Math.max(sum, cnt);
				}
			}
			
//			for (int i = 0; i < n-m+1; i++) {
//				cnt = 0;
//				for (int j = 0; j < m; j++) {
//					cnt += arr[i+j] * arr2[j];
//				}
//				sum = Math.max(sum, cnt);
//			}
			
			sb.append("#" + t + " " + sum);
			System.out.println(sb);
			
		}
		
	}

}
