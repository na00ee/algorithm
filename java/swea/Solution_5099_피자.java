

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5099_피자 {

	static class Pizza{
		int index;
		int C;
		
		public Pizza(int index, int c) {
			super();
			this.index = index;
			C = c;
		}
		
	}
	static int T, N, M;
	static int[] map;
	
	static Queue<Pizza> ovens;
	static Queue<Pizza> pizzas;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T+1; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			pizzas = new LinkedList<>();
			
			ovens = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < M; i++) {
				pizzas.offer(new Pizza(i+1, Integer.parseInt(st.nextToken())));
			}
			
			for (int i = 0; i < N; i++) {
				ovens.offer(pizzas.poll());
				
			}
			
			while(!(ovens.size()==1)) {
				ovens.peek().C = ovens.peek().C/2;
				if(ovens.peek().C==0) {
					pizzas.offer(ovens.poll());
				} else {
					ovens.offer(ovens.poll());
				}
				if(pizzas.peek().C != 0 && ovens.size()!=N) ovens.offer(pizzas.poll());  
			}
			System.out.println("#" + t + " " + ovens.peek().index);
		}
	}

}
