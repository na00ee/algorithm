
public class JMMath {

	public static void main(String[] args) {

		System.out.println(isPrime(1283));
		System.out.println(isPrime1(1283));
		dividePrime(350);
		dividePrime(10000137);
		
	}

	public static boolean isPrime1(int n) {
		for (int i = 2; i*i <= n; i++) {
			if(n%i==0) return false;
		}
		return true;
	}
	
	public static boolean isPrime(int n) {
		for (int i = 2; i <= (int)(Math.sqrt(n)); i++) {
			if(n%i==0) return false;
		}
		return true;
	}
	
	public static void dividePrime(int n) {
		
		int p = 2;
		while(n>1) {
			if(n%p==0) {
				if(n/p==1) {
					System.out.printf("%d\n", p);
				}else {
					System.out.printf("%d X ", p);
				}
				n/=p;
			} else {
				p++;
			}
		}
		
	}
	
	public static int sumEach(int n) {
		int tot = 0;
		while(n>0) {
			tot += (n%10);
			n/=10;
		}
		return tot;
	}
	
}
