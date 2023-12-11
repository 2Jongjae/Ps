import java.io.*;
import java.util.*;

public class Main {
	static int n, min;
	static int[][] arr;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		min  = Integer.MAX_VALUE;
		arr = new int[n][n];
		visit = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);
		System.out.println(min);

	}

	private static void dfs(int idx, int cnt) {
		if (cnt == n / 2) {
			comb();
			return;

		}

		for (int i = idx; i < n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				dfs(i + 1, cnt + 1);
				visit[i] = false;
			}

		}

	}

	private static void comb() {
		int a = 0;
		int b = 0;

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {

				if (visit[i] == true && visit[j] == true) {
					a += arr[i][j];
					a += arr[j][i];

				} else if (visit[i] == false && visit[j] == false){
					b += arr[i][j];
					b += arr[j][i];
				}

			}
		}
		
		
		int val =  Math.abs(a-b);
		
		if (val == 0 ) {
			System.out.println(val);
			System.exit(0);
		}

		min = Math.min(val, min);
		
	}
	
	
}
