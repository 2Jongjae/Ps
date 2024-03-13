import java.util.*;
import java.io.*;
class Position implements Comparable<Position>{
	int node,dist;
	Position (int node, int dist){
		this.node = node;
		this.dist = dist;
	}
	
	public int compareTo(Position o) {
		return this.dist-o.dist;
	}
}



public class Main {
	static ArrayList<ArrayList<Position>> graph = new ArrayList<>();
	static int n,m;
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();

    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	for(int i =0 ; i<= n ; i++)  graph.add(new ArrayList<>());
    	
    	
    	for( int i = 0 ; i< m ; i++) {
    		st = new StringTokenizer(br.readLine());
    		int start = Integer.parseInt(st.nextToken());
    		int end = Integer.parseInt(st.nextToken());
    		int dist = Integer.parseInt(st.nextToken());
    		Position ps1 = new Position(start,dist);
    		Position ps2 = new Position(end,dist);
    		graph.get(start).add(ps2);
    		graph.get(end).add(ps1);
    	}
    	
    	
    	System.out.println(prim(1));
    }
    
    public static int prim(int start) {
    	int sum = 0 ;
    	PriorityQueue<Position> pq = new PriorityQueue<>();
    	
    	pq.add(new Position(1,0));
    	boolean[] visit = new boolean[n+1];
    	while(!pq.isEmpty()) {
    		Position temp = pq.poll();
    		int node = temp.node;
    		int dist = temp.dist;
    		if(visit[node]) continue;
    		if(!visit[node]) sum += dist;
    		visit[node] = true;
    		for( Position a : graph.get(node)) {
    			if(!visit[a.node]) pq.add(a);
    		}
    		
    	}
    	return sum;
    }
    
}
