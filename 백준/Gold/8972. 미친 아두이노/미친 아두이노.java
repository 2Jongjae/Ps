import java.util.*;
import java.io.*;
class Position{
	int x,y;
	Position(int x, int y){
		this.x = x;
		this.y = y;
	}
}


public class Main {
	static int[] deltax = {0,1,1,1,0,0,0,-1,-1,-1};
	static int[] deltay = {0,-1,0,1,-1,0,1,-1,0,1};
	static int n,m;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	Position jong = new Position(0,0);
    	Queue<Position> qq = new ArrayDeque<>();
    	int[][] arr = new int[n][m];
    	for(int i = 0 ; i < n ; i ++) {
    		String input = br.readLine();
    		for(int j = 0 ; j<  m; j ++) {
    			if(input.charAt(j) == 'I' ) jong = new Position(i,j);
    			if(input.charAt(j) == 'R' ) {
    				qq.add(new Position(i,j));
    				arr[i][j] ++;
    			}
    		}
    	}
    	
    	String order = br.readLine();

    	for( int i = 0 ; i < order.length(); i++) {
    		int value = order.charAt(i) - '0';
    		jong.x += deltax[value];
    		jong.y += deltay[value];
    		if(arr[jong.x][jong.y] == 1 ) {
				System.out.println("kraj " + (i+1));
				return;
    		}
    		int size = qq.size();
    		for( int j = 0 ; j < size ; j++) {
    			Position temp = qq.poll();
    			int x = temp.x;
    			int y = temp.y;
    			if( arr[x][y] >=2) continue;
    			int min = Integer.MAX_VALUE;
    			int idx = 0;
    			for( int k = 1 ; k < 10 ; k++) {
    				int xx = Math.abs(jong.x - (x+ deltax[k]));
    				int yy = Math.abs(jong.y - (y + deltay[k]));
    				int dis = xx+ yy;
    				if( min > dis) {
    					idx = k;
    					min = dis;
    				}
    			}
    			
    			int newX = x + deltax[idx];
    			int newY = y + deltay[idx];
    			
    			if( newX == jong.x && newY == jong.y ) {
    				System.out.println("kraj " + (i+1));
    				return;
    			}
    			qq.add(new Position(newX,newY));
    		}
    		arr = new int[n][m];
    		for(Position a : qq) arr[a.x][a.y] ++;
    	}
    	
    	
    	for(int i = 0; i < n ; i++) {
    		for(int j = 0 ; j < m ; j ++) {
    			if(jong.x == i && jong.y == j ) {
    				System.out.print('I');
    				continue;
    			}
    			if( arr[i][j] == 1) System.out.print('R');
    			else System.out.print('.');
    		}
    		System.out.println();
    	}
    	
    }
}
