package Gold;

import java.io.*;
import java.util.*;

public class G5_19539 {

	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[n];
		int sum = 0;
		int odd = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			sum += num;
			if(num % 2 == 1) odd++;
		}
		
		if(sum % 3 == 0 && odd <= sum/3) System.out.println("YES");
		else System.out.println("NO");
	}

}
