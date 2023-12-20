import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static List<Integer> li;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st =new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	li = new LinkedList();
    	visit =new boolean[10_001];
    	
    	st =new StringTokenizer(br.readLine());
    	
    	for ( int i = 0 ; i <n ; i ++)
    		li.add(Integer.parseInt(st.nextToken()));
    	
    	Collections.sort(li);
    	List<Integer> result = new LinkedList();
    	dfs(0, result);
    	System.out.println(sb);
    	
    	
    }
	private static void dfs(int idx, List<Integer> result) {
		if(result.size() == m) {
			for ( int a : result) {
				sb.append(a + " ");
			}
			sb.append("\n");
			return;
		}
		
		for( int i = idx ; i< n ; i++) {
			int temp = li.get(i);
			if( !visit[temp] ) {
				result.add(temp);
				visit[temp] = true;
				dfs(i,result);
				if(li.size() >0) result.remove(result.size()-1);
				visit[temp] = false;
			}
		}
		
	}
}
