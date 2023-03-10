package Silver;

import java.util.*;

public class S2_18352 {

	static int n,m,k,x;
	static int[] dis;
	static ArrayList<ArrayList<Integer>> city = new ArrayList<>();
	static Queue<Integer> q = new LinkedList<>();
	
	
	public static void BFS(int start) {
		dis = new int[n+1];
		Arrays.fill(dis, -1);
		dis[start] = 0;
		q.offer(start);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int city : city.get(cur)) {
				if(dis[city] == -1) {
					dis[city] = dis[cur] + 1;
					q.offer(city);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		x = sc.nextInt();
		
		for(int i = 0; i <= n; i++) city.add(new ArrayList<>());
		
		for(int i = 0; i < m; i++) {
			int to = sc.nextInt();
			int from = sc.nextInt();
			city.get(to).add(from);
		}
		
		BFS(x);
		boolean flag = false;
		for(int i = 1; i <= n; i++) {
			if (dis[i] == k) {
				flag = true;
				System.out.println(i);
			} 
		}
		if(flag == false) System.out.println(-1);
	}

}
