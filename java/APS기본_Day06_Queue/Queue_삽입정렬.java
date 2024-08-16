import java.util.Arrays;

public class Queue_삽입정렬 {
	
	static int[] queue;

	public static void main(String[] args) {

		int[] arr = new int[] { 69, 10, 30, 2, 16, 8, 31, 22 };
		
		// 삽입 정렬
		// i : 정렬되지 않은 집합의 첫 번째 원소
		for (int i = 1; i < arr.length; i++) {
			// 정렬된 집합의 뒤에서부터 비교하여 위치 찾아주기
			int data = arr[i];
			int j;
			for (j = i-1; j >= 0 && arr[j] > data; j--) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = data;
			System.out.println(Arrays.toString(arr));
		}
		// 우선순위큐1차원배열 다운받아야 함
	}
	
}
