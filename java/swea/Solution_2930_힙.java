import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_2930_힙 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	static StringTokenizer st;
	static int T, N;
	
	public static void main(String[] args) throws Exception {

		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
			sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				if(n==1) {
					que.offer(Integer.parseInt(st.nextToken()));
				} else {
					if(que.peek()==null) {
						sb.append(-1).append(" ");
					} else {
						sb.append(que.poll()).append(" ");
					}
				}
			}
			System.out.println(sb);
		}
	}

}
