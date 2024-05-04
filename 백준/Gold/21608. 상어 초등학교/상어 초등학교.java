import java.io.*;
import java.util.*;

class Position {
	int x,y;
	Position(int x, int y ) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}
	
}

public class Main {
	static int n, ans;
	static int[][] arr;
	static List<Integer>[] li;
	static int[] deltax = {-1,1,0,0};
	static int[] deltay = {0,0,-1,1};
	static List<Position> ps;
	static int[] order;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		li = new ArrayList[n*n];
		order = new int[n*n+1];
		for(int i = 0 ; i <n*n ; i++) li[i] = new ArrayList<>();
		
		for(int i = 0 ; i <n *n ; i++) {
			 st = new StringTokenizer(br.readLine());
			int a,b,c,d,e;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			order[a] = i;
			li[i].add(a);
			li[i].add(b);
			li[i].add(c);
			li[i].add(d);
			li[i].add(e);
		}
		
		arr = new int[n][n];
		
		arr[1][1] = li[0].get(0);

		
		for( int i = 1 ; i < n*n ; i++) {
		
			if(first(i)) {
				if(second(i)) {
					third(i);
				}
			}
//			for(int wi = 0 ; wi < n ;wi++) {
//				System.out.println(Arrays.toString(arr[wi]));
//			}
//			System.out.println();
		}
		
		last();
		
		
		System.out.println(ans);
		
		
	}
	
	static void last() {
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j ++) {
				int sum = 0 ;
				int a = arr[i][j];
				for(int k = 0 ; k < 4 ; k++) {
					int x = i + deltax[k];
					int y = j + deltay[k];
					if( x >= 0 && x < n && y >= 0 && y <n  && li[order[a]].contains(arr[x][y])) sum++;
					
				}
				if( sum == 1) ans +=1;
				if( sum == 2) ans +=10;
				if( sum == 3) ans +=100;
				if( sum == 4) ans +=1000;
			}
		}
		
	}
	
	
	static boolean first(int idx) {
		
		int temp = li[idx].get(0);
		ps = new ArrayList<>();
		int max =0;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j ++) {
				int sum = 0 ;
				if( arr[i][j] != 0 ) continue;
				for(int k = 0 ; k < 4 ; k++) {
					int x = i + deltax[k];
					int y = j + deltay[k];
					if( x >= 0 && x< n && y >= 0 && y<n && arr[i][j] == 0 && li[idx].contains(arr[x][y])) sum++;
				}
				
				
				if( max < sum) {
					max = sum;
					ps = new ArrayList<>();
					ps.add(new Position(i,j));
					continue;
				}
				if( max == sum ) ps.add(new Position(i,j));
			}
		}

		if(ps.size() >=2) return true;
		
		arr[ps.get(0).x][ps.get(0).y] = temp;
		return false;
	}
	
	
	static boolean second(int idx) {
		List<Position > temp = new ArrayList<>();
		int max = 0; 
	
		for( Position a : ps) {
			int sum = 0 ;
//			if( idx == 1) System.out.println(a);
			for( int i = 0 ; i < 4; i ++) {
				int x = a.x + deltax[i];
				int y = a.y + deltay[i];
				if( x >= 0 && x < n && y >=0 && y<n && arr[x][y] == 0  ) sum++;
			}
			if( sum > max ) {
				max = sum;
				temp.clear();
				temp.add(a);
				continue;
			}
			if( max == sum ) temp.add(a);
 		}
	
		ps = new ArrayList<>(temp);
		
		
		if( temp.size() >= 2) return true;
		Position p = temp.get(0);
		arr[p.x][p.y] = li[idx].get(0);
		return false;
	}
	
	static void third(int idx) {
		int x = 99;
		int y = 99;
		for( Position a : ps) {
			x = Math.min(x, a.x);
		}
		for( Position a : ps) {
			if( x == a.x) {
				y = Math.min(y, a.y);
			}
		}
		arr[x][y] = li[idx].get(0);
		
	}
	
}