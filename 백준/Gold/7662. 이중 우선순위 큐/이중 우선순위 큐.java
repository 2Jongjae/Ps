import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                int temp = Integer.parseInt(st.nextToken());

                if (a.equals("I")) {
                    map.put(temp, map.getOrDefault(temp, 0) + 1);
                } else if (a.equals("D")) {
                    if (!map.isEmpty()) {
                        if (temp == 1) {
                            int maxKey = map.lastKey();
                            if (map.get(maxKey) == 1) {
                                map.remove(maxKey);
                            } else {
                                map.put(maxKey, map.get(maxKey) - 1);
                            }
                        } else if (temp == -1) {
                            int minKey = map.firstKey();
                            if (map.get(minKey) == 1) {
                                map.remove(minKey);
                            } else {
                                map.put(minKey, map.get(minKey) - 1);
                            }
                        }
                    }
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }

        System.out.println(sb);
    }
}
