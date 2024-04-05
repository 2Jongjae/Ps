import java.util.*;
import java.io.*;
class Position{
    int x, y , color;
    Position(int x, int y, int color){
        this.x = x;
        this.y = y;
        this.color = color;
    }
    Position(){}
}


public class Main {
    static int n,m;
    static int[][] arr;
    static boolean[][][][] visit;
    static int[] deltax = {-1,1,0,0};
    static int[] deltay = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        Position red = new Position();
        Position blue = new Position();

        arr = new int [n][m];
        visit = new boolean[n][m][n][m];
        
        for (int i = 0 ; i < n ; i ++) {
            String input = br.readLine();
            for(int j = 0 ; j < m ; j ++) {
                if(input.charAt(j) == '#') arr[i][j] = 1;
                if(input.charAt(j) == 'R') red = new Position(i,j,2);
                if(input.charAt(j) == 'B') blue = new Position(i,j,3);
                if(input.charAt(j) == 'O') arr[i][j] = 9;
            }
        }
        
        
        Queue<Position> qq = new ArrayDeque<>();
        qq.add(red);
        qq.add(blue);
        

        int time = 0;
        while(!qq.isEmpty()) {
            int size = qq.size() ;
            if (time > 100 ) break;
            time ++ ;
            if( time >10 ) {
            	System.out.println(-1);
            	return;
            }
            for ( int i = 0 ; i< size/2 ;  i++) {
                Position a = qq.poll();
                Position b = qq.poll();
                
                visit[a.x][a.y][b.x][b.y] = true;
                
                l: for(int k = 0 ; k < 4 ; k ++ ) {
                    int xx1 = 0;
                    int yy1 = 0;
                    
                    int xx2 = b.x + deltax[k];
                    int yy2 = b.y + deltay[k];
                    
                    int idx = 1;
                    
                    //빨간공
                    while (true) {
                        int x = a.x + (deltax[k] *idx);
                        int y = a.y + (deltay[k] *idx);
                        if( x >=0  && x < n && y>0 && y < m  && arr[x][y] != 1) {
                            if(arr[x][y] == 9 ) {
                                xx1 = x;
                                yy1 = y; 
                                break;
                            }
                            idx ++;
                            continue;
                        }
                        xx1 = a.x + deltax[k] *(idx-1);
                        yy1 = a.y + deltay[k] *(idx-1);
                        break;
                    }
                    
                    
                    //파란공 
                    idx =1;
                    while (true) {
                        int x = b.x + deltax[k] *idx;
                        int y = b.y + deltay[k] *idx;
                        if( x >=0  && x < n && y>0 && y < m  && arr[x][y] != 1) {
                            if(arr[x][y] == 9 ) continue l;
                            idx ++;
                            continue;
                        }
                        xx2 = b.x + deltax[k] *(idx-1);
                        yy2 = b.y + deltay[k] *(idx-1);
                        break;
                    }
                    if(arr[xx2][yy2] == 9) continue;
                    if( arr[xx1][yy1] == 9 ) {
                    	System.out.println(time);
                    	return;
                    }

                    if( xx1 == xx2 && yy1 == yy2) {
                        if( k== 0 ) {
                        	if(a.x< b.x) xx2++;
                        	else xx1++;
                        }
                        if( k == 1 ) {
                        	if(a.x< b.x) xx1--;
                        	else xx2--;
                        }
                        if( k== 2 ) {
                        	if( a.y < b.y)yy2++;
                        	else yy1++;
                        }
                        if( k== 3) {
                        	if( a.y < b.y)yy1--;
                        	else yy2--;
                        }
                        
                    }
                    if(visit[xx1][yy1][xx2][yy2]) continue;
                    visit[xx1][yy1][xx2][yy2] =true;
                    Position redball = new Position(xx1,yy1,2);
                    Position blueball = new Position(xx2,yy2,3);
                   qq.add(redball);
                   qq.add(blueball);
                   }
                
            } //size 
            
        } // while 
        
        
        
        
        System.out.println(-1);
        
    }// main
}
