package Silver;

import java.io.*;
import java.util.*;

public class S2_15988 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int[] q = new int[t];
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			q[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, q[i]);
		}
 		
		long[] dp = new long[max+1];
		if(max >= 1) dp[1] = 1;
		if(max >= 2) dp[2] = 2;
		if(max >= 3) dp[3] = 4;
		for(int i = 4; i <= max; i++) {
			dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1000000009;
		}
		StringBuilder answer = new StringBuilder();
		for(int x : q) System.out.println(dp[x]);
	}

}
