package Gold;

import java.util.*;

public class G4_1715 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) pQ.offer(sc.nextInt());
		
		int sum = 0;
		while(pQ.size() > 1) {
			int lt = pQ.poll();
			int rt = pQ.poll();
			
			pQ.offer(lt+rt);
			sum = sum + lt + rt;
			
		}
		
		System.out.println(sum);
	}

}
