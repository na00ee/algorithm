import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2806_NQueen {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int T, N, sum;
	static int [] arr;
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			sum = 0;
			arr = new int [N];
			
			dfs(0);
			
			System.out.println(sb.append(sum));
		}
		
	}
	
	static void dfs(int cnt) {
		if (cnt==N) {
			sum++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			arr[cnt] = i;
			if (isTrue(cnt)) {
				dfs(cnt+1);
			}
			
		}
	}
	
	static boolean isTrue(int cnt) {
		for (int j = 0; j < cnt; j++) {
			if (arr[j]==arr[cnt] || Math.abs(j-cnt)==Math.abs(arr[j]-arr[cnt])) return false;
		}
		return true;
	}
	
}

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class swea_2806_NQueen {
//	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	static StringTokenizer st;
//	static StringBuilder sb;
//	static int T, N, sum;
//	static int [] arr;
//	public static void main(String[] args) throws Exception {
//		T = Integer.parseInt(br.readLine());
//		
//		for (int t = 1; t <= T; t++) {
//			sb = new StringBuilder();
//			sb.append("#").append(t).append(" ");
//			N = Integer.parseInt(br.readLine());
//			sum = 0;
//			arr = new int [N];
//			
//			dfs(0);
//			
//			System.out.println(sb.append(sum));
//		}
//		
//	}
//	
//	static void dfs(int cnt) {
//		if (cnt==N) {
//			sum++;
//			return;
//		}
//		
//		for (int i = 0; i < N; i++) {
//			arr[cnt] = i;
//			if (cnt==0) dfs(cnt+1);
//			else {
//				boolean isS = true;
//				for (int j = 0; j < cnt; j++) {
//					if (arr[j]==arr[cnt] || arr[j]+j == arr[cnt]+cnt || arr[j]-j == arr[cnt]-cnt) {
//						isS = false;
//						break;
//					}
//				}
//				if (isS) dfs(cnt+1);
//			}
//			
//		}
//	}
//	
//}