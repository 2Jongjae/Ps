import java.io.*;
import java.util.*;

public class Main {
	static int n,max,z;
	static int[][] arr;
	static int[] check;
	static boolean[] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n  = Integer.parseInt(br.readLine());
		
		arr = new int[n][2];
		visit = new boolean[n];
		check = new int[n];
		for( int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		dfs(0);
		System.out.println(max);
	}
	
	static void dfs(int dep) {
		z++;
		if( dep == n ) {
			int[] eggs = new int[n];
			int[][] arr2 = new int[n][2];
			for(int i = 0 ; i < n ; i ++) {
				int a = arr[i][0];
				int b = arr[i][1];
				arr2[i][0] = a;
				arr2[i][1] = b;
			}
			
			for( int i = 0 ; i < n ; i++) {
				if(eggs[i] == -1 ) continue;
				int target = check[i];
				int Aval = arr2[i][0];
				int Awei = arr2[i][1];
				
				if( eggs[target] == -1) continue;
				int Bval = arr2[target][0];
				int Bwei = arr2[target][1];
				
				arr2[i][0] -= Bwei;
				arr2[target][0] -= Awei;
				if( arr2[i][0]  <= 0 )  eggs[i] = -1;
				if( arr2[target][0]  <= 0 )  eggs[target] = -1;
			}
			int ans = 0;
			for( int i = 0 ; i < n ; i++) ans+= eggs[i];
			max = Math.max(Math.abs(ans),max);
			
			return;
		}
		
		for( int i = 0 ; i < n ; i ++) {
			if(dep!= i) {
				check[dep] = i;
				dfs(dep+1);
			}
		}
		
		
	}
}