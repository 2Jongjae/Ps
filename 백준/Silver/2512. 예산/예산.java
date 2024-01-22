import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
      BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      
      int[] arr =new int [n];
      st = new StringTokenizer(br.readLine());
      int sum= 0;
      int max = 0;
      for (int i = 0 ; i < n ; i++) {
    	  arr[i] = Integer.parseInt(st.nextToken());
    	  max = Math.max(max, arr[i]);
    	  sum+= arr[i];
      }
      
      int limit = Integer.parseInt(br.readLine());
      
      if( limit >= sum ) {System.out.println(max);
      return;
      }
      
      int left = 0;
      while( left <=max) {
    	  int mid = (left + max )/2;
    	  sum = 0 ; 
    	  for (int i =0  ; i < n ; i++) {
    		  if( arr[i] <=mid) sum += arr[i];
    		  else sum+= mid;
    	  }
    	  if( sum <=limit) left = mid+1;
    	  else max = mid-1;
    	  
      }
      
      System.out.println(max);
      
      
    
    }
}
