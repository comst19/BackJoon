package Gold;

import java.io.*;
import java.util.*;

class Point{
	int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class G4_2573 {
	
	static int n,m;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] map;
	
	public static int count() {
		boolean[][] visited = new boolean[n][m];
		
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] != 0 && visited[i][j] == false) {
					DFS(i,j,visited);
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static void DFS(int y, int x, boolean[][] visited) {
		visited[y][x] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx < m && ny >= 0 && ny < n && map[ny][nx] != 0 && visited[ny][nx] == false) {
				DFS(ny, nx, visited);
			}
		}
	}
	
	public static void BFS() {
		Queue<Point> q = new LinkedList<>();
		
		boolean[][] visited = new boolean[n][m]; // 매우 중요!, 올해에 빙산에서 바다가 된 경우 바다로 인식하여 다른 빙산에 영향을 주는 것을 막을 수 있다.
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] != 0) {
					q.offer(new Point(j,i));
					visited[i][j] = true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			int sea = 0;
			for(int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx >= 0 && nx < m && ny >= 0 && ny < n && map[ny][nx] == 0 && visited[ny][nx] == false) {
					sea++;
				}
			}
			if(map[cur.y][cur.x] - sea < 0) map[cur.y][cur.x] = 0;
			else map[cur.y][cur.x] -= sea;
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		int cnt = 0;
		while((cnt = count()) < 2) {
			if(cnt == 0) {
				answer = 0;
				break;
			}
			BFS();
			answer++;
		}
		
		System.out.println(answer);
	}

}
