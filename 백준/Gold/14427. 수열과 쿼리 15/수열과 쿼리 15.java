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
	
}

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Position> pq = new PriorityQueue<Position>();
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			Position ps = new Position(i, Integer.parseInt(st.nextToken()));
			arr[i] = ps.value;
			pq.add(ps);
		}

		int query = Integer.parseInt(br.readLine());
		for (int i = 0; i < query; i++) {
			st = new StringTokenizer(br.readLine());
			int value = Integer.parseInt(st.nextToken());
			if (value == 2) {
				while (true) {
					Position temp = pq.poll();
					if( arr[temp.mId] != temp.value) continue;
					sb.append(temp.mId + "\n");
					pq.add(temp);
					break;
				}
			}
			if (value == 1) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				pq.add( new Position(start,end));
				arr[start] = end;
			}
		}
		System.out.println(sb);
	}
}