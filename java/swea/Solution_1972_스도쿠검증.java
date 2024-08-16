import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1972_스도쿠검증 {

	static int T, answer;
	static int[][] map = new int [9][9];
	static boolean[] d;
	static int[] dr = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			answer = 0;
			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			if(check(map)) answer = 1;
			
			System.out.println("#" + t + " " + answer);
		}
		
	}
	
	
	static boolean check(int[][] sudoku) {
		// 행 기준으로 숫자가 1~9까지 있는지 확인
		for (int i = 0; i < 9; i++) {
			d = new boolean [10];
			for (int j = 0; j < 9; j++) {
				if (d[sudoku[i][j]]) return false;
				d[sudoku[i][j]] = true;
			}
		}
		
		// 열 기준으로 숫자가 1~9까지 있는지 확인
		for (int i = 0; i < 9; i++) {
			d = new boolean [10];
			for (int j = 0; j < 9; j++) {
				if (d[sudoku[j][i]]) return false;
				d[sudoku[j][i]]=true;
			}
		}
		
		// 3*3 범위 기준으로 1~9까지 있는지 확인
		for (int r = 1; r < 8; r+=3) {
			for (int c = 1; c < 8; c+=3) {
				d = new boolean [10];
				for (int i = 0; i < 9; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if (d[sudoku[nr][nc]]) return false;
					d[sudoku[nr][nc]]=true;
				}
			}
		}
		
//		boolean [][][] count = new boolean[3][3][10];
//		for (int r = 0; r < 9; r++) {
//			for (int c = 0; c < 9; c++) {
//				int num = sudoku[r][c];
//				int i = r/3;
//				int j = c/3;
//				if(count[i][j][num]) return false;
//				count[i][j][num] = true;
//			}
//		}
		
		
		return true;
	}
	
}
