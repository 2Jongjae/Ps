import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[1_000_001];
		int maxVal = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			int num = arr[i];
			dp[num] = Math.max(dp[num-1]+1, 1);
			maxVal = Math.max(dp[num],maxVal);
		}
		System.out.println(maxVal);
	}
}
