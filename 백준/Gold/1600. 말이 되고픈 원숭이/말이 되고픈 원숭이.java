import java.util.*;
import java.io.*;

class Position {
	int x, y,time;

	Position(int x, int y,int time) {
		this.x = x;
		this.y = y;
		this.time = time;
	}
}

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];

		boolean[][][] visit = new boolean[n][m][31];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j]= Integer.parseInt(st.nextToken());
			}
		}

		int[] horsex = { -1, -2, -2, -1, 1, 2, 2, 1 };
		int[] horsey = { -2, -1, 1, 2, 2, 1, -1, -2 };

		int[] deltax = { -1, 1, 0, 0 };
		int[] deltay = { 0, 0, -1, 1 };

		Queue<Position> qq = new ArrayDeque<Position>();

		qq.add(new Position(0, 0,0));
		visit[0][0][0] = true;

		int ans = 0 ;
		while (!qq.isEmpty()) {
			int size =  qq.size();
			for (int i = 0 ; i< size ; i++) {
				Position temp = qq.poll();
				int x = temp.x;
				int y = temp.y;
				if( x== n-1 && y == m-1 ) {
					System.out.println(ans);
					return;
				}
				int time = temp.time;
				for (int j = 0 ; j < 4 ; j++) {
					int newX = x +deltax[j];
					int newY = y +deltay[j];
					if( newX>= 0 && newX<n && newY>=0 && newY<m && arr[newX][newY] != 1 && arr[newX][newY] != 1 &&!visit[newX][newY][time]  ) {
						qq.add(new Position(newX,newY,time));
						visit[newX][newY][time] =true;
					}
				}
				
				for (int j = 0 ; j< 8 ; j++) {
					int newX = x +horsex[j];
					int newY = y +horsey[j];
					if( newX>= 0 && newX<n && newY>=0 && newY<m && arr[newX][newY] != 1 && arr[newX][newY] != 1&& time<h && !visit[newX][newY][time+1]  ) {
						qq.add(new Position(newX,newY,time+1));
						visit[newX][newY][time+1] =true;
					}
				}
				 
			}
			ans++;
		} //while 
		System.out.println(-1);
	}
}