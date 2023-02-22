package Silver;

import java.util.*;
import java.io.*;

public class S2_14713 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Queue<String>> qList = new ArrayList<>();
		
		for(int i = 0 ; i < n; i++) {
			Queue<String> q = new LinkedList<>();
			String[] s = br.readLine().split(" ");
			for(int k = 0; k < s.length; k++) q.offer(s[k]);
			qList.add(q);
		}
		
		String[] answer = br.readLine().split(" ");
		boolean flag = true;
		
		for(int i = 0; i < answer.length; i++) {
			if(!flag) break;
			for(int j = 0; j < qList.size(); j++) {
				flag = false;
				if(!qList.get(j).isEmpty() && qList.get(j).peek().equals(answer[i])) {
					qList.get(j).poll();
					flag = true;
					break;
				}
			}
		}
		
		while(!qList.isEmpty()) {
			if(qList.get(0).isEmpty()) qList.remove(0);
			else break;
		}
		
		if(flag && qList.isEmpty()) System.out.println("Possible");
		else System.out.println("Impossible");
		
		
	}

}
