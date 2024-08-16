
public class Stack2_팩토리얼 {
	public static void main(String[] args) {
		System.out.println(factorial1(10));
		
		System.out.println(factorial2(10));
	}

	static int factorial1(int N) {
		int result = 1;
		for (int i = 0; i < N; i++) {
			result += i;
		}
		return result;
	}
	
	static int factorial2(int N) {
		// 기저 조건을 넣지 않으면 StackOverFlowError 발생
		if (N == 0 | N == 1) {
			return 1;
		}
		return N * factorial2(N -1);
	}
}
