package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11054_가장긴바이토닉부분수열 {

    static int N;
    static int[] nums;
    static int[] inc_dp;
    static int[] dec_dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        inc_dp = new int[N];
        dec_dp = new int[N];

        System.out.println(solution());
    }

    static int solution() {
        LIS();
        LDS();

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, inc_dp[i] + dec_dp[i]);
        }

        return max-1;  // 바이토닉 수열의 정점 부분이 중복 카운트되므로 -1 처리
    }

    // 가장 긴 증가하는 부분수열
    static void LIS() {
        for (int i = 0; i < N; i++) {
            inc_dp[i] = 1;  // 1로 초기화

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    inc_dp[i] = Math.max(inc_dp[i], inc_dp[j]+1);
                }
            }
        }
    }
    
    // 가장 긴 감소하는 부분수열
    static void LDS() {
        for (int i = N-1; i >= 0; i--) {
            dec_dp[i] = 1;

            for (int j = N-1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    dec_dp[i] = Math.max(dec_dp[i], dec_dp[j]+1);
                }
            }
        }
    }
    
}
