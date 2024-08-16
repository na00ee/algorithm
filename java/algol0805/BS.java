package algol0805;

import java.util.Arrays;

public class BS {
	static int [] p = {4, 6, 7, 3, 9, 5, 1, 15, 18};
	
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(p));
		Arrays.sort(p);
		int index = bs(p, 9);
		System.out.println(index);
		index = bs(p, 11);
		System.out.println(index);
	}
	
	static int bs(int[] n, int key) {
		int l = 0;
		int r = n.length-1;
		while(l<=r) {
			int m = (l+r)>>>1;
			int mv = n[m];
			if(mv == key) {
				return m;
			} else if(mv < key) {
				l=m+1;
			} else {
				r=m-1;
			}
		}
		return -(l+1);
	}
	
}
