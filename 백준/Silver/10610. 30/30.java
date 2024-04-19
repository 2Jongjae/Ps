import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		int sum = 0;
		int zerocnt=0;
		List<Integer> li = new ArrayList<>();
		for( int i = 0 ; i < input.length() ; i++) {
			sum += input.charAt(i) -'0';
			li.add(input.charAt(i)-'0');
			if(li.get(i) == 0 ) zerocnt++;
		}
		Collections.sort(li);
		if( zerocnt  > 0 && sum % 3 == 0 ) {
		for( int i = li.size() -1 ; i >=0 ;  i--) {
			System.out.print(li.get(i));
		}
		}
		else System.out.println(-1);
	}

}
