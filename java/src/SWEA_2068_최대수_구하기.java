package algol0729;
import java.util.Scanner;

class SWEA_2068_최대수_구하기{
	public static void main(String args[]) throws Exception{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++){
            int r = 0;
            for(int i = 0; i < 10;i++){   
				int n = sc.nextInt();
                if(r < n) r = n;
            }
            System.out.printf("#%d %d\n", test_case, r);
		}
	}
}