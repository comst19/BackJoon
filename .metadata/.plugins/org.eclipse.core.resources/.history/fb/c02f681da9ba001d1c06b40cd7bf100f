package Silver;

import java.io.*;
import java.util.*;

public class S2_11501 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			int max = Integer.MIN_VALUE;
			long answer = 0;
			for(int j = n-1; j >= 0; j--) {
				if(arr[j] > max) max = arr[j];
				else answer += max - arr[j];
			}
			
			System.out.println(answer);
		}
	}

}
