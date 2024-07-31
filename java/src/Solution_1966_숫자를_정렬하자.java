import java.util.Arrays;
import java.util.Scanner;

public class Solution_1966_숫자를_정렬하자 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t < T+1; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int n = 0; n < N; n++) {
				arr[n] = sc.nextInt();
			}
			Arrays.sort(arr);
			System.out.printf("#%d ", t);
			for (int i = 0; i < arr.length; i++) {
				System.out.printf("%d ", arr[i]);
			}
			System.out.println();
			
		}
	}

}
