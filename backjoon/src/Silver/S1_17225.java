package Silver;

import java.io.*;
import java.util.*;

public class S1_17225 {

	static class Order implements Comparable<Order>{
		int st;
		char color;
		
		public Order(int st, char color) {
			this.st = st;
			this.color = color;
		}

		@Override
		public int compareTo(Order o) {
			// TODO Auto-generated method stub
			if(this.st == o.st) return this.color - o.color;
			return this.st - o.st;
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sangT = Integer.parseInt(st.nextToken());
		int jiT = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int sTM = 0;
		int jTM = 0;
		
		PriorityQueue<Order> pQ = new PriorityQueue<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			int num = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < num; j++) {
				if(c == 'B') {
					if(sTM >= t) {
						pQ.add(new Order(sTM,c));
						sTM += sangT;
					}else {
						pQ.add(new Order(t,c));
						sTM = t + sangT;
					}
				}else {
					if(jTM >= t) {
						pQ.add(new Order(jTM,c));
						jTM += jiT;
					}else {
						pQ.add(new Order(t,c));
						jTM = t + jiT;
					}
				}
			}
			
		}
		
        ArrayList<Integer> sangmin = new ArrayList<>();
        ArrayList<Integer> jisoo = new ArrayList<>();
		
        int cnt = 1;
        while(!pQ.isEmpty()) {
        	Order order = pQ.poll();
        	if(order.color == 'B') sangmin.add(cnt);
        	else jisoo.add(cnt);
        	cnt++;
        }
        StringBuffer answer = new StringBuffer();
        answer.append(sangmin.size()).append("\n");
        for(int x : sangmin) answer.append(x).append(" ");
        answer.append("\n");
        answer.append(jisoo.size()).append("\n");
        for(int x : jisoo) answer.append(x).append(" ");
        
        System.out.println(answer);
	}
}
