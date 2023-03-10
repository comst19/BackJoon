package Silver;

import java.util.*;

public class S3_2579 {

	static int n;
	static int[] arr,dp;
	
	public static int TTB(int s){
		if(dp[s] == 0 && s >= 3) {
			dp[s] = Math.max(TTB(s-3) + arr[s-1], TTB(s-2)) + arr[s];
		}
		return dp[s];
	}
	
	public static int BTT(int s){
		if(s >= 3) {
			for(int i = 3; i <= s ; i++) {
				dp[i] = Math.max(dp[i-3] + arr[i-1], dp[i-2]) + arr[i];
			}
		}
		return dp[s];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n+1];
		dp = new int[n+1];
		for(int i = 1; i < n+1; i++) arr[i] = sc.nextInt();
		
		dp[1] = arr[1];
		if(n >= 2) dp[2] = arr[1] + arr[2];
		
		//System.out.println(TTB(n));
		System.out.println(BTT(n));
	}

}
