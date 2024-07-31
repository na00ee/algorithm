import java.util.Scanner;

public class Solution_1204_ 최빈값_구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			sc.nextInt();
			int[] scores = new int[101]; 
			for (int i = 0; i < 1000; i++) { // 1000명의 학생의 점수 입력
				scores[sc.nextInt()]++;
			}
			int max = 0;
			int idx = 0; 
			for (int i = 100; i > 0; i--) {
				if (scores[i] > max) { 
					max = scores[i]; // 빈도수 저장
					idx = i; // 최빈값 점수
				}
			}

			System.out.printf("#%d %d\n", t, idx);
		}
	}
}
