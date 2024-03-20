import java.util.*;
import java.io.*;

class Position {
    int x, y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Position [x=" + x + ", y=" + y + "]";
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int player = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        int[] distance = new int[player + 1];
        Queue<Position>[] graph = new LinkedList[player + 1]; // ArrayList 대신에 LinkedList 사용

        for (int i = 1; i <= player; i++) {
            graph[i] = new LinkedList<>(); // ArrayList 대신에 LinkedList 사용
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= player; i++)
            distance[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                char ch = input.charAt(j);
                arr[i][j] = ch - '0';
                if (ch == '.')
                    arr[i][j] = 0;
                if (ch == '#')
                    arr[i][j] = -1;
                if (arr[i][j] > 0)
                    graph[arr[i][j]].add(new Position(i, j));
            }
        }

        int[] deltax = { -1, 1, 0, 0 };
        int[] deltay = { 0, 0, -1, 1 };

        boolean flag = false;
        while (!flag) {
            int cnt = 0;
            for (int i = 1; i <= player; i++) {
                if (graph[i].isEmpty())
                    cnt++;
            }
            if (cnt == player) {
                flag = true;
                break;
            }

            for (int i = 1; i <= player; i++) {
                for (int play = 0; play < distance[i]; play++) {
                    Queue<Position> qq = graph[i];
                    int qsize = qq.size();
                    if (qsize == 0)
                        break;

                    while (qsize-- > 0) {
                        Position cur = qq.poll();

                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur.x + deltax[dir];
                            int ny = cur.y + deltay[dir];
                            if (nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] == 0) {
                                arr[nx][ny] = i;
                                qq.add(new Position(nx, ny));
                            }
                        }
                    }
                }

            }

        } // while loop

        int[] ans = new int[player + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] > 0) {
                    ans[arr[i][j]]++;
                }
            }
        }

        for (int i = 1; i <= player; i++) {
            System.out.print(ans[i] + " ");
        }

    }// main
}
