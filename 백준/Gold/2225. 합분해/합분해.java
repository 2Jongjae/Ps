import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int mod = 1_000_000_000;
        int[][] dp = new int[m+1] [n+1];
        
        
        for( int i = 0 ; i <= n ; i ++)  dp[1][i] = 1;
        
        for( int i = 2 ; i <= m ; i++) {
        	for( int j = 0 ; j <= n ; j++) {
        		for( int k = 0 ; k <=j ; k++) {
        			dp[i][j] += dp[i-1][j-k];
        			dp[i][j] %= mod;
        		}
        	}
        }
        
        System.out.println(dp[m][n]);
        
    }
}