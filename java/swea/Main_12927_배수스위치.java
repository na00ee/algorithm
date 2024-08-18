package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_12927_배수스위치 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	static char[] arr;
	static int cnt, n, answer;
	
	public static void main(String[] args) throws Exception {

		arr = br.readLine().toCharArray();
		answer = 0;
		cnt = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='Y') cnt++;
		}
		
		while(cnt>0) {
			n = 0;
			for (int i = 0; i < arr.length; i++) {
				if(arr[i]=='Y') {
					n = i+1;
					break;
				}
			}
			
			for (int i = n-1; i < arr.length; i+=n) {
				if(arr[i]=='Y') {
					arr[i] = 'N';
					cnt--;
				} else {
					arr[i] = 'Y';
					cnt++;
				}
			}
			answer++;
		}
		
		System.out.println(answer);
		
	}

}
