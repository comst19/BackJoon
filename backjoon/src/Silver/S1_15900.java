package Silver;

import java.io.*;
import java.util.*;

public class S1_15900 {

	static int answer = 0;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	
	public static void DFS(int start, int L) {
		visited[start] = true;
		if(start != 1 && graph.get(start).size() == 1) {
			answer += L;
			return;
		}
		for(int next : graph.get(start)) {
			if(visited[next] == false) DFS(next,L+1);
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());
		
		visited = new boolean[n+1];
		for(int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		DFS(1,0);
		if(answer % 2 == 0) System.out.println("No");
		else System.out.println("Yes");
	}

}
