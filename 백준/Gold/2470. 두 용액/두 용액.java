import java.util.*;
import java.io.*;



public class Main {
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	int n = Integer.parseInt(br.readLine());
    	
    	int[] arr =new int[n];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n ; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(arr);
    	
    	
    	int mina = 0;
    	int minb = 0;
    	int sum = Integer.MAX_VALUE;
    	int past = Integer.MAX_VALUE;
    	int left = 0;
    	int right = n-1;
    	while(left < right) {
    		
    		int a = arr[left] + arr[right];
    		
    		
    		
    		if( past == a ) {
    			left++;
    			continue;
    		}
    		
    		if(Math.abs(a) <sum ) {
    			mina = left;
    			minb = right;
    			sum = Math.abs(a);
    		}
    		
    		if( a< 0 ) left++;
    		else right --;
    				
    		past = a;
    		
    	}
    	System.out.println(arr[mina] + " " + arr[minb]);
    	
    	
    	
    }
}
