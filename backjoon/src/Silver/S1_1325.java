package Silver;

import java.io.*;
import java.util.*;

public class S1_1325 {

	static int n,m;
	static ArrayList<ArrayList<Integer>> graph;
	
	public static int BFS(int start) {
		boolean[] visited = new boolean[n+1];
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;
		int cnt = 1;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int nCur : graph.get(cur)) {
				if(visited[nCur] == false) {
					visited[nCur] = true;
					q.offer(nCur);
					cnt++;
				}
			}
		}
		return cnt;
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[] computer = new int[n+1];
		graph = new ArrayList<>();
		for(int i = 0; i <= n; i++) graph.add(new ArrayList<Integer>());
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			graph.get(c2).add(c1);
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 1; i <= n; i++) {
			computer[i] = BFS(i);
			max = Math.max(max, computer[i]);
		}
		
		StringBuilder answer = new StringBuilder();
		for(int i = 1; i <= n; i++) {
			if(computer[i] == max) answer.append(i).append(" ");
		}
		
		System.out.println(answer);
	}

}
