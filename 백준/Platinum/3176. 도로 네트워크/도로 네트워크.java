import java.util.*;
import java.io.*;

class Position {
	int node, distance;

	Position(int node, int distance) {
		this.node = node;
		this.distance = distance;
	}
}

public class Main {
	static ArrayList<ArrayList<Position>> tree;
	static int[][] parent;
	static int[] depth,dist;
	static int[][] maxdist,mindist;
	static int n;
	static int max,min;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		tree = new ArrayList<>();
		for (int i = 0; i <= n; i++)  tree.add(new ArrayList<>());

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			addEdge(start, end, distance);
		}
		int log = (int) Math.ceil(Math.log(n) / Math.log(2));
		parent = new int[n + 1][log + 1];
		maxdist = new int[n + 1][log + 1];
		mindist = new int[n + 1][log + 1];
		depth = new int[n + 1];
		dist = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(parent[i], -1);
			Arrays.fill(maxdist[i], -1);
			Arrays.fill(mindist[i], Integer.MAX_VALUE);
			
		}
		
		dfs(1, 0, -1,-1);
		for (int j = 1; j <= log; j++) {
			for (int i = 1; i <= n; i++) {
				if (parent[i][j - 1] != -1) {
					parent[i][j] = parent[parent[i][j - 1]][j - 1];
					maxdist[i][j] = Math.max(maxdist[parent[i][j-1]][j-1], maxdist[i][j-1]);
					mindist[i][j] = Math.min(mindist[parent[i][j-1]][j-1], mindist[i][j-1]);
				}
			}
		}
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st ;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());

			int common = findlca(left, right);
			sb.append(min + " " + max + "\n");
		}
		System.out.println(sb);

	}


	static int findlca(int a, int b) {
		if (depth[a] < depth[b]) {
			int temp = b;
			b = a;
			a = temp;
		}
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		int log = (int) Math.ceil(Math.log(n) / Math.log(2));

		for (int i = log; i >= 0; i--) {
			if (depth[a] - (1 << i) >= depth[b]) {
				min = Math.min(min, mindist[a][i]);
				max = Math.max(max, maxdist[a][i]);
				a = parent[a][i];
			}
		}
		if (a == b) return a;
		for (int i = log; i >= 0; i--) {
			if (parent[a][i] != -1 && parent[a][i] != parent[b][i]) {
				min = Math.min(min, Math.min(mindist[a][i], mindist[b][i]));
				max = Math.max(max, Math.max(maxdist[a][i], maxdist[b][i]));
				a = parent[a][i];
				b = parent[b][i];
			}
		}
		
		min = Math.min(min, Math.min(mindist[a][0], mindist[b][0]));
		max = Math.max(max, Math.max(maxdist[a][0], maxdist[b][0]));
		return parent[a][0];

	}

	public static void dfs(int node, int dep, int par,int len) {
		parent[node][0] = par;
		depth[node] = dep;
		if(len>=0) {
		maxdist[node][0] = len;
		mindist[node][0] = len;
		}
		for (Position a : tree.get(node)) {
			if (a.node != par) dfs(a.node, dep + 1, node,a.distance);
		}

	}

	public static void addEdge(int start, int end, int distance) {
		Position ps1 = new Position(start, distance);
		Position ps2 = new Position(end, distance);
		tree.get(start).add(ps2);
		tree.get(end).add(ps1);
	}

}
