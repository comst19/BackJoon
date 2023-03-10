package Gold;

import java.io.*;
import java.util.*;

class Time implements Comparable<Time>{
	int start, end;
	public Time(int start, int end) {
		this.start = start;
		this.end = end;
	}
	@Override
	public int compareTo(Time o) {
		// TODO Auto-generated method stub
		return this.start - o.start;
	}
	
}

class Seat implements Comparable<Seat>{
	int end, idx;
	public Seat(int end, int idx) {
		this.end = end;
		this.idx = idx;
	}
	@Override
	public int compareTo(Seat o) {
		// TODO Auto-generated method stub
		if(this.end == o.end) return this.idx - o.idx; 
		return this.end - o.end;
	}
}

public class G3_12764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        int[] ch = new int[n];
        Time[] times = new Time[n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            times[i] = new Time(start,end);
        }
        
        Arrays.sort(times);
        PriorityQueue<Seat> seats = new PriorityQueue<>();
        PriorityQueue<Integer> idx = new PriorityQueue<>();
        
        for(Time time : times) {
        	
        	while(!seats.isEmpty() && time.start >= seats.peek().end) {
        		idx.add(seats.poll().idx);
        	}
        	
        	if(idx.isEmpty()) {
        		seats.offer(new Seat(time.end, cnt));
        		ch[cnt] = 1;
        		cnt++;
        	}else {
        		int num = idx.poll();
        		seats.offer(new Seat(time.end, num));
        		ch[num]++;
        	}
        }
        System.out.println(cnt);
        for(int i = 0; i < cnt; i++) System.out.print(ch[i]+" ");
    }
}