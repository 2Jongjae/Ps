import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr =new int[n+1];
		int[] result =new int [n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1 ; i<= n ; i ++) {
			result[i] = result[i-1] +Integer.parseInt(st.nextToken());
		}
		int max = Integer.MIN_VALUE;
		for (int i = m ; i <=n ; i ++) {
			int temp = result[i] - result[i-m];
			if( temp > max ) max = temp;
		}
		System.out.println(max);
	}

}