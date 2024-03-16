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

class Main {
    static ArrayList<ArrayList<Position>> graph = new ArrayList<>();
    static final int INF = 100000000;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<Position>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Position(end, dist));
            graph.get(end).add(new Position(start, dist)); // 양방향 그래프
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int c1 = dijkstra(1, start) + dijkstra(start, end) + dijkstra(end, n);
        int c2 = dijkstra(1, end) + dijkstra(end, start) + dijkstra(start, n);
        int min = Math.min(c1, c2);
        if (min >= INF) min = -1;
        System.out.println(min);
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Position> pq = new PriorityQueue<>();
        int[] distance = new int[graph.size()];
        Arrays.fill(distance, INF);

        distance[start] = 0;
        pq.add(new Position(start, 0));

        while (!pq.isEmpty()) {
            Position current = pq.poll();
            int node = current.node;
            int dist = current.dist;

            if (distance[node] < dist) continue;

            for (Position next : graph.get(node)) {
                int cost = dist + next.dist;
                if (distance[next.node] > cost) {
                    distance[next.node] = cost;
                    pq.add(new Position(next.node, cost));
                }
            }
        }

        return distance[end];
    }
}
