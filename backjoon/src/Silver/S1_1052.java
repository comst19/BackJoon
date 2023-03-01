package Silver;

import java.util.*;

public class S1_1052 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int answer = 0;
		
		if(n <= k) answer = 0;
		else {
			while(true) {
				int cnt = 0; // 물병 개수
				int temp = n + answer;
				while(temp > 0) {
					if(temp % 2 == 1) cnt++;
					temp = temp / 2;
				}
				if(cnt <= k) break;
				answer++;
			}
		}
		System.out.println(answer);
	}

}
