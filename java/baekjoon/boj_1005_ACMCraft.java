import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1005_ACMCraft {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Queue<Integer> que;
    static int T, N, K, cnt, min;
    static List<Integer>[] p;
    static int [] arr;
    static boolean [] visited;
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			que = new LinkedList<>();
			p = new ArrayList [N+1];
			arr = new int [N+1];
			visited = new boolean [N+1];
			
			for (int i = 0; i < N+1; i++) {
				p[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 1; i < N+1; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			
			bfs(que);
			
			System.out.println(min);
		}
		
		
		
	}
	
	static void bfs(Queue<Integer> que) {
		while (!que.isEmpty()) {
			int n = que.poll();
		}
	}

}


