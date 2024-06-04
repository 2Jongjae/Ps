import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	String n =  st.nextToken();
    
    	if( n.charAt(0) == '0' ) {
    		System.out.println(0);
    		return;
    	}
    	int[] dp = new int[n.length()+1];
    	
    	dp[0] = 1;
    	dp[1] = 1;
    	
    	for( int i = 2 ; i <= n.length() ; i++) {
    		int one = Integer.parseInt(n.substring(i-1, i));
    		int two = Integer.parseInt(n.substring(i-2, i));
    		
    		if( one != 0 ) dp[i] += dp[i-1];
    		
    		if( two >=10 && two <=26) dp[i] += dp[i-2];
    		
    		dp[i] %= 1000000;
    	}
    	System.out.println(dp[n.length()]);
    	
	}
}
