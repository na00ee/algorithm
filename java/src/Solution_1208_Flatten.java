import java.util.Arrays;
import java.util.Scanner;

public class Solution_1208_Flatten {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 0; t < 10; t++) {
			int dump = sc.nextInt();
			int[] boxes = new int[100];
			int result = 0;
			for (int i = 0; i < 100; i++) {
				boxes[i] = sc.nextInt();
			}
			for (int i = 0; i < dump+1; i++) {
				Arrays.sort(boxes);
				result = boxes[99] - boxes[0];
				if(result == 0) {
					break;
				} else {
					++boxes[0];
					--boxes[99];
				}
			}
			System.out.printf("#%d %d\n", t+1, result);
		}
	}
}
