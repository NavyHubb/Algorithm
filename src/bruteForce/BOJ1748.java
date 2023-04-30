package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = Integer.parseInt(s);
        int ans = 0;

        /**
         * start: 현재 자릿수의 최솟값; 1, 10, 100, ... (10배씩 증가)
         * len: 현재 자릿수
         * end: 현재 자릿수의 최댓값
         */
        for (int start = 1, len = 1; start <= N; start *= 10, len++) {
            int end = start * 10 - 1;  // 현재 start 자리수의 최댓값(마지막 값)

            // 입력받은 수가 현재 자릿수 범위 내에 존재할 경우
            if (end > N) {
                end = N;
            }

            ans += len * (end - start + 1);
        }

        System.out.println(ans);
    }
}