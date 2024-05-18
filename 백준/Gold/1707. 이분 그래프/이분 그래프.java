import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int n,m;
    static String ans;
    static int[] dp;
    static boolean flag;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int t = Integer.parseInt(st.nextToken());
        
        for( int tc = 0 ; tc< t ; tc++) {
        	ans = "YES";
        	graph = new ArrayList<>();
        	
        	st = new StringTokenizer(br.readLine());
        	n = Integer.parseInt(st.nextToken());
        	m = Integer.parseInt(st.nextToken());
        	
        	dp = new int[n+1];
        	
        	for( int i = 0 ; i <= n; i ++) {
        		graph.add(new ArrayList<>());
        	}
        	
        	for (int i = 0 ; i < m ; i++) {
        		st = new StringTokenizer(br.readLine());
        		int start = Integer.parseInt(st.nextToken());
        		int end = Integer.parseInt(st.nextToken());
        		graph.get(start).add(end);
        		graph.get(end).add(start);
        	}
        	
        	for (int i = 1 ; i <= n ; i++) {
        		if( dp[i] == 0 ) {
        			dfs(i, 1);
        		}
        	}
        
        	System.out.println(ans);
        	
        }
        
    }
    
    static void dfs(int node,int type) {
    	if( ans.equals("NO")) return;
    	dp[node] = type;
    	
    	for( int adj : graph.get(node)) {
    		if( dp[adj] == 0) {
    			dfs(adj ,3-type);
    		} else if(dp[adj] == type ) {
    			ans = "NO";
    			return;
    		}
    		
    		
    	}
    	
    	
    	
    }
    
}
