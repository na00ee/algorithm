import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11399_ATM {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, sum, cnt;
	static int[] time;
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		time = new int [N];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			time [i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time);
		
		for (int i = 0; i < N; i++) {
			sum += time [i];
			cnt += sum;
		}
		
		System.out.println(cnt);
	}

	
	
}
