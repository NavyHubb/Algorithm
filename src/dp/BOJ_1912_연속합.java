package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [문제 분석]
 * 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하라
 * 수는 한 개 이상 선택해야 한다
 *
 * [문제 풀이]
 * dp[i]: i번째까지의 연속합 중 최댓값
 */
public class BOJ_1912_연속합 {

    static int N;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution());
    }

    private static int solution() {
        int[] dp = new int[N];

        dp[0] = nums[0];
        for (int i = 1; i < N; i++) {
            // 이전 원소까지를 범위로 했을 때의 최대 누적합에 현재 원소를 더했을 때와 현재 원소만을 고려한 것을 비교하여 더 큰 값을 선택
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
        }

        return Arrays.stream(dp).max().getAsInt();
    }

}
