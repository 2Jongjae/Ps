import java.io.*;
import java.util.*;
class position{
	int f,x,y;

	public position(int f, int x, int y) {
		super();
		this.f = f;
		this.x = x;
		this.y = y;
	}


	
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int floor = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		if( floor== 0 && n == 0 && m ==0 ) return;
		int[][][] arr = new int[floor][n][m];
		boolean[][][] visit = new boolean[floor][n][m];
		
//		위 아래 상하좌우 
		int[] deltafloor = { 1,-1,0,0,0,0};
		int[] deltax = { 0,0,-1,1,0,0};
		int[] deltay = {0,0,0,0,-1,1};
		
		Queue<position> qq = new LinkedList<>();
		
		int q ,w,e;
		q=w=e=0;
		
		for( int f = 0 ; f < floor ; f++) {
		for ( int i  = 0 ; i < n ; i ++) {
			String input = br.readLine();
			for (int j  = 0 ; j < m ; j ++) {
				char temp = input.charAt(j);
				if( temp == '.') arr[f][i][j] = 0;
				if( temp == '#') arr[f][i][j] = -1;
				if( temp == 'S') {
					arr[f][i][j] = 0;
					qq.add(new position(f, i, j));
					visit[f][i][j] = true; 
				}
				if( temp == 'E') {
					q = f;
					w = i;
					e = j ;
				}
			}
		}
		br.readLine();
	}
		
		while(!qq.isEmpty()) {
			position temp = qq.poll();
			
			for ( int i = 0 ; i < 6 ; i++) {
				int dx = temp.x + deltax[i];
				int dy = temp.y + deltay[i];
				int dz = temp.f + deltafloor[i];
			
				if( dx>=0 && dx< n && dy>= 0 &&dy<m && dz >=0 && dz<floor && !visit[dz][dx][dy] && arr[dz][dx][dy] ==  0) {
					qq.add(new position(dz, dx, dy));
					visit[dz][dx][dy] = true;
					arr[dz][dx][dy] = arr[temp.f][temp.x][temp.y] +1;
				}
			}
			
		}
		if( arr[q][w][e] ==  0 ) System.out.println("Trapped!");
		else {
			System.out.println("Escaped in " + arr[q][w][e] + " minute(s).");
		}
		}
	}
}
