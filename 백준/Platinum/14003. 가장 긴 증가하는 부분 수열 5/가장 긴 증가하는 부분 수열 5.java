import java.io.*;
import java.util.*;
class position{
	int idx, val;
	
	public position(int idx, int val) {
		super();
		this.idx = idx;
		this.val = val;
	}
	
}

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		

		List<Integer> li =  new ArrayList<Integer>();
		int[] tt = new int[n];
		int[] value = new int[n];
		
		int start = -1 ;
		int last = -1 ;
		
		for ( int i = 0 ; i < n ; i ++) {
			int temp = Integer.parseInt(st.nextToken());
			value[i] = temp;
			if( li.size() == 0 || li.get(li.size()-1) < temp ) {
				li.add(temp);
				last = i ; 
				
				if( li.size() ==  1 ) {
					tt[i] = 0;
					start = i;
				}
				else tt[i] = li.size()-1;
				continue;
			}
			
			int idx = Collections.binarySearch(li, temp);
			if( idx < 0 ) idx = -idx -1;
			tt[i] = idx;
			
			if ( idx == 0 && temp == li.get(0) ) continue;
			if  (idx == 0 ) start  = i ;
			li.set(idx, temp);
			
			
		} // for 문 
		
		sb.append(li.size() + "\n");

//		for ( int a : li) {
//			sb.append(a + " ");
//		}
		
		
		List<Integer> result = new LinkedList<Integer>();
		
		int size = li.size()-1;
		for ( int i = n-1;  i>=0 ; i--) {
			if( tt[i] == size) {
				result.add(value[i]);
				size--;
			}
		}
		Collections.reverse(result);
		
		for ( int a : result) sb.append(a + " ");
//		System.out.println(result);
		
		
		
//		System.out.println( start);
//		System.out.println( last);
//		System.out.println(Arrays.toString(tt));
		System.out.println(sb.toString().trim());
		
	}
}
