import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int left = 0;
        int right = 0;
        int[] cnt = new int[100001];

        while (right < n) {
            cnt[arr[right]]++;
            if (cnt[arr[right]] <= m) {
                max = Math.max(max, right - left + 1);
            } else {
                while (cnt[arr[right]] > m) {
                    cnt[arr[left]]--;
                    left++;
                }
            }
            right++;
        }

        System.out.println(max);
    }
}
