import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		int n = a.length();
		int m = b.length();
		
		int[][] dp = new int[n+1][m+1];
		for ( int i  = 1;  i <= n ; i ++) {
			char temp1 = a.charAt(i-1);
			for (int j = 1 ; j <= m ; j ++) {
				char temp2  = b.charAt(j-1);
				if(temp1 == temp2 ) {
					dp[i][j] = dp[i-1][j-1] +1 ;
				} else {
					dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
				}
			}
		}
		
		System.out.println(dp[n][m]);
	}
}
