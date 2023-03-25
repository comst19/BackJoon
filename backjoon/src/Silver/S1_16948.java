package Silver;

import java.io.*;
import java.util.*;

class Point{
	int y;
	int x;
	public Point(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class S1_16948 {

	static int n,r1,c1,r2,c2;
	static int[] dx = {-1,1,-2,2,-1,1};
	static int[] dy = {-2,-2,0,0,2,2};
	static int[][] map;
	
	public static void BFS(int y, int x) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(y,x));
		boolean[][] visited = new boolean[n][n];
		visited[y][x] = true;
		while(!q.isEmpty()) {
			Point cur = q.poll();
			for(int i = 0; i < 6; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				if(nx >= 0 && nx < n && ny >= 0 && ny < n && visited[ny][nx] == false) {
					visited[ny][nx] = true;
					map[ny][nx] = map[cur.y][cur.x] + 1;
					q.offer(new Point(ny,nx));
				}
			}
		}
		
		if(visited[r2][c2]) System.out.println(map[r2][c2]);
		else System.out.println(-1);
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		
		st = new StringTokenizer(br.readLine());
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		
		BFS(r1,c1);
	}

}
