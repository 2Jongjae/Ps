import java.io.*;
import java.util.*;

class Robot {
	int x, y, dir;

	public Robot(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
}

public class Main {
	static int n, m;
	static Robot endRobot;
	static int[][][] check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		Robot robot = new Robot(x, y, dir);

		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
		endRobot = new Robot(x, y, dir);

		Queue<Robot> qq = new LinkedList<>();

		qq.add(robot);

		// 동서남북 1, 2, 3,4
		int[] deltax = { 0, 0, 0, 1, -1 };
		int[] deltay = { 0, 1, -1, 0, 0 };

		check = new int[n + 1][m + 1][5];
		boolean[][][] visit = new boolean[n + 1][m + 1][5];
		int ans = 0;
		while (!qq.isEmpty()) {
			int size = qq.size();
			for (int i = 0; i < size; i++) {
				Robot temp = qq.poll();
				x = temp.x;
				y = temp.y;
				dir = temp.dir;
				if( x==endRobot.x && y == endRobot.y && dir == endRobot.dir) {
					System.out.println(ans);
					return;
				}
				int left = 0;
				int right = 0;
				if( dir ==1 ) left = 3;
				if( dir ==1 ) right =4;
				if( dir ==2 ) left = 3;
				if( dir ==2 ) right =4;
				if( dir ==3 ) left = 2;
				if( dir ==3 ) right =1;
				if( dir ==4 ) left = 1;
				if( dir ==4 ) right =2;
				
				if(!visit[x][y][left]) {
					qq.add(new Robot(x,y,left));
					visit[x][y][left] = true;
				}
				if(!visit[x][y][right]) {
					qq.add(new Robot(x,y,right));
					visit[x][y][right] = true;
				}
				
				
				for( int k = 1 ; k<= 3 ; k++) {
					int xx = x + deltax[dir] * k;
					int yy = y + deltay[dir] * k;
					
					if(xx>0 && xx<=n && yy>0 && yy<=m && arr[xx][yy] == 0) {
						if( visit[xx][yy][dir]) continue;
						qq.add(new Robot(xx,yy,dir));
						visit[xx][yy][dir] =true;
					} else break; 
				}
				
				
				
			}
			ans++;
		}



	}

}