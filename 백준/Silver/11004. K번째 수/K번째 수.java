import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i ++) {
			int input = Integer.parseInt(st.nextToken());
			pq.add(input);
		}
		for(int i = 1 ; i < m ; i ++)  pq.poll();
		
		System.out.println(pq.peek());
	}
}
