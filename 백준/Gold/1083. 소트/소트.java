import java.io.*;
import java.util.*;

public class Main {
	static int n, k ;
	static List<Integer> arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new ArrayList<>();
		
		for(int i = 0 ; i < n ; i++) {
			arr.add( Integer.parseInt(st.nextToken()));
		}
		Long ans = (long)Math.pow(n, 2);
		k = Integer.parseInt(br.readLine());
		if(k == 0 ) {
			for(int i = 0 ; i < n ; i ++) {
				System.out.print(arr.get(i) + " ");
			}
			return;
		}
		
		if( ans <= k) {
			Collections.sort(arr);
			for(int i = n-1 ; i>=0 ; i--) {
				System.out.print(arr.get(i) + " ");
			}
			return;
		}
		
		
		l: while( true) {
			for(int i = 0 ; i < n-1 ; i++) {
				int idx = 0;
				int value = 0;
				for(int j = i +1 ; j < n ; j++) {
					if(arr.get(i) < arr.get(j) ) {
						int gap = j - i ;
						if( gap > k ) break;
						if( value < arr.get(j)) {
							value = arr.get(j);
							idx = j ;
						}
					}
				}
				if( idx != 0 ) {
					k += i ;
					k -= idx;
					int a = arr.remove(idx);
					arr.add(i, a);
					if( k == 0 ) break l;
					continue l;
				}
			}
			break;
		}
		
		for(int i = 0 ; i <n ; i ++) {
			System.out.print(arr.get(i) +" " );
		}
	}
}