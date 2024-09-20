import java.io.*;
import java.util.*;
class Position{
	int x,y;
	String type;
	Position(int x, int y , String type){
		this.x = x;
		this.y = y;
		this.type = type;
	}

	
}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][n];
		for(int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j ++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(arr[n-1][n-1] == 1 ) {
			System.out.println(0);
			return;
		}
		Queue<Position> qq = new LinkedList<Position>();
		
		qq.add(new Position(0,1,"가로"));
		int ans = 0;
		while(!qq.isEmpty()) {
			Position ps = qq.poll();
			if( ps.x == n-1 && ps.y == n-1) {
				ans++;
				continue;
			}
			int x = ps.x;
			int y = ps.y;
			if(ps.type == "가로") {
				if(y+1 >= n ) continue;
				if(arr[x][y+1] == 1) continue;
				qq.add(new Position(x,y+1,"가로"));
				if(x+1 < n && arr[x+1][y] == 0  && arr[x+1][y+1] == 0) 
					qq.add(new Position(x+1,y+1,"대각선"));
			}
			if(ps.type == "세로") {
				if(x+1 >= n ) continue;
				if(arr[x+1][y] == 1) continue;
				qq.add(new Position(x+1,y,"세로"));
				if(y+1>= n) continue;
				if(arr[x+1][y+1] == 0 && arr[x][y+1] == 0 ) {
					qq.add(new Position(x+1,y+1,"대각선"));
				}
			}
			
			if(ps.type == "대각선") {
				if(x+1 <n && arr[x+1][y] == 0 ) qq.add(new Position(x+1,y,"세로"));
				if(y+1 <n && arr[x][y+1] == 0 ) qq.add(new Position(x,y+1,"가로"));
				if( x+1 <n && y+1 < n && arr[x+1][y] == 0 && arr[x][y+1] ==0 
						&& arr[x+1][y+1] == 0 ) qq.add(new Position(x+1,y+1,"대각선"));
			}
			
		}
		
		System.out.println(ans);
	}
}