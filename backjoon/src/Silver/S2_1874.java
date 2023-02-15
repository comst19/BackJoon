package Silver;

import java.util.*;

public class S2_1874 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		// String answer = ""; 메모리 누수 코드
		StringBuilder answer = new StringBuilder();
		
		int cur = 0;
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			int num = sc.nextInt();
			
			if(num > cur) {
				for(int j = cur + 1; j <= num; j++) {
					stack.push(j);
					answer.append("+");
				}
				cur = num;
			}else {
				if(stack.peek() != num) {
					System.out.println("NO");
					System.exit(0);
				}
			}
			stack.pop();
			answer.append("-");
		}
		for(char c : answer.toString().toCharArray()) System.out.println(c);
	}

}
