import java.io.*;
import java.util.*;

class Main {
	static int n,m, max;
	static int[][] arr ;
	static boolean[][] visit ;
	static int[] deltax = {-1,1,0,0};
	static int[] deltay = {0,0,-1,1};
	public static void main ( String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visit = new boolean[n][m];
		for ( int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j <m ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max = Integer.MIN_VALUE;		
		for ( int i = 0 ; i < n ; i++) {
			for ( int j = 0 ; j < m ; j ++) {
				visit[i][j] = true;
				dfs(i,j,0,0);
				visit[i][j] = false;
			}
		}
		System.out.println(max);
	} //main 
	
	static void dfs(int x, int y , int depth, int sum) {
		sum+= arr[x][y];
		if(depth == 3) {
			max = Math.max(max, sum);
			return;
		}
		for ( int i = 0 ; i < 4 ; i++) {
			int xx = x + deltax[i];
			int yy = y + deltay[i];
			if(xx>=0 && xx<n && yy>= 0 && yy<m && !visit[xx][yy]) {
				visit[xx][yy] = true;
				dfs(xx,yy,depth+1,sum);
				if( depth == 1 ) {
					for (int j = 0 ; j < 4 ; j++) {
						int xxx = x + deltax[j];
						int yyy = y + deltay[j];
						if(xxx>=0 && xxx<n && yyy>= 0 && yyy<m && !visit[xxx][yyy]) {
							int temp = sum + arr[xx][yy];
							visit[xxx][yyy]= true;
							dfs(xxx,yyy,depth+2,temp);
							visit[xxx][yyy] = false;
						}
					} // j 
				}
				visit[xx][yy] = false; 
			}
		}
	} //dfs
	
	
}