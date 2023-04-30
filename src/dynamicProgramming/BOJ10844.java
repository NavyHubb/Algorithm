package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10844 {
    static Long[][] dp;
    final static long MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        dp = new Long[N+1][10];  // dp[자릿수][자릿값] = (경우의 수)

        // 첫째 자릿수(1의 자리)는 1로 초기화
        // 첫째 자리수는 더이상 뒤에 수를 붙일 자리가 없기 때문에 경우의 수는 1이다
        // i=0인 경우(dp[1][0])는 1L이 아닌 0이 맞으나 result를 계산하는 과정에서 dp[1][0]은 제외시키도록 설계되어 있으므로 함께 초기화시켜준다
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }

        long result = 0;

        // 마지막
        for (int i = 1; i <= 9; i++) {
            result += recur(N, i);
        }

        System.out.println(result % MOD);
    }

    static long recur(int digit, int val) {

        if (digit == 1) {
            return dp[digit][val];
        }

        if (dp[digit][val] == null) {
            // 자릿수(val)가 0일 경우 그 뒤에 올 수 있는 수는 1뿐
            if (val == 0) {
                dp[digit][val] = recur(digit - 1, 1);
            }
            // 자릿수(val)가 9일 경우 그 뒤에 올 수 있는 수는 8뿐
            else if (val == 9) {
                dp[digit][val] = recur(digit - 1, 8);
            }
            // 그 외의 경우는 val-1인 경우와 val+1인 경우의 수를 합한 만큼의 경우의 수가 된다
            else {
                dp[digit][val] = recur(digit - 1, val - 1) + recur(digit - 1, val + 1);
            }
        }

        return dp[digit][val] % MOD;
    }
}