package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1= new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());

        int max = 0;

        int[] arr = new int[n];
        StringTokenizer st2= new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        for (int i = 0; i < n - 2; i++) {  // 3개를 고르기 때문에 n-2까지
            for (int j = i + 1; j < n - 1; j++) {  // 두번째 인자는 첫번째보다 큰 수부터
                for (int k = j + 1; k < n; k++) {  // 세번째 인자는 두번째보다 큰 수부터
                    int tempSum = arr[i] + arr[j] + arr[k];

                    if (tempSum == m) {
                        max = tempSum;
                        break;
                    }

                    if (max < tempSum && tempSum < m) {
                        max = tempSum;
                    }
                }
            }
        }

        System.out.println(max);
    }
}