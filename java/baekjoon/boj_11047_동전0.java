import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11047_동전0 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, K, cnt;
	static int[] coin;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		coin = new int [N];
		
		// 동전 가치를 받음
		for (int i = 0; i < N; i++) {
			coin [i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = N-1; i >= 0; i--) {
			if (coin[i] <= K) {
				cnt += K/coin[i];
				K -= coin[i] * (K/coin[i]);
			}
			if (K <= 0) break;
		}
		System.out.println(cnt);
	}

}
