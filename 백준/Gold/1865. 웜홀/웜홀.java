import java.util.*;
import java.io.*;

class Position implements Comparable<Position>{
	int node, cost;
	Position( int node, int cost){
		this.node = node;
		this.cost = cost;
	}
	public int compareTo(Position o) {
		return this.cost - o.cost;
	}
}

public class Main {
	static ArrayList<Position>[] graph;
	static final int INF = 987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		l: for(int tc = 0 ;  tc < T  ; tc++) {
			graph = new ArrayList[501];
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			for(int i = 0 ; i <=500 ; i ++) {
				graph[i] = new ArrayList<>();
			}
			
			for(int i = 0 ; i < m ; i ++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				graph[start].add(new Position(end,cost));
				graph[end].add(new Position(start,cost));
			}
			
			for(int i = 0 ; i < w ; i ++) {
				st =new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				graph[start].add(new Position(end,-cost));
			}
			
			for(int i = 1 ; i <=500 ; i ++) {
				if( bellman(i)) {
					System.out.println("YES");
					continue l;
				}
			}

			
			
			System.out.println("NO");
			
		}
		
		
	}
	public static boolean bellman(int idx) {
		int[] map = new int[501];
		Arrays.fill(map, INF);
		map[idx] = 0;
		boolean flag = false;
		
		for(int i = 1 ; i< 500 ; i ++) {
			flag = false;
			
			for(int j = 0 ; j <= 500 ; j++) {
				for(Position a : graph[j]) {
					if( map[j] != INF && map[j] + a.cost < map[a.node]) {
						map[a.node] = map[j]+ a.cost;
						flag = true;
					}
				}
			}
			
			if(!flag) break;
		}
		if(flag) {
			for(int i =1 ; i <= 500 ; i++) {
				for( Position a : graph[i]) {
					if( map[i] != INF & map[i] + a.cost < map[a.node]) {
						return true;
					}
				}
			}
		}
		return false; 
		
	}
	
	
}
