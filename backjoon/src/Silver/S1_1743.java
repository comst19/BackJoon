package Silver;

import java.io.*;
import java.util.*;

public class S1_1743 {

	static int n,m,k, answer = Integer.MIN_VALUE;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	static int[][] map;
	static Queue<Point> q;
	
	static class Point{
		int y;
		int x;
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static void BFS(int y, int x) {
		
		visited[y][x] = true;
		q.offer(new Point (y,x));
		int cnt = 1;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			for(int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				if(nx >= 1 && ny >= 1 && ny <= n && nx <= m && map[ny][nx] == 1&&visited[ny][nx] == false) {
					q.offer(new Point(ny, nx));
					visited[ny][nx] = true;
					cnt++;
				}
			}
			
		}
		
		answer = Math.max(answer, cnt);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][m+1];
		visited = new boolean[n+1][m+1];
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			map[y][x] = 1;
		}
		
		q = new LinkedList<>();
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(map[i][j] == 1 && visited[i][j] == false) {
					BFS(i,j);
				}
			}
		}
		
		
		System.out.println(answer);
	}

}
