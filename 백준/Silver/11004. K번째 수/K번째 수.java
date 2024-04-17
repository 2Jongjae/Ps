import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i ++) {
			int input = Integer.parseInt(st.nextToken());
			arr[i]= input;
		}
		Arrays.sort(arr);
		System.out.println(arr[m-1]);
	}
}
