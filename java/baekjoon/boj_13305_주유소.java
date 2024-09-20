import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_13305_주유소 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static long sum, min = Integer.MAX_VALUE;
    static long [] dis, oil;
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		dis = new long [N-1];
		oil = new long [N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N-1; i++) {
			dis[i] = Integer.parseInt(st.nextToken());
			sum += dis[i];
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			oil[i] = Integer.parseInt(st.nextToken());
		}
		
		perm(0, 0, 0);
		System.out.println(min);
		
	}

	static void perm(int city, long currentCost, long currentFuel) {
        // 마지막 도시에 도착한 경우 최소 비용 갱신
        if (city == N - 1) {
            min = Math.min(min, currentCost);
            return;
        }

        // 현재 도시에서 필요한 만큼 기름을 채우고 다음 도시로 이동
        for (int i = 0; i <= sum; i++) {
            if (currentFuel + i >= dis[city]) { // 다음 도시로 이동할 수 있는지 확인
                perm(city + 1, currentCost + i * oil[city], currentFuel + i - dis[city]);
            }
        }
    }
}
