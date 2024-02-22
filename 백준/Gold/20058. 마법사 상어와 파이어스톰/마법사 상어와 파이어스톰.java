import java.io.*;
import java.util.*;
class Position{
	int x,y;
	Position(int x, int y ){
		this.x = x;
		this.y = y;
	}
}


public class Main {
	static int[][] arr ;
	static int n,q,nn,max;
	static int[] deltax = {-1,1,0,0};
	static int[] deltay = {0,0,-1,1};
	static boolean[][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		nn = (int) Math.pow(2,n);
		arr = new int[nn][nn];
		
		for (int i = 0 ; i < nn ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < nn ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for( int i = 0 ; i < q ;i++) {
			fire(Integer.parseInt(st.nextToken()));
		}
		
		int sum = 0;
		max = 0;
		for (int i = 0 ; i < nn ; i++) {
			for (int j = 0 ; j<nn ; j++) {
				sum += arr[i][j];
			}
		}
		
		visit = new boolean[nn][nn];
		for( int i = 0 ; i< nn ; i++) {
			for (int j = 0 ; j < nn ; j++) {
				if(!visit[i][j] && arr[i][j] >0 ) bfs(i,j);
			}
		}
		
		
		
		
		System.out.println(sum);
		System.out.println(max);
		
	}
	
	private static void bfs(int x, int y) {
		int sum = 1 ; 
		Position ps = new Position(x,y);
		visit[x][y] = true;
		
		Queue<Position> qq = new LinkedList<Position>();
		qq.add(ps);
		
		while(!qq.isEmpty()) {
			Position temp = qq.poll();
			int xx = temp.x;
			int yy = temp.y;
			
			for( int i = 0 ; i < 4 ; i++) {
				int newX = xx + deltax[i];
				int newY = yy + deltay[i];
				if( newX>=0 && newX<nn && newY>=0 && newY<nn && !visit[newX][newY] && arr[newX][newY] >0) {
					qq.add(new Position(newX,newY));
					visit[newX][newY] = true;
					sum += 1;
				}
			}
		}
		max = Math.max(max,sum);
		
	}

	static void fire(int value) {
		visit = new boolean[nn][nn];
		
		for(int i = 0 ; i < nn ; i++) {
			for(int j=0; j< nn ; j++) {
				if( !visit[i][j]) move(i,j,value);
			}
		}
		
		List<Position > ice = new ArrayList();
		for(int i = 0 ; i < nn ; i++) {
			for(int j = 0 ; j< nn ; j++) {
				int cnt = 0 ;
				for(int k = 0 ; k < 4 ; k++) {
					int x = i + deltax[k];
					int y = j + deltay[k];
					if( x>=0 && x<nn && y>=0 &&y<nn && arr[x][y] >0) cnt++;
				}
				if(cnt<3) ice.add(new Position(i,j));
			}
		}
		
		for(Position a : ice) {
			arr[a.x][a.y] --;
			if( arr[a.x][a.y]==-1) arr[a.x][a.y] = 0 ;
		}
		
		
	}
	
	static void move(int x, int y, int value) {
	    int v = (int) Math.pow(2, value);
	    int[][] temp = new int[v][v]; 
	    
	    for (int i = 0; i < v; i++) {
	        for (int j = 0; j < v; j++) {
	            temp[i][j] = arr[y + i][x + j];
	        }
	    }
	    
	    for (int i = 0; i < v; i++) {
	        for (int j = 0; j < v; j++) {
	            arr[y + j][x + (v - 1 - i)] = temp[i][j];
	        }
	    }
	    
	    for( int i = x ; i < x+v; i++) {
	    	for ( int j = y ; j < y+v ; j++) {
	    		visit[i][j] = true;
	    	}
	    }
	  	    
	}

	
	
}
