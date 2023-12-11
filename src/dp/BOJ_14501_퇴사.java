package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [문제 분석]
 * 퇴사 전까지 상담을 하여 얻을 수 있는 최대 수익을 구하라
 *
 * [문제 풀이]
 * 상담을 마치고 난 다음에야 수익을 얻을 수 있다
 */
public class BOJ_14501_퇴사 {

    static int N;
    static int[] T, P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        T = new int[N];  // 상담을 완료하는 데 걸리는 기간
        P = new int[N];  // 상담을 완료했을 때 얻는 수익

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution());
    }

    public static int solution() {
        int[] dp = new int[N+1];

        for (int i = 0; i < N; i++) {  // 모든 상담에 대한 반복
            if (i + T[i] <= N) {  // 퇴사 전에 끝낼 수 있는 상담인 경우
                dp[i+T[i]] = Math.max(dp[i+T[i]], dp[i] + P[i]);
            }

            dp[i+1] = Math.max(dp[i], dp[i+1]);
        }

        return dp[N];
    }

}