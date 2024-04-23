import java.util.*;
import java.io.*;
class Position implements Comparable<Position>{
	int x,y;
	Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int compareTo(Position o) {
		if( this.x == o.x) return o.y - this.y;
		return (this.x -o.x);
	}
	
}


public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	Position[] arr = new Position[n];
    	for(int i = 0 ; i < n ; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int start = Integer.parseInt(st.nextToken());
    		int end = Integer.parseInt(st.nextToken());
    		arr[i] = new Position(start,end);
    	}
    	
    	Arrays.sort(arr);
    	
    	int left = arr[0].x;
    	int right = arr[0].y;
    	int ans = right -left;
    	for( int i = 1 ; i < n ; i++) {
    		if( arr[i].x <= right && arr[i].y > right) {
    			ans+= (arr[i].y - right);
    			right = arr[i].y;
    		}
    		if (arr[i].x > right) {
    			left = arr[i].x;
    			right = arr[i].y;
    			ans += (right-left);
    		}
    		
    	}
    System.out.println(ans);
    	
    }
}
