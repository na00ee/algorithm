import java.util.Scanner;
// 터짐 123456 10 -> (15)^10 => 600초
public class Solution_1244 {

	static int T,N,K;
	static int[][] maxVal;
	static int max;
	public static void main(String[] args) {
	
		Scanner scann=new Scanner(System.in);
		T=scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N=scann.nextInt();
			K=scann.nextInt();
			max=-1;
			int n=(""+N).length();
			card((""+N),0);
			System.out.println("#"+t+" "+max);
		}

	}
	static void card(String ss, int cnt) {
		if(cnt==K) {
			int val=Integer.parseInt(ss);
			max=Math.max(max, val);
			return;
		}
		
		int n=ss.length();
		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n; j++) {
				char[] cs=(""+N).toCharArray();
				char tc=cs[i];
				cs[i]=cs[j];
				cs[j]=tc; 
				card(new String(cs),cnt+1);
			}
		}
	}

}
