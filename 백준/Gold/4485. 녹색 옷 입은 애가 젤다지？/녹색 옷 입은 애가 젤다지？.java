import java.io.*;
import java.util.*;
class Position{
	int x,y;
	public Position(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int ans = 1;
		while(true) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		if( n == 0 ) {
			System.out.println(sb);
			return;}
		if( ans != 1) sb.append("\n");
		int[][] arr = new int[n][n];
		for ( int i = 0 ; i <n ; i ++) {
			st = new StringTokenizer(br.readLine());
			for ( int j = 0 ; j <n ; j++) {
			arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] dp = new int[n][n];
		
		int[] deltax = {-1,1,0,0};
		int[] deltay = {0,0,-1,1};
		
		for (int i= 0 ; i <n ; i++) {
			Arrays.fill(dp[i],-1);
		}
		
		dp[0][0] = arr[0][0];
		for ( int z = 0 ;  z< n ; z++) {
		for (int i = 0; i <n  ; i++) {
			for (int j = 0 ; j < n ; j++) {
				for (int k = 0; k<4 ;k++) {
					int x = i + deltax[k];
					int y = j + deltay[k];
					
					if(x>=0 && x<n && y>=0 && y<n ) {
						if( dp[i][j] == -1 && dp[x][y] != -1 ) {
							dp[i][j] = dp[x][y]+ arr[i][j];
						}
						if( dp[i][j]== -1 && dp[i][j] == -1) continue;
						if(dp[i][j] != -1  && dp[x][y] != -1 ) {
							dp[i][j] = Math.min(dp[i][j], dp[x][y] +arr[i][j]);
						}
					}
				}
			}
		}
		}
		sb.append("Problem " + ans+": " +dp[n-1][n-1]);
		ans++;
		}//while 
	}
}