package Silver;

import java.util.*;

public class S1_11497 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i = 0 ; i < T; i++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			int[] answer = new int[n];
			
			for(int j = 0; j < n; j++) arr[j] = sc.nextInt();
			
			Arrays.sort(arr);
			int left = 0;
			int right = n-1;
			for(int j = 0; j < n ; j++) {
				if(j % 2 == 0) answer[left++] = arr[j];
				else answer[right--] = arr[j];
			}

			int max = Integer.MIN_VALUE;
			for(int j = 1; j < n; j++) {
				max = Math.max(max, Math.abs(answer[j] - answer[j-1]));
			}
			max = Math.max(max, Math.abs(answer[0] - answer[n-1]));
			
			System.out.println(max);
		}
		
	}

}
