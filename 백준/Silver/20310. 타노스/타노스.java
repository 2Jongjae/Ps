import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		int zero = 0;
		int one = 0;
		List<Character> li = new LinkedList<>();
		
		for( int i = 0 ; i < input.length() ; i++) {
			if( (input.charAt(i) - '0') == 0 ) zero++;
			else one ++;
			li.add(input.charAt(i));
		}
		
		
		int halfone = one/2;
		int halfzero = zero/2;
		for(int i = 0 ; i < li.size() ; i++) {
			if(li.get(i) == '1') {
				li.remove(i);
				i--;
				one--;
			}
			if( one == halfone ) break;
		}
		
		
		for( int i = li.size()- 1 ; i >=0 ; i--) {
			if(li.get(i)== '0' ) {
				li.remove(i);
				zero--;
			}
			if( zero == halfzero) break;
		}
		
		
		for( Character a : li) System.out.print(a);
		
	}// main
}