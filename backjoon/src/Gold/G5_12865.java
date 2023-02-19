package Gold;

import java.util.*;

public class G5_12865 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
		int[] W = new int[n + 1];
		int[] V = new int[n + 1];
		int[][] dp = new int[n + 1][k + 1];
 
		for (int i = 1; i <= n; i++) {
			W[i] = sc.nextInt();
			V[i] = sc.nextInt();
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				
				if(W[i] > j) {
					dp[i][j] = dp[i - 1][j];
				}
				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
				}
				
			}
		}
		
		System.out.println(dp[n][k]);
	}

}
