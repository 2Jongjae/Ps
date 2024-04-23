import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[] Arr = new int[n];
		int[] Brr = new int[n];
		int[] Crr = new int[n];
		int[] Drr = new int[n];
		int[] arr = new int[n*n];
		int[] brr = new int[n*n];
		
		for( int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			Arr[i] = a;
			Brr[i] = b;
			Crr[i] = c;
			Drr[i] = d;
		}
		
		for( int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j< n ; j ++) {
				arr[n*i + j]  = Arr[i] + Brr[j];
				brr[n*i + j]  = Crr[i] + Drr[j];
			}
		}
		Arrays.sort(arr);
		Arrays.sort(brr);
		long ans = 0; 
		
		int arridx = -1;
		int brridx = -1;
		for( int i = 0 ;  i < n*n  ; i++) {
			if( arr[i] >0) {
				arridx= i;
				break;
			}
		}
		for( int i = 0 ;  i < n*n  ; i++) {
			if( brr[i] >0) {
				brridx= i;
				break;
			}
		}		

		
		int left = 0;
		int right = n*n-1;
		while( left >= 0 && left <n*n && right >=0 && right <n*n ) {
			 if (arr[left] >= 0 || brr[right] <= 0) break;

			    int sum = arr[left] + brr[right];

			    if (sum > 0) {
			        right--;
			    } else if (sum == 0) {
			        int leftDuplicates = 1;
			        int rightDuplicates = 1;

			        while (left + 1 < arr.length && arr[left] == arr[left + 1]) {
			            left++;
			            leftDuplicates++;
			        }

			        while (right - 1 >= 0 && brr[right] == brr[right - 1]) {
			            right--;
			            rightDuplicates++;
			        }
			        long dup = 0;
			        dup += leftDuplicates;
			        dup *= rightDuplicates;
			        ans += dup;
			        left++;
			        right--;
			    } else  left++;
		}
		left = 0;
		right = n*n-1;
		
		while( left >= 0 && left <n*n && right >=0 && right <n*n ) {
			if( brr[left] >= 0) break;
			if( arr[right] <= 0 ) break;
			int sum = brr[left] + arr[right];
			if( sum >0 ) right--;
			if( sum == 0 ) {
				
			    int leftDuplicates = 1;
		        int rightDuplicates = 1;

		        while (left + 1 < brr.length && brr[left] == brr[left + 1]) {
		            left++;
		            leftDuplicates++;
		        }

		        while (right - 1 >= 0 && arr[right] == arr[right - 1]) {
		            right--;
		            rightDuplicates++;
		        }
		        long dup = 0;
		        dup += leftDuplicates;
		        dup *= rightDuplicates;
		        ans += dup;
		        left++;
		        right--;				
				
			}
			if( sum <0 ) left++;
		}
		int aa = 0 ;
		int bb = 0;
		
		for( int i = 0 ; i < n*n ; i++) {
			if(arr[i] == 0 ) aa++;
			if(brr[i] == 0 ) bb++;
		}
		long multi = 0;
		multi += aa;
		multi *= bb;
		
		ans += multi;
		
		System.out.println(ans);
	}
}
