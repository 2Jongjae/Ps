import java.util.*;
import java.io.*;
class Position{
	int s,b,cnt;
	Position( int s, int b, int cnt){
		this.s = s;
		this.b = b;
		this.cnt = cnt;
	}
}



public class Main {
	static int n,m,ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		boolean[][] visit = new boolean[1001][1001];
		
		
		Queue<Position> qq = new ArrayDeque<>();
		qq.add(new Position(1,0,0));
		visit[1][0] = true;
		
		while(!qq.isEmpty()) {
			Position ps = qq.poll();
			int s = ps.s;
			int b = ps.b;
			int cnt = ps.cnt;
			
			if( s== n ) {
				System.out.println(cnt);
				return;
			}
			
			if(s != b && !visit[s][s]) {
				qq.add(new Position(s,s,cnt+1));
				visit[s][s] = true;
			}
			
			if(s+b <=1000 && !visit[s+b][b]) {
				qq.add(new Position(s+b,b,cnt+1));
				visit[s+b][b] = true;
			}
			
			if(s>0 && !visit[s-1][b]) {
				qq.add(new Position(s-1,b,cnt+1));
				visit[s-1][b] = true;
			}
			
		}
	
		
		
	}
}
