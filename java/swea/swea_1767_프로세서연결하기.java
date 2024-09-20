import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class swea_1767_프로세서연결하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
    static StringTokenizer st;
    static int T, N, min, core, cnt, sumCore;
    static int [][] map;
    static boolean [][] visited;
    static List<int []> list;
	//	   상 좌 하 우
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			cnt = 0;
			core = 0;
			sumCore = 0;
			min = Integer.MAX_VALUE;
			map = new int [N][N];
			visited = new boolean [N][N];
			list = new ArrayList<>();
			
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if (map[r][c]==1) {
						core++;
						list.add(new int[] {r, c});
						visited[r][c] = true;
					}
				}
			}
			
//			for (int i = 0; i < list.size(); i++) {
//				int [] arr = list.get(i);
//				makeCore(arr[0], arr[1], 0, 0, 0);
//			}
			
			makeCore(0, 0, 0);
			
			System.out.println(sb.append(min));
			
		}// t
	}// main
	
	static void makeCore(int cnt, int sum, int index) {
		
		if (index == list.size()) {
			 if (cnt > sumCore) {
		        sumCore = cnt;
		        min = sum;
		    } else if (cnt!=0 && cnt == sumCore) {
		        min = Math.min(min, sum);
		    }
		    return;
		}
		
//		// sumCore는 최대 연결 코어 수를 저장. cnt는 재귀 돌면서 연결된 코어 수 저장.
//		// sum은 최소 전선 수를 저장.
//		if (cnt!=0 && cnt == sumCore) {
//			min = Math.min(sum, min);
////			System.out.println(min);
//		}
//	
//		// 연결된 코어가 최대 연결 코어보다 많을 경우 min값 리셋
//		if (cnt > sumCore) {
//			min = sum;
//			sumCore = cnt;
////			System.out.println(min);
//		}

		int r = list.get(index)[0];
		int c = list.get(index)[1];
			

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			int sumLine = 0;
			
			// 상우하좌 끝까지 돌면서 가장자리에 닿을 수 있는지 확인
			while (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
//				// 다음 좌표가 방문한 좌표일 경우 break
//				if (visited[nr][nc]) break;
				visited[nr][nc] = true;
				nr += dr[d];
				nc += dc[d];
				sumLine++;
			}

			if (nr >= N || nr < 0 || nc >= N || nc < 0) {
				makeCore(cnt+1, sum+sumLine, index+1);
			}
			
			
			// 전선 제거 (백트래킹)
//	        nr = r;
//	        nc = c;
	        for (int i = 0; i < sumLine; i++){
	            nr -= dr[d];
	            nc -= dc[d];
	            visited[nr][nc] = false;
	        }
			
		}
		// 해당 루틴에서 전선이 없는 경우의 수도 추가
		makeCore(cnt, sum, index+1);
	}

}
