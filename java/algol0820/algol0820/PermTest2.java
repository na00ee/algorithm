package algol0820;

import java.util.Arrays;

// nPr = n! / (n-r)!
// 서로 다른 n개에서 서로 다른 r개를 선택+나열(순서 고려)
// 123 != 132

// 대입
// dfs(depth)
// 초기화			=> backtracking
// 123 -> 124 -> 125 -> 132
public class PermTest2 {

	static int [] p = {1, 2, 3, 4, 5, 6};
	static int N, R, count;
	static int [] nums;
	static boolean[] visited;
	
	public static void main(String[] args) {
		
		N = p.length;
		R = 4;
		count = 0;
		nums = new int[R];
		visited = new boolean[N];
		nPr(0);
		System.out.println(count);
		
	}

	static void nPr(int cnt) {
		if (cnt == R) {
			count++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			nums[cnt] = p[i];
			nPr(cnt+1);
			nums[cnt] = 0;
			visited[i] = false;
		}
	}

}
