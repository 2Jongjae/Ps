import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int pos = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        if (pos <= n) {
            int[] dp = new int[100001];
            int[] path = new int[100001];
            Arrays.fill(dp, -1); // 초기화
            dp[pos] = 0;

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(pos);

            while (!queue.isEmpty()) {
                int cur = queue.poll();

                if (cur == n) {
                    break;
                }

                int[] nextPositions = {cur - 1, cur + 1, cur * 2};
                for (int next : nextPositions) {
                    if (next >= 0 && next <= 100000 && dp[next] == -1) {
                        dp[next] = dp[cur] + 1;
                        path[next] = cur; // 경로 추적을 위한 부모 저장
                        queue.offer(next);
                    }
                }
            }

            // 최소 이동 시간 출력
            sb.append(dp[n]).append("\n");

            // 경로 역추적
            List<Integer> pathList = new ArrayList<>();
            int current = n;
            while (current != pos) {
                pathList.add(current);
                current = path[current];
            }
            pathList.add(pos);

            // 경로 출력
            for (int i = pathList.size() - 1; i >= 0; i--) {
                sb.append(pathList.get(i)).append(" ");
            }
        } else {
    		sb.append(pos-n+ "\n");
    		
    		for (int i = pos ; i >= n; i--) {
    			sb.append(i + " ");
    		}
    		
    		}
        System.out.println(sb);
    }
}
