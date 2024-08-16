package algol0806;

public class Fact2 {

	public static void main(String[] args) {

		int[] fact = new int[13];
		fact[0] = 1;
		// dp - memoization, tablization
		for (int i = 1; i < fact.length; i++) {
			fact[i] = i*fact[i-1];
			System.out.println(i + "!= " + fact[i]);
		}
		
	}

}
