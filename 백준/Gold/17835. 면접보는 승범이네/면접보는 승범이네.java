import java.util.*;
import java.io.*;

class Position implements Comparable<Position>{
	int node;
	long dist;
	Position(int node, long dist){
		this.node = node;
		this.dist = dist;
	}
	public int compareTo(Position o) {
		return Long.compare(this.dist, o.dist);
		
	}
	@Override
	public String toString() {
		return "Position [node=" + node + ", dist=" + dist + "]";
	}
	
	
}

public class Main {
	static int n,m,k;
	static ArrayList<ArrayList<Position>> graph = new ArrayList<>();
	static long[] distance;
	static int[] target;
	static long INF =  100000000000L;
	static int ans;
	static long ansdist;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	k = Integer.parseInt(st.nextToken());
    	
    	for( int i = 0 ; i <= n ; i ++) {
    		graph.add(new ArrayList<Position>());
    	}
    	distance = new long[n+1];
    	target = new int[k];
    	
    	
    	for( int i = 0 ; i< m ; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		int start = Integer.parseInt(st.nextToken());
    		int end = Integer.parseInt(st.nextToken());
    		int dis = Integer.parseInt(st.nextToken());
    		
    		graph.get(end).add(new Position(start,dis));
    	}
    	st = new StringTokenizer(br.readLine());
    	for (int i = 0 ; i < k ; i++) {
    		target[i] = Integer.parseInt(st.nextToken());
    	}
    	

    		dijkstra();
    	
    	System.out.println(ans);
    	System.out.println(ansdist);
    	
        
    }//main
    
    static void dijkstra() {
    	PriorityQueue<Position> pq = new PriorityQueue<Position>();
    	Arrays.fill(distance, INF);

    	for( int a : target) {
    		pq.add(new Position(a,0L));
    		distance[a] = 0 ;
    	}
    	
    	
    	while(!pq.isEmpty()) {
    		Position temp = pq.poll();
    		int node = temp.node;
    		long dist = temp.dist;
    		if( dist > distance[node]) continue;
    		
    		for ( Position a : graph.get(node)) {
    			long cost = dist+ a.dist;
    			if(distance[a.node] > cost ) {
    				pq.add(new Position(a.node ,cost));
    				distance[a.node] = cost;
    			}
    		}
    	} //while

    	for(int i= 1 ; i<= n ; i++) {
    		if( ansdist < distance[i]) {
    			ansdist = distance[i];
    			ans = i;
    		}
    	}
    	
    }
    
    
    
    
}