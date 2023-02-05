package Silver;

import java.util.*;

public class S3_9095 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] nums = new int[t];
		int max = Integer.MIN_VALUE;
		for(int i=0; i<t; i++) {
			nums[i] = sc.nextInt();
			max = Math.max(max, nums[i]);
		}
		int[] dp = new int[max + 1];
		
		if(max>=1) dp[1] = 1;
		if(max>=2) dp[2] = 2;
		if(max>=3) dp[3] = 4;
		for(int i = 4; i < max+1; i++) {
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
		}
		for(int x : nums) System.out.println(dp[x]);
		
	}

}
