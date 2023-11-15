import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int ans, n, cnt ;
	static int[] graph;
	static boolean[] endvisit,visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0;  tc< T ; tc++) {
			n = Integer.parseInt(br.readLine());
			ans = n;
			cnt = 0; 
			st = new StringTokenizer(br.readLine());
			graph = new int[n+1];
			endvisit = new boolean[n+1];
			visit = new boolean[n+1];
			
			for ( int i = 1; i <= n ; i++) {
				int temp = Integer.parseInt(st.nextToken());
				graph[i] = temp;
				if( temp == i) {
					endvisit[i] = true;
					ans--;
				}
			}
			//입력 값 끝
			
			// 로직 시작 
			// 로직1. dfs를 돌려서 만약에 성공적으로 끝난 원소의 경우 완성처리
			// 완성이 되는 조건 최초 dfs의 루트노드를 방문처리하지 않고 
			// 그 끝이 자기 자신이 나오게 된다면 처리
			// 최초의 루트에 대한 저장이 필요 
			
			for( int i = 1 ; i<= n ; i++) {
				dfs(i);
			}
			ans = ans - cnt; 
			sb.append(ans+ "\n");
			
 		} // 테케 끝 
		System.out.println(sb);
	}
	private static void dfs(int i) {
//		System.out.println(i + " " + Arrays.toString(visit) + " cnt의 값은 " + cnt);
		if( visit[i]) return;
		
		
		visit[i] = true; 
		int temp =  graph[i];
		if( !visit[temp]) dfs(temp);
		else {
			if( !endvisit[temp]) {
				cnt++;
				for ( int j  = temp ; j != i ; j =graph[j] ) {
					cnt++;
//					System.out.println(j);
				}
			}
		}
		endvisit[i] = true; 
		
	}
}
