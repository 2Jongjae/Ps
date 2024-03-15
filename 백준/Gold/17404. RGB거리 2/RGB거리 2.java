import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n + 1][4];
		int[][] dp = new int[n + 1][4];

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (i == 1)
					dp[i][j] = arr[i][j];
			}
		}

		int min = 123123123;
		for (int j = 1; j <= 3; j++) {

		     for(int i = 1 ; i <= 3; i++) {
	                if(i == j) dp[1][i] = arr[1][i];
	                else dp[1][i] = 123123123;
	            }
			
			
			for (int i = 2; i <= n; i++) {

				dp[i][1] = Math.min(dp[i - 1][2], dp[i - 1][3]) + arr[i][1];
				dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][3]) + arr[i][2];
				dp[i][3] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][3];

			
			}
			
			for( int i = 1 ; i<=3 ;i++) {
				if(i != j) min = Math.min(dp[n][i],min);
			}
			
		}
		System.out.println(min);
	}

}