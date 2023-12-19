import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st =new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(br.readLine());
    	
    	List<Integer>[] li = new LinkedList[n+1];
    	
    	for ( int i =  1; i <= n ; i++) {
    		li[i] = new LinkedList<>();
    	}
    	
    	for( int i = 1 ; i<=n ; i ++) {
    		st = new StringTokenizer(br.readLine());
    		for ( int j = 1 ; j<=n ; j++) {
    			int temp = Integer.parseInt(st.nextToken());
    			if( temp == 1 ) {
    				li[i].add(j);
    				li[j].add(i);
    			}
    		}
    	}
    	
    	List<Integer> arr = new LinkedList<>();
    	st =new StringTokenizer(br.readLine());
    	for( int i = 0 ; i < m; i++) {
    		arr.add(Integer.parseInt(st.nextToken()));
    	}
    	
    	boolean[] visit = new boolean[n+1];
    	
    	Queue<Integer> qq = new LinkedList();
    	
    	qq.add(arr.get(0));
    	visit[arr.get(0)] = true;
    	while(!qq.isEmpty()) {
    		int temp = qq.poll();
    		 
    		for( int i = 0 ; i < li[temp].size(); i++) {
    			int value = li[temp].get(i);
    			if( !visit[value]) {
    				qq.add(value);
    				visit[value] = true;
    			}
    		}
    	}
    	
    	for (int a : arr) {
    		if( !visit[a]) {
    			System.out.println("NO");
    			return;
    		}
    	}
    	System.out.println("YES");
    	
    	
    	
    	
    	
    }
}
