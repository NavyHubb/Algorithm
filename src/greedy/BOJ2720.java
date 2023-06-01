package greedy;

import java.io.IOException;
import java.util.Scanner;

public class BOJ2720 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int C = sc.nextInt();

            int[] result = solution(C);
            for (int j = 0; j < 4; j++) {
                sb.append(result[j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static int[] solution(int N) {
        int[] coins = {25, 10, 5, 1};
        int[] result = new int[4];

        for (int i = 0; i < 4; i++) {
            result[i] = N / coins[i];
            N %= coins[i];
        }
        return result;
    }
}