import java.io.*;
import java.util.*;


public class Main {
	static int[][] arr;
	static int n,max;
	static int[] order = new int[9];
	static Deque<Integer> people ;
	static boolean[] visit = new boolean[9];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		arr = new int[n][9];
		
		for( int i = 0  ; i <n ; i++) {
			st = new StringTokenizer(br.readLine());
			for ( int j = 0 ; j < 9 ; j ++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visit[0] = true;
		order[3] = 0;
		dfs(0);
		System.out.println(max);
	}
	
	static void dfs(int idx) {
		if( idx == 3) idx++;
		if( idx == 9) {
			game();
			return;
		}
		for( int i = 0 ; i < 9 ; i++) {
			if(!visit[i]) {
				visit[i] = true;
				order[idx] = i;
				dfs(idx+1);
				visit[i] =false;
			}
		}
	}
	
	static void game() {
		int idx = 0 ;
		int sum= 0;
		int limit = 0;
		people = new ArrayDeque<>();
		people.add(0);
		people.add(0);
		people.add(0);
		int outcnt = 0;
		while( !(limit ==n) ) {
			int num = order[idx%=9];
			int value = arr[limit][num];
			idx++;
			if( value == 0) outcnt++;
			if( outcnt == 3 ) {
				people.clear();
				people.add(0);
				people.add(0);
				people.add(0);
				limit ++;
				outcnt=0;
				continue;
			}
			if(value == 0 ) continue;
			for( int i = 0 ; i <value ; i++) 
				if(!people.isEmpty()) sum+=people.pollLast();
			if( value == 4) {
				sum++;
				people.add(0);
				people.add(0);
				people.add(0);
				continue;
			}
			people.addFirst(1);
			if(value >= 2) people.addFirst(0);
			if(value >= 3) people.addFirst(0);
			
		}
		max = Math.max(max, sum);
		
	}
	
}
