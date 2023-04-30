package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N+1];

        dp[0] = 0;
        dp[1] = 1;

        // 1. n번째 자리(일의 자리)가 1이면 n-1번째 자리에는 0으로 끝나는 수만 올 수 있다. 따라서 n-2번째 자리에는 0 혹은 1이 올 수 있다: dp[n-2]
        // 2. n번째 자리(일의 자리)가 0이면 n-1번째 자리에는 0 혹은 1이 올 수 있다: dp[n-1]
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[N]);
    }
}