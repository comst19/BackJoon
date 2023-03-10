package Gold;

import java.io.*;
import java.util.*;

public class G4_3078 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Queue<Integer>[] q = new LinkedList[21];
		
		for(int i = 0; i <= 20; i++) q[i] = new LinkedList<>();
		
		long answer = 0;
		
		for(int i = 0; i < n; i++) {
			String name = br.readLine();
			int len = name.length();
			if(q[len].isEmpty()) {
				q[len].offer(i);
				continue;
			}
			while(!q[len].isEmpty()) {
				if(i - q[len].peek() <= m) {
					answer += q[len].size();
					break;
				}
				q[len].poll();
			}
			q[len].offer(i);

		}
		
		System.out.println(answer);
	}

}
