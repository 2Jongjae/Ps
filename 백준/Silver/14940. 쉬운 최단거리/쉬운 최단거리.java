import java.io.*;
import java.util.*;

class position{
	int x, y;
	position(int x , int y){
		this.x = x ;
		this.y = y;
	}
	
}

class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n,m;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] arr = new int [n][m];
		
		Queue<position> q = new LinkedList<>();
		boolean[][] visit = new boolean[n][m];
		for( int i = 0 ; i< n ; i ++) {
			st = new StringTokenizer(br.readLine());
			for( int j = 0 ; j < m ; j ++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if( arr[i][j] == 2)  q.add(new position(i, j));
				if (arr[i][j] == 0 ) visit[i][j] = true;
			}
		}

		int[] deltax = {-1,1,0,0};
		int[] deltay = {0,0,-1,1};
		int[][] ans = new int[n][m];
		visit[q.peek().x][q.peek().y] = true;
		while(!q.isEmpty()) {
			position temp = q.poll();
			int x = temp.x;
			int y = temp.y;
			
			for(int i = 0 ; i < 4; i ++){
				int xx = temp.x + deltax[i];
				int yy = temp.y + deltay[i];
				
				if(xx>=0&&xx<n && yy>=0 && yy<m && !visit[xx][yy] && arr[xx][yy] != 0 ) {
					visit[xx][yy] = true;
					q.add(new position(xx,yy));
					ans[xx][yy] = ans[x][y] + 1;
				}
			}
		}
		
		for (int i = 0 ; i < n ; i ++) {
			for(int j = 0 ; j < m ; j ++) {
				if(!visit[i][j]) {
					System.out.print(-1 + " "); 
					continue;
				}
					System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}
}