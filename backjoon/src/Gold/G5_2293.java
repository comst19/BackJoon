package Gold;

import java.util.*;

public class G5_2293 {

	static int n, k;
	static int[] coins, dp;
	
	public static int solution() {
		dp[0] = 1;
		for(int coin : coins) {
			for(int j = coin; j <= k; j++) {
				dp[j] = dp[j] + dp[j-coin];
			}
		}
		return dp[k];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		coins = new int[n];
		dp = new int[k+1];
		for(int i=0; i<n; i++) coins[i] = sc.nextInt();
		System.out.println(solution());
	}

}
