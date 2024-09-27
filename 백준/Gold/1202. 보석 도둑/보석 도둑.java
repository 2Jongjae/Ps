import java.util.*;
import java.io.*;
class Position implements Comparable<Position>{
	int kg, value;
	
	Position(int kg, int value){
		this.kg = kg;
		this.value = value;
	}
	
	public int compareTo(Position o) {
		return this.kg - o.kg;
	}
}

public class Main {
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		Position[] ps = new Position[n];
		int[] arr = new int[m];
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			int kg = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			ps[i] = new Position(kg,value);
		}
		
		for(int i = 0 ; i < m ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(ps);
		Arrays.sort(arr);
		
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		long ans = 0;
		int idx = 0 ;
		for(int i = 0 ; i < m ; i++) {
			int cnt = 0; 
			for(int j = idx ; j < n ; j ++) {
				if(ps[j].kg <= arr[i]  ) {
					pq.add(ps[j].value);
					cnt++;
				} else  break;
			}
			idx += cnt;
			if(!pq.isEmpty()) ans += pq.poll();
		}
	
		System.out.println(ans);
	}
}
