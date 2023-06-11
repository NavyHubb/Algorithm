package math;

import java.util.Scanner;

public class BOJ1789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long sum = 0;
        int count = 0;

        for (int i = 1; ; i++) {
            sum += i;
            count++;

            if (sum == N) {
                break;
            } else if (sum > N) {
                count--;
                break;
            }
        }

        System.out.println(count);
    }

}