import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_6190_정곤이의단조증가하는수 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T, N;
	static int[] arr;
	static int max;
	static String s;
	static boolean isS;
	
	public static void main(String[] args) throws Exception {
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			
			// 초기화
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			sb = new StringBuilder();
			max = -1;
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// 완탐문제인 듯,,,
//			for (int i = N-1; i >= 0; i--) {
//				for (int j = i-1; j >= 0; j--) {
//					isS = true;
//					s = arr[i] * arr[j] + "";
//					for (int k = 0; k < s.length()-1; k++) {
//						if(s.charAt(k) > s.charAt(k+1)) {
//							isS = false;
//							break;
//						}
//					} if (isS) max = Math.max(max, arr[i] * arr[j]);
//				}
//			}
			
			// 종하님 ver
			for (int i = N-1; i >= 0; i--) 
				r : for (int j = i-1; j >= 0; j--) {
					int n = arr[i] * arr[j];
					int m = n%10;
					n/=10;
					while (n > 0) {
						if (m < n%10) {
							continue r;
						}
						m = n%10;
						n/=10;
					}
					max = Math.max(max, arr[i] * arr[j]);
				}
			
			// 뒤에서부터 값을 찾아나감 => 1 2 7 8 9의 경우 가장 큰 값이 56이어야 하지만 2 * 9 = 18이 나옴
			// 이렇게 하면 가장 큰 값을 찾을 수 없음
//			for (int i = N-1; i >= 0; i--) {
//				for (int j = i-1; j >= 0; j--) {
//					isS = true;
//					// 곱한 값을 문자열로 바꾼 뒤 각각의 자릿수 값의 크기 비교
//					s = arr[i] * arr[j] + "";
//					// 만약 현재 문자가 다음 문자보다 크면 return false
//					for (int k = 0; k < s.length()-1; k++) {
//						if(s.charAt(k)-'0' > s.charAt(k+1)-'0') {
//							isS = false;
//							break;
//						}
//					}
//					if (isS) {
//						max = arr[i] * arr[j];
//						break;
//					}
//				}
//				if (isS) break;
//			}
			
			sb.append(String.format("#%d %d", t, max));
			System.out.println(sb);
			
		}

	}

}
