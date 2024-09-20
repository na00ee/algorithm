import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_17219_비밀번호찾기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static HashMap<String, String> map = new HashMap<>();
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// N개의 줄에 있는 홈페이지와 비밀번호 묶음을 HashMap에 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), st.nextToken());
		}
		
		// M개의 줄에 찾고자 하는 홈페이지를 받고 비밀번호 출력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			sb.append(map.get(st.nextToken())).append("\n");
		}
		
		System.out.println(sb);
	}

}
