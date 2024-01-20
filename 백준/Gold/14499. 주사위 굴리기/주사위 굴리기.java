import java.io.*;
import java.util.*;
class Dice {
	int top, bottom, ea,we,no,so,x,y;
	
	Dice(int x , int y){
		this.x = x;
		this.y = y;
	
	}
}


public class Main{
	static Dice dice;
	static int n,m,x,y,k;
	static int[] deltax = {0,0,0,-1,1};
	static int[] deltay = {0,1,-1,0,0};
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		
				
		for( int i = 0 ; i<n  ;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < m ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dice = new Dice(x,y);
		st = new StringTokenizer(br.readLine());
		for (int i = 0 ; i < k ;i++) {
			int delta = Integer.parseInt(st.nextToken());
			int xx = dice.x + deltax[delta];
			int yy = dice.y + deltay[delta];
			if( xx>=0 && xx<n && yy>=0 && yy<m) {
				dice.x = xx;
				dice.y = yy;
				int temptop = dice.top;
				int tempbottom = dice.bottom;
				int tempea = dice.ea;
				int tempwe = dice.we;
				int tempso = dice.so;
				int tempno = dice.no;
				if( delta == 1) {
					dice.top = tempwe;
					dice.bottom = tempea;
					dice.ea = temptop;
					dice.we = tempbottom;
				}
				if( delta == 2) {
					dice.top = tempea;
					dice.bottom = tempwe;
					dice.ea = tempbottom;
					dice.we = temptop;
				}
				
				if( delta == 3) {
					dice.top = tempso;
					dice.bottom = tempno;
					dice.so = tempbottom;
					dice.no = temptop;
				}
				if( delta == 4) {
					dice.top = tempno;
					dice.bottom = tempso;
					dice.so = temptop;
					dice.no = tempbottom;
				}
				
				if( arr[xx][yy] != 0 ) {
					int temp = arr[xx][yy];
					dice.bottom = temp;
					arr[xx][yy] = 0 ;
					sb.append(dice.top);
					if( i !=(k-1) )sb.append("\n");
				
					continue;
					
				}
				if( arr[xx][yy] == 0 ) {
					
					arr[xx][yy] =dice.bottom;
					sb.append(dice.top);
					if( i !=(k-1) )	sb.append("\n");
					continue;
				}
				
				
			}
		}
		System.out.println(sb);
		
	}
}