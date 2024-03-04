import java.util.*;
import java.io.*;

public class Main {
    static int[][] parent; 
    static int[] depth; 
    static ArrayList<ArrayList<Integer>> tree; 

    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        
        
        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        
        for( int i = 0 ; i < n-1 ; i ++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	addEdge(start,end);
        }

        preprocess(n);
        
        n = Integer.parseInt(br.readLine());
        for ( int i = 0 ; i < n ; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	sb.append(findLCA(start,end)+"\n");
        }
        System.out.println(sb);
        
    }

    static void addEdge(int u, int v) {
        tree.get(u).add(v);
        tree.get(v).add(u);
    }
    static void preprocess(int n) {
        int log = (int) Math.ceil(Math.log(n) / Math.log(2));
        parent = new int[n + 1][log + 1];
        depth = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            Arrays.fill(parent[i], -1);
        }
        
        dfs(1, 1, 0);

        for (int j = 1; j <= log; j++) {
            for (int i = 1; i <= n; i++) {
                if (parent[i][j - 1] != -1) {
                    parent[i][j] = parent[parent[i][j - 1]][j - 1];
                }
            }
        }
    }

    static void dfs(int node, int par, int dep) {
        parent[node][0] = par;
        depth[node] = dep;
        for (int adj : tree.get(node)) {
            if (adj != par) {
                dfs(adj, node, dep + 1);
            }
        }
    }

    // LCA 찾기
    static int findLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        
        int log = (int) Math.ceil(Math.log(depth[u]) / Math.log(2));
        for (int i = log; i >= 0; i--) {
            if (depth[u] - (1 << i) >= depth[v]) {
                u = parent[u][i];
            }
        }
        
        if (u == v) return u;
        
        for (int i = log; i >= 0; i--) {
            if (parent[u][i] != -1 && parent[u][i] != parent[v][i]) {
                u = parent[u][i];
                v = parent[v][i];
            }
        }
        return parent[u][0];
    }
}
