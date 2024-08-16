import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1289_원재의메모리복구 {

	static int T;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int cnt, n;
	static String s;
	
	public static void main(String[] args) throws Exception {
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			
			s = br.readLine();
			cnt = 0;
			if (s.charAt(0)=='1') cnt++;
			
			for (int i = 0; i < s.length()-1; i++) {
				while(i < s.length()-1) {
					if(s.charAt(i)!=s.charAt(i+1)) {
						cnt++;
						break;
					}
					i++;
				}
			}
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
			
		}
		System.out.println(sb);
	}

}
