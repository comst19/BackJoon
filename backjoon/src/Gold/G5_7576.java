package Gold;

import java.util.*;

class Point{
	public int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class G5_7576 {

	static int m ,n;
	static Queue<Point> q = new LinkedList<>();
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	static int[][] arr;
	
	public static void BFS() {
		while(!q.isEmpty()) {
			Point cur = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx >= 0 && nx < m && ny >= 0 && ny < n && arr[ny][nx] == 0) {
					arr[ny][nx] = arr[cur.y][cur.x] + 1;
					q.offer(new Point(nx,ny));
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		arr = new int[n][m];
		// 1 익은 토마토, 0 익지 않은 토마토, -1 토마토 없음
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) arr[i][j] = sc.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == 1) q.offer(new Point(j,i));
			}
		}
		BFS();
		boolean flag = true;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == 0) {
					flag = false;
					break;
				}
				max = Math.max(arr[i][j], max);
			}
			if(flag == false) break;
		}
		// 첫째 날은 제외
		int answer = max - 1;
		if(flag) System.out.println(answer);
		else System.out.println(-1);
	}

}
