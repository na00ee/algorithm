package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11866_요세푸스문제0 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, K, cnt, n, distance;
	static boolean [] visited;
	static int [] arr;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int [N];
		visited = new boolean [N];
				
		for (int i = 0; i < N; i++) {
			distance = K;
			while (distance>0) {
				if (!visited[n]) {
					distance--;
					if (distance == 0) break;
				}
				n = (n + 1 > N-1) ? 0 : n+1;
			}
			visited[n] = true;
			arr [i] = n+1;
		}
		sb.append("<");
		for (int i = 0; i < N; i++) {
			if(i==N-1) sb.append(arr[i]).append(">");
			else sb.append(arr[i]).append(", ");
		}
		
		System.out.println(sb.toString());
	}

}
