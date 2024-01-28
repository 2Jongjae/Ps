import java.io.*;
import java.util.*;
class Position{
	int x,y;
	Position(int x , int y ){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int n,blackmax , whitemax;
	static int[][] white,black;
	static int[] deltax = {-1,1,1,-1};
	static int[] deltay = {1,1,-1,-1};
	static List<Position> blackList= new ArrayList();
	static List<Position> whiteList= new ArrayList();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		white = new int[n][n];
		black = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for ( int j = 0 ; j < n ; j++) {
				Position ps = new Position(i, j);
				int value = Integer.parseInt(st.nextToken());
				if( (i%2) == 0 && (j%2) == 0  && value == 1) {
					white[i][j] ++;  
					whiteList.add(ps);
				}
				if( (i%2) == 0 && (j%2) == 1  && value == 1) {
					black[i][j] ++;  
					blackList.add(ps);
				}
				if( (i%2) == 1 && (j%2) == 0  && value == 1) {
					black[i][j] ++;  
					blackList.add(ps);
				}
				if( (i%2) == 1 && (j%2) == 1  && value == 1) {
					white[i][j] ++;  
					whiteList.add(ps);
				}
			}
		}
		blackcheck(0,0);
		whitecheck(0,0);

		System.out.println(blackmax+whitemax);
	}
	public static void blackcheck(int idx,int cnt ) {
		for( int i = idx ; i < blackList.size() ; i++) {
				Position ps = blackList.get(i);
				if(check(ps.x,ps.y)) {
					black[ps.x][ps.y] = 2;
					blackcheck(i+1, cnt+1);
					black[ps.x][ps.y] = 1;
				}
		}
		blackmax = Math.max(blackmax, cnt);
	}
	
	private static boolean check(int psx, int psy) {
		for(int i = 0 ; i < 4 ; i++) {
			int val = 1;
			while(true) {
			int x = psx + deltax[i]*val;
			int y = psy + deltay[i]*val;
			if( x>=0 && y>=0 && x<n && y<n ) {
				val++;
				if(black[x][y] == 2)  return false;
				} else break;
			}
		}
		return true;
	}
	
	
	
	public static void whitecheck(int idx,int cnt ) {
		for( int i = idx ; i < whiteList.size() ; i++) {
				Position ps = whiteList.get(i);
				if(check1(ps.x,ps.y)) {
					white[ps.x][ps.y] = 2;
					whitecheck(i+1, cnt+1);
					white[ps.x][ps.y] = 1;
				}
		}
		whitemax = Math.max(whitemax, cnt);
	}
	
	private static boolean check1(int psx, int psy) {
		for(int i = 0 ; i < 4 ; i++) {
			int val = 1;
			while(true) {
			int x = psx + deltax[i]*val;
			int y = psy + deltay[i]*val;
			if( x>=0 && y>=0 && x<n && y<n ) {
				val++;
				if(white[x][y] == 2)  return false;
				} else break;
			}
		}
		return true;
	}
	
}