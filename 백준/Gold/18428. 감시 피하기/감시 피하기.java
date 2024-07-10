import java.io.*;
import java.util.*;


public class Main {
	static int n;
	static char[][] arr;
	static int[] deltax = {-1,1,0,0};
	static int[] delaty = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		arr = new char[n][n];
		
		for( int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			for( int j = 0 ; j < n ; j++) {
				arr[i][j] = st.nextToken().charAt(0);
			}
		}

		
		dfs(0);
		
	System.out.println("NO");
	
	}
	
	public static void dfs(int dep) {
		if(dep == 3 ) {
			boolean flag = false;
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					if(arr[i][j] == 'T') {
						for(int k = 0 ; k < 4 ; k++) {
							int idx = 1;
							while(true) {
								int x = i + deltax[k]*idx;
								int y = j + delaty[k]*idx;
								if( x<0 || x >= n || y <0 || y>= n) break;
								if( arr[x][y] == 'S') {
									flag = true;
									break;
								}
								if( arr[x][y] == 'O') break;
								idx++;
							}
							if( flag) break;
						}
					}
				}
			}
			if(!flag) {
				System.out.println("YES");
				System.exit(0);
			}
			
			return;
		}
		
		
		for(int i = 0 ; i < n ; i++) {
			for( int j = 0 ; j < n ; j++) {
				if(arr[i][j] == 'X') {
					arr[i][j] = 'O';
					dfs(dep+1);
					arr[i][j] = 'X';
				}
			}
		}
		
		
		
	}
	
}
