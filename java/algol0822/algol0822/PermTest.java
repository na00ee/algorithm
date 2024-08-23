package algol0822;

import java.util.Arrays;

public class PermTest {

	static int [] p = {1, 2, 3, 4, 5, 6};
	static int N, R, count;
	static int [] nums;
	static boolean [] visited; // int[]
	
	public static void main(String[] args) {
		N = p.length;
		R = 3; // 6P3
		count = 0;
		nums = new int[R];
		visited = new boolean[N];
		perm(0);
		System.out.println(count);
	}

	static void perm(int cnt) {
		if(cnt==R) {
			count++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue; // 이거 지우면 중복순열임(1, 1, 1 같은 거)
			visited[i]=true;
			nums[cnt] = p[i];
			perm(cnt+1);
			nums[cnt] = 0;
			visited[i] = false;
		}
	}

}
