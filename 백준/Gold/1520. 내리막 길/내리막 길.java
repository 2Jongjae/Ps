import java.io.*;
import java.util.*;

class Position {
    int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    static int n, m;
    static int[][] arr;
    static int[][] dp;
    static int[] deltax = {-1, 1, 0, 0};
    static int[] deltay = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1; 
            }
        }

        int result = countPaths(0, 0);
        System.out.println(result);
    }

    static int countPaths(int x, int y) {
        if (x == n - 1 && y == m - 1) {
            return 1; 
        }

        if (dp[x][y] != -1) {
            return dp[x][y]; 
        }

        int paths = 0;
        for (int k = 0; k < 4; k++) {
            int newX = x + deltax[k];
            int newY = y + deltay[k];

            if (newX >= 0 && newX < n && newY >= 0 && newY < m && arr[newX][newY] < arr[x][y]) {
                paths += countPaths(newX, newY);
            }
        }

        dp[x][y] = paths;
//        System.out.println("x = " + x  + " y = " + y);
//        for ( int i = 0 ; i < n ; i ++) {
//        	System.out.println(Arrays.toString(dp[i]));
//        }
//        System.out.println();
        return paths;
    }
}
