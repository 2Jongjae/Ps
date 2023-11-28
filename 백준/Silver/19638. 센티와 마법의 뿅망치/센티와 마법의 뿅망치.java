import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int n = Integer.parseInt(st.nextToken());
		int limit = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(st.nextToken());

		for ( int i = 0 ; i < n ; i ++) {
			int temp = Integer.parseInt(br.readLine());
			pq.add(temp*-1);
		}
		boolean flag = false;
		int cnt = 0;
		while(true) {
			int temp = pq.poll()*-1;
			
			if(temp < limit) {
				pq.add(temp*-1);
				break;
			}
			if( temp == 1 ) {
				pq.add(temp *-1);
				break;
			}
			temp /= 2;
			cnt++;
	
			pq.add(temp*-1);
			
			if( cnt == time) break;
			
		}
		if( pq.peek()*-1  < limit) flag =true; 
		
		if(flag) {
			System.out.println("YES");
			System.out.println(cnt);
		} else {
			System.out.println("NO");
			System.out.println(pq.peek()*-1);
		}
		
	}

}