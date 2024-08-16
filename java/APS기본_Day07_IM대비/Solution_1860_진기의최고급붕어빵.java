import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1860_진기의최고급붕어빵 {

	static int T, N, M, K, n;
	static int [] client;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			n = 1;
//			int a = 1;
			
			client = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				client[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(client);
			
			for (int i = 0; i < N; i++) {
				if (client[i]/M * K < i+1) {
					n = 0;
					break;
				}
			}
			
//			while(n >= 0 && N > 0) {
//				if(a%M==0) {
//					n += K;
//				}
//				
//				for (int c : client) {
//					if(a==c) {
//						n--; N--;
//					}
//					
//				}
//				
//				a++;
//			}
			
			System.out.print("#" + t + " ");
			
			if(n==0) {
				System.out.println("Impossible");
			} else {
				System.out.println("Possible");
			}
			
		}
		
	}

}
