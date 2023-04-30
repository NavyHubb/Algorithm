package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2225 {
    private static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[k+1][n+1];  // dp[a][b] : a개의 수로 b를 만드는 경우의 수

        // 한 개의 수로 어떤 수를 만드는 경우의 수는 1
        Arrays.fill(dp[1], 1);  // Arrays.fill(): 배열의 모든 원소를 일괄적으로 1로 초기화

        // 몇 개의 수를 쓰든 0을 만드는 경우의 수는 1
        for (int i = 2; i <= k; i++) {
            dp[i][0] = 1;
        }


        /**
         *  (i개의 수로 j를 만드는 경우의 수)
         *  = (i-1개의 수로 0부터 j까지를 만드는 경우의 수의 합)
         *  = (i-1개의 수로 j를 만드는 경우의 수) + (i-1개의 수로 0부터 j-1까지를 만드는 경우의 수의 합)
         *  = (i-1개의 수로 j를 만드는 경우의 수) + (i개의 수로 j-1을 만드는 경우의 수)
         */
        for (int i = 2; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                dp[i][j] %= MOD;
            }
        }

        System.out.println(dp[k][n]);
    }
}