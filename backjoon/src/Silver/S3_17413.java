package Silver;

import java.io.*;
import java.util.*;

public class S3_17413 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		StringBuilder answer = new StringBuilder();
		
		Stack<Character> stack = new Stack<>();
		
		boolean flag = false;
		
		for(char c : s.toCharArray()) {
			if(c == ' ') {
				while(!stack.isEmpty()) answer.append(stack.pop());
				answer.append(" ");
			}else {
				if(c == '<') {
					while(!stack.isEmpty()) answer.append(stack.pop());
					flag = true;
					answer.append("<");
				}else if(c == '>') {
					flag = false;
					answer.append(">");
				}else {
					if(flag) answer.append(c);
					else stack.push(c);
				} 
			}
		}
		
		while(!stack.isEmpty()) answer.append(stack.pop());
		
		System.out.println(answer);
	}

}
