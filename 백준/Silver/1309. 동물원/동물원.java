import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n+1][3];
        
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;
        
        
        
        for(int i = 2 ; i<= n ; i++) {
        	dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2];
        	dp[i][1] = dp[i-1][0] + dp[i-1][2];
        	dp[i][2] = dp[i-1][0] + dp[i-1][1];
        	
        	dp[i][0] %= 9901;
        	dp[i][1] %= 9901;
        	dp[i][2] %= 9901;
        }
        
        int ans = dp[n][0] + dp[n][1] + dp[n][2];
        ans %= 9901;
        System.out.println(ans);
        
    }
}
