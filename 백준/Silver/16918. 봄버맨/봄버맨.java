import java.io.*;
import java.util.*;
class Position {
	int x,y;
	Position(int x, int y ){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n,m,k;
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int [n][m];	
		Queue<Position> qq = new LinkedList<>();
		for (int i = 0 ; i< n ; i++) {
			String input = br.readLine();
			for( int j = 0 ; j < m ; j++) {
				if(input.charAt(j) == '.') arr[i][j] = 0;
				else {arr[i][j] = 1;
				}
			}
		}
		
		int[] deltax = {-1,1,0,0};
		int[] deltay = {0,0,-1,1};
		
		for( int tc = 2;  tc<=k ; tc++) {
			if( tc%2 == 0) {
				for( int i = 0 ; i < n ; i++) {
					for(int j = 0 ; j < m ; j++) {
						if(arr[i][j] ==0) arr[i][j] = tc; 
					}
				}
			} else {
			
			for( int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < m ; j++) {
					if( arr[i][j] <= tc-2) {
						qq.add(new Position(i,j));
					}
				}
			}
			
			while(!qq.isEmpty()) {
				Position temp = qq.poll();
				arr[temp.x][temp.y] = 0 ;
				for (int i = 0 ; i < 4 ; i++) {
					int x = temp.x + deltax[i];
					int y = temp.y + deltay[i];
					if( x>=0 && x<n && y>=0 && y<m ) arr[x][y] = 0 ;
				}
			}
			}
			
			 
		} //while
		
		for( int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				if( arr[i][j]>0 ) System.out.print("O");
				else System.out.print(".");
			}
			System.out.println();
		}
		
	}
}
