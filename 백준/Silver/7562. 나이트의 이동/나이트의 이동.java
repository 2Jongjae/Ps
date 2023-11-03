import java.io.*;
import java.util.*;
class position{
	int x, y ;

	public position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		int[] deltax = {-1,-2,-2,-1,1,2,2,1};
		int[] deltay = { -2,-1,1,2,2,1,-1,-2};
		
		
		for ( int tc = 0 ; tc< T ; tc++) {
			int size = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int startx = Integer.parseInt(st.nextToken());
			int starty = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			int targetx = Integer.parseInt(st.nextToken());
			int targety = Integer.parseInt(st.nextToken());
			
			Queue<position> qq = new LinkedList<>();
			int[][] arr = new int[size][size];
			boolean[][] visit = new boolean[size][size];
			qq.add(new position(startx, starty));
			visit[startx][starty] = true;
			 
			while(!qq.isEmpty()) {
				int time = qq.size();
				for ( int i =  0; i < time ; i++) {
					position temp = qq.poll();
					
					for ( int k  = 0 ; k < deltax.length; k++) {
						int dx = temp.x + deltax[k];
						int dy = temp.y + deltay[k];
						
						if( dx>= 0 && dx< size &&  dy >=0 && dy < size && !visit[dx][dy]) {
							arr[dx][dy] = arr[temp.x][temp.y]+1;
							visit[dx][dy] = true;
							qq.add(new position(dx, dy));
						}
						
					}
				}
			}
			sb.append(arr[targetx][targety] + "\n");
		}// tc
		
		System.out.println(sb);
	}

}
