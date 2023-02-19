package Silver;

import java.util.*;

class Point{
	int x,y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class S1_1926 {

	static int n,m,count = 0, area;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	static int[][] map;
	
	public static void BFS(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x,y));
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx >= 0 && nx < m && ny >= 0 && ny < n && map[ny][nx] == 1) {
					q.offer(new Point(nx, ny));
					area++;
					map[ny][nx] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int max = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 1) {
					map[i][j] = 0;
					count++;
					area = 1;
					BFS(j,i);
					max = Math.max(max, area);
				}
			}
		}
		
		System.out.println(count);
		System.out.println(max);
	}

}
