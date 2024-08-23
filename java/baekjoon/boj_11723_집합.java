package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj_11723_집합 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static Set<Integer> set = new HashSet<>();
	static int N, m;
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if (st.hasMoreTokens()) m = Integer.parseInt(st.nextToken());
			switch(s) {
				case "add":
					set.add(m);
					break;
				case "remove":
					if (set.contains(m)) {
						set.remove(m);
					}
					break;
				case "check":
					if (set.contains(m)) {
						sb.append(1).append("\n");
					} else sb.append(0).append("\n");
					break;
				case "toggle":
					if (set.contains(m)) {
						set.remove(m);
					} else set.add(m);
					break;
				case "all":
					set = new HashSet<>();
					for (int j = 1; j <= 20; j++) {
						set.add(j);
					}
					break;
				case "empty":
					set = new HashSet<>();
					break;
			}
		}
		System.out.println(sb);
	}

}
