import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n,m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i ++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        
        int left = 0;
        int right = 0;
        int ans = Integer.MAX_VALUE;
        while(right < n && left < n ) {
        	int gap = arr[right] -arr[left];
        	if( gap <m)  right++;
        	else {
        		ans =Math.min(gap,ans);
        		left++;
        	}
        	
        }
        System.out.println(ans);
        
    }
}