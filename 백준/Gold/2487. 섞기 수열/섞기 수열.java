import java.util.Scanner;

public class Main {
    static final int MAX_N = 20000;
    static int N;
    static int[] arr = new int[MAX_N + 5];
    static boolean[] same = new boolean[MAX_N + 5];

    static int GCD(int A, int B) {
        int C;
        while (B != 0) {
            C = A % B;
            A = B;
            B = C;
        }
        return A;
    }

    static int LCM(int A, int B) {
        return A / GCD(A, B) * B;
    }

    static int checkCycle(int start) {
        int cycleCnt = 1;
        int next = arr[start];

        while (true) {
            if (start == next) {
                return cycleCnt;
            }
            same[next] = true;
            next = arr[next];
            cycleCnt++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = 1;
        for (int i = 1; i <= N; i++) {
            if (same[i]) continue;
            ans = LCM(ans, checkCycle(i));
        }
        System.out.println(ans);
    }
}
