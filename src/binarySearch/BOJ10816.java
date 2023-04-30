package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        HashMap<Integer, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());

            sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(' ');
        }

        System.out.println(sb);
    }

    // 특정 key값에 대한 하한값(인덱스)
    static int lowerBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (key <= arr[mid]) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    // 특정 key값에 대한 상한값(인덱스)
    static int upperBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (key < arr[mid]) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}