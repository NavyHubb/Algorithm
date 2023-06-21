package dp;

import java.util.Scanner;

public class BOJ9084 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[] coins = new int[N];

            for (int j = 0; j < N; j++) {
                coins[j] = sc.nextInt();
            }

            int M = sc.nextInt();

            System.out.println(solution(N, coins, M));
        }
    }

    static int solution(int N, int[] coins, int M) {
        int[] dp = new int[M+1];

        for (int coin : coins) {
            for (int i = 1; i < M+1; i++) {
                if (i > coin) {
                    dp[i] = dp[i] + dp[i - coin];
                } else if (i == coin) {
                    dp[i]++;
                }
            }
        }

        return dp[M];
    }

}