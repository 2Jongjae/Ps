import java.util.*;
import java.io.*;
class Position{
	int node, distance;
	Position(int node, int distance){
		this.node =node;
		this.distance = distance;
	}
}
public class Main {
    static boolean[] visit;
    static ArrayList<ArrayList<Position>> tree; 
    static int max,value;
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        visit = new boolean[n+1];
        for (int i = 0; i <= n	; i++) {
            tree.add(new ArrayList<>());
        }
        
        for( int i = 1 ; i <= n ; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int value = Integer.parseInt(st.nextToken());
        	if( value == -1 ) continue;
        	while(true) {
        		int check = Integer.parseInt(st.nextToken());
        		if( check == - 1 )break;
        		int distance = Integer.parseInt(st.nextToken());
        		addEdge(value,check,distance);
        	}
        }
        
        dfs(1,0);
        visit = new boolean[n+1];
        dfs(value,0);
        System.out.println(max);
        
        
    }

    static void addEdge(int u, int v, int distance) {
    	Position ps1 = new Position(u,distance);
    	Position ps2 = new Position(v,distance);
        tree.get(u).add(ps2);
        tree.get(v).add(ps1);
    }
    
    static void dfs(int node , int depth){
    
    	visit[node] = true;
    	
    	for( Position adj : tree.get(node)) {
    		if( !visit[adj.node]) {
    		visit[adj.node] = true;
    		dfs(adj.node,depth+adj.distance);
    		}
    	}
    	
    	if( max < depth) {
    		max = depth;
    		value = node; 
    	}
    	
    	
    }
}
