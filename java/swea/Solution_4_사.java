package test;

import java.io.*;
import java.util.*;

class Solution_4_사 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st; 
	
	static int[][] arr; 
	static int N; 

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= t; tc++) {
			// input 
			int N = Integer.parseInt(br.readLine());
			arr = new int[N][N]; 
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) 
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
			// solve
			int maxSize = -1;
			int cnt = 0; 
			// 모든 위치에서
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					// size
					for(int k = N-1; k >= i; k--) {
						for(int p = N-1; p >= j; p--) {
							if(arr[i][j] != arr[k][p])
								continue; 
							int curSize = (k - i + 1) * (p - j + 1);
							if(curSize > maxSize) {
								maxSize = curSize;
								cnt = 1; 
							}
							else if(curSize == maxSize) {
								cnt++; 
							}
						}
					}
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}