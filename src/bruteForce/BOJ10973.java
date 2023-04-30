package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10973 {
    public static int N;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (prepPermutation()) {
            for (int i = 0; i < N; i++) {
                System.out.print(arr[i] + " ");
            }
        }
        else {
            System.out.println("-1");
        }

    }

    public static boolean prepPermutation() {
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] <= arr[i]) {
            i--;
        }
        if (i <= 0) return false;

        int j = arr.length - 1;
        while (arr[i - 1] <= arr[j]) {
            j--;
        }

        swap(i - 1, j);

        j = arr.length - 1;
        while (i < j) {
            swap(i, j);
            i++;
            j--;
        }
        return true;
    }

    public static void swap(int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}