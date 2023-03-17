package Silver;

import java.util.*;

public class S2_2885 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		
		int chcoSize = 1;
		while(chcoSize < k) {
			chcoSize *= 2;
		}
		
		StringBuilder answer = new StringBuilder();
		answer.append(chcoSize).append(" ");
		
		int slice = 0;
		while(k != 0) {
			if(k >= chcoSize) {
				k -= chcoSize;
			}else {
				chcoSize /= 2;
				slice++;
			}
			
		}
		answer.append(slice);
		
		System.out.println(answer);
	}

}