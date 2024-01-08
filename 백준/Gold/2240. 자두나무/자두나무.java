import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][][] dp = new int[n + 1][m + 1][3];

		// i = 떨어지는 개수
		// j = 바꿀 수 있는 기회
		// k = 내 위치
		int temp = Integer.parseInt(br.readLine());
		if (temp == 1) {
			dp[1][0][1] = 1;
		} else
			dp[1][1][2] = 1;

		for (int i = 2; i <= n; i++) {
			temp = Integer.parseInt(br.readLine());
			for (int j = 0; j <= m; j++) {
				for (int k = 1; k < 3; k++) {
					int check = 1;
					if (temp == 1)
						check = 2;

					if (temp == k) {
						dp[i][j][k] = 1;
						int case1 = dp[i - 1][j][k];
						int case2 = 0;
						if (j > 0)
							case2 = dp[i - 1][j - 1][check];
						dp[i][j][k] += Math.max(case1, case2);
					} else {
						int case1 = dp[i - 1][j][k];
						int case2 = 0;
						if (j > 0)
							case2 = dp[i - 1][j - 1][check];
						dp[i][j][k] += Math.max(case1, case2);
					}
//					System.out.println(i + "  "+ j + "   " + k + "   " + dp[i][j][k]);
				}
			}
		}
		int max = 0;
			for( int  j = 0 ; j <=m ; j ++) {
				for ( int k= 1 ; k<3 ; k++) {
					max = Math.max(max, dp[n][j][k]);
				}
			}
			System.out.println(max);
		}
}