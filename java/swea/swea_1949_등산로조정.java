import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1949_등산로조정 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
    static StringTokenizer st;
    static int T, N, K, max, maxH;
    static int [][] map;
    static int [] dr = {-1, 0, 1, 0};
    static int [] dc = {0, 1, 0, -1};
    static boolean [][] visited;
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int [N][N];
			visited = new boolean [N][N];
			max = 0;
			maxH = 0;
			
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					max = Math.max(map[r][c], max);
				}
			}
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c]==max) dfs(r, c, 1, true);
				}
			}
			System.out.println(sb.append(maxH).toString());
		}
	}
	
	static void dfs(int r, int c, int dist, boolean skill) {
		if (dist > maxH) maxH=dist;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			visited[r][c] = true;
			if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
			// 다음 구간이 현재 구간보다 낮은 경우
			if (map[nr][nc] < map[r][c]) dfs(nr, nc, dist+1, skill);
			else if (skill && map[r][c] > map[nr][nc] - K) {
				int temp = map[nr][nc];
				map[nr][nc] = map[r][c]-1;
				dfs(nr, nc, dist+1, false);
				map[nr][nc] = temp;
			}
		}
		visited[r][c] = false;
	}

}
