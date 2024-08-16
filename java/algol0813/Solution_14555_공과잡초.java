import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_14555_공과잡초 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T, cnt;
	static char[] charns;
	static boolean c;
	
	public static void main(String[] args) throws Exception {
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			
			sb = new StringBuilder();
			cnt = 0;
			c = false;
			
			charns = br.readLine().toCharArray();
			
			// char 배열에서 "(" 괄호이면 바로 다음에 ")"가 나오면 인덱스를 ")" 다음으로 변경
			for (int i = 0; i < charns.length; i++) {
				if (charns[i]=='(') {
					cnt++;
					if(charns[i+1]==')') i++;
				} else if (charns[i]==')') cnt++;
			}
			
			sb.append("#" + t + " " + cnt);
			System.out.println(sb);
			
		}
		
	}

}
