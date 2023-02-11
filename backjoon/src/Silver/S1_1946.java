package Silver;

import java.util.*;

class Ranks implements Comparable<Ranks>{
	int or, tr;
	Ranks(int or, int tr) {
		this.or = or;
		this.tr = tr;
	}
	@Override
	public int compareTo(Ranks o) {
		// TODO Auto-generated method stub
		return this.or - o.or;
	}
}



public class S1_1946 {

	static int T,n;
	static ArrayList<Ranks> arr;
	static Scanner sc = new Scanner(System.in);
	
	public static void solution() {
		int answer = 0, min = Integer.MAX_VALUE;
		for(Ranks o : arr) {
			if(min > o.tr) {
				answer++;
				min = o.tr;
			}
		}
		System.out.println(answer);
	}
	
	public static void dataSet() {
		n = sc.nextInt();
		arr = new ArrayList<Ranks>();
		for(int i = 0; i < n; i++) {
			int or = sc.nextInt();
			int tr = sc.nextInt();
			arr.add(new Ranks(or, tr));
		}
		Collections.sort(arr);
		solution();
			
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			dataSet();
		}
	}

}
