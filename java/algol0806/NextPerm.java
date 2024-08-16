package algol0806;

import java.util.Arrays;
// nPn = 나열 n!/(n-r)! => n!/(0)! (0!은 1임)
public class NextPerm {

	static int[] p = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	static int N;
	static int count;
	
	public static void main(String[] args) {
		N = p.length;
		count = 0;
		do {
			count++;
			System.out.println(Arrays.toString(p));
		} while (np(N-1));
		System.out.println(count);
	}
	
	// 10! = 3628800
	static boolean np(int size) {
		int i = size;
		// 1, 2, 5, 4, 3에서 5의 인덱스를 i에 부과
		while (i > 0 && p[i-1] >= p[i]) i--;
		// 가장 큰 값이 첫 번째에 있는 경우의 수까지 돌아가면 return false
		if (i==0) return false;
		
		// 맨 뒤부터 돌게 함
		int j = size;
		// 첫 번째 봉우리의 이전 값보다 큰 값의 위치를 알아냄
		// 1, 2, 5, 3, 4면
		while (p[i-1] >= p[j]) j--;
		int t = p[i-1];
		p[i-1] = p[j];
		p[j] = t;
		int k = size;
		while (i < k) {
			t = p[i];
			p[i] = p[k];
			p[k] = t;
			i++;
			k--;
		}
		
		return true;
	}

}
