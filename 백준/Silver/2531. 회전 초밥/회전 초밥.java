import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {
	static int n,d,k,c;
	static int[]arr;
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	d = Integer.parseInt(st.nextToken());
    	k = Integer.parseInt(st.nextToken());
    	c = Integer.parseInt(st.nextToken());
    	arr = new int[n+k-1];
    	
    	for (int i = 0 ; i < n ; i ++) {
    		arr[i] = Integer.parseInt(br.readLine());
    	}
    	
    	for(int i = n ; i < n +k-1 ; i ++) {
    		int value = arr[i-n];
    		arr[i] = value;
    	}
    	int max = 0;
    	
    	TreeSet<Integer> ts = new TreeSet<>();
    	int[] cnt = new int[d+1];
    	for(int j = 0 ; j < k ; j++) {
    		ts.add(arr[j]);
    		cnt[arr[j]] ++;
    		if(ts.contains(c)) max = Math.max(ts.size(), max);
    		else max = Math.max(ts.size()+1, max);
    	}
//    	System.out.println(Arrays.toString(cnt));
    	for(int i = k ; i < n+k-1; i ++) {
    		
    		cnt[arr[i-k]] --;
    		if( cnt[arr[i-k]] == 0 )ts.remove(arr[i-k]);
    		ts.add(arr[i]);
    		cnt[arr[i]]++;
//    		System.out.println( arr[i]+"  " + ts);
    		if(ts.contains(c)) max = Math.max(ts.size(), max);
    		else max = Math.max(ts.size()+1, max);
    	}
    	System.out.println(max);
    	
    	
    	
	}

	
}
