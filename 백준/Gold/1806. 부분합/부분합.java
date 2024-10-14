import java.util.*;
import java.io.*;

public class Main {
	static int n, m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
	
		for(int i = 0 ; i < n ; i++) {arr[i] = Integer.parseInt(st.nextToken());}
		
		int ans = Integer.MAX_VALUE;
		
		int left = 0;
		int right = 1;
		
		if(arr[left] >= m) {
			System.out.println(1);
			return;
		}
		
		int sum = arr[left] + arr[right];
		
		while( left <= right ) {
//			System.out.println("왼쪽 값은 = " + left + " 오른쪽 값은 = " + right);
			if( sum >= m ) {
				ans = Math.min(ans, right-left);
				sum -= arr[left];
				left ++;
			} else {
				right ++;
				if(right >= n ) break;
				sum += arr[right];
			}
		}
		if(ans == Integer.MAX_VALUE) {
			System.out.println(0);
			return;
		}
		System.out.println(ans+1);
		
	}
}
