package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11057 {
    final static int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] arr = new long[N + 1][10];
        Arrays.fill(arr[1], 1);  // arr[1]의 원소를 일괄적으로 1로 초기화

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j ; k++) {
                    arr[i][j] += arr[i - 1][k];
                }
                arr[i][j] %= MOD;
            }
        }

        int answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer += arr[N][i];
        }

        System.out.println(answer % MOD);
    }
}