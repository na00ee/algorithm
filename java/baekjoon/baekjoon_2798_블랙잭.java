package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2798_블랙잭 {

	static int N, M;
	static int max = 0;
	static int[] arr;
    static int n;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		// 초기화
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 3장의 카드를 뽑아 M보다 작은 수 중 가장 큰 수를 구함
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				for (int k = j+1; k < N; k++) {
					n = arr[i] + arr[j] + arr[k];
					if(n <= M && max < n) max = n;
				}
			}
		}
		System.out.println(max);
	}

}