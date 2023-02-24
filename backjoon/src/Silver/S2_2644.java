package Silver;

import java.util.*;

public class S2_2644 {

	static int answer = 0;
	static boolean[] visit;
	static ArrayList<ArrayList<Integer>> family = new ArrayList<>();
	
	public static void DFS(int start, int target, int cnt) {
		visit[start] = true;
		
		for(int x : family.get(start)) {
			if(visit[x] == false) {
				if(x == target) {
					answer = cnt + 1;
					return;
				}
				
				DFS(x,target,cnt+1);
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t1 = sc.nextInt();
		int t2 = sc.nextInt();
		int m = sc.nextInt();
		
		visit = new boolean[n+1];
		for(int i = 0; i <= n; i++) family.add(new ArrayList<>());
		
		for(int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			family.get(x).add(y);
			family.get(y).add(x);
		}
		
		DFS(t1,t2,0);
		if(answer == 0)System.out.println(-1);
		else System.out.println(answer);
		
	}

}
