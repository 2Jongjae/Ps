import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		TreeMap<String,PriorityQueue<Integer>> tm = new TreeMap();
		
		long ans = 0 ;
		
		for ( int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			int standard = Integer.parseInt(st.nextToken());
			if( standard == 1) {
				String input = st.nextToken();
				int m = Integer.parseInt(st.nextToken());
				PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
				if( tm.get(input) != null ) pq = tm.get(input);
				for( int j= 0 ; j < m ; j++) {
					pq.add(Integer.parseInt(st.nextToken()));
				}
				tm.put(input, pq);
				
			} else {
				String input = st.nextToken();
				int time = Integer.parseInt(st.nextToken());
				if(tm.get(input) == null || tm.get(input).size() == 0 )  continue;
				PriorityQueue<Integer> pq = tm.get(input);
				int cnt = 0 ; 
				while(!pq.isEmpty()) {
					ans += pq.poll();
					cnt++;
					if( cnt == time) break;
				}
				tm.put(input, pq);
			}
			
		}
//		System.out.println(tm);
		System.out.println(ans);
		
	}
}