package slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        int max = 0;
        for (int i = 0; i < K; i++) {
            max += arr[i];
        }

        int sum = max;
        for (int i = K; i < N; i++) {
            sum -= arr[i-K];
            sum += arr[i];

            max = Math.max(sum, max);
        }

        System.out.println(max);
    }
}