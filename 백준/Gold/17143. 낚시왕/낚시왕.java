import java.io.*;
import java.util.*;
class  Position{
	int x,y;
	Position(int x , int y){
		this.x = x;
		this.y = y;
	}
}

class Shark {
	int x,y,speed,dir,size;
	Shark(int x, int y, int speed,int dir,int size){
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.dir = dir;
		this.size = size;
	}
	@Override
	public String toString() {
		return "Shark [x=" + x + ", y=" + y + ", speed=" + speed + ", dir=" + dir + ", size=" + size + "]";
	}
}

class Main {
	static int[][] arr,size;
	static int n ,m,cnt,ans;
	static int[] deltax = {0,-1,1,0,0};
	static int[] deltay = {0,0,0,1,-1};
	static List<Shark> li = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		cnt = Integer.parseInt(st.nextToken());
		arr = new int[n+1][m+1];
		size = new int[n+1][m+1];
	
		for ( int i = 0 ; i < cnt ; i ++) {
			st = new StringTokenizer(br.readLine());
			int a,b,c,d,e;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			li.add(new Shark(a,b,c,d,e));
			size[a][b] = e;
			arr[a][b] ++;
		}
		
		ans = 0 ;
		for ( int t = 1  ; t<=m; t++) {
			check(t);
		
			move();
			update();
			
		}
		System.out.println(ans);
	}
	
	
	public static void check(int t) {
	int x = 0;
	int y = 0;
		for( int i = 1 ; i<= n ; i++) {
			if( arr[i][t] != 0 ) {
				x = i;
				y = t;
				break; 
			}
		}  // 상어 찾기 
		
		int targetsize = 0;
		if( x != 0  ) {
		for ( int i = 0 ; i < li.size() ; i ++) {
			Shark temp = li.get(i);
			if (temp.x == x && temp.y == y) {
				li.remove(i);
				i--;
				ans += temp.size;
				}
			}
		} // 낚시 성공 
			
		
	}
	public static void update() {
		List<Shark> tempList = new ArrayList<>();
		List<Position> ps = new ArrayList<>();
		arr = new int[n+1][m+1];
		for ( Shark a : li) {
			if(arr[a.x][a.y] >=2 ) continue;
			arr[a.x][a.y] ++;
			if(arr[a.x][a.y] >=2 ) ps.add(new Position(a.x,a.y));
		}
		
	
		if( ps.size() == 0 ) return;
		
		//2개이상인 거 삭제 
		for ( int i = 0 ; i< li.size() ; i ++) {
			Shark temp = li.get(i);
			if ( arr[temp.x][temp.y] >=2 ) {
				li.remove(i);
				i--;
				tempList.add(temp);
			}
		}
		
		Shark[] dp = new Shark[ps.size()];
		for ( int i = 0 ; i < ps.size(); i++) {
			Position pstemp = ps.get(i);
			int x = pstemp.x;
			int y = pstemp.y;
			for (int j = 0 ; j< tempList.size(); j++) {
				Shark sh = tempList.get(j);
				if( sh.x == x && sh.y == y) {
					if( dp[i] == null) dp[i] = sh;
					if(dp[i].size < sh.size) dp[i] = sh;
					tempList.remove(j);
					j--;
				}
			}
		}
		for ( int i = 0 ; i < dp.length;i++) {
			li.add(dp[i]);
		}
		
	}
	
	
	
	
	public static void move() {
		arr = new int[n+1][m+1];
		for (Shark a : li) {
			int x = a.x;
			int y = a.y;
			int dir = a.dir;
			int value = a.speed*deltax[a.dir];
			value += a.speed*deltay[a.dir];
			if ( value <= 0 ) value = -value;
			int count = 1; //나머지값
			if( a.speed == 0 ) continue;
			
			//y축 고정 
			if(dir == 1 || dir == 2 ) {
				value %= (n-1)*2;
				int[] temp = new int[(n-1) * 2 +1];
				if( dir == 1 ) {
					for ( int i = (x-1)  ; i >=1 ; i--) {
						temp[count++] = i; 
					}
					for( int i = 2; i<= n ; i++) {
						temp[count++] = -i;
					}
					for( int i = n-1 ; i>x ;i--) {
						temp[count++] = i;
					}
					if (temp[value] == 0 ) continue;
					if ( temp[value] < 0  ) {
						temp[value] = -temp[value];
						a.x = temp[value];
						a.dir = 2;
					} else a.x = temp[value];
				}
				
				if( dir == 2 ) {
					for( int i =  x+1 ; i <= n ; i++) {
						temp[count++] = i;
					}
					for( int i = n-1 ; i >= 1 ; i--) {
						temp[count++] = -i;
					}
					for ( int i = 2 ; i<x ; i++) {
						temp[count++] = i;
					}
				
					
					if (temp[value] == 0 ) continue;
					if ( temp[value] < 0  ) {
						temp[value] = -temp[value];
						a.x = temp[value];
						a.dir = 1;
					} else a.x = temp[value];
					
				}
		
			}
			
			if( dir == 3 || dir == 4) {
				value %= (m-1)*2;
				int[]temp = new int[(m-1) * 2 +1];
					
				if ( dir == 3 ) {
					for ( int i = y + 1 ; i <=m ; i++) {
						temp[count++] = i; 
					}
					for ( int i = m-1 ; i >= 1 ; i--) {
						temp[count++] = -i; 
					}
					for ( int i = 2 ; i <= y-1 ; i++) {
						temp[count++] = i;
					}
					if (temp[value] == 0 ) continue;
					if ( temp[value] < 0  ) {
						temp[value] = -temp[value];
						a.y = temp[value];
						a.dir = 4;
					} else a.y = temp[value];
				}
				if ( dir == 4 ) {
					for ( int i = y - 1 ; i>=1 ; i--) {
						temp[count++] = i; 
					}
					for ( int i = 2 ; i <= m ; i++) {
						temp[count++] = -i; 
					}
					for ( int i = m-1 ; i >= y+1 ; i--) {
						temp[count++] = i;
					}
					if (temp[value] == 0 ) continue;
					if ( temp[value] < 0  ) {
						temp[value] = -temp[value];
						a.y = temp[value];
						a.dir = 3;
					} else a.y = temp[value];
					
				}
				
			} // 3or 4 if
			 
		} //for - each 
	} 	//move메소드 
	
	
}