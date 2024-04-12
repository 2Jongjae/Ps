import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	int[] arr = new int[m];
    	st = new StringTokenizer(br.readLine());
    	for( int i = 0 ; i < m ; i ++)  arr[i] = Integer.parseInt(st.nextToken());
    	
    	int ans = 0 ;

    	for (int i = 1 ; i < m -1 ; i ++) {
    		int left = 0;
    		int right = 0 ;
    		
    		for (int j = 0 ; j < i ; j++)  left = Math.max(arr[j], left);
    		
    		for ( int j = i+1 ;  j < m ; j ++) right = Math.max(arr[j], right);
    		
    		
    		int a  = Math.min(left, right) - arr[i];
    		if( a > 0 ) ans+= a;
    		
    	}
    	System.out.println(ans);
    	
    }
}
