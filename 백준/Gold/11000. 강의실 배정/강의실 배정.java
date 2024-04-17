import java.util.*;
import java.io.*;

class Position implements Comparable<Position>{
	int start, end;
	Position(int start, int end){
		this.start = start;
		this.end = end;
	}
	
	public int compareTo(Position o) {
		if( this.start== o.start) return this.end-o.end; 
		return this.start-o.start;
	}
}
public class Main {
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	Position[] arr = new Position[n];
    	
    	for( int i = 0 ; i < n ; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int start = Integer.parseInt(st.nextToken());
    		int end = Integer.parseInt(st.nextToken());
    		arr[i] = new Position(start,end);
    	}
    	
    	Arrays.sort(arr);
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
    	pq.add(arr[0].end);
    	
    	for(int i = 1 ;  i < n ; i++) {
    		if(arr[i].start >= pq.peek()) {
    			pq.poll();
    		}
    		pq.add(arr[i].end);
    	}
    	System.out.println(pq.size());
    	
    }
}
