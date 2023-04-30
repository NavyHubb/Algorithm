package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15590 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        //
        long[][] dp = new long[100_001][4];  // 정수형 리터럴에 구분자(_)를 넣어 가독성을 높일 수 있다

        dp[1][1] = 1;  // 1
        dp[2][2] = 1;  // 2
        dp[3][1] = 1;  // 2+1
        dp[3][2] = 1;  // 1+2
        dp[3][3] = 1;  // 3

        // '모듈러 연산의 분배법칙 성립'을 이용
        for (int i = 4; i <= 100_000; i++) {
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % 1_000_000_009;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % 1_000_000_009;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % 1_000_000_009;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append((dp[n][1] + dp[n][2] + dp[n][3]) % 1_000_000_009).append("\n");
        }

        System.out.println(sb);
    }
}