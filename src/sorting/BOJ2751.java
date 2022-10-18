package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[2000001];  // 인덱스 1,000,000이 0에 대응

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            arr[a + 1000000] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 2000001; j++) {
            if (arr[j]) {
                sb.append(j - 1000000).append("\n");
            }
        }

        System.out.println(sb);
    }
}