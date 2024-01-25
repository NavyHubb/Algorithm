package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * [문제 분석]
 * K >= 0을 만족하는 모든 K에 대해
 * 가치가 10^K, 25*100^K 인 동전이 있다
 * 각 동전의 개수는 무한하고, 초콜릿을 구매할 때는 정확하게 그 가격만큼만 지불해야 한다
 *
 * 초콜릿 가격이 주어질 때, 구매에 필요한 동전의 최솟값을 구하라
 *
 * [문제 풀이]
 * 사용할 수 있는 동전의 액수를 오름차순으로 나열하였을 때, {1, 10, 25} * 100^n 의 규칙으로 반복된다
 * 따라서, 주어진 수 N을 100 단위로 나누어가며 동전의 개수를 구한다
 */
public class BOJ_1398_동전문제 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            long N = Long.parseLong(br.readLine());
            sb.append(solution(N)).append('\n');
        }

        System.out.println(sb);
    }

    private static int solution(long N) {
        int cnt = 0;

        int[] dp = new int[100];
        int[] coins = {1, 10, 25};

        for (int i = 1; i < 100; i++) {
            dp[i] = i;
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        while (N > 0) {
            cnt += dp[(int) (N % 100)];
            N /= 100;
        }

        return cnt;
    }

}
