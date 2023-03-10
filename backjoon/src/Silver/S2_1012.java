package Silver;

import java.util.*;

class Point{
	public int x,y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class S2_1012 {
	
	static int T, m, n, k, answer;
	static Queue<Point> q;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	static int[][] map;
	static Scanner sc = new Scanner(System.in);
	
	public static void BFS(int x, int y) {
		q = new LinkedList<>();
		q.offer(new Point(x,y));
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			for(int i=0; i<4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if(nx>=0 && nx < m && ny >= 0 && ny < n && map[ny][nx] == 1) {
					q.offer(new Point(nx,ny));
					map[ny][nx] = 0;
				}
			}
		}
	}
	
	public static void readyBFS() {
		map = new int[n][m];
		for(int i=0; i<k; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[y][x] = 1;
		}
		answer = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 1) {
					map[i][j] = 0;
					answer++;
					BFS(j,i);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T = sc.nextInt();
		for(int i=0; i < T; i++) {
			m = sc.nextInt();
			n = sc.nextInt();
			k = sc.nextInt();
			readyBFS();
			System.out.println(answer);
		}
	}

}
