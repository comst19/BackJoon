package Silver;

import java.util.*;

public class S3_1929 {

	static int[] nums;
	
	public static void solution(int n, int m) {
		nums[1] = 1;
		for(int i=2; i<=m ; i++) {
			if(nums[i] == 0) {
				for(int j = i+i; j<= m; j=j+i) {
					nums[j] = 1;
				}
			}
		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		nums = new int[m+1];
		solution(n,m);
		for(int i = n; i<=m ; i++) {
			if(nums[i] == 0) System.out.println(i);
		}
	}

}
