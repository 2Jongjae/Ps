import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static char[] arr, answer;
	static boolean[] visit;
	static TreeSet<String> ts = new TreeSet<String>();
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new char[m];
        visit = new boolean[m];
        answer = new char[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < m ; i++) arr[i] = st.nextToken().charAt(0);
        
        Arrays.sort(arr);
        
        dfs(0);
        
        for(String a: ts)  sb.append(a + "\n");
        System.out.println(sb);
    }
    
    
    static void dfs(int dep) {
    	if( dep == n) {
    		int check = 0;
    		for(char ch : answer) {
    			if(ch == 'a' ||  ch == 'e' || ch == 'i'|| ch =='o' || ch =='u') check++;
    		}
    		if( check >0 &&  (n-check) >=2 ) {
    			char[] temp = new char[n];
    			for( int i = 0 ; i < n ; i++) temp[i] = answer[i];
    			Arrays.sort(temp);
    			String input = String.valueOf(temp);
    			ts.add(input);
    		}
    		
    		return;
    	}
    	
    	for(int i = dep ; i< m ; i++) {
    		if(!visit[i]  ) {
    			answer[dep] = arr[i];
    			visit[i] = true;
    			dfs(dep+1);
    			visit[i] = false;
    		}
    	}
    	
    	
    }
}