package Gold;

import java.io.*;
import java.util.*;

public class G5_9251 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();
		
		int[][] dp = new int[str1.length+1][str2.length+1];
		
		for(int i = 1; i <= str1.length; i++) {
			for(int j = 1; j <= str2.length; j++) {
				if(str1[i-1] == str2[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
				else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		
		System.out.println(dp[str1.length][str2.length]);
	}

}
