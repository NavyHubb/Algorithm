package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] map = new int[N+1];  // 입력값이 담길 배열. n개짜리 카드팩 비용
        int[] dp = new int[N+1];  // n개의 카드를 사기 위해 최대 비용

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                // 카드 i개를 살 때,
                // i개 짜리 카드팩 하나를 사는 것과
                // [i-j개 카드를 사는 최대비용 + j개 짜리 카드팩 하나의 비용] 중에
                // 최댓값을 구한다
                dp[i] = Math.max(dp[i], dp[i-j] + map[j]);
            }
        }

        System.out.println(dp[N]);
    }
}