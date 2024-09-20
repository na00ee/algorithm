import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_25342_최대최소공배수_김나영 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, N, min;
    static int [] nums;
    static boolean [] visited;
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			nums = new int [3];
			N = Integer.parseInt(br.readLine());
			visited = new boolean [N];
			
			combi(0, N);
		}
	}
	static void combi(int cnt, int start) {
		if (cnt == 3) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		for (int i = start; i > 0; i--) {
			nums[cnt] = i;
			combi(cnt+1, i-1);
		}
	}

}
