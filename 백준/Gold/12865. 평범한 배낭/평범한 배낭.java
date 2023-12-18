import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 가지 수  
		int k = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게
		
		int[][] dp = new int[n+1][k+1];
		for ( int i = 1 ; i <=n ; i++) {
			st = new StringTokenizer(br.readLine());
			int kg = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			for(int j = 0 ; j<=k ; j++) {
				//경우의 수는 2가지임 
				int case1 = Integer.MIN_VALUE;
				if( j -kg >=0) case1 = dp[i-1][j - kg] +value;
				int case2 =  dp[i-1][j];
				dp[i][j] = Math.max(case1,case2);
			}
		}
		System.out.println(dp[n][k]);
	}
}