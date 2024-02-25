import java.io.*;
import java.util.*;
class position{
	int x;
	int y;
	public position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n  = Integer.parseInt(st.nextToken());
		int m  = Integer.parseInt(st.nextToken());
		int[][] arr =new int[n][m];
		Queue<position> qq = new LinkedList<position>();
		for ( int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j< m ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
			int year = 0 ;
			while(true) {
				boolean[][] visit = new boolean[n][m];
			//상하좌우
			int[][] temp = new int[n][m];	
			int[] deltax = {-1,1,0,0};
			int[] deltay = { 0 ,0,-1,1};
			
			
			int ans = 0 ; 
			for ( int i = 0 ; i < n ; i++) {
				for (int j = 0 ; j< m ; j++) {
					int cnt = 0;
					//한 해 지나면 녹는 빙하의 높이 
					for( int k = 0 ; k< 4 ; k++) {
						int dx = i + deltax[k];
						int dy = j + deltay[k];

						if( dx>= 0 && dx <n && dy >=0 && dy <m && arr[dx][dy] == 0) {
							cnt++;
						}
					}
					temp[i][j] = cnt;
					
					// bfs 시작 
					if( arr[i][j] != 0 && !visit[i][j]) {
						qq.add(new position(i, j));
						ans++;
						visit[i][j] = true;
						if(ans == 2 ) {
							System.out.println(year);
							return;
						}
						while(!qq.isEmpty()) {
							position xy = qq.poll();
							
							for (int k = 0 ; k< 4 ; k++) {
								int dx = xy.x + deltax[k];
								int dy = xy.y + deltay[k];
								
								
								if( dx>=0 && dx< n && dy >=0 && dy<m  && arr[dx][dy] > 0 && !visit[dx][dy]) {
									qq.add(new position(dx, dy));
									visit[dx][dy] = true;
								}
							}
							
						}
					}
				} // j문
			} // i문
			
			boolean flag = true;
			for( int i = 0 ; i<n ; i ++) {
				for (int j = 0 ; j<m ; j++) {
					arr[i][j] -= temp[i][j];
					if(arr[i][j] <0) arr[i][j] = 0;
					if(arr[i][j] != 0) flag =false; 
				}
			}
			if( flag) {System.out.println(0);
			break;
			}
			year++;
		
			} // while문 
			
			
			
			
			
	}
}