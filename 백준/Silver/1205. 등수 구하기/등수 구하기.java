import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n,m,k;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
	
		List<Integer> li = new ArrayList<>();
		
		if ( n == 0 ) {
			System.out.println(1);
			return;
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0 ; i < n ; i++) {
			li.add(Integer.parseInt(st.nextToken()));
		}
		
		int rank = 1;
		int check = 1;
		for (int i = 0 ; i < n ;i++) {
			if( li.get(i) > m) {
				rank++;
				check++;
			} else if ( li.get(i)==m) check++;
			else break;
		}
		if( check <=k) System.out.println(rank);
		else System.out.println(-1);
		
		
		
	}
}