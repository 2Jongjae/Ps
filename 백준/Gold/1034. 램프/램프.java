import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main {
	static int n,m,k;
	static String[] arr;
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	arr = new String[n];
    	
    	for(int i = 0 ; i < n ; i ++)  arr[i] = br.readLine();
    	
    	k = Integer.parseInt(br.readLine());
    	
    	Map<String, Integer> map = new HashMap<>();
    	
    	for( String a: arr )map.put(a, map.getOrDefault(a,0) +1);
    	
    	int ans = 0;
    	
    	for( Entry<String, Integer> a : map.entrySet()) {
    		String row = a.getKey();
    		int cnt = 0;
    		for( char ch : row.toCharArray()) if( ch == '0') cnt++;
    		if( cnt  <= k && cnt%2 == k%2) ans = Math.max(ans, a.getValue());
    	}
    	
    	System.out.println(ans);
    	
	}
}
