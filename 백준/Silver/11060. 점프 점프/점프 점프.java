import java.io.*;
import java.util.*;

	
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
       int n = Integer.parseInt(br.readLine());
    
       int[] dp = new int[1100];
       int[] arr = new int[n+1];
       StringTokenizer st= new StringTokenizer(br.readLine());
       for ( int i = 1 ; i<=n ; i++) arr[i] = Integer.parseInt(st.nextToken());
       	
       Arrays.fill(dp, 2000);
       dp[1] = 0 ;
       for (int i = 2 ; i<=n ; i++) {
    	   int a = arr[i-1];
    	   for (int j = 0 ; j < a ; j++) {
    		   dp[i+j] = Math.min(dp[i-1] +1, dp[i+j]);
    	   
    	   }
    	   
       }
       
       if( dp[n] == 2000) System.out.println(-1);
       else System.out.println(dp[n]);
    }
}