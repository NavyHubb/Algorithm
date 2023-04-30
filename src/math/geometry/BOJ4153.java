package math.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();

            if (input.equals("0 0 0")) {
                break;
            }
            else {
                StringTokenizer st = new StringTokenizer(input);
                int[] arr = new int[3];

                for (int i = 0; i < 3; i++) {
                    arr[i] = Integer.parseInt(st.nextToken());
                }

                Arrays.sort(arr);

                if (Math.pow(arr[0], 2) + Math.pow(arr[1], 2) == Math.pow(arr[2], 2)) {
                    sb.append("right");
                }
                else {
                    sb.append("wrong");
                }
                sb.append('\n');
            }
        }

        System.out.println(sb);
    }
}