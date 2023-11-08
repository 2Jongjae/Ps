import java.io.*;
import java.util.*;

public class Main {
	static List<Integer> li;
	static StringBuilder sb;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if (n == 0 ) break;
			visit = new boolean[n];
			li = new LinkedList<>();
			for ( int i = 0 ; i < n ; i ++) {
				li.add(Integer.parseInt(st.nextToken()));
			}
			List<Integer> sub = new LinkedList<>();
			dfs(sub,0);
			sb.append("\n");
			
		}
		System.out.println(sb);
	}
	
	
	private static void dfs(List<Integer> sub, int idx) {
		if( sub.size() == 6) {
			
			for ( int a : sub ) {
				sb.append(a + " ");
			}
			sb.append("\n");
		}
		
			for ( int k = idx ; k < li.size() ; k++) {
				if( !visit[k] ) {
					sub.add(li.get(k));
					visit[k]= true;
					dfs(sub, k+1);
					visit[k] = false;
					sub.remove(sub.size()-1);
				}
			}
		
		
		
	}
}
