import java.io.*;
import java.util.*;

class position {
	int x,y;
	public position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n  = Integer.parseInt(st.nextToken());
		int m  = Integer.parseInt(st.nextToken());
	
		int[][] arr = new int[n][m];
		
		for ( int i = 0 ; i < n  ; i ++) {
			String input = br.readLine();
			for ( int j =  0 ;  j < m ; j++) {
				char temp = input.charAt(j);
				if( temp == 'W') arr[i][j] =1;
				else arr[i][j] = 0 ; 
			}
		}
		
		//상하좌우
		int[] deltax = { -1,1,0,0};
		int[] deltay = {0,0,-1,1};
		
		int max = -1;
		for ( int i =0 ; i < n ; i++) {
			for (int j = 0 ; j < m ; j++) {
				if( arr[i][j] == 0) {
					Queue<position> qq = new LinkedList<position>();
					boolean[][] visit = new boolean[n][m];
					int[][] temp = new int[n][m];
					qq.add(new position(i,j));
					visit[i][j] = true;
					while(!qq.isEmpty()) {
						position a = qq.poll();
						int dx = a.x;
						int dy = a.y;
						
						for ( int k  = 0 ; k< 4 ; k++) {
							int xx = dx + deltax[k];
							int yy = dy + deltay[k];
							
							if( xx>=0 && xx< n && yy>=0 && yy<m && arr[xx][yy] == 0 && !visit[xx][yy]) {
								qq.add(new position(xx, yy));
								visit[xx][yy] = true;
								
								temp[xx][yy] = temp[dx][dy] +1 ;
								max = Math.max(temp[xx][yy], max);
							}
						}
					}
					
				}
				
				
			}//j
		}//i
		
		System.out.println(max);
	}
}
