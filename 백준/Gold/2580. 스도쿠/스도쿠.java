import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		arr = new int[9][9];

		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0);

	}

	private static void dfs(int row, int col) {
		if ( col == 9 ) {
			dfs(row+1,0);
			return;
			
		}
		if( row == 9 ) {
			for(int i = 0 ; i< 9 ; i++) {
				for(int j = 0 ; j <9 ; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);
			return;
		}
		
		if (arr[row][col] == 0) {
			for (int k = 1; k <= 9; k++) {
				if (check(row, col, k)) {
					arr[row][col] = k;
					dfs(row,col+1);
				}
			}
			arr[row][col] =0 ;
			return;
		}
		dfs(row,col+1);
		 

	}

	private static boolean check(int x, int y, int k) {
		for (int i = 0; i < 9; i++) {
			if (arr[x][i] == k) return false;
		}
		for (int i = 0; i < 9; i++) {
			if (arr[i][y] == k) return false;
		}
		int xx = (x / 3) * 3;
		int yy = (y / 3) * 3;
		for (int i = xx; i < xx + 3; i++) {
			for (int j = yy; j < yy + 3; j++) {
				if(arr[i][j] == k) return false;
			}
		}

		return true;
	}
}
