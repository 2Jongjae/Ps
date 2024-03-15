import java.util.*;
import java.io.*;

class Position implements Comparable<Position>{
	int node,dist;
	List<Integer> li = new ArrayList<>();
	Position(int node, int dist){
		this.node = node;
		this.dist = dist;
	}
	
	Position(int node, int dist,List<Integer> li){
		this.node = node;
		this.dist = dist;
		this.li = li;
	}
	
	public int compareTo(Position o) {
		return this.dist - o.dist;
	}

	@Override
	public String toString() {
		return "Position [node=" + node + ", dist=" + dist + ", li=" + li + "]";
	}
	
	
	
}


class Main {
	static int INF = Integer.MAX_VALUE;
	static int n,m;
	static ArrayList<ArrayList<Position>> graph = new ArrayList<>();
	static int[] distance; 
	static Position[] obj;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		for( int i = 0 ; i <= n ;i++) {
			graph.add(new ArrayList<>());
		}
		obj = new Position[n+1];
		distance = new int[n+1];
		Arrays.fill(distance, INF);
		
		for( int i = 0 ; i< m ; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			Position ps = new Position(end,dist);
			graph.get(start).add(ps);
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		
		dijkstra(start);		
		Position ans = obj[end];
		System.out.println(ans.dist);
		System.out.println(ans.li.size());
		for(int i : ans.li) {
			System.out.print(i + " ");
		}
		
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Position> pq = new PriorityQueue<>();
		List<Integer> dd = new ArrayList<>();
		dd.add(start);
		Position ps = new Position(start,0,dd);
		distance[ps.node] = 0;
		
		pq.add(ps);
		while(!pq.isEmpty()) {
			Position temp = pq.poll();
			int node = temp.node;
			int dist = temp.dist;
			List<Integer> li = temp.li;
//			System.out.println(temp);
			if( distance[node] <dist) continue;

			for( Position next : graph.get(node)) {
				int cost = dist + next.dist;
					if(distance[next.node] > cost) {
						List<Integer> newli = new ArrayList<>(li);
						newli.add(next.node);
						Position nextPs = new Position(next.node,cost,newli);
					
						pq.add(nextPs);
						distance[next.node] = cost;
						obj[next.node] = nextPs;
					}
			}
			
			
			
		}
		
		
	}
	
}