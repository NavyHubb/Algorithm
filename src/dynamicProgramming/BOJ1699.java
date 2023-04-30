package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[100001];  // 인덱스 i의 값: 주어진 자연수가 i일 때 가질 수 있는 '제곱수 항의 최소 개수'

        for (int i = 1; i <= n; i++) {
            // 1의 제곱으로만 이루어졌을 때의 항의 개수로 초기화
            dp[i] = i;

            // 자연수 i에서 j의 제곱수를 뺀 후 +1(j의 제곱수 항)
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}