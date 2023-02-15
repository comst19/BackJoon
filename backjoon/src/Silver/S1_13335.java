package Silver;

import java.util.*;

public class S1_13335 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 트럭 수
		int w = sc.nextInt(); // 다리의 길이
		int l = sc.nextInt(); // 다리의 최대하중
		
		Queue<Integer> t = new LinkedList<>();
		for(int i = 0; i < n; i++) t.offer(sc.nextInt());
		
		
		Queue<Integer> b = new LinkedList<>();
		for(int i = 0; i < w; i++) b.offer(0);
		
		int cnt = 0, weight = 0;
		
		while(!b.isEmpty()) {
			weight = weight - b.poll();
			if(!t.isEmpty()) {
				if(weight + t.peek() <= l) {
					int cur = t.poll();
					weight = weight + cur;
					b.offer(cur);
				}else {
					b.offer(0);
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}

}
