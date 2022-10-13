package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        for (int i = 0; i < c; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for (int k = 0; k < n; k++) {
                arr[k] = Integer.parseInt(st.nextToken());
            }

            int count = 0;
            for (int j = 0; j < n; j++) {
                double sum = Arrays.stream(arr).sum();
                double mean = sum/n;
                if (arr[j] > mean) count++;
            }

            System.out.println(String.format("%.3f%%", (double)count/n*100));
        }
    }
}
