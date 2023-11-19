import java.io.*;
import java.util.*;
public class Main {
	static List<Integer>[] graph;
	static int n,m,start;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int n = Integer.parseInt(st.nextToken());
		
		for (int i = 0 ; i <n ; i++) {
			pq.add(Integer.parseInt(br.readLine()));
			
		}
		int max = -1; 
		int num = n;

			for ( int i = 0 ; i < n ; i++) {
				int temp = pq.poll();
				max = Math.max(max, temp*num);
				num--;
			}
		System.out.println(max);
	}
}