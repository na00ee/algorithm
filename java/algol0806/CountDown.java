package algol0806;

import java.util.Arrays;

public class CountDown {
	
	static int[] p = {2, 3, 4, 6, 7, 8, 9, 4, 10, 13};

	public static void main(String[] args) {

		System.out.println(Arrays.toString(p));
		countdown(p);
		
		
	}

	static void countdown(int[] arr) {
		int k = -1;
		for (int i = 0; i < arr.length; i++) {
			k = Math.max(k, arr[i]);
		}
		int[] count = new int[k+1];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}
		for (int i = 1; i < count.length; i++) {
			count[i]+=count[i-1];
		}
		int[] sortArr = new int[arr.length];
		for (int i = arr.length-1; i >= 0; i--) {
			sortArr[count[arr[i]]-1] = arr[i];
			count[arr[i]]--;
		}
		System.out.println(Arrays.toString(sortArr));
	}

}
