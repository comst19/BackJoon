package Silver;

import java.io.*;
import java.util.*;

public class S1_20207 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[367];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			for(int j = start; j <= end; j++) arr[j]++;
		}
		
		int w = 0;
		int h = 0;
		int answer = 0;
		for(int i = 1; i <= 365; i++) {
			if(arr[i] > 0) {
				w++;
				h = Math.max(h, arr[i]);
			}else {
				answer += (w * h);
				w = 0;
				h = 0;
			}
		}
		answer += (w * h);
		System.out.println(answer);
	}

}
