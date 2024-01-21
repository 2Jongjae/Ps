import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		
		for (int T = 0 ; T < t ; T++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			int[] count = new int[201];
			int[] score = new int[n];
			for ( int i = 0 ; i<n ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				count[arr[i]]++;
			}
			
			int value = 1;
			Arrays.fill(score,20000);
			for (int i = 0 ; i < n ; i++) {
				if(count[arr[i]] <6) continue;
				score[i] =value++;
			}
			List<Integer>[] li = new ArrayList[201];
			
			for( int i = 1 ; i<= 200 ; i++) {
				li[i] = new ArrayList<>();
			}
			
			for( int i = 0 ; i<n ; i++) {
				if( li[arr[i]].size()<=4 ) li[arr[i]].add(score[i]);
			}
			int ans = -1;
			int temp = 20000;
			for( int i = 1 ; i<= 200 ; i++) {
				if( li[i].size() >=4) {
					int sum = 0;
					for( int j = 0 ; j <4 ; j++) {
						sum += li[i].get(j);
					}
					if( sum <temp) {
						temp = sum;
						ans = i;
						continue;
					}
					if( sum == temp ) {
						if( li[ans].get(4) > li[i].get(4)) {
							ans = i ;
						}
					}
					
				}
			}
			System.out.println(ans);
			
			
		} //tc 
	}
}