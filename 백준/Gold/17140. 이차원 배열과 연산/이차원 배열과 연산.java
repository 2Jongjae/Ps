import java.util.*;
import java.io.*;
class Position implements Comparable<Position>{
	int x,y;
	
	Position(int x, int y ){
		this.x = x;
		this.y = y;
	}
	
	public int compareTo(Position o) {
		if( this.y == o.y) return this.x - o.x;
		return this.y -o.y;
	}

	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}
	
	
	
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] arr = new int[15][15];
        
       int n = Integer.parseInt(st.nextToken());
       int m = Integer.parseInt(st.nextToken());
       int k = Integer.parseInt(st.nextToken());
        
       
       
        for( int i = 0 ; i < 3 ; i++) {
        	st = new StringTokenizer(br.readLine());
        	for( int j = 0 ; j <3 ; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        int row = 3;
        int col = 3;
        
        int ans = 0;
    	if(row >= n && col >= m) {
    		if( arr[n-1][m-1] == k) {
    			System.out.println(ans);
    			return;
    		}
    	}
        
        ArrayList<PriorityQueue<Position>> li = new ArrayList<>();
        for( int i = 0 ; i < 100 ; i ++) li.add(new PriorityQueue<Position>());
        while(true) {
        	ans ++; 
        	
        	if( row>=col) {
        		int max =0;
        		for( int i = 0 ; i < row ; i++) {
        			int[] cnt = new int[101];
        			for( int j = 0 ; j < col ; j ++) cnt[arr[i][j]] ++;
        			
        			li.get(i).clear();
        			for( int j = 1 ; j<= 100 ; j++) {
        				if(cnt[j] !=0) {
        					li.get(i).add(new Position(j,cnt[j]));
        				}
        			}
        			
        			max = Math.max(max,li.get(i).size() *2);
        		}
        		
        		col = max;
        		if(col > 100) col = 100;
        		
        		arr = new int[row][col];
        		for( int i = 0 ; i < row ; i++) {
        			int idx = 0; 
//        			if(ans == 3) System.out.println(li.get(i));
        			while(!li.get(i).isEmpty()) {
        				Position a = li.get(i).poll();
        				arr[i][idx++] = a.x;
        				arr[i][idx++] = a.y;
        				if(idx == 100) break;
        			}
        		}
        		
        		
        	} else {
        		int max = 0 ; 
        		for( int i = 0 ; i < col ; i ++) {
        			int[] cnt = new int[101];
        			for( int j = 0 ; j < row ; j++) {
        				cnt[arr[j][i]] ++;
        			}
        			
        			li.get(i).clear();
        			for( int j = 1 ; j <=100 ; j++) {
        				if( cnt[j] != 0 ) {
        					li.get(i).add(new Position(j,cnt[j]));
        				}
        			}
        			max = Math.max(li.get(i).size() *2 , max);
        		} //i
        	
        		
        		row = max;
        		if( row> 100) row =100;
        		arr = new int[row][col];
        		for( int i = 0 ;i < col ; i ++) {
        			int idx = 0 ;
        			
        			while(!li.get(i).isEmpty()) {
        				Position a = li.get(i).poll();
        				arr[idx++][i] = a.x;
        				arr[idx++][i] = a.y;
        				if(idx == 100) break;
        			}
        			
   
        		}
        		
        		
        	} // if 
        	if(row >= n && col >= m) {
        		if( arr[n-1][m-1] == k) {
        			System.out.println(ans);
        			return;
        		}
        	}
        	
//        	System.out.println("행은 = " + row + " col = " + col);
//        	for(int i =0 ; i < row ; i++) {
//        		System.out.println(Arrays.toString(arr[i]));
//        	}
//        	System.out.println();
        	if( ans >=100 ) {
        		System.out.println(-1);
        		return;
        	}
        }// while 
        
        
        
       
    }// main
}
