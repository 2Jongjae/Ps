import java.io.*;
import java.util.*;

class position{
	int x,y ;

	public position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		int n = a.length();
		int m = b.length();
		
		int[][] dp = new int[n+1][m+1];
		for ( int i  = 1;  i <= n ; i ++) {
			char temp1 = a.charAt(i-1);
			for (int j = 1 ; j <= m ; j ++) {
				char temp2  = b.charAt(j-1);
				if(temp1 == temp2 ) {
					dp[i][j] = dp[i-1][j-1] +1 ;
				} else {
					dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
				}
			}
		}
//		for (int i = 0 ; i <=n ; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
		
		System.out.println(dp[n][m]);
		
		List<Character> li = new LinkedList<Character>();
		
		Queue<position> qq = new LinkedList<position>();
		
		qq.add(new position(n, m));
		
		while(!qq.isEmpty()) {
			position temp  = qq.poll();
			int xx = temp.x;
			int yy = temp.y;
			if( dp[xx][yy] == 0 ) break;
			
			int ss = dp[xx][yy];
			int aa = dp[xx-1][yy];
			int bb = dp[xx][yy-1];
			
			if( ss > aa && ss >bb && ss == dp[xx-1][yy-1] + 1 ) { 
				if( xx-1 >=0) li.add(a.charAt(xx-1));
				else li.add(b.charAt(yy-1));
				qq.add(new position(xx-1, yy-1));
				continue;
			}
			if( aa>= bb)  qq.add(new position(xx-1, yy));
			else qq.add(new position(xx, yy-1));
			
			
		}

		Collections.reverse(li);
		for(char zz : li) {
			System.out.print(zz);
		}
	}
}
