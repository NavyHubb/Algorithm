package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149 {

    final static int Red = 0;
    final static int Green = 1;
    final static int Blue = 2;

    static int[][] cost;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        cost = new int[N][3];
        dp = new int[N][3];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            cost[i][Red] = Integer.parseInt(st.nextToken());
            cost[i][Green] = Integer.parseInt(st.nextToken());
            cost[i][Blue] = Integer.parseInt(st.nextToken());
        }

        dp[0][Red] = cost[0][Red];
        dp[0][Green] = cost[0][Green];
        dp[0][Blue] = cost[0][Blue];

        System.out.println(Math.min(paintCost(N - 1, Red), Math.min(paintCost(N - 1, Green), paintCost(N - 1, Blue))));

    }

    static int paintCost(int N, int color) {
        if (dp[N][color] == 0) {
            if (color == Red) {
                dp[N][Red] = Math.min(paintCost(N - 1, Green), paintCost(N - 1, Blue)) + cost[N][Red];
            }
            else if (color == Green) {
                dp[N][Green] = Math.min(paintCost(N - 1, Red), paintCost(N - 1, Blue)) + cost[N][Green];
            }
            else {
                dp[N][Blue] = Math.min(paintCost(N - 1, Red), paintCost(N - 1, Green)) + cost[N][Blue];
            }
        }

        return dp[N][color];
    }
}