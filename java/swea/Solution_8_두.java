package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_8_두 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	static StringTokenizer st;
	static int T, N, M1, M2, answer, d;
	static Integer[] arr;
	
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M1 = Integer.parseInt(st.nextToken());
			M2 = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			// 초기화
			arr = new Integer [N];
			answer = 0;
			
			// 블록의 무게
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// 내림차순 정렬
			Arrays.sort(arr, Collections.reverseOrder());
			
			d = 1;
			
			for (int i = 0; i < N; i++) {
				answer += arr[i] * d;
				if(i+1<=M1*2 && i+1<=M2*2 &&i%2==0) continue;
				d++;
			}
			sb.append(answer);
			System.out.println(sb);
		}
	}

}
