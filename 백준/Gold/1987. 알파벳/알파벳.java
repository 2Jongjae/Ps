import java.util.*;
import java.io.*;
class Horse{
	int x,y;
	TreeMap<Character,Integer> tm = new TreeMap<>();

	Horse(){}
	Horse(int x, int y , TreeMap<Character,Integer> tm){
		this.x = x;
		this.y = y;
		this.tm = tm;
	}
	@Override
	public String toString() {
		return "Horse [x=" + x + ", y=" + y + ", tm=" + tm + "]";
	}
	
}

public class Main {
	static int n,m;
	static char[][] arr; 
	static int[] deltax = {-1,1,0,0};
	static int[] deltay = {0,0,-1,1};
	static boolean[][] visit ;
	static int max;
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();

    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	arr = new char[n][m];
    	visit = new boolean[n][m];
    	max = 0 ;
    	for( int i = 0 ; i < n ; i++) {
    		String input = br.readLine();
    		for (int j = 0 ; j < m ; j++) {
    			arr[i][j] = input.charAt(j);
    		}
    	}
    	
    	Horse hs = new Horse(); 
    	visit[0][0] = true;
    	hs.tm.put(arr[0][0], 0);
    	dfs(hs);
    	System.out.println(max);
    }
	
	
	static void dfs(Horse hs) {
		TreeMap<Character, Integer> tempMap = hs.tm;
		max = Math.max(max, tempMap.size());
		for( int i = 0 ; i < 4 ; i++) {
			int x = hs.x + deltax[i];
			int y = hs.y + deltay[i];
			
			if( x>=0 && x< n && y>=0 && y< m  && !visit[x][y]) {
				if(tempMap.containsKey(arr[x][y])) {
					continue;
				} else {
					tempMap.put(arr[x][y], 0);
					visit[x][y] = true;
					dfs(new Horse(x,y,tempMap));
					visit[x][y] = false; 
					tempMap.remove(arr[x][y]);
				}
				
			}
			
			
		}
	}
}
