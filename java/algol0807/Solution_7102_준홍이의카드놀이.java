package algol0807;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7102_준홍이의카드놀이 {
	
	static int T, N, M;
	static int[] arr;
	static int max;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			max = 0;
			arr = new int[N+M+1];
			
			for (int n = 1; n < N+1; n++) {
				for (int m = 1; m < M+1; m++) {
					arr[n+m]++;
				}
			}
			
			
			// 배열의 최댓값을 구해 줌
			for (int i = 0; i < arr.length; i++) {
				if(max<arr[i]) max = arr[i];
			}
			
			System.out.print("#" + t + " ");
			
			// 최댓값들의 인덱스를 출력함
			for (int i = 0; i < arr.length; i++) {
				if(arr[i]==max) System.out.print(i + " ");
			}
			
			System.out.println();
		}
		
	}
}
