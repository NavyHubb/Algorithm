package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11053 {

    static int[] seq;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        seq = new int[N];  // 입력값이 담길 배열
        dp = new Integer[N];  // seq 배열의 각 인자가 가지는 증가하는 수열의 길이

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        // 첫번째 원소에 대한 LIS는 1일수밖에 없으므로 1로 초기화
        dp[0] = 1;

        for (int i = 1; i < N; i++) {
            LIS(i);
        }

        int max = dp[0];

        for (int i = 1; i < N; i++) {
            // 최댓값 갱신
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

    // LIS(Longest Increasing Subsequence)
    static int LIS(int N) {
        // 아직 탐색되지 않은 인덱스인 경우
        if (dp[N] == null) {
            /*
             * 일단 현재 값보다 앞에 있는 원소들 중 증가하는 수열을 만드는 원소가 없다는 가정으로 dp[i]에 대한 초기값을 1로 설정하고
             * for문을 돌며 현재 인덱스보다 앞에 있는 값들을 탐색하여 더 큰 LIS 값이 등장하면 그 값으로 dp[i] 값을 갱신시킨다
             */
            dp[N] = 1;
            for (int i = N - 1; i >= 0; i--) {
                if (seq[i] < seq[N]) {
                    dp[N] = Math.max(dp[N], LIS(i) + 1);
                }
            }
        }

        return dp[N];
    }
}