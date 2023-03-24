package Silver;

import java.io.*;
import java.util.*;

public class S3_19941 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		char[] table = br.readLine().toCharArray();
		
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			if(table[i] == 'P') {
				int s = Math.max(i-k, 0);
				int e = Math.min(i+k, n-1);
				for(int j = s; j <= e; j++) {
					if(table[j] == 'H') {
						cnt++;
						table[j] = 'N';
						break;
					}
				}
			}
		}
		System.out.println(cnt);

	}

}
