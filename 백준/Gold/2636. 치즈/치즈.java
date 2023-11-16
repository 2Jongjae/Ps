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
//접근 
// 치즈가 아닌 곳에 좌표를 visit 처리하고 Queue에 담는다.
// Queue에 사이즈인 만큼 꺼낸다.  delta를 활용하여 1이면 visit 처리하고 queue에 넣는다 .
// 마지막 처리를 어떻게 할 것인가
//  매번 마지막에 좌표 확인?


// 사고의 전환 

// 처음부터 배열을 크게 설정 
// 초기 값을 넣고 
// 최초의 외곽 0을 구한다 .
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[row+2][col+2];
		boolean[][] visit = new boolean[row+2][col+2];
		
		 
		Deque<position> qq = new LinkedList<>();
		
		for (int i = 1; i <= row ; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int  j = 1 ; j <= col ; j++) {
			int temp = Integer.parseInt(st.nextToken());
				arr[i][j] = temp;
			}
		}
		qq.add(new position(0, 0));
		//상하좌우
		int[] deltax = {-1,1,0,0};
		int[] deltay = { 0,0,-1,1};
		
		
		while ( !qq.isEmpty()) {
			position temp = qq.removeFirst();
			for ( int i = 0 ; i < 4 ; i++) {
				int dx = temp.x + deltax[i];
				int dy = temp.y + deltay[i];
				if( dx >= 0 && dx<=row+1 && dy>=0 && dy <=col+1 && !visit[dx][dy]&&arr[dx][dy] == 0 ) {
					qq.addLast(new position(dx, dy));
					visit[dx][dy] = true;
				}
			}
		}	
		
		for (int i = 0 ; i <=row+1 ; i ++) {
			for ( int j = 0 ; j <=col+1 ; j++) {
				if(visit[i][j]) qq.addLast(new position(i, j));
			}
		}
		
		int time = 0;
		while(!qq.isEmpty()) {
			boolean flag = true;
			l: for (int i = 1 ; i <= row ; i++) {
				for (int j = 1 ; j <= col ; j++) {
					if(arr[i][j] == 1) {
						flag = false;
						break l;
					}
				}
			}
			if(flag) {
				System.out.println(time);
				System.out.println(qq.size());
				return;
			}
			int size = qq.size();
			
//			System.out.println();
//			for (int i  = 0 ; i <= row+1 ;i++) {
//				System.out.println(Arrays.toString(arr[i]));
//			}
			time ++;
			for ( int  t =  0  ;  t< size ; t++) {
				position temp = qq.removeFirst();
				int dx = temp.x;
				int dy = temp.y;
				
				for ( int i = 0 ; i < 4 ; i++) {
					int xx = dx + deltax[i];
					int yy = dy + deltay[i];
					
					if( xx>= 1 && xx<= row && yy>=0 && yy<=col && !visit[xx][yy]) {
						if( arr[xx][yy] == 0) {
							Queue<position> qqq = new LinkedList<position>();
							qqq.add(new position(xx, yy));
							qq.addFirst(new position(xx, yy));
							size++;
							visit[xx][yy] = true;
							
							while(!qqq.isEmpty()) {
								position temptemp = qqq.poll();
							for (int k = 0 ; k< 4 ;k++) {
								int aa = temptemp.x + deltax[k];
								int bb = temptemp.y + deltay[k];
								
								if( aa>=1 && aa<=row && bb>=1 && bb<=col && !visit[aa][bb]  && arr[aa][bb] == 0) {
									qqq.add(new position(aa, bb));
									qq.addFirst(new position(aa, bb));
									visit[aa][bb] = true;
									size++;
								}
							}
						}
						} 
						else {
							arr[xx][yy] = 0 ;
							visit[xx][yy] = true;
							qq.add(new position(xx, yy));
						}
						
					}
			
			}
	
		}
		
		
		
	}
}
	}