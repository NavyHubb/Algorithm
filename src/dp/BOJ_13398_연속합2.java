package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [문제 분석]
 * 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하라
 * 수는 한 개 이상 선택해야 한다
 * 수를 하나 제거할 수 있다(제거하지 않아도 된다)
 *
 * [문제 풀이]
 * 이차원 dp배열을 사용하여 수를 제거한 경우와 아직 제거하지 않은 경우를 각각 고려한다
 * dp[0]: 수를 제거하지 않은 경우
 * dp[1]: 수를 제거한 경우
 */
public class BOJ_13398_연속합2 {

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
        int[][] dp = new int[N][2];

        dp[0][0] = dp[0][1] = nums[0];
        int answer = nums[0];

        for (int i = 1; i < N; i++) {
            // 특정 수를 제거하지 않은 경우
            dp[i][0] = Math.max(dp[i-1][0] + nums[i], nums[i]);

            // 특정 수를 제거한 경우, 아래 두 가지 경우를 비교한다
            // (1) 현재 수를 최초로 제거하는 경우,
            // (2) 이전에 이미 제거한 수가 있는 경우, 현재 수를 또 제거할 수는 없으므로 직전까지 수를 제거하지 않은 상태의 최댓값에 현재 값을 더하기
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1] + nums[i]);

            answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
        }

        return answer;
    }

}