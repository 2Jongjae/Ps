import java.io.*;
import java.util.*;

public class Main {
	static int n,m,b,min,max,ans,ansheight;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		min = 257;
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for( int j = 0 ; j < m ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, arr[i][j]);
				max = Math.max(arr[i][j], max);
			}
		}
		
		ans = Integer.MAX_VALUE;
		
		for(int i  = min ; i <= max ; i++) {
			dfs(i);
		}
		System.out.println(ans + " " +ansheight);
		
		
	}
	static void dfs(int height) {
		int cnt = b;
		int cost = 0;
		for(int i = 0 ; i < n ; i++) {
			for( int j = 0 ; j < m ; j++) {
				if( arr[i][j] > height ) {
					int gap =  arr[i][j] -height;
					cost += gap*2;
					cnt += gap; 
				}
				if( arr[i][j]  < height) {
					int gap = height - arr[i][j];
					cost += gap;
					cnt -= gap;
				}
 			} 
		}
		if( cnt <0) return;
		if( ans > cost) {
			ans = cost;
			ansheight = height;
		}
		if( ans == cost ) {
			ansheight = Math.max(height,ansheight);
					
		}
		
	}
	
	
}