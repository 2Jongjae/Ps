import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static List<Integer>[] main;
    static int[] depth;
    static int[][] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        graph = new LinkedList[n + 1];
        main = new LinkedList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
            main[i] = new LinkedList();
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
            graph[first].add(last);
            graph[last].add(first);
        }

        depth = new int[n + 1];
        parent = new int[n + 1][20];

        dfs(1, 0);

        int tc = Integer.parseInt(br.readLine());

        for (int T = 0; T < tc; T++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int lca = findLCA(a, b);
          sb.append(lca +"\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int current, int par) {
        depth[current] = depth[par] + 1;
        parent[current][0] = par;

        for (int i = 1; i < 20; i++) {
            parent[current][i] = parent[parent[current][i - 1]][i - 1];
        }

        for (int next : graph[current]) {
            if (next != par) {
                dfs(next, current);
            }
        }
    }

    private static int findLCA(int a, int b) {
        if (depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int i = 19; i >= 0; i--) {
            if (depth[b] - depth[a] >= (1 << i)) {
                b = parent[b][i];
            }
        }

        if (a == b) {
            return a;
        }

        for (int i = 19; i >= 0; i--) {
            if (parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }

        return parent[a][0];
    }
}
