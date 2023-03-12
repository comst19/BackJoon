package Silver;

import java.io.*;
import java.util.*;

public class S1_1389 {

	static int INF = 5001;
	static int n;
	static int[][] arr;
	
	static void floyd() {
		
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n= Integer.parseInt(st.nextToken());
		int m= Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][n+1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(i == j) arr[i][j] = 0;
				else arr[i][j] = INF;
			}
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int f1 = Integer.parseInt(st.nextToken());
			int f2 = Integer.parseInt(st.nextToken());
			arr[f1][f2] = 1;
			arr[f2][f1] = 1;
		}
		
		floyd();

		int answer = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i = 1; i <= n; i++) {
			int sum = 0;
			for(int j = 1; j <= n; j++) {
				sum += arr[i][j];
			}
			if(sum < min) {
				min = sum;
				answer = i;
			}
			
			
		}
	
		System.out.println(answer);
		
	}

}
