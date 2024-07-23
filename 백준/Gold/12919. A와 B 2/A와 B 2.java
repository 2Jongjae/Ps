import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a = br.readLine();
		String b = br.readLine();
		int ans = 0;
		if( dfs(a, b)) ans =1;
		System.out.println(ans);
	}
	
	static boolean dfs(String a, String b) {
		if(a.equals(b)) return true;
		if(a.length() > b.length()) return false;
		
		boolean ans = false;
		
		
		if(b.charAt(b.length()-1) == 'A') {
			String newB = b.substring(0,b.length()-1);
			ans |= dfs(a,newB);
		}
		
		if(b.charAt(0) == 'B') {
			StringBuilder sb = new StringBuilder();
			String newA = b.substring(1);
			sb.append(newA);
			ans |= dfs(a,sb.reverse().toString());
		}
		
		
		return ans;
	}
}
