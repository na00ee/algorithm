package algol0820;

import java.util.Arrays;

// nCr = n! / r!(n-r)!
// n개에서 서로 다른 r개를 선택+나열(순서 고려X)
// 123 == 132

// 대입
// dfs(depth)
// 초기화			=> backtracking
// 123 -> 124 -> 125 -> 132
public class CombiTest {

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
		nCr(0, 0);
		System.out.println(count);
		
	}

	static void nCr(int cnt, int start) {
		if (cnt == R) {
			count++;
			System.out.println(Arrays.toString(nums));
			// 두 팀으로 분리
			for (int i = 0; i < N; i++) {
				if(visited[i]) {
					System.out.print(p[i]+" ");
				}
			}
			System.out.println();
			for (int i = 0; i < N; i++) {
				if(!visited[i]) {
					System.out.print(p[i]+" ");
				}
			}
			System.out.println();
			return;
		}
		for (int i = start; i < N; i++) {
//			if(visited[i]) continue;
			// 한 팀에 4명을 뽑고 2명은 뽑지 않을 경우
			// 뽑힌 사람과 안 뽑힌 사람을 둘 다 출력할 때 visited 사용
			visited[i] = true;
			nums[cnt] = p[i];
			nCr(cnt+1, i+1);
			nums[cnt] = 0;
			visited[i] = false;
		}
	}

}
