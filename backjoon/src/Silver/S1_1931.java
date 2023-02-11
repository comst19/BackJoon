package Silver;

import java.util.*;

class Times implements Comparable<Times>{
	int st, et;
	Times(int st, int et) {
		this.st = st;
		this.et = et;
	}
	@Override
	public int compareTo(Times o) {
		// TODO Auto-generated method stub
		if(this.et == o.et) return this.st - o.st;
		return this.et - o.et;
	}
}

public class S1_1931 {

	static int n;
	static ArrayList<Times> arr = new ArrayList<>();
	
	public static int solution() {
		Collections.sort(arr);
		int answer = 0, et = 0;
		for(Times o : arr) {
			if(et <= o.st ) {
				answer++;
				et = o.et;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i = 0; i < n; i ++) {
			int st = sc.nextInt();
			int et = sc.nextInt();
			arr.add(new Times(st,et));
		}
		
		System.out.println(solution());
	}

}
