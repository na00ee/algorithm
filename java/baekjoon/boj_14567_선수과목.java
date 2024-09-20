import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14567_선수과목 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Queue<Integer> que;
    static int N, M, cnt, min = 1;
    static List<Integer>[] p, r;
    static int [] arr;
    static boolean [] visited;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		que = new LinkedList<>();
		p = new ArrayList [N+1];
		r = new ArrayList [N+1];
		arr = new int [N+1];
		visited = new boolean [N+1];
		
		for (int i = 0; i < N+1; i++) {
			p[i] = new ArrayList<>();
			r[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			p[a].add(b);
			r[b].add(a);
		}
		
		// 선수 과목이 없는 경우에만 que에 넣음
		for (int i = 1; i < N+1; i++) {
			if (r[i].size()==0) {
				que.offer(i);
				cnt++;
			}
		}
		
		bfs(que);
		
		for (int i = 1; i < N+1; i++) {
			sb.append(arr[i]).append(" ");
		}
		
		System.out.println(sb.toString());
		
	}
	
	static void bfs(Queue<Integer> que) {
		while (!que.isEmpty()) {
			int n = que.poll();
			visited[n] = true;
			for (int a : p[n]) {
				boolean isS = true;
				for (int b : r[a]) {
					if (!visited[b]) {
						isS = false;
						break;
					}
				}
				if (isS) {
					que.offer(a);
				}
			}
			arr[n] = min;
			cnt--;
			if(cnt == 0) {
				min++;
				cnt = que.size();
			}
		}
	}

}
