package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1309 {
    final static int MOD = 9901;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // arr[i][j] : i행 j열 칸에 동물을 놓을 수 있는 경우의 수
        // j = 0 : 두 칸 모두 비어있음
        // j = 1 : 첫번째 칸에만 동물을 놓음
        // j = 2 : 두번째 칸에만 동물을 놓음
        long[][] arr = new long[N + 1][3];
        arr[1][0] = arr[1][1] = arr[1][2] = 1;

        for (int i = 2; i <= N; i++) {
            arr[i][0] = (arr[i - 1][0] + arr[i - 1][1] + arr[i - 1][2]) % MOD;
            arr[i][1] = (arr[i - 1][0] + arr[i - 1][2]) % MOD;
            arr[i][2] = (arr[i - 1][0] + arr[i - 1][1]) % MOD;
        }

        System.out.println((arr[N][0] + arr[N][1] + arr[N][2]) % MOD);
    }
}