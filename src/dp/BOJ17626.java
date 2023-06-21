package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[1] = 1;

        int min;
        for (int i = 2; i <= N; i++) {
            min = Integer.MAX_VALUE;

            // i 에서 제곱수를 뺀 값(temp)들을 탐색하면서 dp값을 최소로 갖고 있는 값을 탐색한다
            for (int j = 1; j*j <= i; j++) {
                int temp = i - j*j;
                min = Math.min(min, dp[temp]);
            }
            dp[i] = min + 1;
        }

        System.out.println(dp[N]);
    }
}