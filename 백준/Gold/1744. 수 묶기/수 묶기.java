import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
	
		int[] arr = new int[n];
		int minus = 0;
		for(int i = 0 ; i < n ; i ++)  {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i] <= 0 ) minus++;
		}
		Arrays.sort(arr);
		
		
		int sum = 0;
		for ( int i = 0 ; i < minus ; i++) {
			if( i + 1 < minus) {
				sum += (arr[i] * arr[i+1]);
				i++;
				continue;
			} else {
				sum += arr[i];
			}
		}
		
		for ( int i = n-1 ; i  >= minus ; i--) {
			if( i -1 < minus ) {
				sum += arr[i];
			} else {
				sum += Math.max(arr[i]+arr[i-1], arr[i]*arr[i-1]);
				i--;
			}
		}
		
		System.out.println(sum);
		
		
		
	}
	
}
