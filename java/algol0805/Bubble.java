package algol0805;

import java.util.Arrays;

public class Bubble {
	
	static int [] map;
	static int N=100, M=50;
	static int[] counts;
	
	public static void main(String[] args) {
		map = new int[N];
		for (int i = 0; i < N; i++) {
			map[i]=(int) (Math.random()*M) + 1;
		}
		
		// 1~M
		counts = new int[M+1];
		for (int i = 1; i < N; i++) {
			counts[map[i]]++;
		}
		
		System.out.println(Arrays.toString(counts));
//		Arrays.sort(counts);
//		System.out.println(counts[M]);
		System.out.println(Arrays.toString(map));
		bubble(map);
		System.out.println(Arrays.toString(map));
		
		
	}
	
	static void bubble(int[] p) {
		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j < N-1-i; j++) {
				if(p[j]>p[j+1]) {
					int t = p[j];
					p[j] = p[j+1];
					p[j+1] = t;
				}
			}
		}
	}
}
