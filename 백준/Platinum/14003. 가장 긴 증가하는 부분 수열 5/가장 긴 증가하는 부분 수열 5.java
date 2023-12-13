import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		List<Integer> li =  new ArrayList<Integer>();
		int[] index = new int[n];
		int[] value = new int[n];
		
		for ( int i = 0 ; i < n ; i ++) {
			int temp = Integer.parseInt(st.nextToken());
			value[i] = temp;
			if( li.size() == 0 || li.get(li.size()-1) < temp ) {
				li.add(temp);
				index[i] = li.size()-1;
				continue;
			}
			int idx = Collections.binarySearch(li, temp);
			if( idx < 0 ) idx = -idx -1;
			index[i] = idx;
			if ( idx == 0 && temp == li.get(0) ) continue;
			li.set(idx, temp);
		}
		
		sb.append(li.size() + "\n");
		List<Integer> result = new LinkedList<Integer>();
		
		int size = li.size()-1;
		for ( int i = n-1;  i>=0 ; i--) {
			if( index[i] == size) {
				result.add(value[i]);
				size--;
			}
		}
		Collections.reverse(result);
		
		for ( int a : result) sb.append(a + " ");
		System.out.println(sb.toString().trim());
		
	}
}
