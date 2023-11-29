import java.io.*;
import java.util.*;

class position {
    int x, y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

public class Main {
    static int[][] arr;
    static int n, m, time;
    //상하좌우
    static int[] deltax = {-1,1,0,0};
    static int[] deltay = {0,0,-1,1,};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                char temp = input.charAt(j);
                if (temp == '.') arr[i][j] = 0;
                if (temp == 'x') arr[i][j] = 1;
            }
        }
        time = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int tc = 0; tc < time; tc++) {
            int height = Integer.parseInt(st.nextToken());
            if (tc % 2 == 0) leftshoot(height);
            if (tc % 2 == 1) rightshoot(height);
            
            bfs();
        }

        for (int i = 0 ; i< n ; i ++) {
        	for(int j = 0 ; j<m;j++) {
        		if( arr[i][j] == 0)  sb.append(".");
        		if( arr[i][j] == 1) sb.append("x");
        	}
        	sb.append("\n");
        }
        System.out.println(sb);
        
    }

    private static void bfs() {
        boolean[][] visit = new boolean[n][m];
        int x = n-1 ;
        Queue<position> qq = new LinkedList<>();
        for ( int i = 0 ; i < m ; i ++){
            if(!visit[x][i] && arr[x][i] == 1) {
                qq.add(new position(x,i));
                visit[x][i] = true;
            }

            while(!qq.isEmpty()){
                position temp  = qq.poll();
                int dx = temp.x;
                int dy = temp.y;

                for (int k  = 0 ; k < 4 ; k++){
                    int xx = dx+ deltax[k];
                    int yy = dy+ deltay[k];

                    if( xx>=0 && xx<n && yy >=0 && yy<m && !visit[xx][yy] && arr[xx][yy] == 1 ){
                        qq.add(new position(xx,yy));
                        visit[xx][yy] = true;
                    }
                }

            }
        } //i문
        List<position> li = new LinkedList<>();
        boolean[][] visit2 = new boolean[n][m];

        l: for ( int i = 0 ; i < n ; i++){
            for ( int j = 0 ; j< m  ; j++){
           
                if( arr[i][j] == 1 && !visit[i][j] ){
                    qq.add(new position(i,j));
                    li.add(new position(i,j));
                    visit2[i][j] = true;

                    while(!qq.isEmpty()){
                        position temp = qq.poll();
                        int dx = temp.x;
                        int dy = temp.y;

                        for (int k  = 0 ; k < 4 ; k++){
                            int xx = dx+ deltax[k];
                            int yy = dy+ deltay[k];

                            if( xx>=0 && xx<n && yy >=0 && yy<m && !visit2[xx][yy] && arr[xx][yy] == 1 ){
                                qq.add(new position(xx,yy));
                                li.add(new position(xx,yy));
                                visit2[xx][yy] = true;
                            }
                        }

                    }



                    break l;
                }


            }
        }
        while( true ){
            boolean flag = false;
            if(li.size() == 0 ) break;
            for( int a = 0 ; a < li.size() ; a++){
                li.get(a).x ++;

                int dx = li.get(a).x +1;
                int dy = li.get(a).y;
                if( dx>=n || visit[dx][dy]) flag =true;
            }

            if(flag) break;

        }
        arr = new int[n][m];

        for( position a : li){
            int dx = a.x;
            int dy = a.y;
            arr[dx][dy]  = 1;
        }
//        if( li.size() == 8 ) { 
//        	System.out.println("확인");
//        	
//        	for (int i = 0 ; i < n ; i++) {
//        		System.out.println(Arrays.toString(arr[i]));
//        	}
//        }
        

        for( int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < m ; j ++){
                if(visit[i][j] ) arr[i][j] = 1;
            }
        }

    }

    private static void rightshoot(int height) {
        int x = n - height;
        int y = m - 1;
        while (true) {
            if (arr[x][y] == 1) {
                arr[x][y] = 0;
                break;
            }
            y--;
            if (y < 0) break;

        }


    }

     private static void leftshoot(int height) {
        int x = n - height;
        int y = 0;
        while(true) {
            if (arr[x][y] == 1) {
                arr[x][y] = 0;
                break;
            }
        y++;
        if( y  > m -1 ) break;
        }
    }
}