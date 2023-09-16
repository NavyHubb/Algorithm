package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_12015_가장긴증가하는부분수열2 {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution());
    }

    static int solution() {
        int[] LIS = new int[N];
        LIS[0] = arr[0];
        int lenghOfLIS = 1;

        for (int i = 1; i < N; i++) {
            int num = arr[i];

            if (num > LIS[lenghOfLIS-1]) {  // 현재 수가 LIS의 마지막 값보다 클 경우 추가해준다
                lenghOfLIS++;
                LIS[lenghOfLIS-1] = num;
            } else {
                int lo = 0;
                int hi = lenghOfLIS;

                while (lo < hi) {
                    int mid = (lo + hi) >> 1;  // 2로 나누기

                    if (LIS[mid] < num) {
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }
                }

                LIS[lo] = num;
            }
        }

        return lenghOfLIS;
    }

}