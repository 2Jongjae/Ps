import java.util.*;
import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n,m,l;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		l  = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+2];
		arr[n+1] = l;
		st = new StringTokenizer(br.readLine());
		for (int i = 1 ; i <= n ; i++)  arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		int left = 1;
		int right = l;
		
		while(left<=right) {
			int mid = (left + right )/ 2;
			int sum = 0 ; 
			
			for (int i = 1 ; i <=n+1;i++) {
				sum += (arr[i] - arr[i-1] -1  )/mid;
			}
			if(sum > m) left = mid+1;
			else right = mid-1;
			
		}
		System.out.println(left);
		
	}
}