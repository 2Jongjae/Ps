import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		TreeMap<Integer, Integer> tm = new TreeMap<>();
		
		st = new StringTokenizer(br.readLine());
		for ( int i = 0 ; i < n ; i ++) {
			int value = Integer.parseInt(st.nextToken());
			tm.put(value, 0);
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0 ; i < m ; i ++) {
			int value = Integer.parseInt(st.nextToken());
			if(tm.get(value) == null) continue;
			tm.remove(value);
		}

		System.out.println(tm.size());
		for (Integer a : tm.keySet()) {
			System.out.print(a + " ");
		}
	}
}
