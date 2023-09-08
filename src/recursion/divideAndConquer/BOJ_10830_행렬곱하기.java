package recursion.divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10830_행렬곱하기 {

    static int N;
    static int[][] origin;
    static final int MOD = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        origin = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        int[][] result = solution(origin, B);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    /**
     * 행렬 제곱 분할정복
     * @param A 곱하기 연산의 대상 행렬
     * @param exp 곱한 횟수
     */
    static int[][] solution(int[][] A, long exp) {
        if (exp == 1) return A;

        int[][] result = solution(A, exp/2);
        result = multiply(result, result);

        if (exp % 2 == 1L) {
            result = multiply(result, origin);
        }

        return result;
    }

    /**
     * 행렬의 곱하기 연산
     * @param A
     * @param B
     * @return 곱하기의 결과 행렬
     */
    static int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                    result[i][j] %= MOD;
                }
            }
        }

        return result;
    }
}
