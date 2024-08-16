import java.util.Scanner;

public class Solution_4613_러시아 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 행의 길이
			int M = sc.nextInt(); // 열의 길이

			char[][] board = new char[N][M];

			for (int r = 0; r < N; r++) {
				// 한 줄씩 문자열을 입력받아 문자의 배열로 바꿈
				board[r] = sc.next().toCharArray();
			}

			// 칠해야할 칸 수의 최솟값을 저장할 변수
			// N * M의 최댓값인 2500으로 초기
			int minNeed = 2500;

			// i : 흰색 줄이 몇 번째 열까지 칠해질 것인가를 결정하는 변수
			for (int i = 0; i < N - 2; i++) {
				// j : 파란색 줄이 몇 번째 열까지 칠해질 것인가를 결정하는 변수
				// 흰색 줄이 끝나는 다음 줄부터 파란 줄이 시작되므로 j 는 i + 1 이상
				for (int j = i + 1; j < N - 1; j++) {
					int need = 0; // 칠해야할 칸 수 need 변수

					// 흰색 줄
					// 0번째 줄부터 i번째 줄까지 흰색으로 칠해야할 칸 수 계산
					for (int r = 0; r <= i; r++) {
						for (int c = 0; c < M; c++) {
							if (board[r][c] != 'W') // 흰색이 아니면 칠해야함
								need++;
						}
					}

					// 파란색
					// i + 1번째 줄부터 j번째 줄까지 흰색으로 칠해야할 칸 수 계산
					for (int r = i + 1; r <= j; r++) {
						for (int c = 0; c < M; c++) {
							if (board[r][c] != 'B') // 파란색이 아니면 칠해야함
								need++;
						}
					}

					// 빨간색
					// j + 1번째 줄부터 N - 1번째 줄까지 흰색으로 칠애야할 칸 수 계산
					for (int r = j + 1; r < N; r++) {
						for (int c = 0; c < M; c++) {
							if (board[r][c] != 'R') // 빨간색이 아니면 칠해야함
								need++;
						}
					}

					// 흰색으로 칠해야할 칸의 개수를 구한 후 최솟값 갱신
					minNeed = Math.min(need, minNeed);
				}

			}
			System.out.println("#" + test_case + " " + minNeed);
		}

	}

}