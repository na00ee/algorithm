package algol0808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_2798_블랙잭 {

	static int N, M;
	static int max = 0;
	static int[] arr, p;
    static int n;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		// 초기화
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		p = new int[N];
		Arrays.fill(p, 1);
		for (int i = 0; i < N-3; i++) {
			p[i]=0;
		}
		
		//------------읽기
		max =-1;
		do {
			int r = 0;
			for (int i = 0; i < N; i++) {
				if (p[i]==1) {
					r += arr[i];
				}
			}
			if (r<=M) max = Math.max(r, max);
		} while (np(N-1));
		
		System.out.println(max);
	}

	static boolean np(int size) {
		int i = size;
		while(i>0 && p[i-1]>=p[i]) i--;
		if(i==0) return false;
		int j = size;
		while(p[i-1]>=p[j]) j--;
		int tt = p[i-1];
		p[i-1]=p[j];
		p[j]=tt;
		int k = size;
		while(i<k) {
			tt = p[i];
			p[i]=p[k];
			p[k]=tt;
			i++;
			k--;
		}
		return true;
	}

}