import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		TreeSet<String> ts1 = new TreeSet<>();
		List<String> li = new ArrayList<>();
		
		int n = Integer.parseInt(st.nextToken());
		String type = st.nextToken();
		int cnt = 0;
		if(type.equals("Y")) cnt = 1;
		if(type.equals("F")) cnt = 2;
		if(type.equals("O")) cnt = 3;
		int ans = 0;
		for(int i = 0 ; i < n ; i++) {
			String input = br.readLine();
			int size = ts1.size();
			ts1.add(input);
			if( size != ts1.size()) {
				li.add(input);
				if( li.size() == cnt ) {
					ans++;
					li.clear();
				}
			}
		}
		System.out.println(ans);
	}
	
}