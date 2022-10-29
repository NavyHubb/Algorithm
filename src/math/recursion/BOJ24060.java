package math.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ24060 {
    static int[] temp;
    static int count = 0;
    static int result = -1;
    static int K;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        temp = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(arr, 0, arr.length - 1);

        System.out.println(result);
    }

    static void merge_sort(int[] A, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            merge_sort(A, low, mid);  // 전반부 정렬
            merge_sort(A, mid + 1, high);  // 후반부 정렬
            merge(A, low, mid, high);  // 병합
        }
    }

    static void merge(int[] A, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int t = 0;  // 의사코드에서는 1은 곧 인덱스의 0이다

        while (i <= mid && j <= high) {
            if (A[i] <= A[j]) {
                temp[t++] = A[i++];
            }
            else {
                temp[t++] = A[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = A[i++];
        }

        while (j <= high) {
            temp[t++] = A[j++];
        }
        
        i = low;
        t = 0;
        
        while (i <= high) {
            count++;

            if (count == K) {
                result = temp[t];
                break;
            }

            A[i++] = temp[t++];
        }

    }
}
