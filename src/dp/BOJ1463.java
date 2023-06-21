package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 1부터 N까지의 인덱스를 포함할 수 있도록 N+1 크기의 배열 생성
        int[] arr = new int[N+1];

        // 인덱스 1은 0이므로 2부터 N까지의 수 각각에 대한 연산횟수를 계산하여 배열에 대입
        for (int i = 2; i <= N; i++) {
            // 1을 빼는 연산, 2로 나누는 연산, 3으로 나누는 연산 중 최소 연산횟수값을 가지는 값을 arr[i]에 저장
            arr[i] = arr[i-1] + 1;

            if (i % 2 == 0) {
                arr[i] = Math.min(arr[i/2] + 1, arr[i]);
            }

            if (i % 3 == 0) {
                arr[i] = Math.min(arr[i/3] + 1, arr[i]);
            }
        }

        System.out.println(arr[N]);
    }
}