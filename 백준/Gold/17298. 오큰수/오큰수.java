import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Stack<Integer> ss = new Stack<Integer>();
		
		for( int i = 0 ; i < n ; i++) {
			ss.add(Integer.parseInt(st.nextToken()));
		}

		if( n == 1 ) {
			System.out.println(-1);
			return;
		}
		
		List<Integer> arr = new ArrayList<Integer>();
		ss.add(-1);
		int max = 0 ;
		
		while(!(ss.size()== 1)) {
			int temp = ss.pop();
			max = Math.max(max, temp);
			if( temp > ss.peek()) {
				arr.add(temp);
			} else {
				if( ss.peek() >= max) arr.add(-1);
				else {
					int size= arr.size()-1;
					while(true) {
						int value = arr.get(size);
						if( value == max) {
							arr.add(max);
							break;
						}
						if( value > ss.peek()) {
							arr.add(value);
							break;
						}
						size --;
					}
					
				}
			}
		}
		Collections.reverse(arr);
		for ( int  a : arr) {
			sb.append(a + " ");
		}
		
		System.out.println(sb.toString().trim());
	}
}
