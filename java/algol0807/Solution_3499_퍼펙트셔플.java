package algol0807;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//public class Solution_3499_퍼펙트셔플 {
//
//	static int T, N;
//	static Queue<String> suffle1, suffle2;
//	static String s;
//	
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		T = Integer.parseInt(br.readLine());
//		
//		for (int t = 1; t < T+1; t++) {
//			N = Integer.parseInt(br.readLine());
//			// s 초기화
//			s = "";
//			
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			
//			// Queue 선언
//			suffle1 = new LinkedList<>();
//			suffle2 = new LinkedList<>();
//			
//			// suffle1, 2에 문자열을 반반 넣어줌
//			for (int i = 0; i < N; i++) {
//				if (i < (N+1)/2) suffle1.offer(st.nextToken());
//				else suffle2.offer(st.nextToken());
//			}
//			
//			// 새로운 문자열에 suffle1, 2.poll()을 반복해서 넣어줌
//			for (int i = 0; i < N; i++) {
//				if (i%2==0) {
//					s+=suffle1.poll() + " ";
//				} else {
//					s+= suffle2.poll() + " ";
//				}
//			}
//			System.out.println("#" + t + " " + s);
//		}
//	}
//	
//}

// Queue로 풀지 않는 경우
// 이 방법이 메모리 사용량/실행 시간이 훨씬 줄어든다!
public class Solution_3499_퍼펙트셔플 {

	static int T, N;
	static String[] s;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			N = Integer.parseInt(br.readLine());
			// 배열 s 초기화
			s = new String[N];
			StringBuilder sb = new StringBuilder();
			
			// StringTokenizer로 문자열을 받음
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				s[i] = st.nextToken();
			}
			
			// answer 문자열에 대입
			for (int i = 0; i < (N+1)/2; i++) {
				sb.append(s[i]).append(" ");
				if(i+(N+1)/2 < N) {
				sb.append(s[i+(N+1)/2]).append(" ");
				}
			}
			
			System.out.println("#" + t + " " + sb);
		}
	}
	
}