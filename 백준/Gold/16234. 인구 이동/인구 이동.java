import java.io.*;
import java.util.*;

class Position {
	int x, y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

public class Main {
	static int n, min, max;
	static int[][] arr;
	static boolean[][] visit;
	//상하좌우
	static int[] deltax = {-1,1,0,0};
	static int[] deltay = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		min = Integer.parseInt(st.nextToken());
		max = Integer.parseInt(st.nextToken());

		arr = new int[n][n];
		visit = new boolean[n][n];
		
		for (int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < n ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		List<Position> li ;
		Queue<Position> qq; 
		int ans = 0 ;
	
		while( true) {
			visit = new boolean[n][n];
			int check = 0 ;
		for (int i = 0 ; i < n ; i ++) {
			for (int j = 0 ; j < n ; j++) {
				if(!visit[i][j]) {
					
					li = new ArrayList<Position>();
					qq = new LinkedList<Position>();
					qq.add(new Position(i,j));
					li.add(new Position(i,j));
					check ++;
					visit[i][j] = true;
					while( !qq.isEmpty()) {
						
						Position temp = qq.poll();
						int x = temp.x;
						int y = temp.y;
						
						for (int  k = 0 ; k < 4 ; k ++) {
							int xx = x + deltax[k];
							int yy = y + deltay[k];
							
							if( xx>=0 && xx<n && yy>=0 && yy<n && !visit[xx][yy]) {
								int gap = Math.abs(arr[xx][yy]- arr[x][y]);
								if( gap >= min && gap <= max) {
									check++;
									qq.add(new Position(xx,yy));
									li.add(new Position(xx,yy));
									visit[xx][yy] = true; 
								}
							}
							
						}
						
					} // bfs while문
					if( li.size() == 1) {
						check--;
						visit [li.get(0).x] [ li.get(0).y] = true;
						continue;
					}
					int sum = 0 ;
					
					for ( Position a : li) {
						sum +=arr[a.x][a.y];
					}
					sum /= li.size();
					
					for( Position a: li){
						arr[a.x][a.y] = sum;
					}
					
					
				} // j - if문
				
				
			}
		}
		
		if( check == 0 ) break;
		ans ++;
		} //while 문 
		System.out.println(ans);		
		
		
	}
}
