package Silver;

import java.io.*;
import java.util.*;

public class S2_5397 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		Stack<Character> left;
		Stack<Character> right;
		
		StringBuffer answer = new StringBuffer();
		
		for(int i = 0; i < T; i++) {
			String str = br.readLine();
			
			left = new Stack<>();
			right = new Stack<>();
			
			for(char c : str.toCharArray()) {
				
				if(c == '<') {
					if(!left.isEmpty()) right.push(left.pop());
				}else if(c == '>') {
					if(!right.isEmpty()) left.push(right.pop());
				}else if(c == '-') {
					if(!left.isEmpty()) left.pop();
				}
				else left.push(c);
			}
			
			while(!left.isEmpty()) right.push(left.pop());
			while(!right.isEmpty()) answer.append(right.pop());
			answer.append('\n');
		}
		
		System.out.println(answer);
		
	}

}
