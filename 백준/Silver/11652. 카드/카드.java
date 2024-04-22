import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		TreeMap<Long,Integer> tm = new TreeMap<>();
		
		int n = Integer.parseInt(st.nextToken());
		
		for( int i = 0 ; i < n ; i++) {
			long input = Long.parseLong(br.readLine());
			
			if(tm.containsKey(input)) {
				int value = tm.get(input);
				tm.put(input, value+1);
			} else {
				tm.put(input, 1);
			}
		}
		long ans = 0;
		int cnt = 0;
		for( long a : tm.keySet()) {
			if( tm.get(a) > cnt) {
				ans = a;
				cnt = tm.get(a);
			}
		}
		
		System.out.println(ans);
	}
}
