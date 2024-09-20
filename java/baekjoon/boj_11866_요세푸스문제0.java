import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11866_요세푸스문제0 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, K, cnt, n, distance;
	static boolean [] visited;
	static int [] arr;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int [N];
				
		for (int i = 0; i < N; i++) {
			distance = K;
			while (distance>0) {
				if (arr [i] != 0) {
					n = (n + 1 > N-1) ? 0 : n+1;
					continue;
				}
				arr [i] = n;
				cnt++;
				n = (n + 1 > N-1) ? 0 : n+1;
				distance--;
			}
		}
	}

}
