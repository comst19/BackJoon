package Silver;

import java.util.*;
import java.io.*;

public class S1_1080 {
	
	static int[][] map1, map2;
	
	public static void reverse(int y, int x) {
		for(int ny = y ; ny <= y + 2; ny++) {
			for(int nx = x; nx <= x + 2; nx++) {
				map1[ny][nx] = 1 - map1[ny][nx];
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		map1 = new int[n][m];
		map2 = new int[n][m];
		
		for(int i = 0 ; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < m; j++) map1[i][j] = s.charAt(j) - '0';
		}
		for(int i = 0 ; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < m; j++) map2[i][j] = s.charAt(j) - '0';
		}
		
		int cnt = 0;
		
		for(int i = 0; i <= n-3; i++) {
			for(int j = 0; j <= m-3; j++) {
				if(map1[i][j] != map2[i][j]) {
					cnt++;
					reverse(i,j);
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map1[i][j] != map2[i][j]) {
					System.out.println(-1);
					System.exit(0);
				}
			}
		}
		
		System.out.println(cnt);
	}
	

}
