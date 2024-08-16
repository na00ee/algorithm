import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1230_암호문3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	static List<String> list = new ArrayList<>();
	static StringTokenizer st;
	static int N, M, x, y;
	static String[] arr;
	
	public static void main(String[] args) throws Exception {
		
		for (int t = 1; t < 11; t++) {
			
			// 원본 암호문 길이 받기
			N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			
			// 원본 암호문 List에 저장
			for (int i = 0; i < N; i++) {
				list.add(st.nextToken());
			}
			
			// 명령문과 개수 받기
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			// 명령문을 받고 받을 때마다 규칙에 따라 list 조정
			for (int i = 0; i < M; i++) {
				// 삽입일 경우
				if (st.nextToken().equals("I")) {
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					arr = new String[y];
					
					// 삽입할 문자열을 배열로 미리 받아두기(안 받아두고 그냥 삽입하면 거꾸로 삽입됨)
					for (int j = 0; j < y; j++) {
						arr[j] = st.nextToken();
					}
					
					// list에 받아놓은 문자열을 삽입하기
					for (int j = y-1; j >= 0; j--) {
						list.add(x, arr[j]);
					}
				// 삭제일 경우
				} else if (st.nextToken().equals("D")) {
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						list.remove(x);
					}
				// 추가일 경우
				} else {
					y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						list.add(st.nextToken());
					}
				}
			}
			
			// 암호문 뭉치의 앞부분 10개의 암호문을 출력
			sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			
			for (int i = 0; i < 11; i++) {
				sb.append(list.get(i)).append(" ");
			}
			System.out.println(sb);
		}
		
	}

}
