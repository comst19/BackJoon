package Gold;

import java.io.*;
import java.util.*;

class Lecture implements Comparable<Lecture>{
	int st, et;
	public Lecture(int st, int et) {
		this.st = st;
		this.et = et;
	}
	@Override
	public int compareTo(Lecture o) {
		if(this.st == o.st) return this.et - o.et;
		return this.st - o.st;
	}
}

public class G5_11000 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		Lecture[] lectures = new Lecture[n];
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			lectures[i] = new Lecture(start, end);
		}
		
		Arrays.sort(lectures);
		
		pQ.offer(lectures[0].et);
		
		for(int i = 1; i < n; i++) {
			if(pQ.peek() <= lectures[i].st) {
				pQ.poll();
			}
			pQ.add(lectures[i].et);
		}
		
		System.out.println(pQ.size());
		
	}

}
