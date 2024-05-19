import java.io.*;
import java.util.*;



public class Main {
	static int n;
	static List<List<Integer>> graph = new ArrayList<>();
	static boolean[] visit;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n  = Integer.parseInt(st.nextToken());
		
		visit = new boolean[n];
		arr = new int[n][n];
		
		
		for(int i = 0 ; i < n ; i++) {
			graph.add(new ArrayList<>());
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				int a = Integer.parseInt(st.nextToken());
				if( a== 1) graph.get(i).add(j);
			}
		}
		
		for( int i = 0 ; i< n ; i++) {
			visit = new boolean[n];
			dfs(i,i);
			for(int j = 0 ; j < n ; j ++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		
		
	}
	
	static void dfs(int idx, int node ) {
		for( int adj : graph.get(node)) {
			if(!visit[adj] ) {
				arr[idx][adj] = 1;
				visit[adj] = true;
				dfs(idx,adj);
			}
		}
		
	}
	
	
	
	
}
