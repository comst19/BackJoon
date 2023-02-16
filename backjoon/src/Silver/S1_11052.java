package Silver;

import java.util.*;

public class S1_11052 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		
		for(int i = 1; i <= n; i++) arr[i] = sc.nextInt();
		
		dp[1] = arr[1];
		for(int i = 2; i <= n; i++ ) {
			int max = Integer.MIN_VALUE;
			for(int j = i - 1; j >= 1; j--) {
				max = Math.max(max, dp[i-j] + arr[j]);
			}
			dp[i] = Math.max(arr[i], max);
		}
		System.out.println(dp[n]);
	}

}
