package Silver;

import java.io.*;
import java.util.*;

public class S2_1406 {

	public static void main(String[] args) throws Exception {
	    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
	    int n = Integer.parseInt(br.readLine());
		
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		
		for(int i = 0; i < s.length(); i++) left.push(s.charAt(i));
		
		for(int i = 0; i < n; i++) {
			char[] com = br.readLine().toCharArray();
			if(com[0] == 'P') {
				left.push(com[2]);
			}else if(com[0] == 'B' && !left.isEmpty()) {
				left.pop();
			}else if(com[0] == 'L' && !left.isEmpty()) {
				right.push(left.pop());
			}else if(com[0] == 'D' && !right.isEmpty()) {
				left.push(right.pop());
			}
		}
		
		StringBuilder sb = new StringBuilder();
	    while(!left.isEmpty()) right.push(left.pop());
	    while(!right.isEmpty()) sb.append(right.pop());
	    System.out.println(sb);
	}

}