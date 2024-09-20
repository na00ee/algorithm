import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class baekjoon_15686_치킨배달 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, cnt, minDis = Integer.MAX_VALUE;;
	static List<int []> chickens, houses;
	static int [][] map;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int [N][N];
		chickens = new ArrayList<>();
		houses = new ArrayList<>();
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c]==1) houses.add(new int[] {r, c});
				else if (map[r][c]==2) chickens.add(new int[] {r, c});
			}
		}
		
		combi(0, 0, new ArrayList<int []>());
		
		System.out.println(minDis);
		
	}
	static void combi(int cnt, int start, List<int []> nums) {
		if (cnt == M) {
			int sum = 0;
			// 각 집에서 각 선택된 치킨집의 거리를 계산
			for (int [] home : houses) {
				int min = Integer.MAX_VALUE;
				for (int [] selected : nums) {
					int dis = Math.abs(home[0] - selected[0]) + Math.abs(home[1] - selected[1]);
					min = Math.min(min, dis);
				}
				sum += min;
			}
			minDis = Math.min(minDis, sum);
			return;
		}
		
		for (int i = start; i < chickens.size(); i++) {
			nums.add(chickens.get(i));
			combi(cnt+1, i+1, nums);
			nums.remove(cnt);
		}
	}
	

}
