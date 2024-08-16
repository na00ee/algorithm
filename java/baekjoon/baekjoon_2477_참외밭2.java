package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2477_참외밭2 {

	static int N, M, max;
	static int[] melon = new int[7];
	static int sum;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		max = -1;
		int index = 0;
		sum = 0;
		
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			index = Integer.parseInt(st.nextToken());
			melon[i] = Integer.parseInt(st.nextToken());
			
		}
		
		melon[6] = melon[0];
		
		for (int i = 0; i < 6; i++) {
			sum += melon[i + 1] * melon[i];
			max = Math.max(max, melon[i + 1] * melon[i]);
		}
		
		System.out.println((max - (3*max - sum)) * N);
		
	}

}
