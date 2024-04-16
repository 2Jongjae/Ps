import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int target =Integer.parseInt(br.readLine());
		
		int left = 0;
		int right= n-1;
		int ans = 0;
		while(left<right) {
			int sum = arr[left] + arr[right];
			
			if( sum > target) {
				right--;
				continue;
			}
			if (sum == target) {
				ans++;
				right --;
				continue;
			}
			if( sum < target) {
				left++;			
			}
			
		}
		
		System.out.println(ans);
	}

}
