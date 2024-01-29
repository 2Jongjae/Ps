import java.io.*;
import java.util.*;
class Position{
	int x,y;
	Position ( int x , int y ){
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}
	
}

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
        int[][] arr = new int[12][6];
        boolean[][] visit = new boolean[12][6];
        
        for (int i = 0 ; i < 12 ; i++) {
        	String input = br.readLine();
        	for( int j = 0 ; j < 6 ; j++) {
        		if( input.charAt(j) == 'R') arr[i][j] = 1;
        		if( input.charAt(j) == 'G') arr[i][j] = 2;
        		if( input.charAt(j) == 'B') arr[i][j] = 3;
        		if( input.charAt(j) == 'Y') arr[i][j] = 4;
        		if( input.charAt(j) == 'P') arr[i][j] = 5;
        	}
        }
        
        
        
       int cnt = 0;
       Queue<Position> qq = new LinkedList<>();
       int deltax[] = {-1,1,0,0};
       int deltay[] = {0,0,-1,1};
       int puyo=0;
        while(true) {
        	boolean flag = false;
        	visit = new boolean[12][6];
        	for( int i = 0 ; i < 12 ; i++) {
        	for( int j = 0 ; j < 6;j++) {
        		if(!visit[i][j] && arr[i][j] != 0) {
        			qq.add(new Position(i,j));
        			visit[i][j] = true;
        			List<Position> li = new ArrayList<>();
        			li.add(new Position(i,j));
        			while(!qq.isEmpty()) {
        				Position ps = qq.poll();
        				
        				for (int k = 0 ; k <4 ; k++) {
        					int x = ps.x + deltax[k];
        					int y = ps.y + deltay[k];
        					if( x>=0 && x<12 && y>=0 && y<6 && !visit[x][y] && arr[x][y] == arr[ps.x][ps.y]) {
        						li.add(new Position(x,y));
        						qq.add(new Position(x,y));
        						visit[x][y] = true;
        					}
        				}
        			} //while
        			if( li.size() >= 4 ) {
        			for( Position a : li) arr[a.x][a.y] = 0 ;
        			flag = true; 
        			}
        			} // if문 
        		} // j문 
        	}
//        	for( int i = 0 ; i < 12; i++) {
//        		System.out.println(Arrays.toString(arr[i]));
//        	}
//        	System.out.println();
     
        	for (int z = 0 ;  z< 12 ; z++) {
        	for (int j = 0 ; j <6 ; j ++) {
        		for (int i = 11 ; i>= 1 ; i--) {
        			if(arr [i][j] == 0) {
        				int temp = arr[i-1][j] ;
        				arr[i][j] =temp;
        				arr[i-1][j] = 0;
        			}
        		}
        	}
        	}
//        	for( int i = 0 ; i < 12; i++) {
//        		System.out.println(Arrays.toString(arr[i]));
//        	}
//        	System.out.println();
        	if( flag) puyo++;
        	else break;
        } //for문 

        
        System.out.println(puyo);
        
        
        
        
    }
}
