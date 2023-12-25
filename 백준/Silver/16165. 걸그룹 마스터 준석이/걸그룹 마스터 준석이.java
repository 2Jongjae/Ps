import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String[]> team = new HashMap<>();
        Map<String, String> girl = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String tName = br.readLine();
            int K = Integer.parseInt(br.readLine());
            String[] arr = new String[K];

            for (int j = 0; j < K; j++) {
                String gName = br.readLine();
                girl.put(gName, tName);
                arr[j] = gName;
            }

            Arrays.sort(arr);
            team.put(tName, arr);
        }

        for (int i = 0; i < M; i++) {
            String tmp = br.readLine();
            int pr = Integer.parseInt(br.readLine());

            switch (pr) {
                case 0:
                    for (String s : team.get(tmp)) {
                        bw.write(s + "\n");
                    }
                    break;
                case 1:
                    bw.write(girl.get(tmp) + "\n");
                    break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
