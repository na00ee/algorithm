import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_8382_방향전환 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
    static StringTokenizer st;
    static int T, x1, x2, y1, y2, disX, disY, n, min, exX, exY, temp;
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			min = 0;
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			disX = Math.abs(x1 - x2);
			disY = Math.abs(y1 - y2);

			n = (disX + disY) / 2;

			min += 2 * n;
			
			if (y1 > y2) {
				temp = x1;
				x1 = x2;
				x2 = temp;
				
				temp = y1;
				y1 = y2;
				y2 = temp;
			}
			
			if (x2 < x1) {
				exX = x1 - n;
				exY = y1 + n;
				min += Math.abs(exX - x2) + Math.abs(exY - y2);
			} else {
				exX = x1 + n;
				exY = y1 + n;
				min += Math.abs(exX - x2) + Math.abs(exY - y2);
			}
			
//			if (disX > disY) {
//				int temp = disX;
//				disX = disY;
//				disY = temp;
//			}
			sb.append(min);
			System.out.println(sb.toString());
		} // t
		
	}// main

}
