import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static int root,ans;
	static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        
        int n = Integer.parseInt(st.nextToken());
        visit = new boolean[n];
        for (int i = 0 ; i < n ; i++) {
        	graph.add(new ArrayList<>());
        }
        
        
        st = new StringTokenizer(br.readLine());
        for( int i = 0 ; i <n ; i++) {
        	int value = Integer.parseInt(st.nextToken());
        	if( value == -1) {
        		root = i; 
        		continue;
        	}
        	graph.get(i).add(value);
        	graph.get(value).add(i);
        }
        
        int target = Integer.parseInt(br.readLine());
        visit[target] = true;
        if( target == root) {
        	System.out.println(0);
        	return;
        }
        for( int a : graph.get(target)) {
        	remove(a,target);
        }
        
        if( graph.get(root).size() == 0 ) {
        	System.out.println(1);
        	return;
        }
        dfs(root);
        System.out.println(ans);
        
    }//main
    
    private static void remove(int a, int target) {
    	for (int i = 0 ; i < graph.get(a).size() ;i++) {
    		if( target == graph.get(a).get(i)) {
    			graph.get(a).remove(i); 
    			i--;
    		}
    	}

    }
    	
	static void dfs(int node) {
    	
    	for( int  adj : graph.get(node)) {
    		if(!visit[adj]) {
    			visit[adj] = true;
    			dfs(adj);
    		}
    	}
    	if( node != root  && graph.get(node).size() ==1 )  ans++;
    	
    }
    
}