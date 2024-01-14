package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [문제 분석]
 * 세 개의 케이스가 주어진다
 * 동전의 크기와 갯수가 주어질 때, 전체 금액을 절반으로 나눌 수 있는지 판단하라
 *
 * [문제 풀이]
 *
 */
public class BOJ_1943_동전분배 {

    static int N, total;
    static Coin[] coins;
    static boolean[] dp;
    static class Coin {
        int value, quantity;

        public Coin(int value, int quantity) {
            this.value = value;
            this.quantity = quantity;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int t = 0; t < 3; t++) {
            N = Integer.parseInt(br.readLine());
            coins = new Coin[N];
            total = 0;
            dp = new boolean[100_001];  // 원장님이 주신 금액의 최댓값은 100,000원

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int value = Integer.parseInt(st.nextToken());
                int quantity = Integer.parseInt(st.nextToken());

                coins[i] = new Coin(value, quantity);
                total += value * quantity;

                // 현재 동전으로 만들 수 있는 금액을 true 처리
                for (int j = 1; j <= quantity; j++) {
                    dp[value * j] = true;
                }
            }

            if (solution()) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    private static boolean solution() {
        if (total%2 != 0) {
            return false;  // 총액이 홀수인 경우
        }
        if (dp[total/2]) {  // 이미 반으로 나눌 수 있음이 확인된 경우
            return true;
        }

        dp[0] = true;
        for (Coin coin : coins) {
            for (int i = total/2; i >= coin.value; i--) {
                if (dp[i - coin.value]) {
                    for (int j = 1; j <= coin.quantity; j++) {
                        if ((i - coin.value) + (coin.value*j) > total/2) break;  // total/2 이상으로는 탐색할 필요 없음

                        dp[(i - coin.value) + (coin.value*j)] = true;
                    }
                }
            }
        }

        return dp[total/2];
    }

}