package Silver;

import java.util.*;

public class S2_1912 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		int answer = Integer.MIN_VALUE;
		for(int i = 1; i <= n; i++) {
			int num = sc.nextInt();
			dp[i] = Math.max(num, dp[i-1] + num);
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(answer);
	}

}
