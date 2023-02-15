package Silver;

import java.io.*;

public class S2_16953 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int a = Integer.parseInt(s[0]);
		int b = Integer.parseInt(s[1]);
		int cnt = 0;
		
		while(a != b) {
			if(a > b) {
				System.out.println(-1);
				System.exit(0);
			}
			if( b % 10 == 1) b = b / 10;
			else if(b % 2 == 0) b = b / 2;
			else {
				System.out.println(-1);
				System.exit(0);
			}
			cnt++;
		}
        System.out.println(cnt+1);		
		
	}

}
