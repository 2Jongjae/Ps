import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	long n = Long.parseLong(br.readLine());
	int pisano =1_500_000;
	long[] dp = new long[pisano+1];
	
	dp[1] = 1;
	dp[2] = 1;
	for ( int i =3 ; i<= pisano ; i++) {
		dp[i] = (dp[i-1] + dp[i-2])%1000000;
	}
	
	if(n>=pisano) n %= pisano;
	
	
	System.out.println(dp[(int) n]);
	
	}
}
