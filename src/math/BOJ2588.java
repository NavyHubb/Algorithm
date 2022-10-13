package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int total = 0;

        for (int i = 0; i < 3; i++) {
            int temp = a * (b % 10);
            total += temp * Math.pow(10, i);
            System.out.println(temp);
            b = b / 10;
        }
        System.out.println(total);

    }
}
