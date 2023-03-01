package Silver;

import java.util.*;

public class S2_5464 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] parkAreaCost = new int[n];
		int[] carWeight = new int[m];
		for(int i = 0; i < n; i++) parkAreaCost[i] = sc.nextInt();
		for(int i = 0; i < m; i++) carWeight[i] = sc.nextInt();
		
		int answer = 0;
		int[] parkArea = new int[n];
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 0; i < 2*m; i++) {
			int carState = sc.nextInt();
			if(carState > 0) {
				boolean flag = false;
				for(int j = 0; j < n; j++) {
					if(parkArea[j] == 0) {
						flag = true;
						parkArea[j] = carState;
						break;
					}
				}
				if(flag == false) q.offer(carState);
				
			}else {
				for(int j = 0; j < n; j++) {
					if(parkArea[j] + carState == 0) {
						parkArea[j] = 0;
						answer = answer + carWeight[carState*(-1) - 1]*parkAreaCost[j];
						if(!q.isEmpty()) parkArea[j] = q.poll();
						break;
					}
				}
			}
		}
		
		System.out.println(answer);
	}

}
