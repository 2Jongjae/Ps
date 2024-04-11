import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		
		String ans = input; 
		TreeSet<String> ts = new TreeSet<String>();
		for (int i = 1; i < input.length() - 1; i++) { 
			for (int j = i + 1; j < input.length(); j++) {
				String a = reverse(input.substring(0, i));
				String b = reverse(input.substring(i, j));
				String c = reverse(input.substring(j));

				String temp = a + b + c;
				ts.add(temp);
			}
		}
		System.out.println(ts.first());
	}
	
	public static String reverse(String a) {
		return new StringBuilder(a).reverse().toString();
	}
}
