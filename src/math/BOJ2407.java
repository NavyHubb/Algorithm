package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ2407 {
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (N == M) {
            System.out.println(1);
            return;
        }

        BigInteger result = BigInteger.ONE;
        for (int i = N; i >= N - M + 1; i--) {
            BigInteger num = new BigInteger(String.valueOf(i));
            result = result.multiply(num);
        }

        for (int i = 2; i <= M; i++) {
            BigInteger num = new BigInteger(String.valueOf(i));
            result = result.divide(num);
        }

        System.out.println(result);
    }

}