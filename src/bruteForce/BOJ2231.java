package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str_N = br.readLine();
        int N = Integer.parseInt(str_N);
        int result = 0;

        // N의 자릿수 구하기
        int digits = str_N.length();

        for (int i = N - 9 * digits; i < N; i++) {  // 하나의 자리수에서 가장 큰 수는 9이기 때문에 N에서 자리수*9 만큼을 뺀 값부터 반복을 시작한다
            int sum = i;

            // 특정 수 i와 그 수의 각 자리 수 더하기
            int num = i;
            while (num % 10 != 0) {
                sum += num % 10;
                num /= 10;
            }

            if (sum == N) {
                result = i;
                break;  // 처음 등장하는(즉, 가장 작은) 생성자가 생기면 반복문 종료
            }
        }

        System.out.println(result);
    }
}