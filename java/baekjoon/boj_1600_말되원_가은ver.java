import java.io.*;
import java.util.*;

public class boj_1600_말되원_가은ver {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int k, r, c;
	static int[][] map, ans;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	static int[] dxH = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dyH = {-2, -1, 1, 2, 2, 1, -1, -2};
	static boolean[][][] visited;
	static int INF = Integer.MAX_VALUE;
	
	static class P{
		int x, y, go, jump;
		P (int x, int y, int go, int jump) {
			this.x = x;
			this.y = y;
			this.go = go;
			this.jump = jump;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		map = new int[r][c];
		visited = new boolean[r][c][k + 1];
		ans = new int[r][c];
		for(int i = 0; i < r; i++) {
			Arrays.fill(ans[i], INF);
		}
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
		if(ans[r - 1][c - 1] == INF) {
			System.out.println(-1);
		} else System.out.println(ans[r - 1][c - 1]);
	}
	
	static void bfs() {
		
		Queue<P> q = new LinkedList<>();
		q.offer(new P(0, 0, 0, 0));
		visited[0][0][0] = true;
		
		while (!q.isEmpty()) {
			
			P cur = q.poll();
			
			ans[cur.x][cur.y] = Math.min(ans[cur.x][cur.y], cur.go);
			
			for(int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(check(nx, ny) && !visited[nx][ny][cur.jump] && map[nx][ny] != 1) {
					visited[nx][ny][cur.jump] = true;
					q.offer(new P(nx, ny, cur.go + 1, cur.jump));
				}
			}
			
			for(int i = 0; i < 8; i++) {
				int nx = cur.x + dxH[i];
				int ny = cur.y + dyH[i];
				
				if(cur.jump < k && check(nx, ny) && !visited[nx][ny][cur.jump + 1] && map[nx][ny] != 1) {
					visited[nx][ny][cur.jump + 1] = true;
					q.offer(new P(nx, ny, cur.go + 1, cur.jump + 1));
				}
			}
		}
	}
	
	static boolean check(int x, int y) {
		if(x < 0 || x >= r || y < 0 || y >= c) return false;
		return true;
	}
}