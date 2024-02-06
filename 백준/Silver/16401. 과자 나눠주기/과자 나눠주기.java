import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n,m;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[m];
		st = new StringTokenizer(br.readLine());
		for( int i = 0 ; i < m ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int left = 1;
		int right = arr[m-1];
		int ans = 0;
		
		while(left<=right) {
			int cnt = 0;
			int mid = (left +right)/2;
			
			for (int i = 0 ; i < m ; i++) cnt += arr[i]/mid;
			
			if ( cnt>= n) {
				ans =mid;
				left = mid+1;
			} else right = mid-1;
			
			
		}
		
		System.out.println(ans);
	}
	
}