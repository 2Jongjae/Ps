import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n, m, k;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][n];
		int[][] winter = new int[n][n];
		for (int i = 0; i < n; i++)
			Arrays.fill(arr[i], 5);
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				winter[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		PriorityQueue[][] tree = new PriorityQueue[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				tree[i][j] = new PriorityQueue<Integer>();
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			tree[x - 1][y - 1].add(age);
		}

		int[] deltax = { -1, -1, -1, 0, 1, 1, 1, 0 };
		int[] deltay = { -1, 0, 1, 1, 1, 0, -1, -1 };

		for (int tc = 0; tc < k; tc++) {

			// 봄 나무가 자신의 나이만큼 양분을 먹고, 나이가 1 증가한다.\
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (tree[i][j].isEmpty())
						continue;
					PriorityQueue<Integer> live = new PriorityQueue();
					while (!tree[i][j].isEmpty()) {
						int value = (int) tree[i][j].peek();
						if (value <= arr[i][j]) {
							arr[i][j] -= value;
							live.add((int) tree[i][j].poll() + 1);
						} else
							break;
					} // while

					PriorityQueue<Integer> pq = tree[i][j];
					for (Integer c : pq) arr[i][j] += c / 2;
					tree[i][j] = live;
				}
			}

			int[][] check = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (tree[i][j].isEmpty()) continue;
					PriorityQueue<Integer> pq = tree[i][j];
					for (Integer c : pq) {
						if ( (c%=5) == 0) {
							for ( int w = 0 ;  w < 8 ; w++) {
								int x = i + deltax[w];
								int y = j + deltay[w];
								if( x>=0 && x< n && y>=0 && y<n ) check[x][y] ++;
							}
						}
					}
				}
			}
			
			for( int i = 0 ;  i< n ; i ++) {
				for (int j = 0 ; j < n ; j++) {
					arr[i][j] += winter[i][j];
					for(int w = 0 ; w < check[i][j] ; w++) {
						tree[i][j].add(1);
					}
				}
			}
			
			

		} // tc

		int sum = 0;
		for (int i = 0 ; i < n ; i ++) {
			for(int j = 0 ; j < n ; j++) {
				sum+= tree[i][j].size();
			}
//			System.out.println(Arrays.toString(tree[i]));
		}
		
		System.out.println(sum);
	}
}
