import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        ArrayList<Integer>[] graph= new ArrayList[n+1];
        int[] depth = new int[n+1];
        
        for(int i = 1 ; i <= n ; i++) {
        	graph[i] = new ArrayList<>();
        }
        
        for(int i = 0 ; i < m ; i++) {
        	st = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	graph[start].add(end);
        	depth[end] ++;
        }
        
        Queue<Integer> qq = new LinkedList<>();
        
        for(int i = 1; i <= n ; i++) {
        	if( depth[i] == 0 ) qq.add(i); 
        }
        
        StringBuilder sb = new StringBuilder();
        while(!qq.isEmpty()) {
        	int now = qq.poll();
        	sb.append(now + " ");
        	
        	for(int next : graph[now]) {
        		depth[next] --;
        		if(depth[next] == 0) qq.add(next);
        	}
        	
        }
        System.out.println(sb);
        
    }
}
