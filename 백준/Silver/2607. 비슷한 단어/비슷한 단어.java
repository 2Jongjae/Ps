import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[26];
		String input = br.readLine();
		int size = input.length();
		for( int i = 0 ; i < input.length();i++) arr[input.charAt(i)-'A'] ++;
		int ans = 0 ; 
		l: for ( int i = 0 ; i < n -1 ;i++) {
			int[] temp = new int [26];
			input = br.readLine();
			int size2 = input.length();
			if( Math.abs(size-size2)>=2) continue;
			
			for( int j = 0 ; j < input.length(); j++) temp[input.charAt(j)-'A'] ++;
			int stand = 0;
			for( int j  = 0 ; j < 26 ;j++) {
				stand += Math.abs(arr[j]-temp[j]);
				if( stand >=3 ) continue l;
			}
			ans++;
		}
		System.out.println(ans);
	}
}