package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2473_세용액 {

    static int N;
    static long[] arr;
    static long[] result;
    static long minSum = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        result = new long[3];
        for (int i = 0; i < N-2; i++) {
            solution(i);
        }

        for (int i = 0; i < 3; i++) {
            System.out.print(result[i] + " ");
        }
    }

    static void solution(int idx) {
        long fixed = arr[idx];

        int left = idx+1;
        int right = N-1;
        while (left < right) {
            // 각 용액의 크기는 int 범위 내에 있지만 세 용액의 합은 int 범위를 초과할 수 있으므로
            // 변수 sum은 물론 fixed와 arr[] 또한 마찬가지로 long 형으로 선언한다
            long sum = fixed + arr[left] + arr[right];
            long absSum = Math.abs(sum);
            if (absSum < minSum) {
                minSum = absSum;
                result = new long[]{fixed, arr[left], arr[right]};  // fixed의 크기는 무조건 arr[left], arr[right]의 크기보다 작으므로
            }

            if (sum == 0) {
                System.out.println(fixed + " " + result[1] + " " + result[2]);
                System.exit(0);
            }

            if (sum >= 0) {  // 두 수의 합이 0보다 크거나 같은 경우
                right--;  // 더 작아져야하므로
            } else {  // 두 수의 합이 0보다 작은 경우
                left++;
            }
        }
    }

}