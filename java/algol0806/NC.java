package algol0806;

import java.util.Arrays;
// nCr = 5C3 = 5!/(2!*3!)
// nCr = n!/((n-r) * (r!)
// 순서가 없는 경우
public class NC {

	static int[] p = {0, 0, 1, 1, 1};
	static int[] q = {1, 2, 3, 4, 5};
	static int N = p.length;
	static int count;
	
	public static void main(String[] args) {
		count = 0;
		do {
			count++;
			System.out.println(Arrays.toString(p));
			for (int i = 0; i < N; i++) {
				if(p[i]==1) {
					System.out.print(q[i] + " ");
				}
			}
			System.out.println();
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
		// 1, 2, 5, 4, 3이면 2보다 큰 값이 이후에 있는지 확인
		while (p[i-1] >= p[j]) j--;
		// 2를 t에 넣음
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
