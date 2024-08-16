package algol0805;

import java.util.Arrays;

public class SliceWindow {
	
	static int [] map;
	static int N=500, M=50;
	static int sum;
	static int max;
	static int ts;
	
	public static void main(String[] args) {
//		map = new int[N];
//		for (int i = 0; i < N; i++) {
//			map[i]=(int) (Math.random()*M) + 1;
//		}
		map = new int[]{3, 2, 5, 4, 6, 7, 2, 8, 1};
		max = -1;
		ts = 0;
		N = map.length;
		M = 4;
		System.out.println(Arrays.toString(map));
		
		for (int i = 0; i < M; i++) {
			ts += map[i];
		}
		System.out.println("ts " + ts);
		for (int i = 1; i < N-M; i++) {
			ts = sw(map, i, M, ts);
			System.out.println("ts " + ts);
			max = Math.max(max, ts);
		}

		System.out.println(max);
	}
	
	// 1~50 2 51 -> 50+2-1
	static int sw(int[] p, int start, int m, int s) {
		return s - p[start-1] +p[start+m-1];
	}
}
