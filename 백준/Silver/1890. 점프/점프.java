import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		long[][] dp = new long[n+1][n+1];
		
		dp[1][1]= 1;
		for (int i = 1 ; i <= n ; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j =  1 ; j<=n ; j++) {
				int temp = Integer.parseInt(st.nextToken());
				
				if( dp[i][j] >= 1 && temp != 0  ) {
					if( j+ temp <=n)  dp[i][j+temp] += dp[i][j];
					
					if( i + temp <= n ) dp[i+temp][j] += dp[i][j];
				}
				
			}
			
			
		}
		
		System.out.println(dp[n][n]);
		
		
	}
}
