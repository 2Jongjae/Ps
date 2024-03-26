import java.util.*;
import java.awt.Container;
import java.io.*;

public class Main {
	static List<Integer>[] arr = new ArrayList[4];
	static int[] check ;
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
     
   
       
       
       
       
       for (int i = 0 ; i < 4 ; i ++) {
    	   String input = br.readLine();
    	   arr[i] = new ArrayList<>();
    	   for (int j = 0 ; j < 8 ; j ++) {
    		   arr[i].add(input.charAt(j) - '0');
    	   }
       }
       
       int n = Integer.parseInt(br.readLine());
       
       for( int i = 0 ; i < n ; i ++) {
    	   StringTokenizer st = new StringTokenizer(br.readLine());
    	   int start = Integer.parseInt(st.nextToken()) -1 ;
    	   int dir = Integer.parseInt(st.nextToken());
    	   dfs(start, dir);
       }
       
       int ans = 0 ;
       if( arr[0].get(0) == 1) ans += 1;
       if( arr[1].get(0) == 1) ans += 2;
       if( arr[2].get(0) == 1) ans += 4;
       if( arr[3].get(0) == 1) ans += 8;
       System.out.println(ans);
    }
    
    
    static void dfs( int start ,int dir ) {
    	check = new int[4];
    	checkright(start);
    	checkleft(start);
    	
    	for( int i = start+1 ; i < 3 ; i++) {
    		if( check[i] == 1 )  check[i+1] = 1;
    	}
    
    	for( int i = start-1 ; i >=1 ; i--) {
    		if( check[i] == 1 )  check[i-1] = 1;
    	}
    	
    	
    	for( int i = 0 ; i < 4 ; i++) {
    		if( (start%2 ) == (i%2) && check[i] == 0 ) spin(i,dir);
    		if( (start%2 ) != (i%2) && check[i] == 0 ) spin(i,-dir);
    	}
    }
    
    static  void spin( int start, int dir ) {
//    	System.out.println(start);
    	if( dir == 1 ) {
    		int a = arr[start].remove(7);
    		arr[start].add(0, a);
    	} else {
    		int a = arr[start].remove(0);
    		arr[start].add(a);
    	}
    	
    	
    }
    
    static void checkleft(int start) {
    	if(start == 0 ) return; 
    	if(arr[start].get(6) == arr[start-1].get(2) ) check[start-1] = 1;
    	checkleft(start-1);
    	
    }
    
   
    static void checkright(int start) {
    	if(start == 3 ) return; 
    	if(arr[start].get(2) == arr[start+1].get(6) ) check[start+1] = 1;
    	checkright(start+1);
    }
    
}
