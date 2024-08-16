import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1926_간단한369게임 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, n;
	static String s;
	
	public static void main(String[] args) throws Exception {
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i < N+1; i++) {
			// i를 문자열로 받기
			s = i+"";
			n = 0;
			
			// i가 3, 6, 9를 포함하면 n++
			for (int j = 0; j < s.length(); j++) {
				if(s.charAt(j) == '3' || s.charAt(j) == '6' || s.charAt(j) == '9' ) {
					n++;
				}
			}
			
			// n이 0이 아니면 '-'를 append
			if(n!=0) {
				for (int k = 0; k < n; k++) {
					sb.append('-');
				}
			} else sb.append(s);
			sb.append(" ");
		}
		System.out.println(sb);
	}

}
