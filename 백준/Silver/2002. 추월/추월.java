import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	int n = Integer.parseInt(br.readLine());
    	
    	String[] arr = new String[n];
    	String[] arr2 = new String[n];
    	boolean[] visit = new boolean[n];
    	for(int i = 0; i < n ; i++)  arr[i] = br.readLine();
    	for(int i = 0; i < n ; i++)  arr2[i] = br.readLine();
    	
    	int ans = 0;
    	
    	for(int i = 0 ; i < n ; i ++) {
    		
    		for( int j = 0 ; j < n ; j ++) {
    			if(arr[i].equals(arr2[j])) {
    				visit[j] = true;
    				break;
    			}
    			if( !visit[j]) {
    				visit[j] = true;
    				ans++;
    			}
    			
    		}
    	}
    	
    	
    	System.out.println(ans);
    	
    	
    }
}
