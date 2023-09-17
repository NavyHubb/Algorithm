package dp;

import java.util.Scanner;

/**
 * 파스칼의 삼각형 공식 활용
 * nCr = (n-1)C(r-1) + (n-1)C(r)
 *
 * dp 배열의 정의
 * dp[i][j] = iCj의 값
 */
public class BOJ_11051_이항계수2 {

    static int[][] dp;
    static final int MOD = 10_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        dp = new int[N+1][N+1];

        System.out.println(solution(N, K));
    }

    static int solution(int n, int r) {
        if (n == r || r == 0) {
            return 1;
        }

        if (dp[n][r] == 0) {
            dp[n][r] = solution(n-1, r-1) + solution(n-1, r);
            dp[n][r] %= MOD;
        }
        return dp[n][r];
    }

}