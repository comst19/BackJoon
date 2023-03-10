package Gold;

import java.util.*;

public class G4_1339 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] value = new int[26];
		String[] S = new String[n];
		
		for(int i = 0; i < n; i++) {
			S[i] = sc.next();
		}
		
		for(String s : S) {
			for(int i = 0; i < s.length(); i++) {
				value[s.charAt(i)-'A'] +=  Math.pow(10, (s.length()-1-i));
			}
		}
		
		Arrays.sort(value);;
		int sum = 0;
		for(int i = 25,k = 9; ;i--,k--) {
			if(value[i] == 0) break;
			sum += value[i]*k;
		}
		
		System.out.println(sum);
		
		
	}

}
