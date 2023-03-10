package Silver;

import java.util.*;

public class S3_1213 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		
		int[] num = new int[26];
		
		for(char ch : name.toCharArray()) {
			num[ch - 'A']++;
		}
		
		int odd = 0;
		int idx = 0;
		for(int i = 0; i < 26; i++) {
			if(num[i] % 2 == 1) {
				odd++;
				idx = i;
			}
		}
		
		StringBuilder answer = new StringBuilder();
		
		int len = name.length();
		if(len % 2 == 1 && odd != 1 || len % 2 == 0 && odd != 0) {
			answer.append("I'm Sorry Hansoo");
		}else {
			for(int i = 0; i < 26; i++) {
				for(int j = 0; j < num[i] / 2; j++) answer.append((char)(i+'A'));
			}
			
			StringBuilder reverse = new StringBuilder(answer).reverse();
			
			if(odd == 1) {
				answer.append((char)(idx+'A'));
			}
			
			answer.append(reverse);
		}
		System.out.println(answer);
	}

}
