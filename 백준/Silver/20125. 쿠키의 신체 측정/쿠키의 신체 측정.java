import java.io.*;
import java.util.*;
class Position{
	int x, y;
	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		char[][] arr = new char[n][n];
		
		int x = 0;
		int y = 0 ;
		for (int i = 0 ; i < n ; i ++) {
			String input = br.readLine();
			for (int j = 0 ; j < n ; j++) {
				arr[i][j] = input.charAt(j);
				if( x== 0 && y == 0 && arr[i][j] == '*' ) {
					x = i+1 ; 
					y = j;
				}
			}
		}
		//왼팔, 오른팔, 허리, 왼다리,오른다리
		int[] ans = new int[5];
		
		
		int[] deltax = {0,0,1};
		int[] deltay = {-1,1,0}; 
		int ansx = x+1;
		int ansy = y+1;
		Queue<Position> qq = new LinkedList<>();
		for (int i = 0 ; i < 3 ; i++) {
			qq.add(new Position(x,y));
			int cnt = 0 ;
			while(!qq.isEmpty()) {
				Position temp = qq.poll();
				int newX = temp.x + deltax[i];
				int newY = temp.y + deltay[i];
				if( newX>=0 && newX<n && newY>=0 && newY<n && arr[newX][newY] == '*' ) {
					qq.add(new Position(newX,newY));
					cnt++;
				} else {
					if( i == 2 ) x = temp.x;
					if( i == 2 ) y = temp.y;
				}
			}
			ans[i] = cnt;
		}
		
		for (int i = 1 ; i < n ; i ++) {
			if( x+i < n && arr[x+i][y-1] == '*' ) {}
			else {
				ans[3] = i-1;
				break;	
			}
		}
		
		for (int i = 1 ; i < n ; i ++) {
			if( x+i < n && arr[x+i][y+1] == '*' ) {} 
			else {
				ans[4] = i-1;
				break;
			}
		}
		
		System.out.println(ansx + " " + ansy);
		for (int a : ans) {
			System.out.print(a + " ");
		}
		
	}
}