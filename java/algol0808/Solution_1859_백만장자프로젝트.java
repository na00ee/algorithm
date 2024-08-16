package algol0808;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1859_백만장자프로젝트{
	static int T;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			long sum = 0;
			int max = arr[N-1];
			for (int i = N-1; i >= 0; i--) {
				if (max > arr[i]) {
					sum += max - arr[i];
				}else {
					max = arr[i];
				}
			}
			System.out.printf("#%d %d\n", t+1, sum);
		}
	}
}