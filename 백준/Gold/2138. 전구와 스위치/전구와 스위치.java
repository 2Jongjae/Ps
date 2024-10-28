import java.util.*;
import java.io.*;

public class Main {
	static int[] arr, target;
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		target = new int[n];
		
		String input = br.readLine();
		String tar = br.readLine();
		
		for(int i = 0 ; i < n ; i++) {
			arr[i] = input.charAt(i) - '0';
			target[i] = tar.charAt(i) - '0';
		}
		
		
		int a = light(arr.clone());
		int[] temp = arr.clone();
		temp[0] = 1- temp[0];
		temp[1] = 1 - temp[1];
		int b = light(temp);
		if( b != Integer.MAX_VALUE) b++;
		if( Math.min(a, b) == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(Math.min(a, b));
		
	}
	private static int light(int[] clone) {
		int cnt = 0;
		for(int i = 1 ; i < n ; i++) {
			if(clone[i-1] != target[i-1]) {
				change(clone, i);
				cnt++;
			}
		}
		
		if( Arrays.equals(clone, target)) return cnt;
		
		return Integer.MAX_VALUE;
	}
	
	private static void change(int[] clone , int idx) {
		clone[idx] = 1 - clone[idx];
		clone[idx-1] = 1 - clone[idx-1];
		if(idx < n-1 )  clone[idx+1] = 1 - clone[idx+1]; 
		
	}
}