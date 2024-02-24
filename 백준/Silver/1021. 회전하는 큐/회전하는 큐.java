import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int ans = 0;
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 1 ; i <= n ; i ++)  dq.add(i);
		st = new StringTokenizer(br.readLine());
		for (int i = 0 ; i < m ; i ++) {
			int target = Integer.parseInt(st.nextToken());
			int cnt = 0;
			while(!(target == dq.peekFirst())) {
				int temp = dq.pollFirst();
				dq.addLast(temp);
				cnt++;
			}
			ans += Math.min(cnt, dq.size()-cnt);
			dq.pollFirst();
		}
		System.out.println(ans);
			
	}
}
