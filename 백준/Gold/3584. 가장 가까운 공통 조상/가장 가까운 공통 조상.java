import java.io.*;
import java.util.*;


public class Main {
	
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int T = Integer.parseInt(st.nextToken());
		l: for(int tc = 0 ; tc<T ;tc++) {
			int n = Integer.parseInt(br.readLine());
			List<Integer>[] graph = new LinkedList[n+1];
			
			for(int i = 1 ; i<= n ; i++) {
				graph[i] = new LinkedList();
			}
			
			for (int i = 1 ; i < n  ; i++) {
				st = new StringTokenizer(br.readLine());
				int first = Integer.parseInt(st.nextToken());
				int last = Integer.parseInt(st.nextToken());
				graph[last].add(first);
			}
			st = new StringTokenizer(br.readLine());
			
			int target1 = Integer.parseInt(st.nextToken());
			int target2 = Integer.parseInt(st.nextToken());
			
			if(graph[target1].size() == 0 ) {
				System.out.println(target1);
				continue l;
			}
			if(graph[target2].size() == 0) {
				System.out.println(target2);
				continue l;
			}
			
			
			boolean[] visit = new boolean[n+1];
			Stack<Integer> ss = new Stack<Integer>();
			
			ss.add(target1);
			
			while(!ss.isEmpty()) {
				int temp = ss.pop();
				if(visit[temp]) {
					System.out.println(temp);
					continue l;
				}
				visit[temp] = true;
				if(graph[temp].size()  != 0 ) ss.add(graph[temp].get(0));
				
			}
			
			ss.add(target2);
			while(!ss.isEmpty()) {
				int temp = ss.pop();
				if(visit[temp]) {
					System.out.println(temp);
					continue l;
				}
				visit[temp] = true;
				if(graph[temp].size()  != 0 ) ss.add(graph[temp].get(0));
				
			}
			
			
			
			
		}//tc
		
	
	
	
	}
}
