import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_7465_창용마을무리의개수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
    static StringTokenizer st;
    static int T, N, M, cnt;
    static class Edge {
    	int s;
    	int e;
    	public Edge (int s, int e) {
    		this.s = s;
    		this.e = e;
    	}
    }
    static int [] p, r;
    static Edge [] arr;
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			cnt = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new Edge [M];
			makeset();
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				arr[i] = new Edge(s, e);
			}
			
			for (Edge edge : arr) {
				union(edge.s, edge.e);
			}
			
			for (int i = 1; i < N+1; i++) {
				if (p[i] == i) cnt++;
			}
			
			sb.append(cnt);
			System.out.println(sb);

		}// t
	}// main
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x==y) return;
		if (r[x] < r [y]) {
			r[y] += r[x];
			p[x] = y;
		} else {
			r[x] += r[y];
			p[y] = x;
		}
		return;
	}
	
	// 최종 부모를 찾는 메서드
	static int find(int x) {
		if (x==p[x]) return p[x];
		return p[x] = find(p[x]);
	}

	// 부모와 랭킹 배열 생성
	static void makeset() {
		p = new int [N+1];
		r = new int [N+1];
		for (int i = 1; i < N+1; i++) {
			p[i] = i;
			r[i] = 1;
		}
	}

}
