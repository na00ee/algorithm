package algol0820;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2309_일곱난장이 {

	static int N=9, R=7;
	static int [] p;
	static int [] nums;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		p = new int[N];
		for (int i = 0; i < N; i++) {
			p[i] = scann.nextInt();
		}
		
		nums = new int [R];
		nCr(0, 0, 0);
		Arrays.sort(nums);
		for (int s : nums) {
			System.out.println(s);
		}
	}

	static void nCr(int cnt, int start, int tot) {
		if(tot>100) {
			return;
		}
		if (cnt==R) {
			if(tot==100) {
				Arrays.sort(nums);
				for (int s : nums) {
					System.out.println(s);
				}
			}
			return;
		}
		for (int i = start; i < N; i++) {
			nums[cnt] = p[i];
			nCr(cnt+1, i+1, tot+p[i]);
			nums[cnt] = 0;
		}
	}

}
