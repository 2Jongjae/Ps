import java.io.*;
import java.util.*;
import java.util.function.BinaryOperator;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		

		List<Integer> li =  new ArrayList<Integer>();
		
		
		for ( int i = 0 ; i < n ; i ++) {
			int temp = Integer.parseInt(st.nextToken());
			
			if( li.size() == 0 || li.get(li.size()-1) < temp ) {
				li.add(temp);
				continue;
			}
			
			int idx = Collections.binarySearch(li, temp);
			if( idx < 0 ) idx = -idx -1;
			li.set(idx, temp);
			
			
			
		} // for 문 
		
		System.out.println(li.size());
		
		
		
		
	}
}
