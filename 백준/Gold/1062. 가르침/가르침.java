import java.util.*;
import java.io.*;

public class Main {
	static boolean[] visit = new boolean[26];
	static int n,m, ans;
	static String[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new String[n];
		
		for(int i = 0 ; i < n ; i++) {
			arr[i] = br.readLine();
		}
		//a n t i c
		
		visit[0] = true;
		visit[2] = true;
		visit[8] = true;
		visit[13] = true;
		visit[19] = true;
		
		
		dfs(0,5);
		
		System.out.println(ans);
		
	}
	
	
	static void dfs(int idx, int cnt) {
		if(cnt == m) {
			int a = 0;
			l: for( String s : arr) {
				for(int i = 0 ;  i < s.length(); i ++) {
					char c = s.charAt(i);
					if( !visit[c-'a']) continue l;
				}
				a++;
			}
			ans = Math.max(ans, a);
			return;
		}
		
		
		for(int i = idx ; i < 26 ; i ++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(i+1,cnt+1);
				visit[i] = false;
			}
		}
		
	}
}