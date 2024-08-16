package algol0807;

import java.util.Arrays;

public class NextPerm {
	static int[] p = {1, 2, 3, 4, 5, 6};
	static int N = p.length;
	static int count;
	
	public static void main(String[] args) {
		
		do {
			count++;
			System.out.println(Arrays.toString(p));
		} while (np(N-1));
		System.out.println(count);
	}

	static boolean np(int size) {
		int i = size;
		while(i > 0 && p[i-1] >= p[i]) {
			i--;
			System.out.print(" " + p[i]);
		}
		if(i==0) return false;
		int j = size;
		while(p[i-1] >= p[j]) {
			j--;
			System.out.print(p[j]);
		}
		int t = p[i-1];
		p[i-1] = p[j];
		p[j] = t;
		int k = size;
		while(i < k) {
			t = p[i];
			p[i] = p[k];
			p[k] = t;
			i++;
			k--;
		}
		return true;
	}
	
}
