import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static int[][] dp;
    static int n, ans;
    static int[] deltax = {-1, 1, 0, 0};
    static int[] deltay = {0, 0, -1, 1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }
        
        System.out.println(ans);
    }
    
    static int dfs(int x, int y) {
        if (dp[x][y] != 0) {
            return dp[x][y]; 
        }
        
        dp[x][y] = 1; 
        
        for (int i = 0; i < 4; i++) {
            int xx = x + deltax[i];
            int yy = y + deltay[i];
            if (xx >= 0 && xx < n && yy >= 0 && yy < n && arr[xx][yy] > arr[x][y]) {
                dp[x][y] = Math.max(dp[x][y], 1 + dfs(xx, yy));
            }
        }
        
        return dp[x][y];
    }
}
