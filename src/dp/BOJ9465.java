package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9465 {

    static int dp[][], point[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());  // 테스트 케이스의 개수

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());  // 스티커의 가로 길이

            point = new int[2][N + 1];  // 각 위치의 포인트
            dp = new int[2][N + 1];  // 각 위치까지의 최댓 점수

            // 배열 입력
            StringTokenizer st;
            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= N ; k++) {
                    point[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            // 기저 사례
            dp[0][1] = point[0][1];
            dp[1][1] = point[1][1];

            // 현재 위치의 대각선 값과 그 왼쪽 값을 비교
            for (int j = 2; j <= N; j++) {
                // 점화식
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + point[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + point[1][j];
            }

            System.out.println(Math.max(dp[0][N], dp[1][N]));
        }
    }
}