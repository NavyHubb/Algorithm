package combinatorics;

import java.util.Scanner;

public class BOJ_1722_순열의순서 {

    static int N;
    static int[] comb;
    static long[] f;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        // 팩토리얼 구하기
        f = new long[21];
        f[0] = 1;  // 0!은 0이 아니라 1임에 유의!!
        for (int i = 1; i <= 20; i++) {
            f[i] = f[i-1] * i;
        }

        comb = new int[N];
        int type = sc.nextInt();
        if (type == 1) {
            long idx = sc.nextLong();
            sol1(idx);
        } else {
            for (int i = 0; i < N; i++) {
                comb[i] = sc.nextInt();
            }

            sol2(comb);
        }
    }

    static void sol1(long idx) {
        boolean[] visited = new boolean[21];
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= N; j++) {
                if (visited[j]) continue;

                if (f[N-i-1] < idx) {
                    idx -= f[N-i-1];
                } else {
                    comb[i] = j;
                    visited[j] = true;
                    break;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(comb[i]+" ");
        }
    }

    static void sol2(int[] comb) {
        long idx = 1;
        boolean[] visited = new boolean[21];

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < comb[i]; j++) {
                if (!visited[j]) {
                    idx += f[N-i-1];
                }
            }
            visited[comb[i]] = true;
        }

        System.out.println(idx);

        Math.atan(360);
    }

}