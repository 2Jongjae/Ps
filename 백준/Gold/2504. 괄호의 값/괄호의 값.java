import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());

		String input = br.readLine();
		
		int n = input.length();
		
		Stack<Integer> st = new Stack<>();
		for( int i = 0 ; i < n ; i++) {
			char ch = input.charAt(i);
			if(ch == '(' || ch =='[') st.push((int)ch);
			if( ch == ')') {
				if(!st.isEmpty() && st.pop() == '(') {}
				else {
					System.out.println(0);
					return;
				}
			}
			if( ch == ']') {
				if(!st.isEmpty() && st.pop() == '[') {}
				else {
					System.out.println(0);
					return;
				}
			}
		}
		
		if( st.size() >0 ) {
			System.out.println(0);
			return;
		}
		st = new Stack<>();
		for( int i = 0 ; i < n ; i++) {
			char ch = input.charAt(i);
			if(ch  ==  '(' || ch =='[') st.push(-1);
			if(ch == ')'  || ch == ']') {
				int value = 0;
				while( !(st.peek() == -1)) {
					value += st.pop();
				}
				if( value == 0 ) value =1;
				st.pop();
				if(ch == ')') {
					value *= 2;
				}
				if(ch == ']') value *= 3;
				st.push(value);
			}
		}
		
		int ans = 0 ;
		while(!st.isEmpty())  ans += st.pop();
		System.out.println(ans);
	}
}
