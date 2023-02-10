package Silver;

import java.util.*;

public class S2_11053 {

	static int n, answer = Integer.MIN_VALUE;
	static int[] arr, dp;
	
	public static void solution() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < i ; j++) {
				if(arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			answer = Math.max(answer, dp[i]);
		}
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		dp = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			dp[i] = 1;
		}
		solution();
		System.out.println(answer);
	}

}
