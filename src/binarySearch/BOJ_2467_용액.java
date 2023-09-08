package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2467_용액 {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }

    static void solution() {
        int minSum = Integer.MAX_VALUE;
        int[] result = new int[2];

        int left = 0;
        int right = N-1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            int absSum = Math.abs(sum);
            if (absSum < minSum) {
                minSum = absSum;
                result = new int[]{arr[left], arr[right]};
            }

            if (sum == 0) {
                break;
            }

            if (sum >= 0) {  // 두 수의 합이 0보다 크거나 같은 경우
                right--;  // 더 작아져야하므로
            } else {  // 두 수의 합이 0보다 작은 경우
                left++;
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }

}