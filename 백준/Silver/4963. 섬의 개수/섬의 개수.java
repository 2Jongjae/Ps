import java.io.*;
import java.util.*;
class position{
	int x,y;
	public position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		StringTokenizer st;
		int n,m;
		while(true) {
			st =new StringTokenizer(br.readLine());
			
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			if (n==0&& m==0)  break;
			
			int[][] arr =  new int[n][m];
			boolean[][] visit = new boolean[n][m];
			
			
			for (int i = 0 ; i < n ; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0 ; j< m ; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 1은 땅 0은 바다 
			//8방향 11시부터 시계방향
			int[] deltax = {-1,-1,-1,0,1,1,1,0};
			int[] deltay = {-1,0,1,1,1,0,-1,-1};
			
			Queue<position> qq = new LinkedList<>();
			int cnt = 0 ;
			for (int i = 0 ; i< n ; i++) {
				for(int j = 0 ; j < m ; j++) {
					if( !visit[i][j] && arr[i][j] == 1) {
						cnt++;
						qq.add(new position(i, j));
						visit[i][j] = true;
						
						while(!qq.isEmpty()) {
							position temp = qq.poll();
							int xx = temp.x;
							int yy = temp.y;
							
							for (int k = 0 ; k< 8 ; k++) {
								int dx = xx + deltax[k];
								int dy = yy + deltay[k];
								
								if( dx>=0 && dx<n && dy>=0 && dy<m && !visit[dx][dy] && arr[dx][dy] == 1) {
									qq.add(new position(dx, dy));
									visit[dx][dy] =true;
								}
								
							}
							
						}
						
						
					} //if문
					
					
				}
			}
			sb.append(cnt + " \n");
		} // while 
		System.out.println(sb.toString().trim());
		
    }
}
