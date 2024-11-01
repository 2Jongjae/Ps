import java.util.*;
import java.io.*;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] graph = new int[n+1][n+1];
		
		for(int i = 1 ; i < n +1 ; i++) {
			Arrays.fill(graph[i],INF);
			graph[i][i] = 0;
		}
		
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a][b] = Math.min(c,graph[a][b]);
		}
		
		
		for(int k = 1 ; k <= n ; k++) {
			for(int i = 1 ; i <=n ;i++) {
				for(int j = 1 ; j <= n ; j++) {
					if(graph[i][k] != INF && graph[k][j] != INF && graph[i][k] + graph[k][j] < graph[i][j]) {
						graph[i][j] = graph[i][k] + graph[k][j];
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <= n ; j++) {
				if(graph[i][j] == INF) sb.append(0+ " ");
				else sb.append(graph[i][j]+ " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}