import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(br.readLine());
		int size = 1 ;
		
		while( size <n) size *=2;
		int ans =  size;
		int cnt = 0 ;
		while( n>0) {
			if( n<size) {
				size/=2 ;
				cnt++;
			} else n -= size;
		}
		
		
		System.out.println(ans + " " + cnt);
	}
	
}