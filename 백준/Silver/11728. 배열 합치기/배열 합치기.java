import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n+m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i ++) {
			int input = Integer.parseInt(st.nextToken());
			arr[i]= input;
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = n ; i < n+m ; i ++) {
			int input = Integer.parseInt(st.nextToken());
			arr[i]= input;
		}
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		for( int i = 0 ; i < n+m ; i++) {
			sb.append(arr[i] + " ");
		}
		System.out.println(sb);
	}
}
