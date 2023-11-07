import java.io.*;
import java.util.*;

public class Main {
	static int  n, min;
	static int[] people;
	static boolean[] visit;
	static List<Integer>[] li;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//구역의 개수
		n = Integer.parseInt(st.nextToken());
		
		li = new LinkedList[n+1];
		for ( int i = 1 ; i <= n  ; i++)  
			li[i] = new LinkedList<Integer>();
		// 각 구역의 인구수 
		people =new int[n+1]; 
		visit =new boolean[n+1]; 
		st = new StringTokenizer(br.readLine());
		
		for ( int i = 1 ; i <= n ; i ++)  
			people[i] = Integer.parseInt(st.nextToken());
		
		for ( int i  = 1 ; i<=n  ; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			for ( int j = 0 ; j < m ; j ++) {
				li[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		List<Integer> temp = new LinkedList<Integer>();
		// 값 입력 끝 
		min = 123123;
		dfs(1,temp);
		if( min == 123123) System.out.println(-1);
		else System.out.println(min);
	}

	private static void dfs(int idx, List<Integer> temp) {
		if( temp.size() >0 && temp.size() < n ) {
			boolean[] check = new boolean[n+1];
			boolean[] check2 = new boolean[n+1];
			List<Integer> arr =new LinkedList<Integer>();
			for ( int i = 1 ;i<= n ; i++){
				if( !temp.contains(i)) arr.add(i);
			}
			
			Queue<Integer> qq =new LinkedList<Integer>();
			qq.add(temp.get(0));
			check[temp.get(0)] = true;
			while(!qq.isEmpty()) {
				int t = qq.poll();
				l:for ( int a : li[t]) {
					for ( int i= 1 ; i < temp.size() ; i ++) {
						if (a ==temp.get(i) && !check[a]) {
							check[a] = true; 
							qq.add(a);
							continue l;
						}
					}
				}
			}
			qq =new LinkedList<Integer>();
			qq.add(arr.get(0));
			check2[arr.get(0)] = true; 
			while(!qq.isEmpty()) {
				int t = qq.poll();
				l:for ( int a : li[t]) {
					for ( int i= 1 ; i < arr.size() ; i ++) {
						if (a ==arr.get(i) && !check2[a]) {
							check2[a] = true; 
							qq.add(a);
							continue l;
						}
					}
				}
			}
			boolean[] result = new boolean[n+1];
			boolean flag = true; 
			for ( int i = 1 ; i <= n ; i++) {
				result[i] = check[i] ^ check2[i];
				if( !result[i]) {
					flag = false;
					break; 
				}
			}
			if( flag ) {
				int a = 0 ;
				int b = 0 ;
				
				for ( int x : temp )  a += people[x]; 
				for ( int x : arr) b += people[x];
				min = Math.min(min, Math.abs(a-b));
			}
			
		}
		
			for ( int i = idx ; i <=n  ; i ++) {
					if( !visit[i]  ) {
						temp.add(i);
						visit[i] = true;
						dfs(i ,temp);
						visit[i] = false;
						temp.remove(temp.size()-1);
					}
			}
		
		
	}

	
	
	
}
        