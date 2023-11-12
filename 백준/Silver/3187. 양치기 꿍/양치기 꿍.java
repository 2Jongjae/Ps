import java.io.*;
import java.util.*;

//좌표값을 담을 클래스 선언 
class position {
	int x, y;

	public position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int[][] arr; // 초기 지도 값
	static boolean[][] visit; // 부분 집합에 대한 방문배열
	static int n, m, sh, wo;
	static boolean[] check; // 부분 집합에 필요한 부분집합 (백트래킹)
	// 상하좌우
	static int[] deltax = { -1, 1, 0, 0 };
	static int[] deltay = { 0, 0, -1, 1 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visit= new boolean[n][m];
		for ( int i  = 0 ; i < n ; i ++) {
			String input = br.readLine();
			for ( int  j = 0 ; j < m ; j++) {
				char temp = input.charAt(j);
				if( temp == '.') arr[i][j] = 0;
				if( temp == '#') {
					arr[i][j] = 1;
					visit[i][j]  =true;
				}
				if( temp == 'v') arr[i][j] = 2; //늑대 
				if( temp == 'k') arr[i][j] = 3; // 양
			}
		}
			Queue<position> qq = new LinkedList<position>();
			int endsh =0;
			int endwo =0;
				for(int i = 0 ; i< n ; i++) {
					for(int j =  0; j<m ; j++) {
						if( arr[i][j] != 1 && !visit[i][j]) {
							qq.add(new position(i, j));
							visit[i][j] = true; 
							sh = wo  = 0;
							if(arr[i][j] == 2) wo++;
							if(arr[i][j] == 3) sh++;
							while(!qq.isEmpty()) {
								position temp = qq.poll();
								int dx = temp.x;
								int dy = temp.y;
								for ( int k = 0 ; k < 4 ; k++) {
									int xx = dx + deltax[k];
									int yy = dy + deltay[k];
									if( xx>=0 && xx< n && yy>=0 && yy<m && arr[xx][yy] != 1 && !visit[xx][yy]) {
										if(arr[xx][yy] == 2)  wo ++;
										if(arr[xx][yy] == 3)  sh ++;
										qq.add(new position(xx, yy));
										visit[xx][yy] = true;
									}
									
								}
								
							}
							if( sh > wo ) endsh += sh;
							else  endwo += wo;
							
						}
				} 
			}
		System.out.println(endsh + " " + endwo);
}
}
