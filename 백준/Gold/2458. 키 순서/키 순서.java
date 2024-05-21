import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] taller;
    static ArrayList<Integer>[] shorter;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 학생 수
        int m = Integer.parseInt(st.nextToken()); // 비교 횟수

        taller = new ArrayList[n + 1];
        shorter = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            taller[i] = new ArrayList<>();
            shorter[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            taller[a].add(b); // a < b
            shorter[b].add(a); // b > a
        }

        int result = 0;

        for (int i = 1; i <= n; i++) {
            count = 0;
            visited = new boolean[n + 1];
            dfs(i, taller);
            int tallerCount = count;

            count = 0;
            visited = new boolean[n + 1];
            dfs(i, shorter);
            int shorterCount = count;

            if (tallerCount + shorterCount == n - 1) {
                result++;
            }
        }

        System.out.println(result);
    }

    static void dfs(int current, ArrayList<Integer>[] graph) {
        visited[current] = true;
        for (int next : graph[current]) {
            if (!visited[next]) {
                count++;
                dfs(next, graph);
            }
        }
    }
}
