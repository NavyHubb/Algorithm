package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11497 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

            System.out.println(solution(arr, N));
        }
    }

    static int solution(int[] arr, int N) {
        Arrays.sort(arr);

        int[] sort = new int[N];

        int left = 0;
        int right = N-1;

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                sort[left++] = arr[i];
            } else {
                sort[right--] = arr[i];
            }
        }

        int min = Math.abs(sort[0] - sort[N-1]);
        for (int i = 0; i < N-1; i++) {
            int abs = Math.abs(sort[i] - sort[i + 1]);
            if (abs > min) {
                min = abs;
            }
        }

        return min;
    }

}