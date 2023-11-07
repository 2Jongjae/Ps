import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> maxheap = new PriorityQueue<>();
		PriorityQueue<Integer> minheap = new PriorityQueue<>();
		
		for( int i = 0 ; i < n ; i ++) {
			
			int temp = Integer.parseInt(br.readLine());
			
			if( maxheap.size() == minheap.size()) maxheap.add(temp*-1);
			else minheap.add(temp);
			
			
			if( !maxheap.isEmpty() &&  !minheap.isEmpty()) {
				if(maxheap.peek()*-1 > minheap.peek()) {
					int t = maxheap.poll() * -1;
					maxheap.add(minheap.poll() *-1);
					minheap.add(t);
				}
			}
			
			if( minheap.size() == maxheap.size()) {
				int a = Math.min(maxheap.peek()*-1, minheap.peek());
				sb.append(a + "\n");
			} else sb.append(maxheap.peek() *-1+ "\n");
			
			
			
		}
		
		System.out.println(sb);
	
	}
}