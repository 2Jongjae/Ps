import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {
	static int n;
	static char[][] arr;
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	n = Integer.parseInt(st.nextToken());
    	arr = new char[n][n];
    	
    	for(int i = 0 ; i < n ; i ++) Arrays.fill(arr[i], ' ');
    	
    	dfs(0,0,n);
    	
    	for(int i = 0 ; i < n ; i++) {
    		for( int j = 0 ; j < n ; j ++) {
    			sb.append(arr[i][j]);
    		}
    		sb.append("\n");
    	}
    	System.out.println(sb);
	}
	static void dfs(int x,int y,int value) {
		if( value == 1) {
			arr[x][y] = '*';
			return;
		}
		
		int div = value/3;
		for( int i = 0 ; i<3 ; i++) {
			for (int j = 0 ; j < 3 ; j++) {
				if(i == 1 && j== 1) continue;
				
				dfs(x+i*div,y+j*div,div);
			}
		}
		
		
	}
	
}
