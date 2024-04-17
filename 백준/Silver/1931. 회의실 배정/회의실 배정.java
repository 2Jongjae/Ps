import java.util.*;
import java.io.*;

class Position implements Comparable<Position>{
	int start, end;
	Position(int start, int end){
		this.start = start;
		this.end = end;
	}
	
	public int compareTo(Position o) {
		if( this.end== o.end) return this.start-o.start; 
		return this.end-o.end;
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
    	
    	List<Position> li = new ArrayList<>();
    	li.add(arr[0]);
    	
    	for(int i = 1 ;  i < n ; i++) {
    		if(arr[i].start >= li.get(li.size()-1).end) {
    			li.add(arr[i]);
    		}
    	}
    	System.out.println(li.size());
    	
    }
}
