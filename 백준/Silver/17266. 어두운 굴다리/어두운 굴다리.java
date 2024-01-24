import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
      BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      int m = Integer.parseInt(st.nextToken());
      int[] arr =new int [m];
      st = new StringTokenizer(br.readLine());
      for (int i = 0 ; i < m ; i++) {
    	  arr[i] = Integer.parseInt(st.nextToken());
      }
      
      
      int left = 1;
      int right = n;
      int ans =0;
      
      while( left<=right) {
    	  int mid = (left+right)/2;
    	  int dis = 0;
    	  boolean flag = true; 
    	  for ( int light : arr) {
    		  int start = light -mid;
    		  int end = light + mid;
    	
    		  if( start<=dis) dis = end;
    		  else {
    			  flag=false;
    			  break;
    		  }
    	  }
    	
    	  if( flag && n <=  dis ) {
    		  ans = mid;
    		  right = mid-1;
    	  }
    	  else left = mid +1; 

    	  
      }
      
      System.out.println(ans);
    
    }
}
