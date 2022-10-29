package math.primalityTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

//            /**
//             * 첫번째 풀이)
//             * 입력받은 수에 대해 소수 여부를 판단하기 위해
//             * 2부터 자기 자신까지의 수를 차례로 나누어 본다
//             */
//            for (int j = 2; j <= num; j++) {
//                // j가 입력받은 수에 이르기까지 break에 걸리지 않았다는 건 나누어 떨어지는 수가 없었다는 것
//                if (j == num) {
//                    count++;
//                }
//
//                // 입력받은 수가 어떤 수 j로 나누어떨어지면 더 이상 소수일 수 없기 때문에 반복 종료
//                if (num % j == 0) {
//                    break;
//                }
//            }

            /**
             * 두번째 풀이)
             * isPN이 소수이기 위해서는 isPN의 제곱근보다 크지 않는 어떤 수로도 나눠지지 않아야 한다
             */
            boolean isPrime = true;
            if (num == 1) {
                continue;
            }
            for (int j = 2; j <= Math.sqrt(num); j++) {
                if (num % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                count++;
            }

        }

        System.out.println(count);
    }
}