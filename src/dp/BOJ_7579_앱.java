package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7579_앱 {

    static int N, M;
    static int[][] apps;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  // 앱의 갯수
        M = Integer.parseInt(st.nextToken());  // 확보해야 하는 메모리
        apps = new int[N+1][2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            apps[i+1][0] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            apps[i+1][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution());
    }

    static int solution() {
        int result = Integer.MAX_VALUE;
        int[][] dp = new int[2][10001];  // dp[i][c]: 1~i번째 앱을 고려하였을 때 비용 c로 확보할 수 있는 최대 메모리

        for (int i = 1; i <= N; i++) {
            int memory = apps[i][0];
            int cost = apps[i][1];

            for (int c = 0; c <= 10000; c++) {
                if (c >= cost) {
                    dp[i%2][c] = Math.max(memory + dp[(i-1)%2][c-cost], dp[(i-1)%2][c]);
                } else {
                    dp[i%2][c] = dp[(i-1)%2][c];
                }

                if (dp[i%2][c] >= M) {
                    result = Math.min(result, c);
                }
            }
        }

        return result;
    }

}