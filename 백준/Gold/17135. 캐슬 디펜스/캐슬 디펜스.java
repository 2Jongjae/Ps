import java.io.*;
import java.util.*;
class Position{
	int x,y;
	Position( int x, int y ){
		this.x = x;
		this.y = y;
	}
	
}

public class Main {
	static int n,m,d,max,sum;
	static int[][] arr;
	static int[] bow;
	static boolean[][] visit;
	static boolean[] visit2;
	static int[] deltax = {-1,1,0,0};
	static int[] deltay = {0,0,-1,1};
	static List<Position>[] li = new LinkedList[3];
	static Queue<Position> qq2 = new LinkedList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][m];
		for ( int i  = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			for ( int j = 0 ; j < m ; j ++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				sum += arr[i][j];
			}
		}
		bow = new int[m];
		visit = new boolean[n+1][m];
		visit2 = new boolean[m];
		for ( int i = 0 ; i < 3 ; i++)  li[i] = new LinkedList<>();
		
		dfs(0);
		System.out.println(max);
		
	}
	
	public static void dfs(int depth) {
		if( depth == 3 ) {
			game();
			return;
		}
		for ( int i = depth; i < m ; i ++) {
			if( !visit2[i]) {
				visit2[i] = true;
				bow[i] = 1 ;
				dfs(depth+1);
				bow[i] = 0 ;
				visit2[i] = false;
			}
		}
	}
	
	public static void game() {
		int ans = sum;
		int cnt = 0 ;
		
		int[][] temp = new int [n+1][m];
		for ( int i = 0 ; i < n ; i ++) {
			for( int j =  0 ; j < m ; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		List<Position> lipos = new LinkedList<Position>();
		 for ( int i = 0 ; i < m ; i ++) if( bow[i] == 1 )  lipos.add (new Position(n,i));
		while(ans > 0 ) {
			li[0].clear();
			li[1].clear();
			li[2].clear();
		l: for (int i= 0 ; i < 3 ; i++) {
			qq2.clear();
			visit =  new boolean[n+1][m];
			Position ps =  lipos.get(i);
			qq2.add(ps);
			visit[ps.x][ps.y] = true; 
			int limit = 1; 
			while(!qq2.isEmpty()) {
			int size = qq2.size();
			if( limit> d ) break; 
			for ( int  j = 0 ; j < size ; j++) {
				ps = qq2.poll();
				for ( int  k = 0 ; k < 4 ; k ++) {
					int x = ps.x + deltax[k];
					int y = ps.y + deltay[k];
					if( x>=0 && x<n && y >=0 && y<m && !visit[x][y]) {
						if( temp[x][y] == 1 ) {
							li[i].add(new Position(x,y));
							continue;
						}
						visit[x][y] = true;
						qq2.add(new Position(x,y));
					}
				}
			}
			if( li[i].size()>0) continue l;
			limit++;
			}
		} // 3바퀴 끝 
		for ( int i = 0; i < 3 ; i ++) {
			int min = 99;
			for ( int j = 0 ; j < li[i].size() ; j ++) {
				Position pp = li[i].get(j);
				min = Math.min(pp.y, min);
			}
			for( int j = 0 ; j < li[i].size() ; j ++) {
				Position pp = li[i].get(j);
				if( min == pp.y) {
					if( temp[pp.x][pp.y] == 1 ) {
						cnt++;
						ans--;
						temp[pp.x][pp.y] =0;
					}
					break;
				}
			}
		}
		for( int i = n ; i>=0 ; i--) {
			for( int j = 0 ; j < m ; j ++) {
				if( i == n)  {
					ans -= temp[i][j];
					temp[i][j] = 0 ;
					continue;
				}
				int num = temp[i][j];
				temp[i+1][j] = num;
				temp[i][j] = 0;
			}
		}
	} //마지막 	
	max = Math.max(max, cnt);
	}
}
