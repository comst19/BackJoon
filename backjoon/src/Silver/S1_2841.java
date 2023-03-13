package Silver;

import java.io.*;
import java.util.*;

public class S1_2841 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int tP = Integer.parseInt(st.nextToken());
		
		ArrayList<Stack<Integer>> stacks = new ArrayList<>();
		for(int i = 0; i <= 6; i++) stacks.add(new Stack<>());
		
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int pN = Integer.parseInt(st.nextToken());
			
			if(stacks.get(l).isEmpty()) {
				stacks.get(l).push(pN);
				cnt++;
			}else {
				while(!stacks.get(l).isEmpty() && stacks.get(l).peek() > pN) {
					stacks.get(l).pop();
					cnt++;
				}
				if(!stacks.get(l).isEmpty() && stacks.get(l).peek() == pN) continue;
				else {
					stacks.get(l).push(pN);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}
