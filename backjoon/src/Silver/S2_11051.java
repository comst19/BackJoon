package Silver;

import java.util.*;

public class S2_11051 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[][] dp = new int[n+1][n+1];
		
		for(int i = 1 ; i <= n; i++) {
			for(int j = 0; j <= n; j++) {
				if(j == 0 || j == i) dp[i][j] = 1;
				else {
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10007;
				}
			}
		}
		System.out.println(dp[n][k]);
	}

}
