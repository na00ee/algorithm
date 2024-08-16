import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2_최대최소인원 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	static StringTokenizer st;
	static int T, N, min, max;
	static int m;
	static int[] score;
	
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			min = Integer.parseInt(st.nextToken());
			max = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			score = new int[N];
			
			for (int i = 0; i < N; i++) {
				score[i] = Integer.parseInt(st.nextToken());
			}
			
			// 정렬
			Arrays.sort(score);
			
			m = 1000;
			
			// 최소 인원보다 같거나 많으면서, 최대인원보다 같거나 작은 경우의 수를 구함
			// 이 때 각 분반의 최솟값이 같아야 함
			
			// 앞에서부터 차례대로 숫자를 꺼낸 후, 해당 
//			root : for (int i = min; i < N-min; i++) {
//				int a = 0;
//				for (int r = 0; r < i; r++) {
//					if (score[r] == score[r+1]) {
//						continue root;
//					} else a += r;
//				}
//				
//				for (int r = i; r < N; r++) {
//					if (score[r] == score[r+1]) {
//						r++;
//					} else a -= r;
//				}
//				
//				
//			}
			
			// 첫 번째 분반
			for (int i = min; i < N-min; i++) {
				if (score[i-1]==score[i]) {
					continue;
				}
				// 두 번째 분반
				for (int j = i+min; j < N; j++) {
					int n = 0;
					int l = 0;
					
					if(score[j-1]==score[j]) {
						continue;
					} else if (j-i > max || N-1-j > max) {
						continue;
					}
					
					if (j > N-min) {
						m = Math.min(N-i, m);
					} else {
						n = Math.max(i, Math.max(j-i, N-j));
						l = Math.min(i, Math.min(j-i, N-j));
						m = Math.min(n - l, m);
//						System.out.println(n + " " + l);
//						System.out.println(i + " " + j);
					}
				}
			}
			if (m==1000) m = -1;
			
			sb.append(m);
			System.out.println(sb);
		}
	}
}
