package math.primalityTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9020 {

    static boolean[] arr = new boolean[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int n;

        make_prime();

        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            int first_partition = n / 2;
            int second_partition = n / 2;

            for (int j = 0; j < first_partition; j++) {
                if (!arr[first_partition - j] && !arr[second_partition + j]) {
                    sb.append(first_partition-j).append(" ").append(second_partition+j).append("\n");
                    break;
                }
            }
        }

        System.out.println(sb);
    }

    public static void make_prime() {
        arr[0] = arr[1] = true;

        for (int i = 2; i <= Math.sqrt(arr.length); i++) {
            for (int j = i * i; j < arr.length; j += i) {
                arr[j] = true;
            }
        }
    }
}