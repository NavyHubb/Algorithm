package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(arithmetic_sequence(Integer.parseInt(br.readLine())));
    }

    public static int arithmetic_sequence(int n) {
        int cnt = 0;

        if (n < 100) {
            cnt = n;  // 100 미만의 수는 모두 수열에 해당함
        } else {
            cnt = 99;

            for (int i = 100; i <= n; i++) {
                // 각자리 숫자를 변수로 지정
                int hun = (i / 100) % 100;
                int ten = (i / 10) % 10;
                int one = i % 10;

                if ((hun - ten) == (ten - one)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
