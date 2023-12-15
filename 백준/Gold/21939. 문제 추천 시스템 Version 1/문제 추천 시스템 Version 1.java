import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int value = Integer.parseInt(st.nextToken());
			int key = Integer.parseInt(st.nextToken());
			addmap(map, key, value);

		}
		
		n = Integer.parseInt(br.readLine());
		
		for ( int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			
			if( input.equals("add")) {
				int value = Integer.parseInt(st.nextToken());
				int key = Integer.parseInt(st.nextToken());
				addmap(map, key, value);
			}
			
			if( input.equals("solved")) {
				int num = Integer.parseInt(st.nextToken());
				
				removemap(map,num);
			}
			if( input.equals("recommend")) {
				int number = Integer.parseInt(st.nextToken());
				
				if ( number == 1 )  hard(map);
				if ( number == -1 ) easy(map);
			}
			
			
		}
		System.out.println(sb);
		
		
	}

	private static void easy(TreeMap<Integer, TreeSet<Integer>> map) {
		int ans = map.firstKey();
		sb.append(map.get(ans).first() + " \n");
		
	}

	private static void hard(TreeMap<Integer, TreeSet<Integer>> map) {
		int ans = map.lastKey();
		sb.append(map.get(ans).last()+ "\n");
	}

	
	private static void removemap(TreeMap<Integer, TreeSet<Integer>> map, int num) {
		for( TreeSet<Integer> set : map.values()) {
			set.remove(num);
			}
		map.entrySet().removeIf(entry -> entry.getValue().isEmpty() );
		
	}

	private static void addmap(TreeMap<Integer, TreeSet<Integer>> map, int key, int value) {
		if( !map.containsKey(key)) {
			map.put(key, new TreeSet<>());
		}
		map.get(key).add(value);
	}

}
