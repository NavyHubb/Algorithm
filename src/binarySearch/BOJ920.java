package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ920 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (binarySearch(Integer.parseInt(st.nextToken())) >= 0) {
                sb.append(1).append('\n');
            }
            else {
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
    }

    static int binarySearch(int key) {

        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;  // 중간 위치

            // key값이 중앙값보다 작을 경우
            if (key < arr[mid]) {
                hi = mid - 1;
            }
            // key값이 중앙값보다 클 경우
            else if (key > arr[mid]) {
                lo = mid + 1;
            }
            // key값과 중앙값이 같을 경우
            else {
                return mid;
            }
        }

        // 탐색범위 내에 key값이 존재하지 않을 경우
        return -1;
    }
}
