import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr =new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i< n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		
		int sum = 0 ;
		
		for( int i = 0 ; i< m ;i++) {
			sum += arr[i];
		}
		
		  int max = sum;
	        int maxCnt = 1;
	        for (int i = m; i < n; i++) {
	            sum += arr[i] - arr[i-m];
	            if (max == sum) maxCnt++;
	            else if (max < sum) {
	                max = sum;
	                maxCnt = 1;
	            }
	        }
	        if (max == 0) {
	            System.out.println("SAD");
	            return;
	        }
	        System.out.println(max);
	        System.out.println(maxCnt);
		
	        
	}
}