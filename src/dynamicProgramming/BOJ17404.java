package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17404 {

    final static int Red = 0;
    final static int Green = 1;
    final static int Blue = 2;
    final static int MAX = 1000 + 1;
    static int[][] cost, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        cost = new int[N][3];
        dp = new int[N][3];

        // 배열 입력
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            cost[i][Red] = Integer.parseInt(st.nextToken());
            cost[i][Green] = Integer.parseInt(st.nextToken());
            cost[i][Blue] = Integer.parseInt(st.nextToken());
        }

        int min = MAX;

        for (int start = 0; start < 3; start++) {
            for (int i = 0; i < 3; i++) {
                if (start == i) {
                    dp[0][i] = cost[0][i];
                }
                else {
                    dp[0][i] = MAX;  // 시작하는 집에 사용된 색깔 이외의 색깔은 최댓값으로 설정함으로써 최솟값을 찾는 알고리즘에서 선택되지 않도록
                }
            }

            for (int i = 1; i < N; i++) {
                dp[i][Red] = Math.min(dp[i - 1][Green], dp[i - 1][Blue]) + cost[i][Red];
                dp[i][Green] = Math.min(dp[i - 1][Red], dp[i - 1][Blue]) + cost[i][Green];
                dp[i][Blue] = Math.min(dp[i - 1][Red], dp[i - 1][Green]) + cost[i][Blue];
            }

            // start로 선택된 색깔 이외의 dp값 중 최솟값 선택
            for (int i = 0; i < 3; i++) {
                if (i != start && min > dp[N - 1][i]) {
                    min = dp[N - 1][i];
                }
            }
        }
        System.out.println(min);
    }
}