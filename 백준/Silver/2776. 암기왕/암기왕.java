import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 0 ; tc < T ; tc++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			TreeMap<Integer,Integer> tm = new TreeMap<>();
			for( int i = 0 ; i < n ; i++) tm.put(Integer.parseInt(st.nextToken()), 0);
			
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for( int i = 0 ; i < n ; i++)
				if(tm.containsKey(Integer.parseInt(st.nextToken()))) sb.append(1 +"\n");
				else sb.append(0 + "\n");
		}// tc
		System.out.println(sb);
	}
}
