package algol0822;

public class NPermTest {

	static int[] p = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	static int N, count;
	
	public static void main(String[] args) {
		N = p.length;
		count = 0;
		
		do {
			count++;
			System.out.println(p);
		} while(np(N-1));
		
		System.out.println(count);
	}

	private static boolean np(int i) {
		// TODO Auto-generated method stub
		return false;
	}


}
