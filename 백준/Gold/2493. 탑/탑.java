import java.io.*;
import java.util.*;
class position{
	int x,y;

	public position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Stack<position> ss = new Stack<position>();

		for (int i = 0 ; i< n ; i++) {
			position temp = new position(Integer.parseInt(st.nextToken()), i+1);
			
			while(!ss.isEmpty()) {
				if(temp.x> ss.peek().x) {
					ss.pop();
				} else {
					sb.append(ss.peek().y + " ");
					break;
				}
			}
			
			if(ss.isEmpty()) {
				sb.append("0" + " ");
				
				
			}
			ss.add(temp);
			}
		
		System.out.println(sb);
		
	}
}
