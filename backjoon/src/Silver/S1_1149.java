package Silver;

import java.util.*;

public class S1_1149 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] cost = new int[n+1][3];
		for(int i = 1; i <= n; i++) {
			int rc = sc.nextInt();
			int gc = sc.nextInt();
			int bc = sc.nextInt();
			
			cost[i][0] = Math.min(cost[i-1][1], cost[i-1][2]) + rc; 
			cost[i][1] = Math.min(cost[i-1][0], cost[i-1][2]) + gc; 
			cost[i][2] = Math.min(cost[i-1][0], cost[i-1][1]) + bc; 
		}
		int answer = Math.min(cost[n][0], Math.min(cost[n][1], cost[n][2]));
		System.out.println(answer);
	}

}
