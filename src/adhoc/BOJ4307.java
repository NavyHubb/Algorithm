package adhoc;

import java.util.Scanner;

public class BOJ4307 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int l = sc.nextInt();
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            solution(l, n, arr);
        }
    }

    static void solution(int l, int n, int[] arr) {
        int min = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            int ant = arr[i];

            min = Math.max(min, Math.min(ant, l - ant));
            max = Math.max(max, Math.max(ant, l - ant));
        }

        System.out.println(min + " " + max);
    }

}