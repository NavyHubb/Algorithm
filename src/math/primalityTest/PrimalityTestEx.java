package math.primalityTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimalityTestEx {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(isPrime3(N));
    }

    public static boolean isPrime1(int n) {

        boolean isPrime = true;

        // 0과 1은 소수가 아니다
        if (n < 2) {
            return false;
        }

        for (int i = 2; i < n; i++) {
            // 1과 n 이외의 약수를 갖고 있는 경우
            if (n % i == 0) {
                isPrime = false;
                return isPrime;
            }
        }

        // 위 반복문에서 약수를 갖고 있지 않음이 확인되면 소수다
        return isPrime;
    }

    public static boolean isPrime2(int n) {

        boolean isPrime = true;

        // 0과 1은 소수가 아니다
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            // 1과 n 이외의 약수를 갖고 있는 경우
            if (n % i == 0) {
                isPrime = false;
                return isPrime;
            }
        }

        // 위 반복문에서 약수를 갖고 있지 않음이 확인되면 소수다
        return isPrime;
    }

    public static boolean isPrime3(int n) {

        boolean[] prime = new boolean[n+1];

        if (n < 2) {
            return true;  // false이면 소수. 1, 2번 방법과 반대로 표시
        }

        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (prime[i]) {
                continue;
            }

            for (int j = 2; i * j < n; j++) {
                prime[i * j] = true;
            }
        }

        return prime[n];
    }

}