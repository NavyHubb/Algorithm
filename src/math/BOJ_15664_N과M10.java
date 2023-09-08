package math;

import java.util.Arrays;
import java.util.Scanner;

/**
 * [조건]
 * N개의 자연수 중 M개를 골라 비내림차순인 수열 모두 구하라
 */
public class BOJ_15664_N과M10 {

    static int N, M;
    static int[] arr;
    static int[] output;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        output = new int[M];
        visited = new boolean[N];

        Arrays.sort(arr);

        dfs(0, 0);
        System.out.println(sb);
    }

    static void dfs(int depth, int start) {
        if (depth == M) {
            print();
            return;
        }

        int before = -1;
        for (int i = start; i < N; i++) {
            if (visited[i]) continue;
            if (before == arr[i]) continue;

            visited[i] = true;
            output[depth] = arr[i];
            before = output[depth];
            dfs(depth+1, i+1);
            visited[i] = false;
        }
    }

    static void print() {
        for (int i : output) {
            sb.append(i).append(' ');
        }
        sb.append('\n');
    }
}
