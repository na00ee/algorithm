import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class boj_1197_최소스패닝트리 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int V, E;
    static class Edge implements Comparable<Edge> {
    	int s;
    	int e;
    	int w;
		public Edge(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(w, o.w);
		}
    }
    static int [] p;
    static int [] r;
    static PriorityQueue<Edge> pre;
    static long min;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		pre = new PriorityQueue<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			pre.offer(new Edge(s, e, w));
		}
		makeset();
		int cnt = 0;
		min = 0;
		while(cnt != V-1) {
			Edge edge = pre.poll();
			// 연결할 수 있으면 true
			if (union(edge.s, edge.e)) {
				cnt++;
				min+=edge.w;
			}
		}
		System.out.println(min);
	}

	static boolean union(int x, int y) {
		x=find(x);
		y=find(y);
		if(x==y) return false; // 사이클에 포함됨
		if(r[x] < r[y]) {
			r[y]+=r[x];
			p[x]=y;
		} else {
			r[x]+=r[y];
			p[y]=x;
		}
		return true;
	}

	static int find(int x) {
		if (x==p[x]) return p[x];
		return p[x] = find(p[x]);
	}

	static void makeset() {
		p = new int [V+1];
		r = new int [V+1];
		for (int i = 1; i < V+1; i++) {
			p[i] = i;
			r[i] = 1;
		}
	}
	
}
