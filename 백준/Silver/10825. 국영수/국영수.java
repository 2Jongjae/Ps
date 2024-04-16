import java.io.*;
import java.util.*;


class Position implements Comparable<Position>{
	String name;
	int ko,en,ma;
	Position(String name, int ko, int en, int ma){
		this.name = name;
		this.ko = ko;
		this.en = en;
		this.ma = ma;
	}
	public int compareTo(Position o) {
		if( this.ko == o.ko) {
			if( this.en == o.en) {
				if(this.ma == o.ma) return this.name.compareTo(o.name);
				return -(this.ma-o.ma);
			}
			return -(o.en -this.en);
		}
		return -(this.ko - o.ko);
	}
}
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
//		TreeSet<Position> ts = new TreeSet<>();
		List<Position> ts = new ArrayList<>();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i< n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int ko = Integer.parseInt(st.nextToken());
			int en = Integer.parseInt(st.nextToken());
			int ma = Integer.parseInt(st.nextToken());
			ts.add(new Position(name,ko,en,ma));
		}
		Collections.sort(ts);

		for( Position a : ts) sb.append(a.name +"\n");
		System.out.println(sb);
	}

}
