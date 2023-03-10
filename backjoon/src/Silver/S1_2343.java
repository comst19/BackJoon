package Silver;

import java.io.*;
import java.util.*;

public class S1_2343 {

	static int n,m,left = Integer.MIN_VALUE, right = 0;
	static int[] arr;
	
	public static void solution() {
		
		while(left<=right) {
			int cnt = 1;
			int sum = 0;
			int size = (left + right) / 2;
			for(int i = 0; i < n; i++) {
				if(size < sum + arr[i]) {
					sum = 0;
					cnt++;
				}
				sum += arr[i];
			}
			
			if(cnt <= m) right = size - 1;
			else left = size + 1;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			right += arr[i];
			left = Math.max(left, arr[i]);
		} 
		
		solution();
		System.out.println(left);
	}

}
