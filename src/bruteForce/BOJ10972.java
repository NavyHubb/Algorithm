package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10972 {
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

        if (nextPermutation()) {
            for (int i = 0; i < N; i++) {
                System.out.print(arr[i] + " ");
            }
        }
        else {
            System.out.println("-1");
        }
    }

    public static boolean nextPermutation() {
        // 수의 오른쪽에서부터 이웃한 두 수를 탐색하면서
        // 왼쪽 수보다 오른쪽 수가 큰 경우를 찾는다
        int i = arr.length -1;
        while (i > 0 && arr[i - 1] >= arr[i]) {
            i--;
        }
        if (i <= 0) return false;  // 내림차순 정렬인 경우 그 다음 순열이 존재하지 않기 때문에 false

        // 다시 뒤에서부터 탐색하면서
        // i번째 수보다 큰 수를 찾는다
        int j = arr.length - 1;
        while (arr[i - 1] >= arr[j]) {
            j--;
        }

        swap(i - 1, j);

        // swap으로 인해 앞자리 수가 바뀌었으므로 그 뒤에 위치한 수들을 오름차순으로 초기화
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