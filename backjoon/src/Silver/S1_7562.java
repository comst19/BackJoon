package Silver;

import java.util.*;

class Point{
	int x,y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class S1_7562 {
	static int n;
	static int[] dx = {-1,-1,-2,-2,1,1,2,2};
	static int[] dy = {2,-2,1,-1,2,-2,1,-1};
	static int[][] arr;
	
	public static int BFS(int sX, int sY, int eX, int eY) {
		
		boolean[][] visited = new boolean[n][n];
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(sX,sY));
		visited[sX][sY] = true;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			if(cur.x == eX && cur.y == eY) return arr[cur.x][cur.y];
			
			for(int i = 0; i < 8; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx >= 0 && nx < n && ny >= 0 && ny < n && visited[nx][ny] == false) {
					q.offer(new Point(nx,ny));
					arr[nx][ny] = arr[cur.x][cur.y]+1;
					visited[nx][ny] = true;
					
				}
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++) {
			n = sc.nextInt();
			arr = new int[n][n];
			
			int sX = sc.nextInt();
			int sY = sc.nextInt();
			int eX = sc.nextInt();
			int eY = sc.nextInt();
			System.out.println(BFS(sX,sY,eX,eY));
			
		}
	}

}
