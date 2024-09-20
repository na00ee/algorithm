import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1244_최대상금 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
    static StringTokenizer st;
    static int T, N, K, max;
    static char [] charns;
    static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			max = 0;
			
			st = new StringTokenizer(br.readLine());
			
			charns = st.nextToken().toCharArray();
			N = charns.length;
			K = Integer.parseInt(st.nextToken());
			visited = new boolean [K][999999+1];
			
			dfs(charns, 0);
			
			sb.append(max);
			System.out.println(sb.toString());
		}
	}
	
	static void dfs(char[] c, int cnt) {
		if (cnt == K) {
			int n = Integer.parseInt(new String(c));
			max = Math.max(max, n);
			return;
		}
	
		if (visited[cnt][Integer.parseInt(new String(c))]) return;
		visited[cnt][Integer.parseInt(new String(c))] = true;
		
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				swap(i, j, c);
				dfs(c, cnt+1);
				swap(i, j, c);
			}
		}
	
	
	}

	static void swap(int i, int j, char [] c) {
		char temp = c[i];
		c[i] = c[j];
		c[j] = temp;
	}
	
//	static void dfs(String s, int cnt) {
//		if (cnt == K) {
//			int n = Integer.parseInt(s);
//			max = Math.max(max, n);
//			return;
//		}
//
//		if (visited[cnt][Integer.parseInt(s)]) return;
//		visited[cnt][Integer.parseInt(s)] = true;
//		
//		for (int i = 0; i < N-1; i++) {
//			for (int j = i+1; j < N; j++) {
//				char c[] = s.toCharArray();
//				char temp = c[i];
//				c[i] = c[j];
//				c[j] = temp;
//				dfs(new String(c), cnt+1);
//			}
//		}
//	}

}
