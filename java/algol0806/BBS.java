package algol0806;

import java.util.Arrays;

public class BBS {
	static int[] p = {1, 2, 3, 4, 5, 6, 7, 8, 10, 1, 9};
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(p));
		bbs(p);
		System.out.println(Arrays.toString(p));
	}

	static void bbs(int[] q) {
		for (int i = 0; i < q.length-1; i++) {
			for (int j = 1; j < q.length-1-i; j++) {
				if (q[j]>q[j+1]) {
					swap(q, j+1, j);
				}
			}
		}
	}

	static void swap(int[] q, int i, int j) {
		int t = q[j];
		q[j]=q[i];
		q[i]=t;
	}
}
