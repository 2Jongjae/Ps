import java.io.*;
import java.util.*;

	
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br= new BufferedReader(new InputStreamReader(System.in ));
    	long[] dp = new long[51];
    	int n = Integer.parseInt(br.readLine());
    	dp[0] = 1;
    	dp[1] = 1;
    	
    	for ( int i =2  ; i<51  ; i++) {
    		dp[i] = (dp[i-2] + dp[i-1]+1) % 1000000007;
    	}
    	System.out.println(dp[n]);
    	
    }
}