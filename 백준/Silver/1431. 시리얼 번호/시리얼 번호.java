import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		List<String> li = new LinkedList<String>();
		for (int i = 0; i < n; i++) {
			li.add(br.readLine());
		}
		Collections.sort(li, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					int a = 0;
					int b = 0;
					for (int i = 0; i < o1.length(); i++) {
						if (o1.charAt(i) >= '0' && o1.charAt(i) <= '9')
							a += o1.charAt(i) - '0' ;
						if (o2.charAt(i) >= '0' && o2.charAt(i) <= '9')
							b += o2.charAt(i)- '0';
					}
					if(  a== b) return o1.compareTo(o2);
					else  return Integer.compare(a, b);
					
					
				}

				return Integer.compare(o1.length(), o2.length());
			}
		});


		for ( String a : li ) {
			System.out.println(a);
		}
	}
}
