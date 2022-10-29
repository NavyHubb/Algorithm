package math.primalityTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 2; i <= Math.sqrt(N); i++) {
            while (N % i == 0) {
                N /= i;
                sb.append(i).append("\n");
            }
        }

        // 위의 for문을 종료하고 나서 N이 1이 아니라면 그 수는 소수이자 인수이므로 추가로 출력해주어야 한다
        if (N != 1) {
            sb.append(N);
        }

        System.out.println(sb);
    }
}