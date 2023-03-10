package Silver;

import java.util.*;

public class S1_11057 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] dp = new int[n+1][10];  
		for(int i = 0; i <= 9; i++) dp[0][i] = 1;
		
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j <= 9; j++) {
				for(int k = j; k <= 9; k++) {
					dp[i][j] = dp[i][j] + dp[i-1][k];
					dp[i][j] = dp[i][j] % 10007;
				}
			}
		}
		System.out.println(dp[n][0]);
	}

}
