import java.io.*;
import java.util.*;

class position{
	int x,y;

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
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		
		int[][] arr =new int[n][n];
		boolean[][] visit = new boolean[n][n];
		
		for ( int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for ( int j = 0 ; j < n ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 값 입력 끝 
		//상하좌우
		int[] deltax = {-1,1,0,0};
		int[] deltay = {0,0,-1,1};
		
		int min = Integer.MAX_VALUE;
		for( int i = 0 ;  i< n ; i++) {
			for ( int j = 0 ; j < n ; j++) {
				if(arr[i][j] == 1 && !visit[i][j] )  {
					Queue<position> qq = new LinkedList<position>();
					Queue<position> endqq = new LinkedList<position>();
					int[][] temparr = new int[n][n];
					boolean[][] tempvisit =new boolean[n][n];
						qq.add(new position(i, j));
						endqq.add(new position(i, j));
						visit[i][j] = true;
						tempvisit[i][j] = true; 
						temparr[i][j] = 200;
						while(!qq.isEmpty()) {
							position temp = qq.poll() ;
							for ( int k = 0 ; k < 4 ; k++) {
								int dx = temp.x + deltax[k];
								int dy = temp.y + deltay[k];
								
//								if( j== 7&&dx>=0 && dx< n && dy>=0 && dy < n   ) {
//									System.out.println("점검 중"+ " i는 " + i  + "j는  " + j);
//									System.out.println(temp);
//									System.out.println(arr[dx][dy]);
//									System.out.println( dx + "  " + dy);
//									System.out.println(visit[dx][dy]);
//									System.out.println("출력된거빈다");
//								}
								if(dx>=0 && dx< n && dy>=0 && dy < n && !visit[dx][dy] && arr[dx][dy] == 1 ) {
									temparr[dx][dy] = 200;
									qq.add(new position(dx, dy));
									endqq.add(new position(dx, dy));
									visit[dx][dy] = true;
									tempvisit[dx][dy] = true; 
								}
							}
							
						}
						l:while(!endqq.isEmpty()) {
							position temp = endqq.poll() ;
							for ( int k = 0 ; k < 4 ; k++) {
								int dx = temp.x + deltax[k];
								int dy = temp.y + deltay[k];
								
								
								if(dx>=0 && dx< n && dy>=0 && dy < n && !tempvisit[dx][dy]  ) {
									if( arr[dx][dy] == 0 && temparr[temp.x][temp.y] == 200) {
										temparr[dx][dy] = 1;
										tempvisit[dx][dy]= true; 
										endqq.add(new position(dx, dy));
										continue;
									}
									if( arr[dx][dy] == 0 && temparr[temp.x][temp.y] != 200) {
										temparr[dx][dy] = temparr[temp.x][temp.y] + 1;
										tempvisit[dx][dy] = true;
										endqq.add(new position(dx, dy));
										continue;
									}
									if ( arr[dx][dy] == 1 ) {
										min = Math.min(temparr[temp.x][temp.y], min);
										break l;
									}
									
									
									
								}
							}
						} //while  
			
				}
			} // j
		}//i
		
		System.out.println(min);
		
	}
}
