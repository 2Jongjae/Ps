import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TreeSet<String> ts = new TreeSet<>();
		
		String input = br.readLine();
		
		
		for(int i = 0 ; i< input.length() ; i++) {
			String st = input.substring(i,input.length());
			ts.add(st);
		}

		while(!ts.isEmpty()) System.out.println(ts.pollFirst());
	}

}
