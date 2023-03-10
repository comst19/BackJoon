package Gold;

import java.io.*;
import java.util.StringTokenizer;

public class G4_10942 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n+1];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1 ; i <= n; i++)arr[i] = Integer.parseInt(st.nextToken());
		
		boolean[][] dp = new boolean[n+1][n+1];
		
		for(int i = 1; i <= n; i++) dp[i][i] = true;
		for(int i = 1; i <= n-1; i++) {
			if(arr[i] == arr[i+1]) dp[i][i+1] = true;
		}
        for(int i = 2; i < n; i++){
            for(int j = 1; j <= n - i; j++){
                if(arr[j] == arr[j + i] && dp[j + 1][j + i - 1])
                    dp[j][j + i] = true;
            }
        }
		
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		
		StringBuilder answer = new StringBuilder();
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			
			if(dp[to][from]) answer.append(1).append("\n");
			else answer.append(0).append("\n");
		}
		System.out.println(answer);
	}

}
