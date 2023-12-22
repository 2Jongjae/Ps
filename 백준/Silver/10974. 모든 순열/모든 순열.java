import java.io.*;
import java.util.*;

public class Main {
	static List<Integer> li = new LinkedList();
	static List<Integer> subset = new LinkedList();
	static boolean[] visit; 
	static StringBuilder sb = new StringBuilder();
	static int n;
    public static void main(String[] args) throws Exception {
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	visit = new boolean[n+1];
    	for (int i = 1 ; i<=n ; i++) li.add(i);
		
		dfs(0);
    	System.out.println(sb);
    	
	}
	private static void dfs(int idx) {
		if( subset.size() == n) {
			for (int a : subset) {
				sb.append(a + " ");
			}
			sb.append("\n");
			return;
		}
		
		
		for ( int i = idx ; i <n ; i++) {
			if( !visit[i+1]) {
				subset.add(li.get(i));
				visit[i+1] = true;
				dfs(0);
				visit[i+1] = false;
				subset.remove(subset.size()-1);
				
			}
		}
		
		
	}
}
