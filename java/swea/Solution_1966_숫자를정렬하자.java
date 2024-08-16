import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1966_숫자를정렬하자 {

	static int T, N;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			arr = new int[N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// 버블 정렬
			for (int i = 0; i < N-1; i++) {
				for (int j = 0; j < N-1-i; j++) {
					if(arr[j] > arr[j+1]) {
						int n = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = n;
					}
				}
			}
			
			System.out.print("#" + t + " ");
			
			for (int n : arr) {
				System.out.print(n + " ");
			}
			
			System.out.println();
			
		}
		
	}

}
