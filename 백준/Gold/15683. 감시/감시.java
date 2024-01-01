import java.io.*;
import java.util.*;

class position {
	int x, y, z;

	public position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public position(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public String toString() {
		return "position [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

}

public class Main {
	static int n, m;
	static int[][] arr;
	static List<position> li;
	static List<position> subset;
	static int min, res;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		li = new ArrayList();
		subset = new ArrayList();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] >= 1 && arr[i][j] <= 5)
					li.add(new position(i, j));
				if (arr[i][j] == 6)
					res++;
			}
		}
		visit = new boolean[li.size()];
		min = Integer.MAX_VALUE;
		dfs(0);
		System.out.println(min);
	}

	// 1,2,3,4 동, 서 , 남 북
	private static void dfs(int idx) {
		if (idx == li.size()) {
//			System.out.println(subset);
			check(subset);
		}
		for (int i = idx; i < li.size(); i++) {
			if (!visit[i]) {
				visit[i]= true;
				int x = li.get(i).x;
				int y = li.get(i).y;
				if (arr[x][y] == 1) {

						for (int j = 1; j <= 4; j++) {
							subset.add(new position(x, y, j));
							dfs(idx + 1);
							subset.remove(subset.size() - 1);
						}
				}

				if (arr[x][y] == 2) {
					for (int j = 1; j <= 2; j++) {
						subset.add(new position(x, y, j));
						dfs(idx + 1);
						subset.remove(subset.size() - 1);
					}
				}

				if (arr[x][y] == 3) {
					for (int j = 1; j <= 4; j++) {
						subset.add(new position(x, y, j));
						dfs(idx + 1);
						subset.remove(subset.size() - 1);
					}
				}

				if (arr[x][y] == 4) {
					for (int j = 1; j <= 4; j++) {
						subset.add(new position(x, y, j));
						dfs(idx + 1);
						subset.remove(subset.size() - 1);
					}
				}

				if (arr[x][y] == 5) {
					subset.add(new position(x, y, 1));
					dfs(idx + 1);
					subset.remove(subset.size() - 1);
				}
				visit[i] = false;
			}
		}

	}

	private static void check(List<position> subset2) {
		int[][] temp = new int[n][m];

		for (int i = 0; i < subset2.size(); i++) {
			int x, y, z;
			x = subset2.get(i).x;
			y = subset2.get(i).y;
			z = subset2.get(i).z;
			if (arr[x][y] == 1) {
				if (z == 1)
					rightcheck(temp, x, y);
				if (z == 2)
					leftcheck(temp, x, y);
				if (z == 3)
					upcheck(temp, x, y);
				if (z == 4)
					downcheck(temp, x, y);
			}
			if (arr[x][y] == 2) {
				if (z == 1) {
					upcheck(temp, x, y);
					downcheck(temp, x, y);
				}
				if (z == 2) {
					rightcheck(temp, x, y);
					leftcheck(temp, x, y);
				}
			}

			if (arr[x][y] == 3) {
				if (z == 1) {
					upcheck(temp, x, y);
					rightcheck(temp, x, y);
				}
				if (z == 2) {
					rightcheck(temp, x, y);
					downcheck(temp, x, y);

				}
				if (z == 3) {
					downcheck(temp, x, y);
					leftcheck(temp, x, y);
				}
				if (z == 4) {
					leftcheck(temp, x, y);
					upcheck(temp, x, y);
				}
			}
			if (arr[x][y] == 4) {
				if (z == 1) {
					// ㅏ
					upcheck(temp, x, y);
					rightcheck(temp, x, y);
					downcheck(temp, x, y);
				}
				if (z == 2) {
					// ㅜ
					rightcheck(temp, x, y);
					downcheck(temp, x, y);
					leftcheck(temp, x, y);

				}
				if (z == 3) {
					// ㅓ
					downcheck(temp, x, y);
					leftcheck(temp, x, y);
					upcheck(temp, x, y);
				}
				if (z == 4) {
					// h
					leftcheck(temp, x, y);
					upcheck(temp, x, y);
					rightcheck(temp, x, y);
				}
			}
			if (arr[x][y] == 5) {
				leftcheck(temp, x, y);
				upcheck(temp, x, y);
				rightcheck(temp, x, y);
				downcheck(temp, x, y);
			}

		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (temp[i][j] == 0)
					cnt++;
			}
		}

		cnt -= res;
		min = Math.min(min, cnt);

	}

	private static void downcheck(int[][] temp, int x, int y) {
		while (true) {
			temp[x][y] = 1;
			x++;
			if (x >= 0 && x < n && arr[x][y] != 6)
				continue;
			else
				break;
		}

	}

	private static void upcheck(int[][] temp, int x, int y) {
		while (true) {
			temp[x][y] = 1;
			x--;
			if (x >= 0 && x < n && arr[x][y] != 6)
				continue;
			else
				break;
		}
	}

	private static void leftcheck(int[][] temp, int x, int y) {
		while (true) {
			temp[x][y] = 1;
			y--;
			if (y >= 0 && y < m && arr[x][y] != 6)
				continue;
			else
				break;
		}
	}

	private static void rightcheck(int[][] temp, int x, int y) {
		while (true) {
			temp[x][y] = 1;
			y++;
			if (y >= 0 && y < m && arr[x][y] != 6)
				continue;
			else
				break;
		}
	}

}
