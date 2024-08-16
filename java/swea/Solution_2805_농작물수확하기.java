

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_2805_농작물수확하기 {

	static int T, N;
	static int[][] arr;
	static long sum;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		
		
		for (int t = 1; t < T+1; t++) {
			N = Integer.parseInt(br.readLine());
			// sum 초기화
			sum = 0;
			arr = new int[N][N];
			
			// 받은 문자열을 숫자 배열에 삽입
			for (int i = 0; i < N; i++) {
				String[] s = br.readLine().split("");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(s[j]);
				}
			}
			
			// 다이아몬드 형태로 땅의 값을 더함
			for (int i = 0; i < N; i++) {
				for (int j = Math.abs(N/2-i); j < N - Math.abs(i-N/2); j++) {
					sum += arr[i][j];
				}
			}
			System.out.println("#" + t + " " + sum);
		}
		
	}

}
