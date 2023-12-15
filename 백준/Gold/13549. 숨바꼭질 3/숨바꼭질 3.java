import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int pos = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		if (pos <= n) {
			int[] dp = new int[100002];
			dp[pos] = 0;
			for (int i = pos-1 ; i >= 0; i--) {
				dp[i] = dp[i+1] +1; 
			}
			for (int i = pos + 1; i <= n; i++) {
				int min;
				if (i % 2 == 0) {
					min = dp[i/2] ;
				} else {
					min = Math.min(dp[(i+1)/2] ,dp[(i-1)/2]) +1;
				}
				dp[i] = Math.min(dp[i-1]+1, min);
			}
			System.out.println(dp[n]);
		} else {
			System.out.println(pos -n);
		}


	}
}
