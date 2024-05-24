import java.io.*;
import java.util.*;

public class Main {
	static long n,m,cost1,cost2;
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cost1 = Integer.parseInt(st.nextToken());
        cost2 = Integer.parseInt(st.nextToken());
        
        long ans1 = (n+m)*cost1;
        long ans2 = 0;
        if( (n+m) % 2 == 0 ) ans2 =  Math.max(n,m) * cost2;
        else ans2 =  (Math.max(n, m)-1) * cost2 + cost1;
        
        long ans3 =  Math.min(n,m) * cost2 +  Math.abs(n-m) * cost1;
        
        System.out.println( Math.min(Math.min(ans2, ans3),ans1) );
        
        
        
        
        
    }
}
