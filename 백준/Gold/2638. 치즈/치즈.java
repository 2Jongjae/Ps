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
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n+2][m+2];
        boolean[][] visit = new boolean[n+2][m+2];
        
        for ( int i = 1  ; i  <= n ; i ++) {
        	st = new StringTokenizer(br.readLine());
        	for ( int j = 1 ; j <= m ; j ++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        //상하좌우
        int[] deltax =  {-1,1,0,0};
        int[] deltay =  {0,0,-1,1};
        
        Queue<position> qq = new LinkedList<position>();
        qq.add(new position(0, 0));
        visit[0][0] = true; 
        while( !qq.isEmpty()) {
        	position temp =  qq.poll();
        	
        	int dx = temp.x;
        	int dy = temp.y;
        	for  ( int i = 0 ; i < 4 ; i++) {
        		int xx = dx + deltax[i];
        		int yy = dy + deltay[i];
        		if( xx>=0 && xx <= n+1 && yy>=0 && yy <=m+1 && !visit[xx][yy] && arr[xx][yy] == 0) {
        			qq.add(new position(xx, yy));
        			visit[xx][yy] = true;
        			
        		} else continue;
        	}
        }
 
        //로직 정리
        // 1. 4방향에 2개이상 true 가 되어있다면 qq에 넣기 
        // 2. qq에 꺼낼 때  bfs 더 돌려서 0 있는지 체크 
        int ans = 0 ;
        while ( true ) {
        	boolean flag = true; 
        for ( int i = 1 ; i <= n ; i ++) {
        	for ( int j =1 ; j <=m ; j ++) {
        		
        		if( arr[i][j] == 1 ) {
        			flag =false; 
        			int cnt = 0 ; 
        			for ( int  k = 0 ; k < 4 ; k++) {
        				int dx = i + deltax[k];
        				int dy = j + deltay[k];
        				if(visit[dx][dy]) cnt++;
        			}
        			
        			if( cnt >=2 ) 	qq.add(new position(i, j));
        			
        		}
        	}
        }
        
        while(!qq.isEmpty()) {
        	position temp =  qq.poll();
        	
        	int dx = temp.x;
        	int dy = temp.y;
        	arr[dx][dy] = 0 ;
        	visit[dx][dy] = true;
        	for  ( int i = 0 ; i < 4 ; i++) {
        		int xx = dx + deltax[i];
        		int yy = dy + deltay[i];
        		if( xx>=0 && xx <= n+1 && yy>=0 && yy <=m+1 && !visit[xx][yy] && arr[xx][yy] == 0) {
        			qq.add(new position(xx, yy));
        			visit[xx][yy] = true;
        		}
        	}
        	
        }
        

        	ans ++ ;
        	if( flag) break;
        } // while
        System.out.println(ans-1);
        
    }
}
