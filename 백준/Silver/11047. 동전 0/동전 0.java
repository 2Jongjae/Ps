import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] coinArr = new int[N];
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            coinArr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = coinArr.length - 1; i >= 0; i--) {
            count += K / coinArr[i];
            K %= coinArr[i];
            if (K == 0) {
                break;
            }
        }

        System.out.println(count);
    }
}