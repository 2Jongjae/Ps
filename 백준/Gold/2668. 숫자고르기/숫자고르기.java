import java.io.*;
import java.util.*;

class position {
	int x, y;

	public position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "position [x=" + x + ", y=" + y + "]";
	}

}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		List<position> arr = new LinkedList<position>();
		for (int i = 1; i <= n; i++) {
			int m = Integer.parseInt(br.readLine());
			arr.add(new position(i, m));
		}
		TreeSet<Integer> ts = new TreeSet<>();
		Stack<position> ss = new Stack<>();
		boolean[] visit = new boolean[n+1];
		for (int i = 1; i <= n; i++) {
			if(!visit[i])ss.add(arr.get(i-1));
			boolean[] temp = new boolean[n+1];
			temp[i] = true;
			while(!ss.isEmpty()) {
				position x = ss.pop();
				int dy = x.y;
				if(!temp[dy]) {
					ss.add(arr.get(dy-1));
					temp[dy] = true;
				}
				if( dy == i ) {
					for ( int k = 1 ; k<=n ;k++) {
						if(temp[k]) {
							visit[k]= true;
							ts.add(k);
						}
					}
				}
				
			}
			
		}
		sb.append(ts.size() + "\n");
		for ( int a : ts ) {
			sb.append(a + "\n");
		}
		System.out.println(sb);
	}
}