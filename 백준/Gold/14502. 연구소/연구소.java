import java.io.*;
import java.util.*;
class position{
	int x;
	int y;
	int z;

	public position(int x, int y, int z ) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public position(int x, int y) {
	this.x=x;
	this.y=y;
	}
	@Override
	public String toString() {
		return "position [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
}
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		//기둥 3개 박는 거 
		List<position> l = new LinkedList<>();
		for ( int i = 0 ; i <n*m ; i++) {
			for (int j= i+1 ; j<n*m ; j++) {
				for (int k = j+1; k<n*m ; k++) {
					l.add(new position(i, j, k));
				}
			}
		}
		
		
		
		int [][] arr = new int[n][m];
		List<position > repository = new LinkedList<position>();
		for ( int i = 0; i< n ; i++) {
			st = new StringTokenizer(br.readLine());
			for ( int j = 0 ; j<  m ; j++) {
				arr[i][j ] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2 ) repository.add(new position(i, j));
			}
		}
		//상하좌우
		int[] deltax = {-1,1,0,0};
		int[] deltay = {0,0,-1,1};
		
		int min=  -1; 
		for (position a : l) {
			int firstx = a.x/m;
			int firsty = a.x%m;
			int secondx = a.y/m;
			int secondy = a.y%m;
			int thirdx = a.z/m;
			int thirdy = a.z%m;
			
			int[][] temparr = new int[n][m];
			for( int i = 0 ; i<n ; i++) {
				for( int j  = 0 ; j< m ; j++) {
					temparr[i][j] = arr[i][j];
				}
			}
			if(arr[firstx][firsty] == 0 &&  arr[secondx][secondy] == 0 &&  arr[thirdx][thirdy] == 0 ) {
			temparr[firstx][firsty] = 1 ;
			temparr[secondx][secondy] = 1;
			temparr[thirdx][thirdy] = 1;		
		}			
			else continue;
			
			Queue<position> qq = new LinkedList<>();
			boolean[][] visit = new boolean[n][m];
			
			for(position q : repository) {
				qq.add(q);
				visit[q.x][q.y]= true;
			}
			
			while(!qq.isEmpty()) {
				position temp = qq.poll();
				
				for ( int i = 0 ; i <4 ; i++) {
					int dx = temp.x + deltax[i];
					int dy = temp.y + deltay[i];
					
					if(dx>=0 && dx< n && dy >=0 && dy < m && temparr[dx][dy] == 0 && !visit[dx][dy]) {
						qq.add(new position(dx, dy));
						visit[dx][dy] = true;
						temparr[dx][dy] =2;
					}
				}
			}
			int cnt = 0 ; 
			for ( int i = 0 ; i< n ; i++) {
				for(int j = 0 ; j< m ; j++) {
					if(temparr[i][j] == 0) cnt ++;
				}
			}
			if( cnt > min)  min =  cnt; 
		} // 전체 순회 끝 
		
		System.out.println(min);
		
		
	}
}