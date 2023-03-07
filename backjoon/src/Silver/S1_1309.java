package Silver;

import java.util.*;

public class S1_1309 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] dp = new int[n+1][3];
		Arrays.fill(dp[1],1);
		
		for(int i = 2; i <= n; i++) {
			dp[i][0] = (dp[i-1][0]+dp[i-1][1]+dp[i-1][2]) % 9901;
			dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;
			dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9901;
		}
		int answer = 0;
		for(int num : dp[n]) answer+= num;
		System.out.println(answer % 9901);
	}

}
