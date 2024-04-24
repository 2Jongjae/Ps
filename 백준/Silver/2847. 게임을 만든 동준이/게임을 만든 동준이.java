import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
	
		int[] arr = new int[n];
		for( int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int ans = 0;
		for(int i = n - 1 ; i >= 1 ; i--) {
			 if( arr [i] <=arr[i-1]) {
				 while(arr[i]<=arr[i-1]) {
					 arr[i-1]--;
					 ans++;
				 }
			 }
		}
		System.out.println(ans);
	}
}
