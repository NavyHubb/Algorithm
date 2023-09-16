package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * dp[i][j] : i번째 행렬부터 j번째 행렬까지의 곱셈연산의 '최소' 횟수
 */
public class BOJ_11049_행렬곱셈순서 {

    static int N;
    static int[][] mats;
    static int[][] dp;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        mats = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            mats[i][0] = Integer.parseInt(st.nextToken());
            mats[i][1] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N][N];

        System.out.println(solution());
    }

    static int solution() {
        // 인접한 두 행렬의 곱셈연산 횟수
        for (int i = 0; i < N-1; i++) {
            dp[i][i+1] = mats[i][0] * mats[i][1] * mats[i+1][1];
        }

        for (int gap = 2; gap < N; gap++) {  // gap: (하나의 괄호에 묶일 행렬의 갯수) - 1
            for (int i = 0; i+gap < N; i++) {  // i: 괄호의 시작 행렬 인덱스
                int j = i + gap;  // j: 괄호의 마지막 행렬 인덱스
                dp[i][j] = INF;

                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                        dp[i][k] + dp[k+1][j] + (mats[i][0] * mats[k][1] * mats[j][1]));
                }
            }
        }

        return dp[0][N-1];
    }
}