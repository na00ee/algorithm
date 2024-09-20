import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.annotation.processing.SupportedSourceVersion;

public class boj_1600_말되원 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int K, W, H;
	static int [] dr = {-1, 0, 1, 0};
	static int [] dc = {0, 1, 0, -1};
	static int [] dr_H = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int [] dc_H = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int INF = Integer.MAX_VALUE;
	static class P {
		int r, c, cnt, horse;
		
		public P (int r, int c, int cnt, int horse) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.horse = horse;
		}
		
	}
	static int [][] map, ans;
	static boolean [][][] visited;
	
	public static void main(String[] args) throws Exception {
		K = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int [H][W];
		ans = new int [H][W];
		visited = new boolean [H][W][K+1];
		
		for (int r = 0; r < H; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < W; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				ans[r][c] = INF;
			}
		}
		
		bfs(0, 0);
		
		if (ans[H-1][W-1] == INF) System.out.println(-1);
		else System.out.println(ans[H-1][W-1]);
		
	}

	static void bfs(int n, int m) {
		Queue<P> que = new LinkedList<>();
		
		que.offer(new P (n, m, 0, 0));
		visited[0][0][0] = true;
		
		while (!que.isEmpty()) {
			P p = que.poll();
			ans[p.r][p.c] = Math.min(ans[p.r][p.c], p.cnt);
			
			// 그냥 갈 때
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if (!check(nr, nc) || visited[nr][nc][p.horse] || map[nr][nc]==1) continue;
				
				visited[nr][nc][p.horse] = true;
				
				que.offer(new P (nr, nc, p.cnt+1, p.horse));
			}
			
			// 그냥 갈 때
			for (int d = 0; d < 8; d++) {
				int nr = p.r + dr_H[d];
				int nc = p.c + dc_H[d];
				
				if (p.horse >= K || !check(nr, nc) || visited[nr][nc][p.horse+1] || map[nr][nc]==1) continue;
				
				visited[nr][nc][p.horse+1] = true;
				
				que.offer(new P (nr, nc, p.cnt+1, p.horse+1));
			}
		}
	}

	static boolean check(int r, int c) {
		return r >= 0 && r < H && c >= 0 && c < W;
	}
	
}
