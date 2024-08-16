package algol0805;

import java.util.Scanner;
import java.util.Stack;

public class Solution_8931 {

	static int T;
	static int K;
	static int sum;
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for (int t = 1; t < T+1; t++) {
			Stack<Integer> stack = new Stack<>(); // 스택을 각 테스트 케이스마다 초기화
			sum = 0; // 매 테스트 케이스마다 합계를 초기화
			
			// 테스트 케이스 정수 갯수
			K = sc.nextInt();
			
			// stack에 값을 받음. 0이 나오면 top의 원소 pop
			for (int i = 0; i < K; i++) {
				int num = sc.nextInt();
				if(num==0) {
					stack.pop();
				} else {
					stack.push(num);
				}
			}
			
			for (Integer i : stack) {
				sum += i;
			}
			
			System.out.println("#" + t + " " + sum);
		}
		
	}

}
