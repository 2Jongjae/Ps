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
	@Override
	public String toString() {
		return "position [x=" + x + ", y=" + y + "]";
	}
	
}
public class Main {
	static int n,m;
	static int[][] arr;
	static boolean[] visit;
	static List<position> li = new LinkedList<>();
	static int min = Integer.MAX_VALUE;
	//상하좌우
	static int[] deltax = {-1,1,0,0};
	static int[] deltay = {0,0,-1,1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 n = Integer.parseInt(st.nextToken());
		 m = Integer.parseInt(st.nextToken());
	 
		 arr = new int[n][n];
		 for (int i = 0 ; i < n ; i++) {
			 st = new StringTokenizer(br.readLine());
			 for ( int j = 0 ; j < n ; j++) {
				 arr[i][j] = Integer.parseInt(st.nextToken());
				 if( arr[i][j] == 2  ) {
					 li.add(new position(i, j));
				 }
			 }
		 }
		
		 visit = new boolean[li.size()];
		List<position> subset= new LinkedList<position>();
		
		comb(subset, 0 );
		if( min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
		
	}
	private static void comb(List<position> subset, int a) {
		if(subset.size() == m) {
			bfs(subset);
			return;
		}
		
			for(int i = a ; i < li.size(); i ++) {
				if( !visit[i]  ) {
					subset.add(li.get(i));
					visit[i] = true;
					comb(subset, i+1);
					visit[i] = false;
					subset.remove(subset.size()-1);
				} else continue;
				
			}
		 
		
			
	}
	
	
	private static void bfs(List<position> subset) {
		
		boolean[][] check = new boolean[n][n];
		int[][] temparr = new int[n][n];
		
		for ( int i = 0 ; i <n ;i++) {
			for (int j = 0 ; j< n ;j++) {
				int temp = arr[i][j];
				if( temp == 1 ) temparr[i][j] = -1;
				else if( temp == 2 ) temparr[i][j] = 0 ;
				else temparr[i][j] = temp;
			}
		}
	    Queue<position> qq = new LinkedList<>();
		
		for(position temp : subset) {
			int dx = temp.x;
			int dy = temp.y;
			
			qq.add(new position(dx, dy));
			check[dx][dy] = true;
			temparr[dx][dy] = 0;
		}
		
		while(!qq.isEmpty()) {
			int size = qq.size();
			
			for ( int t = 0 ; t <size ; t++) {
				position temp = qq.poll();
				
				int xx = temp.x;
				int yy = temp.y;
				
				for ( int i = 0 ; i<4 ; i++) {
					int dx = xx + deltax[i];
					int dy = yy + deltay[i];
					
					if( dx>=0 && dx<n && dy>= 0 && dy< n && !check[dx][dy] && temparr[dx][dy] != -1) {
						qq.add(new position(dx, dy));
						check[dx][dy] = true; 
						temparr[dx][dy] = temparr[xx][yy]+1;
					}
					
						
				}
				
				
				
			}
		}
		int max  = -1;
		int cnt = 0;
		for ( int i = 0  ; i< n ; i++) {
			for (int j = 0 ; j< n ; j++) {
				max = Math.max( temparr[i][j],max);
				if ( temparr[i][j] == 0) cnt++;
			}
//			System.out.println(Arrays.toString(temparr[i]));
		}
//		System.out.println(subset );
//		System.out.println(max);
//		System.out.println(cnt);
		if(cnt == m) min = Math.min(max, min);		
	}
}