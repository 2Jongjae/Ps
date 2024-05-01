import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int Tc = 1;
		while(true) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if( n== 0 && m ==0 ) break;
			ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
			
			for( int i = 0 ; i<= n ; i++) graph.add(new ArrayList<>());
			
			for (int i = 0 ; i < m ; i ++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				graph.get(start).add(end);
				graph.get(end).add(start);
			}
			boolean[] visit = new boolean[n+1];
			int[] parent = new int[n+1];
			Queue<Integer> qq = new ArrayDeque<>();
			
			int ans = 0 ;
			
			for( int i = 1 ; i <= n ; i++) {
				if(!visit[i]) {
					boolean flag = false;
					ans++;
					qq.add(i);
					visit[i] = true;
					while(!qq.isEmpty()) {
						int temp =qq.poll();
						for ( int adj : graph.get(temp)) {
							if( !visit[adj]) {
								parent[adj] = temp;
								qq.add(adj);
								visit[adj] = true;
							} else if(parent[temp] != adj) {
								flag =true;
							}
						}
					}
					if(flag) ans--;
				}
			}
			sb.append("Case " + Tc);
			if( ans == 1 ) sb.append(": There is one tree."+"\n");
			if( ans > 1 ) sb.append(": A forest of "+ans+" trees."+"\n");
			if( ans == 0 ) sb.append(": No trees."+"\n");
			Tc++;
		}
		System.out.println(sb);
	}
}