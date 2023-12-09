import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0 ; tc<T ; tc++) {
			int n = Integer.parseInt(br.readLine());
			st= new StringTokenizer(br.readLine());
			Deque<Character> dq = new ArrayDeque<>();
			
			for (int i = 0 ; i < n ; i++) {
				char temp= st.nextToken().charAt(0);
				
				if( dq.isEmpty()) {
					dq.add(temp);
					continue;
				}
				
				if( temp <= dq.peekFirst()) dq.addFirst(temp);
				else dq.addLast(temp);
				
			}
			
			
			for(char a : dq) {
				sb.append(a);
			}
				sb.append("\n");
			
			
		}
    	System.out.println(sb);
    }
}
