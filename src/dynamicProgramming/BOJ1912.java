package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1912 {
    static int[] arr;
    static int max;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        dp = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 첫번째 원소만 있을 때는 그 원소 자체가 최댓값
        dp[0] = arr[0];
        max = arr[0];

        // dp의 마지막 인덱스부터 Top-Down 탐색
        recur(n - 1);

        System.out.println(max);
    }

    static int recur(int n) {
        // dp[n]이 탐색된 적 없는 경우
        if (dp[n] == null) {
            // 이전 원소까지를 범위로 했을 때의 최대 누적합에 현재 원소를 포함했을 때와 포함하지 않았을 때를 비교하여 더 큰 값을 선택
            dp[n] = Math.max(recur(n - 1) + arr[n], arr[n]);

            // 최댓값 갱신
            max = Math.max(dp[n], max);
        }

        return dp[n];
    }
}