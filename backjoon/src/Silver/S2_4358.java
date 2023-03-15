package Silver;

import java.io.*;
import java.util.*;

public class S2_4358 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<String, Integer> hM = new HashMap<>();
		
		int cnt = 0;
		while(true) {
			String tree = br.readLine();
			
			if(tree == null || tree.length() == 0) break;
			
			hM.put(tree, hM.getOrDefault(tree, 0)+1);
			cnt++;
		}
		
		Object[] keys = hM.keySet().toArray();
		Arrays.sort(keys);
		
		StringBuilder answer = new StringBuilder();
		for(Object key : keys) {
			String tree = (String)key;
			int num = hM.get(tree);
			double value = (num * 100.0) / cnt;
			answer.append(tree+" "+String.format("%.4f", value) + "\n");
		}
		
		System.out.println(answer);
	}

}
