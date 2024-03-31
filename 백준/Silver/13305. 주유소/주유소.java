import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
	
		int[] cost=  new int[n-1];
		int[] arr = new int[n-1];
		
		int idx = -1;
		int min = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		for( int i = 0 ; i< n-1 ; i++)  cost[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for( int i = 0 ; i< n-1 ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if( min > arr[i]) {
				idx = i;
				min =arr[i];
			}
		}
		
		long ans =0;
		if( idx != 0 ) ans+= arr[0] * cost[0];
		
		for( int i = idx ;i <n-1 ; i++) {
			ans += min * cost[i];
		}
		
		min = Integer.MAX_VALUE;
		for (int i =  0 ; i < idx-1 ; i++) {
			if(arr[i] <min) {
				min =  arr[i];
			}
			ans += min*cost[i];
		}
		
		System.out.println(ans);
		
		
	}// main
}