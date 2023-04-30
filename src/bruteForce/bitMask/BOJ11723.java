package bruteForce.bitMask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        int s = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");

            switch (input[0]) {
                case "all":
                    s = (1 << 20) - 1;  // 2진수 첫째자리부터 20번째자리까지 모두 1인 상태
                    break;
                case "empty":
                    s = 0;  // 십진수 0. 곧 이진수로도 모든 자리 숫자 0
                    break;
                // 위 케이스들에 아무것도 해당하지 않을 때 수행될 코드
                default:
                    int x = Integer.parseInt(input[1]) - 1;
                    switch (input[0]) {
                        case "add":
                            s |= (1 << x);  // 좌우 항의 OR 연산 결과를 좌항에 대입
                            break;
                        case "remove":
                            s &= ~(1 << x);  // 좌우 항의 AND 연산 결과를 좌항에 대입
                            break;
                        case "check":
                            sb.append((s & (1 << x)) != 0 ? 1 : 0).append('\n');  // 2진수 상에서 특정 자리 숫자가 1인지 확인
                            break;
                        case "toggle":
                            s ^= (1 << x);  // 좌우 항의 XOR 연산 결과를 좌항에 대입
                            break;
                    }
            }
        }

        System.out.println(sb);
    }
}