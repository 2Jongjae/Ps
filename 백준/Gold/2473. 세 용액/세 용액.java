import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[n];
		st = new StringTokenizer(br.readLine());
		for( int i = 0 ; i < n ; i ++) arr[i] = Long.parseLong(st.nextToken());
		
		Arrays.sort(arr);
		long min = 50_000_000_000L;
		
		long[] ans = new long[3];
		for(int i = 0 ; i < n-2 ; i++) {
			int left = i+1;
			int right = n-1;
			
			while( left < right){
				long sum =  arr[i] + arr[left] + arr[right];
				if( Math.abs(sum) < min ) {
					ans[0] = arr[i] ;
					ans[1] = arr[left];
					ans[2] = arr[right];
					min = Math.abs(sum);
				}  
				if (sum == 0 ) {
					System.out.println(arr[i] + " " + arr[left] + " " + arr[right]);
					return;
				}
				if ( sum < 0 ) {
					left++;
				} else {
					right--;
				}
				
			}
			
			
		}
		for(long a : ans) System.out.print(a + " ");
		
	}
}
