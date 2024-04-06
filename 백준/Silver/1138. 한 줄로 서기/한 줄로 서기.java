import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static int[] arr2;
	static boolean[] visit;
	static int n ;
	static int k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		
		arr = new int[n];
		arr2 = new int[n];
		visit = new boolean[n];
		
		for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

		dfs(0);
		
		System.out.println(k);
		
	}// main
	
		
	static void dfs(int depth) {
		if( depth == n) {
			boolean flag = false; 
			for( int i = 0 ; i < n ; i++) {
				int cnt = 0;
				int value = arr2[i];
				for( int j = i ; j >=0 ; j-- ) {
					if( arr2[i] < arr2[j]) cnt++;
				}
				if(cnt != arr[value-1] ) return;
			}
			
				for( int a : arr2) {
					System.out.print(a + " ");
				}
				System.exit(0);
			
			return;
		}
		
		for( int i = 1 ;  i<= n ; i++) {
			if(!visit[i-1]) {
				arr2[depth] = i;
				visit[i-1] = true;
				dfs(depth+1);
				visit[i-1] = false;
			}
		}
		
		
	}
	
	
}
