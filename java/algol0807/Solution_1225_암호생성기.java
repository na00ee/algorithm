package algol0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1225_암호생성기 {

	static int T = 10;
	static int N, d;
	static int[] nums;
//	static int[] ds = {1, 2, 3, 4, 5};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for (int t = 1; t < T+1; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			
			// nums 생성으로 초기화
			nums = new int[8];
			// d도 초기화
			d = 1;
			
			for (int i = 0; i < 8; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			while(nums[7]>0) {
				// 첫 번째 숫자에 사이클대로 숫자를 빼 줌
				nums[0] -= d;
				d++;
				if(d>5) d = 0;
				int n = nums[7];
				nums[7] = nums[0];
				nums[0] = n;
				
				// 배열의 위치 변환
				for (int i = 0; i < 6; i++) {
					int j = nums[i+1];
					nums[i+1] = nums[i];
					nums[i] = j;
				}
			}
			
			for (int i = 0; i < 8; i++) {
				sb.append(nums[i]);
			}
			
			System.out.println("#" + t + " " + sb);
		}
	}

}
