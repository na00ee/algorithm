import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class boj_17471_게리맨더링 {

	static int N, n, min = 1000, sum1, sum2;
	static int [] people;
	static int [][] map;
	static boolean[] visited, bvisited; 
	static int[] subset1, subset2;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		people = new int [N];
		visited = new boolean [N];
		map = new int [N+1][N+1];
		
		for (int i = 0; i < N; i++) {
			people[i] = sc.nextInt();
		}
		
		for (int r = 0; r < N; r++) {
			n = sc.nextInt();
			for (int c = 0; c < n; c++) {
				int e = sc.nextInt();
				map[r+1][e] = 1;
				map[e][r+1] = 1;
			}
		}
		
		powerset(0, new int [N]);
		System.out.println(min == 1000 ? -1:min);
	}

	static void powerset(int cnt, int[] nums) {
		if (cnt==N) {
			if(bfs(true)&&bfs(false)) {
				calculate();
			}
			return;
		}
		visited[cnt] = true;
		powerset(cnt+1, nums);
		visited[cnt] = false;
		powerset(cnt+1, nums);
	}

	static boolean bfs(boolean isS) {
		Queue<Integer> que = new LinkedList<>();
		boolean[] bvisited = new boolean[N];
		int start = -1;
		for (int i = 0; i < N; i++) {
			if (visited[i]==isS) {
				start = i;
				break;
			}
		}
		
		// 만약 start = -1이면 전부 true거나 false라는 뜻
		if (start == -1) return false;
		
		que.offer(start);
		bvisited[start] = true;
		
		while (!que.isEmpty()) {
			int n = que.poll();
			for (int i = 0; i < N; i++) {
				if(bvisited[i]) continue;
				// 만약 노드 n과 노드 i가 연결되어 있고, i가 부분집합 내에 포함된 경우 실행
				if(map[n+1][i+1] == 1 && visited[i] == isS) {
					bvisited[i] = true;
					que.offer(i);
				}
			}
		}
		// 만약 visited[i] == isS인 노드가 bvisited[i] == true가 아니면 return false
		for (int i = 0; i < N; i++) {
			if (visited[i]==isS && !bvisited[i]) return false;
		}
		return true;
	}

	static void calculate() {
		sum1 = 0;
		sum2 = 0;
		for(int i = 0; i < N; i++) {
			if (visited[i]) sum1 += people[i];
			else sum2 += people[i];
		}
		min = Math.min(Math.abs(sum2 - sum1), min);
	}
	
}