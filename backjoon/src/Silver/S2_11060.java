package Silver;

import java.io.*;
import java.util.*;

public class S2_11060 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1001;
		}
		
		dp[1] = 0;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= arr[i]; j++) {
				if(i+j > n) break;
				dp[i+j] = Math.min(dp[i+j], dp[i]+1);
			}
		}
		
		if(dp[n] == 1001) System.out.println(-1);
		else System.out.println(dp[n]);
		
		
	}

}
