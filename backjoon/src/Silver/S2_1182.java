package Silver;

import java.io.*;
import java.util.*;

public class S2_1182 {

	static int s,n,answer=0;
	static int[] arr;
	public static void DFS(int L, int sum) {
		if(L == n) {
			if(sum == s) answer++;
		}else {
			DFS(L+1, sum + arr[L]);
			DFS(L+1, sum);
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		DFS(0,0);
		if(s == 0) System.out.println(answer-1);
		else System.out.println(answer);
	}

}
