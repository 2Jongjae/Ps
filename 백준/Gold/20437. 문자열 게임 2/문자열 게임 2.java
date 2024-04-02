import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0 ; tc < T ; tc++ ) {
			String input = br.readLine();
			int[] arr = new int[26];
			
			int max = 0;
			for( int i = 0 ; i< input.length(); i++) {
				int idx = input.charAt(i) -'a';
				arr[idx]++;
				max = Math.max(max, arr[idx]);
			}
			
			int n = Integer.parseInt(br.readLine());

			if( max < n ) {
				sb.append(-1 + "\n");
				continue;
			}
		
			int len = 0 ;

			
			int min = Integer.MAX_VALUE;
			for (int i = 0 ; i < input.length() ; i++) {
				int value = input.charAt(i) -'a';
				int check = 0 ;
				if( arr[value] >= n ) {
					for( int j = i ; j < input.length() ; j++) {
						if(input.charAt(i) == input.charAt(j))check++;
						if( check == n) {
							int gap = j - i+1;
							if( len < gap ) len = gap;
							if( min > gap)  min = gap;
							break;
						}
					}
				}
				
			}
			sb.append(min + " " +len + "\n");
			
		}//tc
	System.out.println(sb);
	}// main
}