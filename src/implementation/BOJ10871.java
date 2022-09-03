package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st1.nextToken());
        int x = Integer.parseInt(st1.nextToken());
        int[] nums = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st2.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
            if (nums[j] < x) {
                sb.append(nums[j]).append(" ");
            }
        }
        br.close();
        System.out.println(sb);
    }
}
