import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<ArrayList<Integer>> graph ;
	static int n,m,log;
	static int[] depth;
	static int[][] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		graph = new ArrayList<>();
		n = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i<= n ; i++) graph.add(new ArrayList<>());
		
		for( int i = 1 ; i< n ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		log =(int) Math.ceil(Math.log(n)/Math.log(2));
		
		parent = new int[n+1][log+1];
		depth = new int[n+1];
		depth[1] = 1;
		dfs(1,1,0);

		for( int j = 1  ; j <=log ; j++) {
			for ( int i = 1 ; i <=n ; i++) {
				if(parent[i][j-1] != 0 ) parent[i][j] = parent[parent[i][j-1]][j-1];
			}
		}
		
		m = Integer.parseInt(br.readLine());
		int sum =0;
		int left = 1;
		for(int i = 0 ; i < m ; i++) {
			int right = Integer.parseInt(br.readLine());
//			st = new StringTokenizer(br.readLine());
//			left = Integer.parseInt(st.nextToken());
//			int right = Integer.parseInt(st.nextToken());
			int anc = LCA(left,right);
			int value = depth[anc];
			int leftvalue = depth[left] -value;
			int rightvalue = depth[right] -value;
			left = right;
			sum += (leftvalue+rightvalue);
//			System.out.println(anc);
		}
		
		System.out.println(sum);
		
	}
	
	static int LCA(int a, int b) {
		
		if( depth[a] < depth[b]) {
			int temp = b;
			b = a;
			a = temp;
		}
		for(int i = log ; i >=0 ; i--) {
			if(depth[a]- depth[b] >= (1  << i)) {
				a = parent[a][i];
			}
		}
		
		if( a== b ) return a;
		
		for( int i =  log ; i >=0 ; i--){
			if( parent[a][i] >0 && parent[a][i] != parent[b][i]) {
				a = parent[a][i];
				b = parent[b][i];
			}
			
		}
		
		
		
		
		return parent[a][0];
	}
	
	static void dfs(int node, int dep, int par) {
		
		for( int cur : graph.get(node)) {
			if(par != cur ) {
				depth[cur] = dep +1;
				parent[cur][0] = node;
				dfs(cur,dep+1 , node);
			}
			
		}
		
	}
	
}