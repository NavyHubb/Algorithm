package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1= new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());

        int max = 0;

        int[] arr = new int[N];
        StringTokenizer st2= new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        for (int i = 0; i < N - 2; i++) {  // 3개를 고르기 때문에 첫번째 카드는 N-2까지
            if (arr[i] > M) continue;  // 첫번째 카드가 M보다 크면 건너뛴다

            for (int j = i + 1; j < N - 1; j++) {  // 두번째 카드는 첫번째 다음 카드부터 N-1까지
                if (arr[i] + arr[j] > M) continue;  // 첫번째 카드와 두번째 카드의 합이 M보다 크면 건너뛴다

                for (int k = j + 1; k < N; k++) { // 세번째 카드는 N까지
                    int tempSum = arr[i] + arr[j] + arr[k];

                    if (tempSum == M) {
                        max = tempSum;
                        break;
                    }

                    if (max < tempSum && tempSum < M) {
                        max = tempSum;
                    }
                }
            }
        }

        System.out.println(max);
    }
}