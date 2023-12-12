import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
	
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n+1];
		
		for( int i = 1 ; i <=n ; i++ ) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[n+1];
		int max= 0;
		for ( int i = 1 ; i <= n ; i++) {
			dp[i] = 1 ;
			for ( int j = 1; j  <=i ; j++) {
				if( arr[i] > arr[j] ) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			max = (max<dp[i])? dp[i]:max;
		}
		List<Integer> result = new LinkedList<Integer>();
//		System.out.println(Arrays.toString(dp));
		int find = max;
		for ( int i = n  ; i >=1 ; i--) {
			if(dp[i] == find) {
				result.add(arr[i]);
				find--;
			}
		}
		System.out.println(max);
		Collections.sort(result);
		for( int a : result) {
			System.out.print( a + " ");
		}
	}
}
