import java.util.*;
import java.io.*;

class Position implements Comparable<Position> {
	int id, dis;
	Position(int id, int dis) {
		this.id = id;
		this.dis = dis;
	}
	@Override
	public int compareTo(Position o) {
		return Integer.compare(this.dis, o.dis);
	}
}

class Main {
	static final int INF = Integer.MAX_VALUE;
	static ArrayList<ArrayList<Position>> graph = new ArrayList<>();
	static int[] distance;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		int start = Integer.parseInt(br.readLine());
		distance = new int[v+1];
		Arrays.fill(distance,INF);
		
		 for (int i = 0; i <= v; i++)  graph.add(new ArrayList<>());
		
		 for (int i = 0; i < e; i++) {
	            st = new StringTokenizer(br.readLine());
	            int a = Integer.parseInt(st.nextToken());
	            int b = Integer.parseInt(st.nextToken());
	            int c = Integer.parseInt(st.nextToken());
	            graph.get(a).add(new Position(b, c));
	        }
		 
		  dijkstra(start);
		  StringBuilder sb = new StringBuilder();
	        for (int i = 1; i <= v; i++) {
	            if (distance[i] == INF)
	                sb.append("INF").append('\n');
	            else
	                sb.append(distance[i]).append('\n');
	        }

	        System.out.print(sb.toString());
		 
	}
	
    public static void dijkstra(int start) {
        PriorityQueue<Position> pq = new PriorityQueue<>();
        pq.offer(new Position(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Position current = pq.poll();
            int now = current.id;
            int dist = current.dis;

            if (distance[now] < dist) continue;

            for (Position next : graph.get(now)) {
                int cost = dist + next.dis;

                if (cost < distance[next.id]) {
                	distance[next.id] = cost;
                    pq.offer(new Position(next.id, cost));
                }
            }
        }
    }
}