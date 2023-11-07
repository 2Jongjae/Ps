import java.io.*;
import java.util.*;

 class change {
	 int x ;
	 String y ;
	public change(int x, String y) {
		super();
		this.x = x;
		this.y = y;
	} 
 }
 class Snake{
	 int x,y,dir;
	public Snake(int x, int y, int dir) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	@Override
	public String toString() {
		return "Snake [x=" + x + ", y=" + y + ", dir=" + dir + "]";
	}
 }
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 사이즈 
		int n = Integer.parseInt(st.nextToken());
		
		// 사과의 개수
		int apple = Integer.parseInt(br.readLine());
			
		int[][] arr =new int[n+1][n+1];
		
		for ( int i = 0 ; i < apple ; i ++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1; 
		}
		
		int turn = Integer.parseInt(br.readLine());
		Deque<change> ch = new ArrayDeque<change>();
		for ( int  i = 0  ; i < turn ; i++) {
			st= new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			ch.add(new change(x, st.nextToken()));
		}
		Deque<Snake> sn = new ArrayDeque<>();
		sn.add(new Snake(1, 1, 1));
		arr[1][1] = 9 ; 		
		// 1,2,3,4 
		// 동 남 서 북 , 나머지로 계산  
		int cnt = 0 ; 
		while(true) {
		
			Snake temp = sn.peekFirst();
			int x = temp.x;
			int y = temp.y;
			int dir = temp.dir;
		
			if(!ch.isEmpty()) {
				change tempch = ch.peekFirst();
				int time = tempch.x;
				String pos = tempch.y;
			
			//방향 전환 타임 
			if( cnt == time) {
				ch.removeFirst();
				if( pos.equals("D")) {
					dir += 1 ;
				}
				if( pos.equals("L")) {
					dir -= 1 ; 
					if(dir == 0 ) dir =  4; 
				}
			}
			}
			//동
			if( dir % 4  == 1 )  y += 1;
			//남
			if( dir % 4  == 2 )  x += 1;
			//서
			if( dir % 4  == 3 )  y -= 1;
			//북
			if( dir % 4  == 0 )  x -= 1;
			
			//벽에 부딪히지 않으면서 , 자기 자신의 일부가 아니라면
			if( x>0  && x<= n && y> 0 && y <= n && arr[x][y] != 9 ) {
				
				sn.addFirst(new Snake(x, y, dir));
				//사과가 없다면 
				if( arr[x][y] == 0) {
					Snake  ss = sn.removeLast();
					arr[ss.x][ss.y] =  0 ; 
				}
					arr[x][y] =  9 ;
				 
//					for ( int i = 0 ; i <= n ; i++) {
//						System.out.println(Arrays.toString(arr[i]));
//					}
//					System.out.println(cnt);
				
			} else {
				break; 
			}
			cnt++; 
		}
		System.out.println(cnt+1);
	}
}
