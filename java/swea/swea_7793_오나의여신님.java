import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_7793_오나의여신님 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	static StringTokenizer st;
	static int T, N, M, m = 1, min, INF = Integer.MAX_VALUE;
	static char [][] map;
	static int [][] ans;
	static boolean [][][] visited;
	static class P {
		int r, c, cnt;
		
		public P (int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int [] dr = {-1, 0, 1, 0};
	static int [] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new char [N][M];
			ans = new int [N][M];
			visited = new boolean [N][M][N*M];
			
			for (int r = 0; r < N; r++) {
				map[r] = br.readLine().toCharArray();
				Arrays.fill(ans[r], INF);
			}
			
			bfs();
			
		}
	}
	
	static void bfs() {
		Queue<P> queS = new LinkedList<>();
		Queue<P> queD = new LinkedList<>();
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map [r][c] == 'S') queS.offer(new P (r, c));
				else if (map [r][c] == '*') queD.offer(new P (r, c));
			}
		}
		
		while (!queS.isEmpty()) {
			P s = queS.poll();
			for (int d = 0; d < 4; d++) {
				int nr = s.r + dr[d];
				int nc = s.c + dc[d];
				
				if (check(nr, nc) && !visited[nr][nc][s.cnt] && map[nr][nc]=='.') {
					visited [nr][nc][s.cnt] = true;
					map[s.r][s.r] = '.';
					map[nr][nc] = 'S';
				}
				
				P D = queS.poll();
				
				for (int i = 0; i < 4; i++) {
					int nr2 = D.r + dr[i];
					int nc2 = D.c + dc[i];
					if (map[nr2][nc2] != '.') continue;
					queD.offer(new P (nr2, nc2));
				}
			}
		}
	}

	static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
