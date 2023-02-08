package Gold;

import java.io.*;

public class G5_10026 {

	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static char[][] map;
	static int[][] ch;
	static int n, answer1, answer2;
	
	public static void DFS(int y, int x) {
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx < n && ny >= 0 && ny < n && map[ny][nx] == map[y][x] && ch[ny][nx] == 0 ) {
				ch[ny][nx] = 1;
				DFS(ny,nx);
			}
		}
	}
	
	public static int solution() {
		int answer = 0;
		ch = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(ch[i][j] == 0) {
					ch[i][j] = 1;
					DFS(i,j);
					answer++;
				}
			}
		}
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		answer1 = solution();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 'R') map[i][j] = 'G';
			}
		}
		
		answer2 = solution();
		
		System.out.println(answer1 + " " + answer2);
		
	}

}
