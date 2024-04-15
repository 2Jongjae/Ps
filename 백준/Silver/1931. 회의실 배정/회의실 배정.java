import java.io.*;
import java.util.*;

class Position implements Comparable<Position>{
	int x, y;
	Position ( int x,  int y ){
		this.x = x;
		this.y = y;
	}
	public int compareTo(Position o) {
		if(this.y == o.y ) return this.x -o.x;
		return this.y - o.y;
	}
	
}

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		List<Position> li = new ArrayList<>();
		for( int i = 0 ; i < n ; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			li.add(new Position(a,b));
		}
		
		Collections.sort(li);
		
		List<Position> ans = new ArrayList<>();
		ans.add(li.get(0));
		
		for( int i = 1 ; i < n ; i ++) {
			if(li.get(i).x >= ans.get(ans.size()-1).y) ans.add(li.get(i));
		}
		System.out.println(ans.size());
		
	}
	
}
