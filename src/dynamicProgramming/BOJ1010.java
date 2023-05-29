package dynamicProgramming;

import java.io.IOException;
import java.util.Scanner;

public class BOJ1010 {
    static int[][] dp = new int[30][30];  // 최대 입력값이 29이므로
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            System.out.println(solution(M, N));  // M과 N의 순서가 바뀜에 유의
        }
    }

    // 조합(Combination)
    static int solution(int n, int r) {
        if (n == r || r == 0) {
            return 1;
        }

        // 이미 탐색한 값이라면 그대로 반환한다
        if (dp[n][r] > 0) {
            return dp[n][r];
        }

        return dp[n][r] = solution(n-1, r-1) + solution(n-1, r);
    }

}