package algol0806;

import java.util.Arrays;

public class BS {
	static int[] p = {1, 2, 4, 5, 6, 7, 8, 9, 11, 10, 13};
	public static void main(String[] args) {
		System.out.println(Arrays.toString(p));
		Arrays.sort(p);
		int i1 = bs(p, 6);
		System.out.println(i1);
		i1 = bs(p, 12);
		System.out.println(i1);
		i1 = Arrays.binarySearch(p, 12);
		System.out.println(i1);
		System.out.println(Arrays.toString(p));
	}

	static int bs(int[] q, int key) {
		int l = 0;
		int r = q.length - 1;
		while(l<=r) {
			int m = (l+r)>>1;
			int mv = q[m];
			if(mv == key) {
				return m;
			} else if(mv < key) {
				l = m + 1;
			} else if(mv > key) {
				r = m - 1;
			}
		}
		return -(l+1);
	}
	
}
