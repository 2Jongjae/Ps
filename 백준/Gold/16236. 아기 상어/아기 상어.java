import java.io.*;
import java.util.*;

class Position {
	int x, y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}
	
	
}

class Baby {
	int size;
	int exp;

	public Baby() {
		this.size = 2;
	}

	public void expup() {
		this.exp++;
		if (this.exp == this.size) {
			exp = 0;
			this.size++;
		}
	}

}

public class Main {
	static int n ,time;
	static int[][] arr;
	static boolean flag; 
	static Position pos;
	static Baby baby = new Baby();
	static List<Position> li ;
	static int[] deltax = {-1,1,0,0};
	static int[] deltay = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		StringTokenizer st;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) pos = new Position(i, j);
					
			}
		}

		time = 0 ;
		
		while(true) {
//			System.out.println("상어의 크기는  =  "  + baby.size   + "   " + "상어의 경험치는  =  "  +baby.exp);
//			System.out.println("상어의 위치는 "  + pos);
//			System.out.println();
//						for ( int i = 0 ; i < n ; i ++) {
//				System.out.println(Arrays.toString(arr[i]));
//			}
			
			
			flag = true;
			check(baby);
			//조건 1 먹을 게 없을 때 탈출 조건 
			if (flag) {
				System.out.println(time);
				return;
			}
			bfs();
			if (flag) {
				System.out.println(time);
				return;
			}
		}
		
		
		
	}
	
	private static void bfs() {
		Queue<Position> qq = new LinkedList();
		qq.add(pos);
		
		int[][] map = new int[n][n];
		boolean[][] visit = new boolean[n][n];
		li = new LinkedList();
		visit[pos.x][pos.y] = true;
		
		while(!qq.isEmpty()) {
			Position temp = qq.poll();
			int x = temp.x;
			int y = temp.y;
			
			if( li.size() >=1 ) {
				int value = map[ li.get(0).x][li.get(0).y];
				if(value < map[x][y]) continue;
			}
			
			
			for ( int i = 0 ;  i< 4 ; i++) {
				int xx = x + deltax[i];
				int yy = y + deltay[i];
				
				
				
				if( xx>= 0 && xx< n && yy>=0 && yy<n &&  !visit[xx][yy]  ) {
					if( arr[xx][yy] == 0 || arr[xx][yy] == baby.size) {
						map[xx][yy] = map[x][y] +1; 
						visit[xx][yy] = true;
						qq.add(new Position(xx,yy));
						continue;
					}
					
					if( arr[xx][yy] < baby.size) {
						visit[xx][yy] = true;
						map[xx][yy] = map[x][y]+1; 
						if( li.size() == 0) {
							li.add(new Position(xx,yy));
							continue;
						}
						if( map[li.get(0).x][li.get(0).y] < map[xx][yy]) continue;
						else li.add(new Position(xx,yy));
					}
					
					
				}
				
			}
			
			
		} //while 
		
//		System.out.println(li);
//		for ( int i = 0 ;  i<n ; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		arr[pos.x][pos.y] = 0;
		if( li.size() == 1) {
			time += map[li.get(0).x][li.get(0).y];
			pos.x = li.get(0).x;
			pos.y = li.get(0).y;
			arr[pos.x][pos.y] = 9;
			
			baby.expup();
			return; 
		}
		
		int min = 1000;
		
		for (Position a : li) {
			int x = a.x;
			int y = a.y;
			min =  Math.min(min, map[x][y]);
		}
		
		int xx = -1;
		int yy = -1;
		
		for (Position a : li) {
			int x = a.x;
			int y = a.y;
			if( map[x][y] == min ) {
				if ( xx == -1 ) {
					xx = x;
					yy = y;
					continue;
				}
				
				if ( xx < x)  continue;
				
				
				if( xx > x ) {
					xx = x;
					yy = y;
					continue;
				}
				
				if(  xx == x) {
					if(  yy > y  ) {
						yy = y;
					} else continue;
				}
				
			}
		}
		if(xx == -1) {
			flag =true;
			return;
		}
		pos.x = xx;
		pos.y = yy;
		time += map[xx][yy];
		arr[pos.x][pos.y] = 9;
		baby.expup();
		return;
		
		
		
	}
	

	private static void check(Baby baby) {
		for ( int i = 0 ;  i< n ; i++) {
			for ( int j = 0 ; j < n ; j ++) {
				if(arr[i][j] >0 && arr[i][j] < baby.size ) {
					flag = false;
					return ; 
				}
			}
		}
	}  //check method
	
	
}