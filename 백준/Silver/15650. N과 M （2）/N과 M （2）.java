import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder sb;
	static int n,m;
	static List<Integer> arr;
	static boolean[] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visit = new boolean[n+1];
		arr = new LinkedList<>();
		List<Integer> subset = new LinkedList<>();
		for ( int i = 1; i <=n ; i++ ) {
			arr.add(i);
		}
		comb(arr,subset, 0);
		System.out.println(sb);
		
	}

	private static void comb(List<Integer> arr2, List<Integer> subset, int index) {
		if( subset.size() == m) {
			for( int  a : subset) {
				sb.append(a + " ");
			}
			sb.append("\n");
			return;
		}
	
			for ( int i = index ; i <arr2.size() ; i ++) {
				if( !visit[i+1] ) {
					subset.add(arr2.get(i));
					visit[i+1] = true; 
					comb(arr2, subset, i+1);
					visit[i+1] = false;
					subset.remove(subset.size()-1);
				} else continue;
		
	}


	}
	
}