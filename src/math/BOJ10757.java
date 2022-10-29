package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ10757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BigInteger a = new BigInteger(st.nextToken());  // BigInteger는 long보다 큰 수를 다루는 데 사용된다
        BigInteger b = new BigInteger(st.nextToken());

        System.out.println(a.add(b));  // BigInteger는 기본 자료형과 달리 사칙연산 기호로 연산되지 않고 메소드를 사용해야 한다
    }
}