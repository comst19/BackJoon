package Silver;

import java.io.*;
import java.util.*;

public class S1_1303 {

	static int n,m,cur_w,cur_b;
	static int total_w = 0, total_b = 0;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	static char[][] map;
	
	static void DFS(int y, int x, char c) {
		visited[y][x] = true;
		if(c == 'W') cur_w++;
		if(c == 'B') cur_b++;
		
		
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny >= 0 && ny < m && nx >= 0 && nx < n && map[ny][nx] == c && visited[ny][nx] == false) {
				DFS(ny,nx,c);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 가로
		m = Integer.parseInt(st.nextToken()); // 세로
		
		map = new char[m][n];
		for(int i = 0; i < m; i++) {
			String str = br.readLine();
			for(int j = 0; j < n ; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		visited = new boolean[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(visited[i][j] == false) {
					cur_w = 0;
					cur_b = 0;
					DFS(i,j,map[i][j]);
					total_b += (cur_b*cur_b);
					total_w += (cur_w*cur_w);
				}
			}
		}
		
		System.out.println(total_w+ " " + total_b);
	}

}
