package Silver;

import java.util.*;

public class S1_2468 {

	static int n, max_h = Integer.MIN_VALUE;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int[][] map, ch;
	
	
	public static int solution() {
		int answer = Integer.MIN_VALUE;
		for(int h = 1; h <= max_h; h++) { // h는 물에 안 잠기는 건물의 높이
			ch = new int[n][n];
			int num = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(map[i][j] >= h && ch[i][j] == 0) {
						num++;
						DFS(j,i, h);
					}
				}
			}
			answer = Math.max(answer, num);
		}
		return answer;
	}
	
	public static void DFS(int x, int y, int h) {
		ch[y][x] = 1;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx < n && ny >= 0 && ny < n && map[ny][nx] >= h && ch[ny][nx] == 0) {
				ch[ny][nx] = 1;
				DFS(nx, ny, h);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] > max_h) max_h = map[i][j];
			}
		}
		System.out.println(solution());
	}

}
