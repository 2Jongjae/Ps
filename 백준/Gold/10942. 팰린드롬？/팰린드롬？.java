import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n+1];
		for(int i = 1 ; i <= n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[n+1][n+1];
		for(int i = 0 ; i <= n ; i ++) {
			dp[i][1] = 1;
		}
		
		for(int i = 1 ; i < n; i ++) {
			if(arr[i] == arr[i+1] ) dp[i][2] = 1;
		}
		
		for(int i = 3 ; i <= n ; i++) {
			for(int j = 1 ; j <= n-i+1; j ++) {
				int start = j ;
				int end = j+i-1;
				if(arr[start] == arr[end] && dp[start+1][i-2] == 1 ) {
					dp[j][i] = 1;
				}
			}
		}

		
		
		StringBuilder sb= new StringBuilder();
		
		while( true ) {
			if( m == 0 ) break;
			st =  new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken())  ;
			int gap = end -start;
			sb.append(dp[start][gap+1]+"\n") ;
			m--;
			
		}
		System.out.println(sb);
		
		
	}
}