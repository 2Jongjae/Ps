import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n+1][m+1];
		for (int i =1 ; i <= n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <=m ; j ++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int tc = Integer.parseInt(br.readLine());
		
		for ( int t = 0 ; t < tc ; t++) {
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			int q,w,e,r;
			q = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			
			for ( int i = q ;  i<= e; i++) {
				for( int j = w ; j<=r ; j++) {
					sum += arr[i][j];
				}
			}
			
			System.out.println(sum);
			
		}
		
		
	}
}