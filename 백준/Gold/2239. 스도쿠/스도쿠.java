import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr = new int[9][9];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			String input = br.readLine();
			for (int j = 0; j < 9; j++) {
				arr[i][j] = input.charAt(j) - '0';
			}

		}

		dfs(0, 0);

	}

	static void dfs(int row, int col) {
		if (col == 9) {
			dfs(row + 1, 0);
			return;
		}

		if (row == 9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}

			System.exit(0);
		}

		if (arr[row][col] == 0) {
			for (int k = 1; k <= 9; k++) {
				if (check(row, col, k)) {
					arr[row][col] = k;
					dfs(row, col + 1);
				}
			}
			arr[row][col] = 0;
			return;
		}
		dfs(row, col + 1);

	}

	static boolean check(int row, int col, int k) {

		for (int i = 0; i < 9; i++)
			if (arr[row][i] == k)
				return false;
		for (int i = 0; i < 9; i++)
			if (arr[i][col] == k)
				return false;

		int x = (row / 3) * 3;
		int y = (col / 3) * 3;

		for (int i = x; i < x + 3; i++) {
			for (int j = y; j < y + 3; j++) {
				if (arr[i][j] == k)
					return false;
			}
		}

		return true;
	}
}
