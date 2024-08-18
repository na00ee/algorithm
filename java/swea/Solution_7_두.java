package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7_두 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	static StringTokenizer st;
	static int T, answer;
	static int [][] square = new int[2][4];
	static int x1, y1, x2, y2, x3, y3, x4, y4;
	
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			sb = new StringBuilder();
//			for (int i = 0; i < 2; i++) {
//				st = new StringTokenizer(br.readLine());
//				for (int j = 0; j < 4; j++) {
//					square[i][j] = Integer.parseInt(st.nextToken());
//				}
//			}
//			
//			// case 1. 겹치는 영역 존재
//			if ((square[0][0] > square[1][0] && square[0][2] < square[1][2]) ||
//				(square[0][0] < square[1][0] && square[0][2] > square[1][2]) ||
//				(square[0][1] > square[1][1] && square[0][3] < square[1][3]) ||
//				(square[0][1] < square[1][1] && square[0][3] > square[1][3])){
//					 answer = 1;
//			// case 3. 겹치는 점이 존재
//			} else if(square[0][0]==square[1][0]&&square[0][1]==square[1][1] ||
//					  square[0][0]==square[1][0]&&square[0][1]==square[1][1] ){
//				
//			}
			
			st = new StringTokenizer(br.readLine());
			
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			x3 = Integer.parseInt(st.nextToken());
			y3 = Integer.parseInt(st.nextToken());
			x4 = Integer.parseInt(st.nextToken());
			y4 = Integer.parseInt(st.nextToken());
			
			// case 4. 겹치는 영역 미존재
			if(x2<x3 || x4<x1 || y2<y3 || y4<y1) {
				answer = 4;
			// case 3. 점으로 겹침
			} else if ((x1==x4 && y1==y4) ||
					   (x2==x3 && y2==y3) ||
					   (x1==x4 && y2==y3) ||
					   (x2==x3 && y1==y4)) {
				answer = 3;
			// case 2. 선으로 겹침
			} else if (x1==x4 || y1==y4 || x2==x3 || y2==y3) {
				answer = 2;
			} else answer = 1;
			
			sb.append("#").append(t).append(" ").append(answer);
			System.out.println(sb);
		}
	}

}
