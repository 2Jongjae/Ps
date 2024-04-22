import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		
		for( int i = 0 ; i < n ; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		int[] gap = new int[n-1];
		for( int i = 0 ; i < n-1 ;i++) {
			gap[i] = arr[i+1] - arr[i];
		}
		Arrays.sort(gap);
		int ans = 0; 
		for( int i = 0 ; i < n-m ; i++) {
			ans+= gap[i];
		}
		System.out.println(ans);
	}
}
