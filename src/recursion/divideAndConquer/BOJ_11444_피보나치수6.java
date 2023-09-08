package recursion.divideAndConquer;

import java.io.IOException;
import java.util.Scanner;

public class BOJ_11444_피보나치수6 {

    static long N;
    static long[][] origin = {{1, 1}, {1, 0}};
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextLong();

        long[][] A = {{1, 1}, {1, 0}};

        long[][] result = solution(A, N-1);
        System.out.println(result[0][0]);
    }

    /**
     * 행렬 제곱 분할정복
     * @param A 곱하기 연산의 대상 행렬
     * @param exp 곱한 횟수
     */
    static long[][] solution(long[][] A, long exp) {
        if (exp == 1 || exp == 0) return A;

        long[][] result = solution(A, exp/2);
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
    static long[][] multiply(long[][] A, long[][] B) {
        long[][] result = new long[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                    result[i][j] %= MOD;
                }
            }
        }

        return result;
    }

}
