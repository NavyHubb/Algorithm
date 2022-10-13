package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.util.Arrays.sort;

public class BOJ3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(br.readLine()) % 42;
        }

        sort(arr);
        int count = 0;
        int max = -1; // 나머지가 0인 경우부터 count 되기 위한 조치이므로 0보다 작은 임의의 수로 설정

        if (arr[0] != arr[9]) {
            for (int j = 0; j < 10; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    count++;
                }
            }
        } else {
            count = 1;
        }

        System.out.println(count);
    }
}
