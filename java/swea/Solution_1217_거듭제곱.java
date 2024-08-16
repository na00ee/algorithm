import java.util.Scanner;

public class Solution_1217_거듭제곱 {

	static int T;
	static int N;
	static int M;
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		for (int t = 0; t < 10; t++) {
			T = sc.nextInt();
			N = sc.nextInt();
			M = sc.nextInt();
			
			System.out.println("#" + T + " " + power(N, M));
		}
		
	}
	
	// 거듭제곱 재귀함수
	static int power(int N, int M) {
		if (M == 1) return N;
		return N * power(N, M-1);
	}

}
