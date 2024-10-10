import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        
        for(int i = 0 ; i < n ; i ++) {
        	st = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken());
        	int end= Integer.parseInt(st.nextToken());
        	
        	tm.put(start,tm.getOrDefault(start, 0) +1);
        	tm.put(end, tm.getOrDefault(end, 0)-1);
        }
        
        int max = 0 ;
        int now = 0;
        int ansStart = -1;
        int ansEnd = -1;
        
        for(Entry<Integer, Integer> a : tm.entrySet()) {
        	int time = a.getKey();
        	int value = a.getValue();
        	
        	now += value;
        	if(now > max) {
        		max = now ;
        		ansStart = time;
        		ansEnd = -1;
        	} else if( max > now && ansEnd == -1) {
        		ansEnd = time;
        	}
        	
        }

        System.out.println(max);
        System.out.println(ansStart + " " + ansEnd);
    }
}