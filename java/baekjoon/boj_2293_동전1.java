import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2293_동전1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, k;
	static int [] coins, dp;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		coins = new int [n];
		k = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
	}

}
