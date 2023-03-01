package Gold;

import java.io.*;
import java.util.*;

public class G4_17298 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		
		Stack<Integer> s = new Stack<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++) {
			
			while(!s.isEmpty() && arr[s.peek()] < arr[i] ) {
				arr[s.pop()] = arr[i];
			}
			s.push(i);
		}
		
		while(!s.isEmpty()) arr[s.pop()] = -1;
		StringBuilder answer = new StringBuilder();
		for(int x : arr) answer.append(x).append(" ");
		System.out.println(answer);
	}

}
