package Silver;

import java.util.*;

public class S1_2504 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		char[] str = sc.next().toCharArray();
		Stack<Character> s = new Stack<>();
		int answer = 0;
		int temp = 1;
		for(int i = 0; i < str.length; i++) {
			char cur = str[i];
			if(cur == '(' || cur == '[') {
				s.push(cur);
				if(cur == '(') temp *= 2;
				else temp *= 3;
			}else {
				if(cur == ')') {
					if(s.isEmpty() || !s.peek().equals('(')) {
						answer = 0;
						break;
					}
					if(str[i-1] == '(') answer += temp;
					s.pop();
					temp /= 2;
				}else {
					if(s.isEmpty() || !s.peek().equals('[')) {
						answer = 0;
						break;
					}
					if(str[i-1] == '[') answer += temp;
					s.pop();
					temp /= 3;
				}
			}
		}
		if(!s.isEmpty()) answer = 0;
		System.out.println(answer);
	}

}
