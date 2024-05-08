import java.io.*;
import java.util.*;

public class Main {
	static int n,m ,cnt;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int [n][n];
		
		for( int i = 0 ; i < n ; i++) {
			st= new StringTokenizer(br.readLine());
			for ( int j = 0 ; j < n ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0 ; i < n ; i++) {
			row(i);
			col(i);
		}
		System.out.println(cnt);
		
	}
	
	static void col ( int start) {
		boolean[] visit = new boolean[n];
		
		
		for(int i = 0 ; i < n-1 ; i ++) {
			int gap = arr[i][start] - arr[i+1][start];
			if( gap == 0 ) continue;
			if( Math.abs(gap) != 1)  return;
			if( gap == 1 ) {
				for( int j = i+1 ;  j <= i + m ; j++) {
					if( j >= n || (arr[i][start] - arr[j][start]) != 1 || visit[j]) return;
					visit[j] = true;
				}
				i += m-1;
				continue;
			}  
			if( gap == -1 ) {
				for( int j = i+1-m ; j <=i  ; j ++ ) {
					if( j <0 ||  (arr[j][start]-arr[i+1][start]) != -1 || visit[j] ) return;
					visit[j] = true;
				}
			}
		}
		
		cnt++;
		
		
	}
	
	
	static void row ( int start) {
		boolean[] visit = new boolean[n];
		
		
		for(int i = 0 ; i < n-1 ; i ++) {
			int gap = arr[start][i] - arr[start][i+1];
			if( gap == 0 ) continue;
			if( Math.abs(gap) != 1)  return;
			if( gap == 1 ) {
				for( int j = i+1 ;  j <= i + m ; j++) {
					if( j >= n || (arr[start][i] - arr[start][j]) != 1 || visit[j]) return;
					visit[j] = true;
				}
				i += m-1;
				continue;
			}  
			if( gap == -1 ) {
				for( int j = i+1-m ; j <=i  ; j ++ ) {
					if( j <0 ||  (arr[start][j]-arr[start][i+1]) != -1 || visit[j] ) return;
					visit[j] = true;
				}
			}
			
			
		}
		
		cnt++;
		
		
	}
}