import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1228_암호문1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, n, m;
	static List<String> list;
	static String[] arr;
	
	public static void main(String[] args) throws Exception {

		for (int t = 1; t < 11; t++) {
			
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			list = new LinkedList<>();
			
			for (int i = 0; i < N; i++) {
				list.add(st.nextToken()+" ");
			}
			
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				if(st.nextToken().equals("I")) {
					n = Integer.parseInt(st.nextToken());
					m = Integer.parseInt(st.nextToken());
					arr = new String[m];
					for (int i = 0; i < m; i++) {
						arr[i] = st.nextToken() + " ";
					}
					for (int i = m-1; i >= 0; i--) {
						list.add(n, arr[i]);
					}
				}
			}
				
			sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i));
			}
			System.out.println(sb);
		}
		
		
	}

}
