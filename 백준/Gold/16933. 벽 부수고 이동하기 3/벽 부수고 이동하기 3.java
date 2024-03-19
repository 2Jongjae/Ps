import java.util.*;
import java.io.*;

class Position{
	int x,y,cnt;
	Position ( int x, int y,  int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}

class Main {
	static int[][] arr;
	static int n,m,k;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for(int i = 0 ; i < n ; i ++) {
			String input = br.readLine();
			for (int j = 0 ; j < m ; j++) {
				arr[i][j] = input.charAt(j) - '0';
			}
		}
		
		Queue<Position> qq = new ArrayDeque<>();
		qq.add( new Position(0,0,0));
		
		boolean[][][][] visit = new boolean[n][m][k+1][2];
		int[] deltax = {-1,1,0,0};
		int[] deltay = {0,0,-1,1};
		visit[0][0][0][0] = true;
		char day = 'n';
		int ans = 0;
		while(!qq.isEmpty()) {
			ans++;
			int size = qq.size();
			for(int i = 0 ; i< size ; i++) {
				Position temp = qq.poll();
				int x = temp.x;
				int y = temp.y;
				int cnt = temp.cnt;
				if( x == n-1 && y == m-1) {
					System.out.println(ans);
					return;
				}
				for( int j = 0 ; j < 4 ; j++) {
					int xx = x + deltax[j];
					int yy = y + deltay[j];
					
					if(xx>=0 && xx< n && yy>=0 && yy< m ) {
						if(arr[xx][yy] == 0  && !visit[xx][yy][cnt][0]) {
							qq.add(new Position(xx,yy,cnt));
							visit[xx][yy][cnt][0]= true;
							continue;
						}
						if(arr[xx][yy] == 1 && cnt+1 <=k  ) {
							if( day == 'm' && !visit[xx][yy][cnt+1][1]) {
								qq.add(temp);
								visit[xx][yy][cnt+1][1] = true;
								continue;
							}
							if( day == 'n' && !visit[xx][yy][cnt+1][0]) {
								qq.add(new Position(xx,yy,cnt+1));
								visit[xx][yy][cnt+1][0] = true; 
								continue;
							}
							
						}
					}
				}
			} // size
			day = (day == 'm') ? 'n' : 'm';
		} //while
		System.out.println(-1);
	}
	
}