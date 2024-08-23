package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_10809_알파벳찾기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static char[] charns;
	static int[] alphabet = new int [26];
	
	public static void main(String[] args) throws Exception {
		charns = br.readLine().toCharArray();
		
		for (int i = 0; i < 26; i++) {
			alphabet[i] = -1;
		}
		
		// 97~ 122
		for (int i = 0; i < charns.length; i++) {
			if(alphabet[charns[i]-97]!=-1) continue;
			alphabet[charns[i]-97] = i;
		}
		
		
		
		for (int i = 0; i < 26; i++) {
			sb.append(alphabet[i]).append(" ");
		}
		System.out.println(sb);
	}

}
