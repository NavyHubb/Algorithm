package math.primalityTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n;
        int count = 0;

        // 에라토스테네스 체
        boolean[] arr = new boolean[123456 * 2 + 1];  // 입력값이 최대일 경우를 가정해서 배열 생성

        arr[0] = arr[1] = true;  // true는 소수가 아닌 것

        for (int i = 2; i <= Math.sqrt(arr.length); i++) {
            for (int j = i * i; j <= arr.length; j += i) {
                arr[j] = true;
            }
        }

        while (true) {
            // 변수 초기화
            n = Integer.parseInt(br.readLine());
            count = 0;

            // 0이 입력되면 반복문 종료
            if (n == 0) break;

            for (int i = n + 1; i <= 2*n; i++) {
                if (!arr[i]) count++;
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}