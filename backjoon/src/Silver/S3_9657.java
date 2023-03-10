package Silver;

import java.util.*;

public class S3_9657 {
	
	static int[] dp;
	
	public static void solution(int n) {
		// 1이면 상근, 0이면 창영
		dp[1] = 1;
		dp[2] = 0;
		dp[3] = 1;
		dp[4] = 1;
		for(int i=5; i <= n; i++) {
			if(dp[i-1] % 2 == 0 || dp[i-3] % 2 == 0 || dp[i-4] % 2 == 0)
				dp[i] = 1;
			else dp[i] = 0;
		}
		if(dp[n] == 1) {
			System.out.println("SK");
		}else System.out.println("CY");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new int[1001];
		solution(n);
		System.out.println();
	}

}
