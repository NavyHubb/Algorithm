package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [문제 분석]
 * 각 자릿수가 모두 1로만 이루어진 n의 배수 중 가장 작은 수의 '자리수'를 구하라
 * 1 -> 11 -> 111 -> ... 여기에 적용되는 연산은 'x*10 + 1'이다
 *
 * [문제 풀이]
 * 풀이1) BigInteger 사용
 * 1을 하나 붙여가면서 매번 n으로 나누어 떨어지는지 확인
 *
 * 풀이2) 나머지 연산 법칙 활용
 * 'x*10 + 1' 연산을 한 뒤 n으로 나누었을 때의 나머지를 그 다음 x로 삼는다
 */
public class BOJ_4375_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;

        while ((s = br.readLine()) != null) {
            int N = Integer.parseInt(s);
            System.out.println(solution(N));
        }
    }

    public static int solution(int N) {
        int cnt = 1;

        int num = 1;
        while ((num = num % N) != 0) {
            cnt++;
            num = num*10 + 1;
        }

        return cnt;
    }

}
