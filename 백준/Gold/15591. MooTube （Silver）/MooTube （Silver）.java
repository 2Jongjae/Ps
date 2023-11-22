import java.io.*;
import java.util.*;

class position {
	int x, y;
	public position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<position>[] graph = new LinkedList[n + 1];

		for (int i = 1; i <= n; i++) {
			graph[i] = new LinkedList<position>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a, b, c;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			graph[a].add(new position(b, c));
			graph[b].add(new position(a, c));
		}
		
		for ( int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int k,a;
			k = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			
			int cnt = 0 ; 
			boolean[] visit = new boolean[n+1];
			
			Queue<Integer> qq = new LinkedList<Integer>();
			visit[a] = true; 
			for(position p : graph[a]) {
				int idx = p.x;
				int value = p.y;
				if( value >= k ) {
					qq.add(idx);
					visit[idx] = true; 
					cnt++; 
				}
			}
			while(!qq.isEmpty()) {
				int  temp = qq.poll();
				for(position p : graph[temp]) {
					int idx = p.x;
					int value = p.y;
					if( value >= k && !visit[idx]) {
						qq.add(idx);
						visit[idx] = true; 
						cnt++; 
					}
				}
			}
				System.out.println(cnt);
		}
		
	}
}