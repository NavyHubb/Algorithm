package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] arr = new long[1_000_001];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for (int i = 4; i <= 1_000_000; i++) {
            // i는
            // i-1에 1을 더하거나
            // i-2에 2을 더하거나
            // i-3에 3을 더하는 방식으로 만들 수 있다
            arr[i] = (arr[i-1] + arr[i-2] + arr[i-3]) % 1_000_000_009;
        }

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[n] % 1_000_000_009).append("\n");
        }

        System.out.println(sb);
    }
}