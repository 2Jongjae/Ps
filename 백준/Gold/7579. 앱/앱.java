import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st,sz;
		st= new StringTokenizer(br.readLine());
		int n,m, ans;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ans = Integer.MAX_VALUE;
		
		long[][] dp = new long[n+1][10001];
		st= new StringTokenizer(br.readLine());
		sz = new StringTokenizer(br.readLine());
		
		for ( int i = 1 ; i <= n ; i ++) {
			int memory = Integer.parseInt(st.nextToken());
			int cos =  Integer.parseInt(sz.nextToken());
			for ( int j =  0 ; j <= 10000 ; j++) {
				if( j>=cos) dp[i][j] = Math.max(dp[i-1][j-cos]+memory , dp[i-1][j]);
					else dp[i][j] = dp[i-1][j];
				if(dp[i][j] >=m)  ans = Math.min(ans, j);
			}
		}
		System.out.println(ans);
		
		
	}
}
