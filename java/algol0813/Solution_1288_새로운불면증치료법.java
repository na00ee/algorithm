import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1288_새로운불면증치료법 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int T, N, n;
	static int[] arr;
	static boolean isS;
	
	public static void main(String[] args) throws Exception {
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			N = Integer.parseInt(br.readLine());
			int i = 1;
			arr = new int [10];
			
			// 한 자릿수로 남을 때까지 10으로 나눔
			// 첫 번째 자릿수가 0이면 1로 변환
			while(true) {
				isS = true;
				n = N * i;
				while(n!=0) {
					arr[n%10]++;
					n = n/10;
				}
				for (int j = 0; j < 10; j++) {
					if(arr[j]==0) isS = false;
				}
				if (isS) break;
				i++;
			}
			System.out.println("#" + t + " " + N*i);
		}
	}
}
