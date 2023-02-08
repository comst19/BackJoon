package Silver;

import java.util.*;

public class S5_1312 {

	public static int solution(int a, int b, int n) {
		
		int answer = a % b; // ?.12345
		for(int i=1; i<n; i++) {
			answer = answer * 10;
			answer = answer % b;
		}
		answer = answer * 10;
		answer = answer / b;
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int n = sc.nextInt();
		
		System.out.println(solution(a,b,n));
	}

}
