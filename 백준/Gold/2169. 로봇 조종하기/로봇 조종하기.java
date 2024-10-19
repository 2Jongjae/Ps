import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int[][] arr, dp;
	static int[] left, right;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		dp = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = arr[0][0];
		
		for (int i = 1; i < m; i++) {
			dp[0][i] += dp[0][i - 1] + arr[0][i];
		}

		for (int i = 1; i < n; i++) {
			left = new int[m];
			right = new int[m];

			dp[i][0] = dp[i - 1][0] + arr[i][0];
			left[0] = dp[i][0];
			for (int j = 1; j < m; j++) {
				left[j] = Math.max(dp[i - 1][j], left[j - 1]) + arr[i][j];
			}

			right[m - 1] = dp[i - 1][m - 1] + arr[i][m - 1];

			for (int j = m - 2; j >= 0; j--) {
				right[j] = Math.max(dp[i - 1][j], right[j + 1]) + arr[i][j];
			}

			for (int j = 0; j < m; j++) {
				dp[i][j] = Math.max(left[j], right[j]);
			}
		}
		System.out.println(dp[n - 1][m - 1]);
	}
}
