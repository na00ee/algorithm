import java.util.Scanner;

public class Main_2346_풍선터뜨리기_김나영 {

	static int N, n, s;
	static int [] balloons;
	static boolean [] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		balloons = new int [N];
		visited = new boolean [N];
		for (int i = 0; i < N; i++) {
			balloons[i] = sc.nextInt();
		}
		
		// 1부터 시작
		n = 0;
		sb.append(n+1).append(" ");
		for (int i = 1; i < N; i++) {
			s = balloons[n];
			visited[n] = true;
			while (s!=0) {
				if (s < 0) {
					n--;
				} else {
					n++;
				}
				if (Math.abs(n)==N) n = 0;
				if (visited[check(n)]) continue;
				if (s < 0) {
					s++;
				} else {
					s--;
				}
			}
			n = check(n);
			sb.append(n+1).append(" ");
		}
		System.out.println(sb);
	}

	// 인덱스 점검
	static int check(int k) {
		if (k >= N) k -= N;
		else if(k < 0) k += N;
		return k;
	}
	
}
