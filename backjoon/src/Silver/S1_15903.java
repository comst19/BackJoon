package Silver;

import java.util.*;

public class S1_15903 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		PriorityQueue<Long> num = new PriorityQueue<>();
		for(int i = 0; i < n; i++) num.offer(sc.nextLong());
		
		for(int i = 0; i < m; i++) {
			Long n1 = num.poll();
			Long n2 = num.poll();
			num.offer(n1+n2);
			num.offer(n1+n2);
		}
		
		long sum = 0;
		while(!num.isEmpty()) sum+=num.poll();
		
		System.out.println(sum);
	}

}
