import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[T + 1];
		int[] arr2 = new int[T + 1];
		int[] dp = new int[T + 1];
		int[] dp2 = new int[T + 1];
		for (int i = 1; i <= T; i++) {
			int temp =  Integer.parseInt(st.nextToken());
			arr[i] = temp ;
			arr2[T+1-i] = temp;
			
		}
		int answer = 0;
		for (int i = 1; i <= T; i++) {
			dp[i] = 1;
			for (int j = 1; j < i; j++) {
				if (arr[i] > arr[j] && dp[i] < dp[j]+1)  dp[i] = dp[j] +1;
				if (arr2[i] > arr2[j] && dp2[i] < dp2[j]+1) dp2[i] = dp2[j] +1;
			}
		}
		for ( int i = 1 ; i <=T ; i++) {
			dp[i] += dp2[T-i+1];
			answer = (dp[i] > answer) ? dp[i] : answer ;
		}	
		System.out.println(answer);
	}
}
