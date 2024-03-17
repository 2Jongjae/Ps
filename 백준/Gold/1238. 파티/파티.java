import java.util.*;
import java.io.*;

class Position implements Comparable<Position> {
	int node, dist;

	Position(int node, int dist) {
		this.node = node;
		this.dist = dist;
	}
	
	public int compareTo(Position o) {
		return this.dist - o.dist;
	}
}

public class Main {
	static int n, m, x;
	static int[] distance;
	static ArrayList<ArrayList<Position>> graph = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		distance = new int[n+1];
		for(int i = 0 ; i<= n ; i++) {
			graph.add(new ArrayList<Position>());
		}
	
		for( int i = 0 ; i< m ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			graph.get(start).add(new Position(end,dist));
		}
		dijkstra(x);
		int[] party = new int[n+1];
		for(int i = 1 ; i<= n ;i++) {
			party[i] = distance[i];
		}
		
		int max = Integer.MIN_VALUE;
		for( int i = 1 ; i<= n;i++) {
			dijkstra(i);
			int value = party[i] + distance[x];
			max = Math.max(value, max);
		}
		System.out.println(max);
		
	}
	
	
	static void dijkstra(int start) {
		PriorityQueue<Position> pq = new PriorityQueue<>();
		distance = new int[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		pq.add(new Position(start,0));
		distance[start] = 0;
		while(!pq.isEmpty()) {
			Position ps = pq.poll();
			int node = ps.node;
			int dist = ps.dist;
			
			if( distance[node] < dist ) continue;
			
			for( Position a : graph.get(node)) {
				int nextnode = a.node;
				int cost = a.dist + dist;
				if( distance[nextnode] > cost) {
					pq.add(new Position(nextnode,cost));
					distance[nextnode] = cost;
				}
			}
			
		}
		
	}
}
