package Gold;

import java.io.*;
import java.util.*;

class Point{
	int y,x;
	public Point(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class G4_14502 {


    static int n,m,answer = Integer.MIN_VALUE;
    static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
    static int[][] map, copyMap;

    
    public static void DFS(int wall) {
        if(wall == 3) {
            BFS();
            return;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    DFS(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
    
    public static void BFS() {
        Queue<Point> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 2) {
                    q.add(new Point(i,j));
                }
            }
        }

        copyMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            copyMap[i] = map[i].clone();
        }

        while(!q.isEmpty()) {
            Point cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(ny >= 0 && ny < n && nx >= 0 && nx < m && copyMap[ny][nx] == 0){
                        q.add(new Point(ny,nx));
                        copyMap[ny][nx] = 2;
                }
            }
        }

        Safe();
    }

    public static void Safe() {
        int cnt =0;
        for(int i = 0; i < n ; i++) {
            for(int j = 0; j < m; j++) {
                if(copyMap[i][j] == 0) cnt++;
            }
        }
        answer = Math.max(cnt, answer);
    }
    
    public static void main(String[] args) throws IOException {
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

        DFS(0);
        System.out.println(answer);
    }

}
