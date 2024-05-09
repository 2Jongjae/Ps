import java.io.*;
import java.util.*;

public class Main {
	static int n,max;
	static int[] parent,depth;
	static int[][] dp;
	static List<ArrayList<Integer>> graph = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		depth = new int[n+1];
		parent = new int[n+1];
		dp = new int[n+1][2];
		for(int i = 0 ; i < n+1 ; i++) { graph.add(new ArrayList<>()); }
			
		
		for(int i = 0 ; i < n-1 ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			graph.get(start).add(end);
			graph.get(end).add(start);
		}
		
		pre(1, 1); // 전처리 
		
		
		 int result = Math.min(dp[1][0], dp[1][1]);
	        System.out.println(result);
		
	}
	
	static void pre(int node,int idx) {
		depth[node] = idx;
		max = Math.max(idx, max);
		dp[node][0] = 0;
		dp[node][1] = 1;
		
		
		for( int adj : graph.get(node)) {
			if(  parent[node] == adj) continue;
			dp[node][0] += dp[adj][1];
			dp[node][1] += dp[adj][0];
			
			parent[adj] = node;
			pre(adj,idx+1);
			
			 dp[node][0] += dp[adj][1];
			 dp[node][1] += Math.min(dp[adj][0], dp[adj][1]);
		}
		
	}
	
}