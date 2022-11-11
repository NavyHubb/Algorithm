package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16194 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] map = new int[N+1];  // 입력값이 담길 배열. n개짜리 카드팩 비용
        int[] dp = new int[N+1];  // n개의 카드를 사기 위해 최소 비용

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            // dp배열도 map배열의 값으로 초기화 시킨다
            // 그렇지 않으면 밑에서 최솟값을 구할 때 dp배열의 초기값이 0이기 때문에 결과값도 0으로 출력된다
            map[i] = dp[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j] + map[j]);
            }
        }

        System.out.println(dp[N]);
    }
}