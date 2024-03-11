import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
	int f = Integer.parseInt(st.nextToken()); // 가장 높은 층
	int s = Integer.parseInt(st.nextToken()); // 현재 위치한 곳
	int g = Integer.parseInt(st.nextToken()); // 강호가 위치한 곳 
	int u = Integer.parseInt(st.nextToken()); // 위로 u층 이동
	int d = Integer.parseInt(st.nextToken()); // 아래로 d 층 이동 

	int[] arr = new int[f+1];
	Arrays.fill(arr, -1);
	boolean[] visit = new boolean[f+1];
	
	Queue<Integer> qq = new LinkedList<Integer>();
	arr[s] = 0;
	qq.add(s);
	visit[s]= true;
	
	
	while(!qq.isEmpty()) {
		int temp = qq.poll();
//		System.out.println(temp);
		
		int up = temp + u ;
		int down = temp - d;
		 
		if( up <= f && !visit[up]) {
			if ( up == 0 ) continue;
			qq.add(up);
			visit[up] = true; 
			arr[up] = arr[temp] +1; 
		}
		if( down >= 1 && !visit[down]) {
			if(d == 0 ) continue;
			qq.add(down);
			visit[down] = true;
			arr[down] = arr[temp] +1; 
		}
	}
	
//	System.out.println(Arrays.toString(arr));
	if( arr[g] == -1 )System.out.println("use the stairs");
	else System.out.println(arr[g]);
	
	
	}
}