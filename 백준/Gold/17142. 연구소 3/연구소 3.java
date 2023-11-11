import java.io.*;
import java.util.*;
class position{
	int x,y ;
	public position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "position [x=" + x + ", y=" + y + "]";
	}
	
	
}
public class Main {
	static int[][] arr;
	static boolean[][] visit;
	static boolean[][] visit2;
	static int n,m, min ;
	static List<position> li;
	static boolean[] check ;
	//상하좌우
	static int[] deltax = {-1,1,0,0};
	static int[] deltay = { 0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		arr = new int[n][n];
		visit2= new boolean[n][n];
		li = new LinkedList<position>();
		for ( int i  = 0 ; i < n ; i ++) {
			st= new StringTokenizer(br.readLine());
			for ( int  j = 0 ; j < n ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if( arr[i][j] == 2 ) {
					li.add(new position(i, j));
					visit2[i][j] = true;
				}
				if( arr[i][j] == 1 ) visit2[i][j] = true;
			
			}
		}
		
		check = new boolean[li.size()];
		List<position>  temp  = new LinkedList<position>();
		
		sub(temp,0);
		if( min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
		
		
	}

	private static void sub(List<position> temp, int idx) {
		if( temp.size() == m ) {
			visit = new boolean[n][n];
			Queue<position > qq = new LinkedList<position>();
			for ( position a : temp ) {
				qq.add(a);
				visit[a.x][a.y] = true;
			}
			int[][] map = new int[n][n];
			
			while(!qq.isEmpty()) {
				position ps = qq.poll();
				
				for ( int i = 0 ; i < 4 ; i++) {
					int dx = ps.x + deltax[i];
					int dy = ps.y + deltay[i];
					
					if( dx>=0 && dx < n  && dy >= 0 && dy <n && !visit[dx][dy] && arr[dx][dy] != 1 ) {
						map[dx][dy] = map[ps.x][ps.y] +1;
						visit[dx][dy] = true; 
						qq.add(new position(dx, dy));
					}
				}
				
			}
			for ( position a : li) {
				map[a.x][a.y]= 0;
			}

			boolean flag = false;
			for ( int i =0 ; i <n ; i++) {
				for ( int j = 0 ;  j< n ; j++) {
					if(!visit2[i][j] && !visit[i][j]) flag = true;
				}
			}
			
			
			int max = 0 ;
			if(!flag) {
			for ( int i = 0 ; i< n ; i ++) {
				for ( int j = 0 ; j < n ;j++) {
					max = Math.max(max, map[i][j]);
				}
			}
			min = Math.min(max, min);
			}
			
//			for(int i =0 ; i < n ; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println();
//			
			return; 
		}
		
		
			for ( int i = idx ; i < li.size() ; i++) {
					if( !check[i]) {
						temp.add(li.get(i));
						check[i]= true;
						sub(temp,i+1);
						check[i]= false;
						temp.remove(temp.size()-1);
					}
				
				
			}
	}
	
	
}
