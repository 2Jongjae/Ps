import java.io.*;
import java.util.*;



public class Main{
	static int n ;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int t = Integer.parseInt(st.nextToken());
		for(int T = 0 ; T<t ; T++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n+1];
			for( int i =1 ;  i<= n ; i++) {
				arr[i] = i;
			}
			String ans =  "1";
			dfs(1,ans);
			if( T == (t-1)) continue;
			System.out.println();
		}
		
	}
	
	static void dfs(int idx, String ans) {
		if( idx == n) {
			String input = ans.replaceAll(" ", "");
			String[] strings = input.split("[+-]");
			arr = new int[n];
			for( int i = 0 ; i < strings.length; i++) {
				arr[i] =  Integer.parseInt(strings[i]);
			}
			int sum = 0;
			int index= 0; 
			for (int i = 0 ; i < input.length() ;i++) {
				char temp = input.charAt(i);
				if( temp == '-' || temp == '+') {
					index++;
					if( temp == '-') arr[index] *= -1;
				}
			}
			
			for( int a : arr) sum+=a;
			if( sum == 0 )  System.out.println(ans);
			
			return;
		}
		
		
		
        dfs(idx + 1, ans + " "+(idx+1));		
		dfs(idx+1 , ans + "+"+(idx+1));
		dfs(idx+1 , ans + "-"+(idx+1));
		
		
		
		
	}
	
	
	
	
}