import java.io.*;
import java.util.*;


public class Main {
	static int n,m,k,num;
	static char[][] arr;
	static HashMap<String,Integer> map = new HashMap<>();
	static int[] dx = {-1,-1,-1,0,1,1,1,0};
	static int[] dy = {-1,0,1,1,1,0,-1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		for(int i = 0 ; i < n ; i ++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		String[] Strings = new String[k];
		for(int i = 0 ; i < k  ; i++) {
			Strings[i] = br.readLine();
			map.put(Strings[i], 0);
		}
		for(int i = 0 ; i < n ; i ++) {
			for(int j = 0 ; j < m ; j ++) {
				String string = String.valueOf(arr[i][j]);
				dfs(i,j,0,string);
			}
		}
		StringBuilder sb = new StringBuilder();
		
		for(String inp : Strings) sb.append(map.get(inp)).append("\n");
		System.out.println(sb);
	
	}
	
	static void dfs(int x, int y , int dep,String a) {
		
			if(map.containsKey(a))  map.put(a, map.getOrDefault(a, 0) + 1);			
			if( dep >= 5) return;
		for(int i = 0 ; i < 8 ; i ++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if( xx == -1 ) xx = n-1;
			if( xx == n )  xx = 0;
			if( yy == -1) yy = m-1;
			if( yy == m ) yy = 0; 
			
			String str = String.valueOf(arr[xx][yy]);
			dfs(xx,yy,dep+1,a+str);
			} 
			
		
	}

}