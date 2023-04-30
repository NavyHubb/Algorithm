package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long count_two = two_power_n(n) - two_power_n(m) - two_power_n(n - m);
        long count_five = five_power_n(n) - five_power_n(m) - five_power_n(n - m);

        System.out.println(Math.min(count_two, count_five));
    }

    static int two_power_n(int n) {
        int count = 0;

        while (n >= 2) {
            count += n / 2;
            n /= 2;
        }

        return count;
    }

    static int five_power_n(int n) {
        int count = 0;

        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }

        return count;
    }

}