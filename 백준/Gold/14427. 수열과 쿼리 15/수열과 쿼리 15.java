import java.util.*;
import java.io.*;

class Position implements Comparable<Position> {
	int mId, value;

	Position(int mId, int value) {
		this.mId = mId;
		this.value = value;
	}


	@Override
	public int compareTo(Position o) {
		if (this.value == o.value) return this.mId - o.mId;
		return this.value - o.value;
	}


	@Override
	public String toString() {
		return "Position [mId=" + mId + ", value=" + value + "]";
	}

	
	
}

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Position> pq = new PriorityQueue<Position>();
		TreeMap<Integer, Integer> tm = new TreeMap<>();
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			Position ps = new Position(i, Integer.parseInt(st.nextToken()));
			tm.put(i,ps.value);
			pq.add(ps);
		}

		int query = Integer.parseInt(br.readLine());
		for (int i = 0; i < query; i++) {
//			System.out.println("i = " +i + pq);
			st = new StringTokenizer(br.readLine());
			int value = Integer.parseInt(st.nextToken());
			if (value == 2) {
				while (true) {
					Position temp = pq.poll();
					if( temp.value != tm.get(temp.mId)) continue;
					sb.append(temp.mId + "\n");
					pq.add(temp);
					break;
				}
			}
			if (value == 1) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				pq.add( new Position(start,end));
				tm.put(start, end);
			}
		}
		System.out.println(sb);
	}
}