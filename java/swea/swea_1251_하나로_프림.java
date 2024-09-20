import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class swea_1251_하나로_프림 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
    static StringTokenizer st;
    static int T, N;
    static double E;
    static long min;
    static int [][] map;
    static class Edge implements Comparable<Edge>{
    	int v;
    	int w;
    	
    	public Edge (int v, int w) {
    		this.v = v;
    		this.w = w;
    	}
    	
    	@Override
    	public int compareTo(Edge o) {
    		return Long.compare(o.w, w);
    	}
    }
    static List<Edge>[] edges;
	public static void main(String[] args) throws Exception{
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			
			N = Integer.parseInt(br.readLine());
			
			map = new int [N][2];
			
			for (int i = 0; i < N; i++) {
				
			}
		}
	}

}
