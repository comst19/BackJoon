package Silver;

import java.io.*;
import java.util.*;

public class S2_11725 {

	static int[] answer;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	
	public static void BFS(int start) {
		answer[start] = start;
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int nCur : graph.get(cur)) {
				if(answer[nCur] == 0) {
					answer[nCur] = cur;
					q.offer(nCur);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());
		
		
		for(int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		answer = new int[n+1];
		BFS(1);
		for(int i = 2; i <= n; i++) System.out.println(answer[i]);
	}

}
