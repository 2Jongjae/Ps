import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = 1;
		 visit = new boolean[10_001];
		while(n < 10_000) {
			if(!visit[n]) {
				sb.append(n +"\n");
				dfs(n);
			}
			n++;
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int n) {
		if( n>= 10_000) return;
		visit[n] = true;
		String a = String.valueOf(n);
		
		int temp = n ;
		for( int i = 0 ; i < a.length(); i ++) {
			temp += a.charAt(i) -'0';
		}
		dfs(temp);
	}
	
	
}