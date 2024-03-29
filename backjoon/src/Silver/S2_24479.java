package Silver;

import java.io.*;
import java.util.*;

public class S2_24479 {

	static int n,m,r,sequence = 1;
	static int[] visited;
	static ArrayList<ArrayList<Integer>> graph;
	
	public static void DFS(int start) {
		
		visited[start] = sequence++;
		for(int next : graph.get(start)) {
			if(visited[next] == 0) DFS(next); 
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			graph.get(s).add(e);
			graph.get(e).add(s);
		}
		
		
		for(int i = 1; i <= n; i++) {
			Collections.sort(graph.get(i));
		}
		
		visited = new int[n+1];
		DFS(r);
		for(int i = 1; i <= n; i++)System.out.println(visited[i]);
	}

}
