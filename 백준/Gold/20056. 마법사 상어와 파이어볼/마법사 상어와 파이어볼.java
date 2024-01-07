import java.awt.Container;
import java.io.*;
import java.util.*;
class Fireball{
	int x,y,amount,speed,direction;
	
	public Fireball(int x, int y , int amount, int speed , int direction ) {
		this.x = x;
		this.y = y;
		this.amount = amount;
		this.speed = speed  ;
		this.direction = direction;
	}
	public String toString() {
		return "x = " + x + " y= " + y + " 질량은 " + amount + " speed = " + speed + " 방향은 = " + direction + "\n";
	}
}




public class Main {
	static int[][] arr ,check;
	static int n,m,orders;
	static List<Fireball> li = new ArrayList<>();
	static List<Fireball> stones;
	static int[] deltax = {-1,-1,0,1,1,1,0,-1};
	static int[] deltay = {0,1,1,1,0,-1,-1,-1};
	
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	orders = Integer.parseInt(st.nextToken());
    	
    	
    	for (int i = 0 ; i < m ; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		int c = Integer.parseInt(st.nextToken());
    		int d = Integer.parseInt(st.nextToken());
    		int e = Integer.parseInt(st.nextToken());
    		li.add(new Fireball(a,b,c,d,e));
    	}
    	
    	
    	for ( int tc= 0 ; tc<orders; tc++) {
    		movecheck();
    		if( !stones.isEmpty()) divide();
    	}
    	
    	int ans = 0;
    	for ( Fireball a : li) ans += a.amount;
    	
    	System.out.println(ans);
    
    }
    
    
    private static void movecheck() {
    	arr = new int [n+1][n+1];
    	check = new int[n+1][n+1];
    	stones = new ArrayList<>();
    	
    	for(Fireball a : li) {
    		int x = a.x;
    		int y = a.y;
    		x += deltax[a.direction]*a.speed;
    		y += deltay[a.direction]*a.speed;
    		x%=n;
    		y%=n;
    		if (x<=0) x = n +x;
    		if (y<=0) y = n +y;

    		int tempx = x;
    		int tempy = y;
    		a.x= tempx;
    		a.y= tempy;
    		arr[tempx][tempy]++;
    		
    		int rest = (a.direction%2 )+2 ;
    		if( check[tempx][tempy] == 0 ) check[tempx][tempy] = rest;
    		if( check[tempx][tempy] != rest ) check[tempx][tempy] = -1;
    	}
    	
    	for (int i = 0 ; i < li.size(); i++) {
    		Fireball fb = li.get(i);
    		if(arr[fb.x][fb.y] >=2) {
    			stones.add(fb);
    			li.remove(i);
    			i--;
    		}
    	}
    }
    
    private static void divide() {
    	List<Fireball> tempList = new ArrayList<>();
    	boolean[][] visit = new boolean[n+1][n+1];
    	for ( Fireball a : stones) {
    		if(visit[a.x][a.y] ) {
    			for(Fireball b : tempList) {
    				if( a.x== b.x && a.y == b.y) {
    					b.amount += a.amount;
    					b.speed += a.speed;
    					break;
    				}
    			}
    			continue;
    		}
    		visit[a.x][a.y] = true;
    		tempList.add(a);
    	}
    	for( Fireball a : tempList) {
    		int standard= -1;
    		if( check[a.x][a.y] == -1 ) standard =1;
    		else standard = 0 ;
    		
    		int amount = a.amount/5 ;
    		if ( amount  == 0 ) continue;
    		int speed = a.speed/arr[a.x][a.y];
    		
    		for ( int i = 0 ; i < 8 ; i ++) {
    			if( (i%2) != standard) continue; 
    			
    			int x = a.x + deltax[i];
    			int y = a.y + deltay[i];
        		x%=n;
        		y%=n;
        		if (x<=0) x = n +x;
        		if (y<=0) y = n +y;
        		li.add(new Fireball(a.x,a.y,amount,speed,i));
    			
    		}
    		
    		
    		
    		
    	}
    	
    	
    	
    	
    }
    
}
