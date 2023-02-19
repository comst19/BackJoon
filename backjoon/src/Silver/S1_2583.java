package Silver;

import java.util.*;

public class S1_2583 {

	static int m,n,k,area,count = 0;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	static int[][] map;
	static ArrayList<Integer> Area = new ArrayList<>();
	
	public static void DFS(int x, int y) {
		map[y][x] = 1;
		area++;
		
		for(int i = 0; i < 4 ; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && nx < n && ny >= 0 && ny < m && map[ny][nx] == 0) {
				DFS(nx, ny);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		k = sc.nextInt();
		
		map = new int[m][n];
		
		// 좌표기준 상하가 반대이기 떄문에 이렇게 했지만 직사각형은 상하대칭이기 때문에 이것을 고려할 필요가 없음
		for(int i = 0; i < k; i++) {
			int x1 = sc.nextInt();
			int y1 = m - sc.nextInt();
			
			int x2 = sc.nextInt();
			int y2 = m - sc.nextInt();
			for(int y = y2 ; y < y1; y++) {
				for(int x = x1 ; x < x2; x++) {
					map[y][x] = 1;
				}
			}
			// 상하 대칭을 미리 시켰을 경우 아래의 코드
//			int x1 = sc.nextInt();
//			int y1 = sc.nextInt();
//			
//			int x2 = sc.nextInt();
//			int y2 = sc.nextInt();
//			for(int y = y1 ; y < y2; y++) {
//				for(int x = x1 ; x < x2; x++) {
//					map[y][x] = 1;
//				}
//			}
		}
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 0) {
					area = 0;
					count++;
					DFS(j,i);
					Area.add(area);
				}
			}
		}
		System.out.println(count);
		Collections.sort(Area);
		for(int a : Area) System.out.print(a + " ");
		
	}

}
