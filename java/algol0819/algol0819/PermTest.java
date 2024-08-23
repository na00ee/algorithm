package algol0819;

import java.util.Arrays;

/**
 * nPr 서로 다른 n개에서 서로 다른 r개를 선택하여 + 나열(순서 고려)
 * 3! = 3P3
 * 1 2 3
 * 1 3 2
 * 213
 * 231
 * 312
 * 321
 * */

public class PermTest {

	static int [] p = {1, 2, 3, 4}; // 5P3
	static int N = p.length;
	static int R;
	static boolean[] visited;
	static int [] nums;
	static int count;
	
	public static void main(String[] args) {
		// 완탐 npr ncn subset 2^n 순조부
		// exausted search
		// brute force
		R = 3;
		count = 0;
		visited = new boolean[N];
		nums = new int[R];
		nPr(0);
		System.out.println(count);
	}

	// recursion(재귀) - call itself
	// dfs -> 깊이
	static void nPr(int cnt) {
		if(cnt==R) {
			count++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			nums[cnt]=p[i];
			nPr(cnt+1);
			nums[cnt]=0;
			visited[i] = false;
		}
	}

}
