package Silver;

import java.io.*;
import java.util.*;

public class S2_11722 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int arr[] = new int[n+1];
		int dp[] = new int[n+1];
	
		
		st = new StringTokenizer(br.readLine());
		int answer = Integer.MIN_VALUE;
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
			for(int j = i-1; j >= 0; j--) {
				if(arr[j] > arr[i]) {
					dp[i] = Math.max(dp[j]+1, dp[i]);
				}
			}
			answer = Math.max(answer, dp[i]);
		} 
		
		System.out.println(answer);
		
	}

}
