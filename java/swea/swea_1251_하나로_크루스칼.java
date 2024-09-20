import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class swea_1251_하나로_크루스칼 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
    static StringTokenizer st;
    static int T, N, edgeNum;
    static double E;
    static long min;
    static class Edge implements Comparable<Edge> {
    	int u;
    	int v;
    	long w;
    	
    	public Edge (int u, int v, long w) {
    		this.u = u;
    		this.v = v;
    		this.w = w;
    	}

    	@Override
    	public int compareTo(Edge o) {
			return Long.compare(w, o.w);
		}
    }
    static List<Edge> edges;
    static int [][] map;
    static int [] parents;
    static int [] p, r;
    
	public static void main(String[] args) throws Exception {
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			min = 0;
			edgeNum = 0;
			
			N = Integer.parseInt(br.readLine());
			edgeNum = N;
			map = new int [N][2];
			
			st = new StringTokenizer(br.readLine());
			
			// x 좌표를 받음
			for (int i = 0; i < N; i++) {
				map[i][0] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			
			// y 좌표를 받음
			for (int i = 0; i < N; i++) {
				map[i][1] = Integer.parseInt(st.nextToken());
			}
			
			E = Double.parseDouble(br.readLine());
			
			p = new int [N];
			r = new int [N];
			
			// makeset
			for (int i = 0; i < N; i++) {
				p[i] = i;
				r[i] = 1;
			}
			
			edges = new ArrayList<>();
			
			// 해당 노드에서 각 섬까지의 가중치를 각각 저장
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					edges.add(new Edge(i, j, distance(i, j)));
				}
			}
			
			// 가중치 기준 오름차순으로 정렬
			Collections.sort(edges);
			
			for (Edge edge : edges) {
				union(edge.u, edge.v, edge.w);
			}
			System.out.println(sb.append(Math.round(E * min)).toString());
		} // t
		
	} // main

	

	static void union(int u, int v, long w) {
		int x = find(u);
		int y = find(v);
		
		if (x == y || edgeNum==0) return;
		
		if (r[x] < r[y]) {
			p[x] = y;
			r[y]++;
		} else {
			p[y] = x;
			r[x]++;
		}
		min += w;
		edgeNum--;
	}



	static int find(int x) {
		if (p[x]==x) return x;
		return p[x] = find(p[x]);
	}



	static long distance(int i, int j) {
		return 0L + (0L + map[i][0] - map[j][0]) * (0L + map[i][0] - map[j][0]) + (0L + map[i][1] - map[j][1]) * (0L + map[i][1] - map[j][1]);
	}

}
