package math.primalityTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2581 {
    // 방법1. 에라토스테네스 체
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());  // 시작 수
        int N = Integer.parseInt(br.readLine());  // 끝 수

        boolean[] prime = new boolean[N + 1];  // 초기값은 false

        // 에라토스테네스 체
        prime[0] = true;  // true이면 소수가 아닌 것
        prime[1] = true;

        for (int i = 2; i <=Math.sqrt(prime.length); i++) {
            if (prime[i]) continue;
            for (int j = i * i; j <= N; j += i) {
                prime[j] = true;
            }
        }

        // 소수들의 합, 최솟값
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = M; i <= N; i++) {
            if (prime[i] == false) {
                sum += i;
                if (min == Integer.MAX_VALUE) {  // 첫번째 소수가 min으로 설정되도록
                    min = i;
                }
            }
        }

        if (sum == 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(sum+"\n"+min);
        }

    }
//    // 방법2. 루트N 이하의 수를 일일이 나누어보기
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int m = Integer.parseInt(br.readLine());  // 시작 수
//        int n = Integer.parseInt(br.readLine());  // 끝 수
//
//        int[] arr = new int[n - m + 2];
//        int idx = 0;
//        for (int num = m; num <= n; num++) {  // m부터 n까지 탐색
//            if (num == 1) {
//                continue;
//            }
//
//            boolean isPN = true;
//            for (int j = 2; j <= Math.sqrt(num); j++) {
//                if (num % j == 0) {
//                    isPN = false;
//                    break;
//                }
//            }
//
//            if (isPN) {
//                arr[idx] = num;
//                idx++;
//            }
//        }
//
//        if (arr[0] == 0) {
//            System.out.println(-1);
//        } else {
//            // 발견된 소수들의 합 구하기
//            int i = 0;
//            int sum = 0;
//            while (arr[i] != 0) {
//                sum += arr[i];
//                i++;
//            }
//
//            System.out.println(sum + "\n" + arr[0]);
//        }
//    }
}