package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_1620_나는야포켓몬마스터이다솜 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static HashMap<Integer, String> arr1 = new HashMap<>();;
	static HashMap<String, Integer> arr2 = new HashMap<>();;
	static String s;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// N개의 줄에 데이터를 받음
		for (int i = 1; i < N+1; i++) {
			s = br.readLine();
			arr1.put(i, s);
			arr2.put(s, i);
		}
		
		for (int i = 0; i < M; i++) {
			s = br.readLine();
			if (s.charAt(0)-'0' <= 9) {
				sb.append(arr1.get(Integer.parseInt(s))).append("\n");
			} else {
				sb.append(arr2.get(s)).append("\n");
			}
		}
		System.out.println(sb);
	}

}
