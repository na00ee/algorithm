package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1194_달이차오른다가자 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, min = -1;
	static char [][] map;
	static boolean [][][] visited;
	static class P {
		int r, c, cnt, keys;
		
		public P(int r, int c, int cnt, int keys) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.keys = keys;
		}
	}
	static int [] dr = {-1, 0, 1, 0};
	static int [] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char [N][M];
		visited = new boolean [N][M][1 << 6];
		
		for (int r = 0; r < N; r++) {
			map [r] = br.readLine().toCharArray();
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == '0') {
					bfs(r, c, 0);
				}
			}
		}
		
		System.out.println(min);
		
	}

	static void bfs(int r, int c, int cnt) {
		Queue<P> que = new LinkedList<>();
		que.offer(new P(r, c, cnt, 0));
		visited[r][c][0] = true;
		while (!que.isEmpty()) {
			P p = que.poll();
			if (map[p.r][p.c] == '1') {
				min = p.cnt;
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if (check(nr, nc) && map[nr][nc]!='#') {
					int key = p.keys;
					// 열쇠구역
					if ('a' <= map[nr][nc] && 'f' >= map[nr][nc]) {
						key |= (1 << (map[nr][nc] - 'a'));
					// 문 구역
					} else if ('A' <= map[nr][nc] && 'F' >= map[nr][nc]) {
						if ((key & (1 << (map[nr][nc] - 'A'))) == 0) continue;
					}
					
					if (!visited[nr][nc][key]) {
						visited[nr][nc][key] = true;
						que.offer(new P (nr, nc, p.cnt+1, key));
					}
					
				}
			}
		}
	}

	static boolean check(int r, int c) {
		return r >=0 && r < N && c >= 0 && c < M;
	}

}
