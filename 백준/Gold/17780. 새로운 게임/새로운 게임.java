import java.io.*;
import java.util.*;

class Position{
	int id, x, y, dir;
	Position(int id, int x, int y, int dir){
		this.id = id;
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
}

public class Main {
	static int[] deltax = {0, 0, 0, -1, 1};
	static int[] deltay = {0, 1, -1, 0, 0};
	static int[][] arr;
	static int ans, n, k = 0;
	static ArrayDeque<Position>[][] arr2;
	static Position[] psArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n][n];
		psArr = new Position[k+1];
		arr2 = new ArrayDeque[n][n];
		
		
		for( int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				arr2[i][j] = new ArrayDeque<Position>();
			}
		}
		for( int i = 1 ; i < k +1 ;  i++) {
			st = new StringTokenizer(br.readLine());
			int a =  Integer.parseInt(st.nextToken()) -1;
			int b =  Integer.parseInt(st.nextToken()) -1;
			int c =  Integer.parseInt(st.nextToken());
			psArr[i] = new Position(i,a,b,c);
			arr2[a][b].add(new Position(i,a,b,c));
		}
		
		
		while(true) {
			ans ++; 
			if( ans > 1000) {
				System.out.println(-1);
				return;
			}
			
			for( int i = 1 ; i < k +1 ; i++) {
				int dir = psArr[i].dir;
				int x = psArr[i].x;
				int y = psArr[i].y;
				int xx = x + deltax[dir];
				int yy = y + deltay[dir];
				if( !arr2[x][y].isEmpty() && arr2[psArr[i].x][psArr[i].y].getFirst().id != i) continue;	
				

				if( xx< 0 || xx >= n || yy < 0 || yy >= n || arr[xx][yy] == 2) {
					blue(x,y,dir);
					continue;
				}
				if( arr[xx][yy] == 1 ) red(x,y,dir);
				else white(x,y,dir);
				
			}
			
		} // while 
		
	}
	
	
	static void blue(int x, int y, int dir) {
		if(dir == 3) dir = 4;
		else if(dir == 4) dir = 3;
		else if(dir == 1) dir = 2;
		else if(dir == 2) dir = 1;
		
		int xx = x + deltax[dir];
		int yy = y + deltay[dir];
		int id = arr2[x][y].getFirst().id;
		Position ps = arr2[x][y].removeFirst();
		ps.dir = dir;
		arr2[x][y].addFirst(new Position(ps.id,ps.x,ps.y,dir));
		psArr[id].dir = dir;
		if( xx< 0 || xx >= n || yy < 0 || yy >= n || arr[xx][yy] == 2) return;
		
		
		if( arr[xx][yy] == 1) red(x,y,dir);
		else white(x,y,dir);
	}
	static void white(int x, int y, int dir) {
		int size = arr2[x][y].size();
		
		int xx = x + deltax[dir];
		int yy = y + deltay[dir];
		
		for(int i = 0 ; i < size ; i++) {
			Position ps = arr2[x][y].removeFirst();
			arr2[xx][yy].addLast(new Position(ps.id,xx,yy,ps.dir));
			
			psArr[ps.id].x = xx;
			psArr[ps.id].y = yy;
		}

		if(arr2[xx][yy].size() >=4 ) end();
	
	}
	static void red(int x, int y, int dir) {
		int size = arr2[x][y].size();
		
		int xx = x + deltax[dir];
		int yy = y + deltay[dir];
		
		for(int i = 0 ; i < size ; i++) {
			Position ps = arr2[x][y].removeLast();
			arr2[xx][yy].addLast(new Position(ps.id,xx,yy,ps.dir));
			psArr[ps.id].x = xx;
			psArr[ps.id].y = yy;
		}
		
		if(arr2[xx][yy].size() >=4 ) end();
	}
	
	static void end() {
		System.out.println(ans);
		System.exit(0);
	}
}