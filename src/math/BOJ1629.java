package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1629 {
    static long C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B));
    }

    // 모듈러 합동 연산: (a * b) % c = (a%c * b%c) % c
    static long pow(long x, long exponent) {
        if (exponent == 1) {
            return x % C;
        }

        long temp = pow(x, exponent / 2);

        if (exponent % 2 == 1) {
            return (temp * temp % C) * x % C;
        }
        return temp * temp % C;
    }
}