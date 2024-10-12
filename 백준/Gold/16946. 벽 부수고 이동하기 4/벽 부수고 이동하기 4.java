import java.io.*;
import java.util.*;
class Position{
	int x,y;
	Position(int x, int y ){
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}
	
	
}
public class Main {
	static int n, m ;
	static char[][] arr;
	static int[][] ans;
	static int[][] mID;
	static boolean[][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int id = 1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new char[n][m];
		ans= new int[n][m];
		mID = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i = 0 ; i < n ;i++) {arr[i] = br.readLine().toCharArray();}
		
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
					if(!visit[i][j] && arr[i][j] == '0') bfs(i,j);
				}
			}
		
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(arr[i][j] == '1') {
					cal(i,j,sb);
				} else sb.append(0);
			}
			sb.append("\n");
		}
		

		
		
		System.out.println(sb);
	}
	
	static void cal(int x,int y,StringBuilder sb) {
		boolean[] check = new boolean[id+1];
		int value = 1;
		for(int i = 0 ; i < 4 ; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if( xx>=0 && xx<n && yy>=0 && yy< m && !check[mID[xx][yy]]) {
				value += ans[xx][yy];
				check[mID[xx][yy]] = true;
			}
		}
		sb.append(value%10);
	}
	
	static void bfs(int x, int y) {
		id++;
		Queue<Position> qq = new LinkedList<>();
		ArrayList<Position> li = new ArrayList<>();
		qq.add(new Position(x,y));
		int cnt = 1;
		visit[x][y] = true;
		while(!qq.isEmpty()) {
			Position ps = qq.poll();
			for(int i = 0 ; i < 4 ; i++) {
				int xx = ps.x + dx[i];
				int yy = ps.y + dy[i];
				if( xx>=0 && xx <n && yy >= 0 &&  yy<m &&!visit[xx][yy] && arr[xx][yy] == '0') {
					visit[xx][yy] = true;
					qq.add(new Position(xx,yy));
					cnt++;
					li.add(new Position(xx,yy));
				}
			}
		}
		
		ans[x][y] = cnt;
		mID[x][y] = id;
		for( Position ps : li) {
			ans[ps.x][ps.y] = cnt;
			mID[ps.x][ps.y] = id;
		}
		
		
	}
	
	
	
}