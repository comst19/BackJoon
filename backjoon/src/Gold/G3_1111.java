package Gold;

import java.util.*;
import java.io.*;

public class G3_1111 {

	static int n;
	static int[] arr;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		if(n == 1 || (n == 2 && arr[0] != arr[1])) {
			System.out.println("A");
			System.exit(0);
		}else if(n == 2) {
			System.out.println(arr[0]);
			System.exit(0);

		}
		
		int a,b;
		if(arr[1] == arr[0]) {
			a = 1;
			b = 0;
		}else {
			a = (arr[2]-arr[1]) / (arr[1] - arr[0]);
			b = arr[1] - (arr[0]*a);
		}
		
		if(check(a,b)) {
			System.out.println(arr[n-1]*a + b);
		}else {
			System.out.println("B");
		}
	}
	
	static boolean check(int a, int b) {
        for(int i=0; i<n-1; i++) {
            if(arr[i+1] != (arr[i]*a+b) )
                return false;
        }
        return true;
    }

}
