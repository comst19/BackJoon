package Silver;

import java.io.*;

public class S2_1541 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split("\\-");
		
		int answer = 0;
		for(int i = 0; i < s.length; i++) {
			int sum = 0;
			String[] add = s[i].split("\\+");
			
			for(String n : add) sum = sum + Integer.parseInt(n);
			
			if(i==0) answer = answer + sum;
			else answer = answer - sum;
		}
		System.out.println(answer);

	}

}
