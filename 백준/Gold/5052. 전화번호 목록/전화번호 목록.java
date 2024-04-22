import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		l: for(int tc = 0 ; tc< T ; tc++) {
			int n = Integer.parseInt(br.readLine());
			String[]  arr = new String[n];
			
			for(int i = 0 ; i < n ; i++) {
				arr[i] = br.readLine();
			}
			Arrays.sort(arr);
			for(int i = 0 ; i < n-1 ; i++) {
				String a = arr[i];
				String b = arr[i+1];
				if(a.equals(b)) {
					System.out.println("NO");
					continue l;
				}
				
				int Asize = a.length();
				int Bsize = b.length();
				if( Asize >= Bsize) continue;
				
				if(a.equals(b.substring(0,Asize))) {
					System.out.println("NO");
					continue l;
				}
			}
			System.out.println("YES");
			
			
			
			
		}
		
	}
}
